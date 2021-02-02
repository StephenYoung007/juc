package tech.ityoung.study.demo.juc.threadpool;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadPoolDemo {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2);
        for (int i = 0; i < 20; i++) {
            int j = i;
            myThreadPool.executeTask(() -> {
                log.info(j + "");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
