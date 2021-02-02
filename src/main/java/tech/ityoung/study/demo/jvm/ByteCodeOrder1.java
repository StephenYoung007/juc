package tech.ityoung.study.demo.jvm;

public class ByteCodeOrder1 {
    static int i = 10;

    static {
        i = 20;
    }

    static {
        i = 30;
    }

    public static void main(String[] args) {
        System.out.println("i = " + i);
    }
}
