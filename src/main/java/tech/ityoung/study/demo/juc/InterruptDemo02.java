package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class InterruptDemo02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    break;
                }
            }
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        log.info("interrupt begin");
        t1.interrupt();
    }
}
