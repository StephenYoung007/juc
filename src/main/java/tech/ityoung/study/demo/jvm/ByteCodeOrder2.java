package tech.ityoung.study.demo.jvm;

public class ByteCodeOrder2 {
    private String a = "s1";

    {
        b = 20;
    }

    private int b = 10;

    {
        a = "s2";
    }

    public ByteCodeOrder2(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        ByteCodeOrder2 order2 = new ByteCodeOrder2("s3", 30);
        System.out.println("order2.a = " + order2.a);
        System.out.println("order2.b = " + order2.b);
    }
}
