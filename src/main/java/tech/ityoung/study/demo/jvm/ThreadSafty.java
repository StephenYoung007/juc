package tech.ityoung.study.demo.jvm;

public class ThreadSafty {
    public static void main(String[] args) throws InterruptedException {
/*        StringBuilder sb =new StringBuilder();
        sb.append(4);
        new Thread(()->{
            m2(sb);
        }).start();
        Thread.sleep(50);
        sb.append(5);
        sb.append(6);
        System.out.println(sb);*/
    }

    private static void m1() {
        StringBuilder sb =new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        System.out.println(sb);
    }

    private static void m2(StringBuilder sb) {
        sb.append(4);
        sb.append(5);
        sb.append(6);
        System.out.println(sb);
    }

    private static StringBuilder m3() {
        StringBuilder sb =new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        System.out.println(sb);
        return sb;
    }
}
