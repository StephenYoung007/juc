package tech.ityoung.study.demo.juc;

public class YieldDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                Thread.yield();
                System.out.println("------------->t1:count = " + count++);
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                System.out.println("--------------------------------------------->t2:count = " + count++);
            }
        }, "t2");
        t2.start();
        t1.start();
    }
}
