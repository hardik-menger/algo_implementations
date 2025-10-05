
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

    private volatile boolean shutdown = false;

    class ScheduledTask implements Comparable<ScheduledTask> {

        Runnable task;
        long nextExecution; // in nanoseconds
        long interval;      // for PERIODIC
        long delay;         // for DELAYED
        TaskType type;

        public ScheduledTask(Runnable task, long nextExecution) {
            this.task = task;
            this.nextExecution = nextExecution;
            this.type = TaskType.ONCE;
        }

        public ScheduledTask(Runnable task, long nextExecution, TaskType type, long period) {
            this.task = task;
            this.nextExecution = nextExecution;
            this.type = type;
            if (type == TaskType.PERIODIC) {
                this.interval = period;
            }
            if (type == TaskType.DELAYED) {
                this.delay = period;
            }
        }

        @Override
        public int compareTo(ScheduledTask other) {
            return Long.compare(this.nextExecution, other.nextExecution);
        }
    }

    private final PriorityQueue<ScheduledTask> queue = new PriorityQueue<>();
    private final ExecutorService executor;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition newTaskAdded = lock.newCondition();
    private final Thread schedulerThread;

    public ScheduledTreadWorker(int threadCount) {
        this.executor = Executors.newFixedThreadPool(threadCount);
        schedulerThread = new Thread(this::processTasks);
        schedulerThread.start();
    }

    private void processTasks() {
        while (!shutdown) {
            ScheduledTask taskToExecute = null;
            long timeToWait = 0;

            lock.lock();
            try {
                while (!shutdown && queue.isEmpty()) {
                    newTaskAdded.await();
                }

                if (shutdown) {
                    return;
                }

                long now = System.nanoTime();
                ScheduledTask head = queue.peek();

                if (head != null) {
                    if (head.nextExecution <= now) {
                        taskToExecute = queue.poll();
                    } else {
                        timeToWait = head.nextExecution - now;
                        newTaskAdded.awaitNanos(timeToWait);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }

            if (taskToExecute != null) {
                final ScheduledTask task = taskToExecute; // final reference for lambda

                switch (task.type) {
                    case ONCE:
                        executor.submit(task.task);
                        break;

                    case PERIODIC:
                        executor.submit(task.task);
                        lock.lock();
                        try {
                            task.nextExecution += task.interval;
                            queue.add(task);
                            newTaskAdded.signalAll();
                        } finally {
                            lock.unlock();
                        }
                        break;

                    case DELAYED:
                        executor.submit(() -> {
                            try {
                                task.task.run();
                            } finally {
                                lock.lock();
                                try {
                                    task.nextExecution = System.nanoTime() + task.delay;
                                    queue.add(task);
                                    newTaskAdded.signalAll();
                                } finally {
                                    lock.unlock();
                                }
                            }
                        });
                        break;
                }
            }
        }
    }

    public void schedule(Runnable task, long delay, TimeUnit unit) {
        lock.lock();
        try {
            long nextExecution = System.nanoTime() + unit.toNanos(delay);
            queue.add(new ScheduledTask(task, nextExecution));
            newTaskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void scheduleAtFixedRate(Runnable task, long initialDelay, long interval, TimeUnit unit) {
        lock.lock();
        try {
            long nextExecution = System.nanoTime() + unit.toNanos(initialDelay);
            queue.add(new ScheduledTask(task, nextExecution, TaskType.PERIODIC, unit.toNanos(interval)));
            newTaskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void scheduleWithFixedDelay(Runnable task, long initialDelay, long delay, TimeUnit unit) {
        lock.lock();
        try {
            long nextExecution = System.nanoTime() + unit.toNanos(initialDelay);
            queue.add(new ScheduledTask(task, nextExecution, TaskType.DELAYED, unit.toNanos(delay)));
            newTaskAdded.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void shutdown() throws InterruptedException {
        shutdown = true;
        lock.lock();
        try {
            newTaskAdded.signalAll();
            queue.clear();
        } finally {
            lock.unlock();
        }

        schedulerThread.join();
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledTreadWorker worker = new ScheduledTreadWorker(3);

        worker.schedule(() -> System.out.println("Task 1 (Once)"), 1, TimeUnit.SECONDS);
        worker.scheduleAtFixedRate(() -> System.out.println("Task 2 (Periodic)"), 1, 5, TimeUnit.SECONDS);
        worker.scheduleWithFixedDelay(() -> System.out.println("Task 3 (Delayed)"), 1, 3, TimeUnit.SECONDS);

        Thread.sleep(15000); // let it run for 15s
        worker.shutdown();
    }
}
