package tech.ityoung.study.demo.juc.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class MyThreadPool {
    private int coreSize;

    private Set<Worker> workers = new HashSet<>();

    private BlockingQueue<Runnable> taskQueue = new BlockingQueue<>(5);

    public MyThreadPool() {
    }

    public MyThreadPool(int coreSize) {
        this.coreSize = coreSize;
    }

    public void executeTask(Runnable task) {
        if (workers.size() < coreSize) {
            Worker worker = new Worker(task, taskQueue, workers);
            log.info("worker created: {}", worker);
            workers.add(worker);
            worker.start();
        } else {
            taskQueue.addTask(task);
        }
    }
}
