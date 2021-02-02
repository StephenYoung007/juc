package tech.ityoung.study.demo.jvm;

public class LazyLoadDemo {
    public static void main(String[] args) {
//        System.out.println("Singleton.getSingleton() = " + Singleton.getSingleton());
        Singleton.tets();
    }
}

class Singleton {
    static {
        System.out.println("this is singleton class");
    }

    private Singleton() {
    }

    private static class LazyLoader {
        private final static Singleton singleton = new Singleton();

        static {
            System.out.println("here is lazyLoader");
        }
    }

    public static Singleton getSingleton() {
        return LazyLoader.singleton;
    }

    public static void tets() {
        System.out.println("test from singleton");
    }
}
