package tech.ityoung.study.demo.juc.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
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

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    private int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public T poolTask(long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (this.size() <= 0) {
                try {
                    if (nanos <= 0) {
                        log.info("get task timeout");
                        return null;
                    }
                    log.info("queue is empty");
                    nanos = emptyQueueCondition.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullQueueCondition.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public void addTask(T task) {
        lock.lock();
        try {
            while (this.size() == capacity) {
                try {
                    log.info("queue is full");
                    fullQueueCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(task);
            emptyQueueCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
