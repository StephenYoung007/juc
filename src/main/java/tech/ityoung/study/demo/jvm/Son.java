package tech.ityoung.study.demo.jvm;

public class Son extends Father {
    private Integer i;
    static {
        System.out.println("this is static block from son");
    }

    {
        System.out.println("this is block from son");
    }

    public Son() {
        System.out.println("this is contractor from son");
    }

    public static void main(String[] args) {
        System.out.println("true = " + true);
        new Son();
    }
}
