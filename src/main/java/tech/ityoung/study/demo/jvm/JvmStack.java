package tech.ityoung.study.demo.jvm;

public class JvmStack {

    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        method2(1, 2);
    }

    private static int method2(int a, int b) {
        int result = a + b;
        System.out.println("指定栈内存大小");
        return result;
    }
}
