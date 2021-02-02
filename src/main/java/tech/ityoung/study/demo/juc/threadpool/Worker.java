package tech.ityoung.study.demo.juc.threadpool;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Worker extends Thread {
    private Runnable task;

    private BlockingQueue<Runnable> taskQueue;

    Set<Worker> workers;

    public Worker(Runnable task, BlockingQueue<Runnable> queue, Set<Worker> workers) {
        this.task = task;
        this.taskQueue = queue;
        this.workers = workers;
    }

    @Override
    public void run() {
        while (task != null || (task = taskQueue.poolTask(5000, TimeUnit.MILLISECONDS)) != null) {
            try {
                task.run();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                task = null;
            }
        }
        workers.remove(this);
    }
}
