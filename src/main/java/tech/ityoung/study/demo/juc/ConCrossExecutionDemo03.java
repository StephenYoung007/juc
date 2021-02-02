package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ConCrossExecutionDemo03 {
    public static void main(String[] args) throws InterruptedException {
        ParkConCrossExecutor executor = new ParkConCrossExecutor(5);
        List<Thread> threads = new ArrayList<>();
        Thread t1 = new Thread(() -> {
            executor.print("1", threads.get(1));
        }, "t1");
        Thread t2 = new Thread(() -> {
            executor.print("2", threads.get(2));
        }, "t2");
        Thread t3 = new Thread(() -> {
            executor.print("3", threads.get(0));
        }, "t3");
        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);
    }
}

@Slf4j
class ParkConCrossExecutor {
    private Integer loopNum;

    public ParkConCrossExecutor(Integer loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String str, Thread next) {
        for (Integer i = 0; i < loopNum; i++) {
            LockSupport.park();
            log.info(str);
            LockSupport.unpark(next);
        }
    }
}