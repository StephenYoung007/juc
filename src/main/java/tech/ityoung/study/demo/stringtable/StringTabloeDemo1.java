package tech.ityoung.study.demo.stringtable;

public class StringTabloeDemo1 {

    public static void main(String[] args) {
        test1();
        System.out.println("哈哈，吉吉国王666");

    }

    static void test1() {
        System.out.println("a");
        System.out.println("b");
        System.out.println("c");
        test2();
    }

    private static void test2() {
        test3();
    }

    private static void test3() {
        test4();
    }

    private static void test4() {
        test5();
    }

    private static void test5() {
        System.out.println("test5");
    }
}
