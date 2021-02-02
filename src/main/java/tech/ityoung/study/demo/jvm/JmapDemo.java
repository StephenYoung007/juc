package tech.ityoung.study.demo.jvm;

public class JmapDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("before byte array created......");
        Thread.sleep(30000);
        byte[] bytes = new byte[1024 * 1024 * 100];
        System.out.println("after byte array created......");
        bytes = null;
        Thread.sleep(30000);
        System.gc();
        System.out.println("after garbage collection......");
        Thread.sleep(30000000);
    }
}
