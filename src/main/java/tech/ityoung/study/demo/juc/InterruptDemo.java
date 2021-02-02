package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.info("start sleep...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t1.interrupt();
        log.info("interrupt status of ti:{}", t1.isInterrupted());
    }
}
