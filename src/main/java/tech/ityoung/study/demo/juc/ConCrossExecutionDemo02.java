package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConCrossExecutionDemo02 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockConCrossExecutor executor = new ReentrantLockConCrossExecutor(5);
        Condition c1 = executor.newCondition();
        Condition c2 = executor.newCondition();
        Condition c3 = executor.newCondition();
        Thread t1 = new Thread(() -> executor.print("1", c1, c2), "t1");
        Thread t2 = new Thread(() -> executor.print("2", c2, c3), "t2");
        Thread t3 = new Thread(() -> executor.print("3", c3, c1), "t3");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        // 如果线程1未进入condition1，则会发生死锁
        executor.start(c1);
    }
}

@Slf4j
class ReentrantLockConCrossExecutor extends ReentrantLock {
    private Integer loopNum;

    public ReentrantLockConCrossExecutor(Integer loopNum) {
        this.loopNum = loopNum;
    }

    public void start(Condition first) {
        try {
            this.lock();
            first.signal();
        } finally {
            this.unlock();
        }
    }

    public void print(String str, Condition current, Condition next) {
        for (int i = 0; i < loopNum; i++) {
            this.lock();
            try {
                current.await();
                log.info(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }
}
