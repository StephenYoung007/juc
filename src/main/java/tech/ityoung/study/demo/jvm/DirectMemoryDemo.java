package tech.ityoung.study.demo.jvm;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirectMemoryDemo {
    static int _100MB = 100 * 1024 * 1024;

    public static void main(String[] args) {
        List<ByteBuffer> bufferList = new ArrayList<>();
        int i = 0;
        while (true) {
            try {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100MB);
                bufferList.add(byteBuffer);
                i++;
            } catch (Exception e) {
                System.out.println("i = " + i);
            }
        }
    }
}
