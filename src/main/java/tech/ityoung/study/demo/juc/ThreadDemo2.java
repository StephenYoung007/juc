package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo2 {
    public static void main(String[] args) {
        int m = method1();
        System.out.println(m);
    }

    private static int method1() {
        Thread runnable = new Thread(() -> {
            log.info("runnable");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("runnable end");
        }, "runnable");
        runnable.start();
        log.info("main thread end");
        return 0;
    }
}
