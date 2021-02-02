package tech.ityoung.study.demo.juc.SemaphoreApplication;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class BlockingQueue<T> {
    private int capacity;

    private Deque<T> queue = new ArrayDeque<>();

    private ReentrantLock lock = new ReentrantLock();

    private Condition fullQueueCondition = lock.newCondition();

    private Condition emptyQueueCondition = lock.newCondition();

    private Semaphore semaphore;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.semaphore = new Semaphore(capacity);
    }

    private int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public T poolTask() {
        lock.lock();
        try {
            while (this.size() <= 0) {
                log.info("queue is empty");
                return null;
            }
            T t = queue.removeFirst();
            semaphore.release();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public void addTask(T task) {
        try {
            queue.addLast(task);
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
