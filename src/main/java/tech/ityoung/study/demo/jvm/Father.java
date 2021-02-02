package tech.ityoung.study.demo.jvm;

public class Father {
    static {
        System.out.println("this is static block from father");
    }

    {
        System.out.println("this is block from father");
    }

    public Father() {
        System.out.println("this is contractor from father");
    }
}
