package tech.ityoung.study.demo.jvm;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemFeatureDemo {

    static int i = 0;

    private static int getI() {
        synchronized (ItemFeatureDemo.class) {
            return i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 50000; j++) {
                i++;
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 50000; j++) {
                i--;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("i = " + i);
        ThreadDemo demo = new ThreadDemo();
        demo.start();
        log.info("main thread end");
        new Thread("sss") {
            @Override
            public void run() {
                log.info("匿名内部类");
            }
        };
        Thread.interrupted();
        Thread.currentThread().isInterrupted();
    }
}

@Slf4j
class ThreadDemo extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        log.info("this is subClass of Thread");
        Thread.sleep(10000);
        log.info("awake");
    }
}
