package tech.ityoung.study.demo.jvm;

public class DeadLock {
    static Integer a = 1;
    static Integer b = 2;

/*    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("我拿到了a 和 b");
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (b) {
                synchronized (a) {
                    System.out.println("我拿到了b 和 a");
                }
            }
        }).start();
    }*/
}
