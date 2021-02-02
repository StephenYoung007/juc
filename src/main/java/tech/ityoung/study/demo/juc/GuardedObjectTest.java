package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Random;

@Slf4j
public class GuardedObjectTest {
    public static void main(String[] args) throws InterruptedException {
        log.info("starting demo");
        GuardedObject guardedObject = new GuardedObject();
        new Thread(() -> {
            int response = 0;
            try {
                response = getResponse();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guardedObject.complete(response);
        }).start();
        Object o = guardedObject.get(5000);
        log.info("getting finished: {}", o);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.remove("ss");
    }

    private static int getResponse() throws InterruptedException {
        Thread.sleep(4000);
        return new Random(5).nextInt();
    }
}
