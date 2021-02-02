package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

public class ConcrossExecutionDemo01 {

    public static void main(String[] args) {
        SynchronizedConCrossExecutor executor = new SynchronizedConCrossExecutor(5, "1");
        Thread t1 = new Thread(() -> executor.print("1", "1", "2"), "t1");
        Thread t2 = new Thread(() -> executor.print("2", "2", "3"), "t1");
        Thread t3 = new Thread(() -> executor.print("3", "3", "1"), "t1");
        t1.start();
        t2.start();
        t3.start();
    }
}

@Slf4j
class SynchronizedConCrossExecutor {
    private Integer loopNum;
    private String nextMark;

    public void print(String str, String mark, String nextMark) {
        for (Integer i = 0; i < loopNum; i++) {
            synchronized (this) {
                while (!this.nextMark.equals(mark)) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info(str);
                this.nextMark = nextMark;
                notifyAll();
            }
        }
    }

    public SynchronizedConCrossExecutor(Integer loopNum, String nextMark) {
        this.loopNum = loopNum;
        this.nextMark = nextMark;
    }
}
