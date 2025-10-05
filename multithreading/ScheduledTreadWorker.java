
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

enum TaskType {
    ONCE,
    PERIODIC,
    DELAYED
}

public class ScheduledTreadWorker {

    volatile boolean shutdown = false;

    class ScheduledTask {

        Runnable task;
        long delay;
        long interval;
        long nextExecution;
        TaskType type;

        public ScheduledTask(Runnable task, long nextExecution) {
            this.task = task;
            this.nextExecution = nextExecution;
            this.type = TaskType.ONCE;
        }

        public ScheduledTask(Runnable task, long nextExecution, TaskType taskType, long period) {
            this.task = task;
            if (taskType == TaskType.PERIODIC) {
                this.interval = period;
            } else if (taskType == TaskType.DELAYED) {
                this.delay = period;
            }
            this.nextExecution = nextExecution;
            this.type = taskType;
        }

        public int compareTo(ScheduledTask other) {
            return Long.compare(nextExecution, other.nextExecution);
        }
    }

    private Thread schedulerThread;
    
    public ScheduledTreadWorker(int threadCount) {
        schedulerThread = new Thread(() -> {
            try {
                this.processTasks();
            } catch (InterruptedException | ExecutionException e) {
                Thread.currentThread().interrupt();
            }
        });
        schedulerThread.start();
    }

    public void processTasks() throws InterruptedException, ExecutionException {
        while (!shutdown) {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    try {
                        newTaskAdded.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (shutdown) {
                    return;
                }
                ScheduledTask scheduledTask = queue.peek();
                while (scheduledTask.nextExecution > System.nanoTime()) {
                    try {
                        newTaskAdded.await(scheduledTask.nextExecution - System.nanoTime(), TimeUnit.NANOSECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                queue.poll();
                if (null != scheduledTask.type && !executor.isShutdown()) {
                    switch (scheduledTask.type) {
                        case ONCE ->
                            executor.submit(scheduledTask.task);
                        case PERIODIC -> {
                            executor.submit(scheduledTask.task);
                            scheduledTask.nextExecution += scheduledTask.interval;
                            queue.add(scheduledTask);
                            newTaskAdded.signalAll();
                        }
                        case DELAYED -> {
                            var fut = executor.submit(scheduledTask.task);
                            fut.get();
                            scheduledTask.nextExecution += scheduledTask.delay;
                            queue.add(scheduledTask);
                            newTaskAdded.signalAll();
                        }
                        default -> {
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        }

    }
    PriorityQueue<ScheduledTask> queue = new PriorityQueue<>((a, b) -> Long.compare(a.nextExecution, b.nextExecution));
    ExecutorService executor = Executors.newFixedThreadPool(3);
    ReentrantLock lock = new ReentrantLock();
    Condition newTaskAdded = lock.newCondition();

    public void schedule(Runnable task, long delay, TimeUnit unit) {
        lock.lock();
        try {
            var period = System.nanoTime() + unit.toNanos(delay);
            ScheduledTask scheduledTask = new ScheduledTask(task, period);
            queue.add(scheduledTask);
            newTaskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void scheduleAtFixedRate(Runnable task, long period, long interval, TimeUnit unit) {
        lock.lock();
        try {
            var nextExecution = System.nanoTime() + unit.toNanos(period);
            ScheduledTask scheduledTask = new ScheduledTask(task, nextExecution, TaskType.PERIODIC, unit.toNanos(interval));
            queue.add(scheduledTask);
            newTaskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void scheduleWithFixedDelay(Runnable task, long period, long delay, TimeUnit unit) {
        lock.lock();
        try {
            var nextExecution = System.nanoTime() + unit.toNanos(period);
            ScheduledTask scheduledTask = new ScheduledTask(task, nextExecution, TaskType.DELAYED, unit.toNanos(delay));
            queue.add(scheduledTask);
            newTaskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void shutdown() throws InterruptedException {
        lock.lock();
        try {
            shutdown = true;
            newTaskAdded.signalAll();
        } finally {
            lock.unlock();
        }
        
        // Wait for scheduler thread to finish
        if (schedulerThread != null) {
            schedulerThread.join();
        }
        
        // Now shutdown the executor
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ScheduledTreadWorker scheduledTreadWorker = new ScheduledTreadWorker(3);
        scheduledTreadWorker.schedule(() -> {
            System.out.println("Task 1");
        }, 1, TimeUnit.SECONDS);
        scheduledTreadWorker.scheduleAtFixedRate(() -> {
            System.out.println("Task 2");
        }, 1, 5, TimeUnit.SECONDS);
        scheduledTreadWorker.scheduleWithFixedDelay(() -> {
            System.out.println("Task 3");
        }, 1, 3, TimeUnit.SECONDS);

        //shutdown after 10 seconds
        Thread.sleep(10000);
        scheduledTreadWorker.shutdown();
    }

}
