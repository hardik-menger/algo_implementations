import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DanceProblemLock {

    private int waitingLeaders = 0;
    private int waitingFollowers = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition leaderQueue = lock.newCondition();
    private final Condition followerQueue = lock.newCondition();

    // Barrier ensures exactly one leader + one follower dance together
    private final CyclicBarrier danceBarrier = new CyclicBarrier(2);

    public void enterLeader() throws InterruptedException {
        lock.lock();
        try {
            if (waitingFollowers > 0) {
                waitingFollowers--; // Pair with waiting follower
                followerQueue.signal(); // Wake follower
            } else {
                waitingLeaders++; // No followers — go to wait
                leaderQueue.await(); // Sleep until paired
            }
        } finally {
            lock.unlock();
        }

        dancePair();
    }

    public void enterFollower() throws InterruptedException {
        lock.lock();
        try {
            if (waitingLeaders > 0) {
                waitingLeaders--; // Pair with waiting leader
                leaderQueue.signal(); // Wake leader
            } else {
                waitingFollowers++; // No leaders — go to wait
                followerQueue.await(); // Sleep until paired
            }
        } finally {
            lock.unlock();
        }

        dancePair();
    }

    private void dancePair() {
        try {
            System.out.println(Thread.currentThread().getName() + " is ready to dance.");
            danceBarrier.await(); // Synchronize exactly 2 threads
            System.out.println(Thread.currentThread().getName() + " is dancing!");
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        DanceProblemLock ballroom = new DanceProblemLock();

        // Leaders
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    ballroom.enterLeader();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Leader-" + i).start();
        }

        // Followers
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    ballroom.enterFollower();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Follower-" + i).start();
        }
    }
}
