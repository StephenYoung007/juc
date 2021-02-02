package tech.ityoung.study.demo.jvm;

public class StackOverFlow {

    private static int count = 0;

    public static void main(String[] args) {
        try {
            method1(count);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("count = " + count);
        }
    }

    private static void method1(int i) {
        i++;
        method1(i);
    }
}
