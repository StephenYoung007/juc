package tech.ityoung.study.demo.jvm;

import org.springframework.asm.ClassWriter;
import org.springframework.asm.Opcodes;

// -XX:MaxMetaspaceSize=80m
// -XX:MaxPermSize=80m
public class MethodAreaOutOfMemory extends ClassLoader{
    public static void main(String[] args) {
        int j = 0;
        try {
            MethodAreaOutOfMemory demo = new MethodAreaOutOfMemory();
            for (int i = 0; i < 200000; i++, j++) {
                // 生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                // 版本号， public, 类名, 包名, 父类, 接口
                cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] code = cw.toByteArray();
                // 执行类的加载
                demo.defineClass("Class" + i, code, 0, code.length);
            }
        } finally {
            System.out.println("j = " + j);
        }
    }
}
