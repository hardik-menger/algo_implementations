
import java.util.concurrent.locks.*;
import java.util.*;

public class Playground {

    private final int MAX_PLAYERS = 10;
    private String currentTeam = null;
    private int currentPlayers = 0;

    private final ReentrantLock lock = new ReentrantLock(true); // fair lock to avoid starvation
    private final Condition condition = lock.newCondition();

    public void enter(String team) throws InterruptedException {
        lock.lock();
        try {
            // Wait while another team is playing OR playground full
            while ((currentTeam != null && !currentTeam.equals(team)) || currentPlayers == MAX_PLAYERS) {
                condition.await();
            }
            // Update state
            currentTeam = team;
            currentPlayers++;
            System.out.println(team + " player entered. Current count: " + currentPlayers);
        } finally {
            lock.unlock();
        }
    }

    public void leave(String team) {
        lock.lock();
        try {
            if (!team.equals(currentTeam)) {
                throw new IllegalStateException("Player from wrong team leaving!");
            }
            currentPlayers--;
            System.out.println(team + " player left. Current count: " + currentPlayers);

            if (currentPlayers == 0) {
                // Playground empty, allow next team
                currentTeam = null;
            }

            // Signal all waiting threads
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // Test scenario
    public static void main(String[] args) {
        Playground playground = new Playground();
        String[] teams = {"A", "B", "C"};

        for (String team : teams) {
            for (int i = 0; i < 15; i++) { // more than 10 to test waiting
                int playerId = i;
                new Thread(() -> {
                    try {
                        playground.enter(team);
                        Thread.sleep(500); // simulate playing
                        playground.leave(team);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
