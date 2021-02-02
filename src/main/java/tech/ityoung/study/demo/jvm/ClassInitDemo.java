package tech.ityoung.study.demo.jvm;

public class ClassInitDemo {
    static {
        System.out.println("main init");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // main方法所在的类总会被首先初始化
        // 访问final静态常量(基本类型和字符串)不会初始化
//        System.out.println(B.b);
//        // 类对象.class不会初始化
//        System.out.println(B.class);
//        // 创建该类的数组不会引发初始化
//        System.out.println(new B[0]);
//        // 类加载器的loadClass方法
        ClassLoader loader = ClassInitDemo.class.getClassLoader();
        System.out.println(loader.loadClass("tech.ityoung.study.demo.jvm.B"));
//        // class.forName的参数2为false时不会初始化类
        System.out.println(Class.forName("tech.ityoung.study.demo.jvm.B", false, loader));

//        // 首次访问类的静态变量或者静态方法会初始化
//        System.out.println("A.a = " + A.a);
//        // 子类初始化时，如果父类没有初始化会先初始化父类
//        System.out.println("B.c = " + B.c);
//        // Class.forName
//        System.out.println(Class.forName("tech.ityoung.study.demo.jvm.B"));
//        // 创建对象
//        System.out.println(new B());
        System.out.println("B.d = " + B.d);

    }
}

class A {
    static int a = 0;

    static {
        System.out.println("class a init");
    }
}

class B extends A {
    final static double b = 5.0;
    static boolean c = false;
    final static Integer d = 20;

    static {
        System.out.println("class b init");
    }

}
