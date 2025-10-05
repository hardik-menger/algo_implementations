
import java.util.*;

public class PubSub {

    LinkedList<Runnable> queue = new LinkedList<>();
    private volatile boolean shutdown = false;
    volatile int activeJobs = 0;

    List<Thread> workers = new ArrayList<>();

    public PubSub(int threadCount) throws InterruptedException {
        for (int i = 0; i < threadCount; i++) {
            var worker = new Thread(() -> {
                try {
                    processJobs();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            workers.add(worker);
            worker.start();
        }
    }

    public void publish(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notifyAll();
        }
    }

    public void waitUntilComplete() throws InterruptedException {
        synchronized (queue) {
            while (!queue.isEmpty() || activeJobs > 0) {
                queue.wait();
            }
        }
    }

    public void processJobs() throws InterruptedException {
        while (!shutdown) {
            Runnable task = null;
            synchronized (queue) {
                while (queue.isEmpty()) {
                    if (shutdown) {
                        return;
                    } else {
                        queue.wait();
                    }
                }
                task = queue.poll();
                activeJobs++;
            }
            try {
                if (task != null) {
                    task.run();
                }
            } finally {
                synchronized (queue) {
                    activeJobs--;
                    if (activeJobs == 0) {
                        queue.notifyAll();
                    }
                }
            }
        }
    }

    public void shutdown() throws InterruptedException {
        synchronized (queue) {
            shutdown = true;
            queue.notifyAll();
        }

        for (Thread t : workers) {
            t.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting PubSub with 3 worker threads...");

        PubSub pubSub = new PubSub(3);

        // Create some sample tasks
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            pubSub.publish(() -> {
                System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
                try {
                    // Simulate some work
                    Thread.sleep(1000 + (int) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
            });
            System.out.println("Published task " + taskId);
        }

        System.out.println("All tasks published. Waiting for completion...");
        pubSub.waitUntilComplete();
        System.out.println("All tasks completed!");

        // Shutdown the system
        pubSub.shutdown();
        System.out.println("PubSub system shutdown complete.");
    }

}
