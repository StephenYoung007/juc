package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MultiGuardedDemo {
    public static void main(String[] args) throws InterruptedException {
        int loopNum = 3;
        for (int i = 0; i < loopNum; i++) {
            new People().start();
        }
        Thread.sleep(1000);
        Set<Integer> boxIds = Mailbox.getBoxIds();
        for (Integer boxId : boxIds) {
            new Postman(boxId, "mail " + boxId).start();
        }
    }

}

@Slf4j
class People extends Thread {
    @Override
    public void run() {
        GuardedObject go = Mailbox.createGuardedObject();
        log.info("starting waiting for receiving mail No.{}", go.getId());
        Object o = go.get(5000);
        log.info("getting email completed:{}", o);
    }
}

@Slf4j
class Postman extends Thread {
    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public synchronized void run() {
        GuardedObject go = Mailbox.getGuardedObject(id);
        go.complete(mail);
        log.info("starting sending mail, the number is {}, and the content is {}", id, mail);
    }
}

class Mailbox {
    private static Map<Integer, GuardedObject> boxes = new ConcurrentHashMap<>();
    private static int id = 1;

    public static synchronized int generateId() {
        return ++id;
    }

    public static GuardedObject getGuardedObject(int id) {
        return boxes.remove(id);
    }

    public static GuardedObject createGuardedObject() {
        GuardedObject guardedObject = new GuardedObject(generateId());
        boxes.put(guardedObject.getId(), guardedObject);
        return guardedObject;
    }

    public static Set<Integer> getBoxIds() {
        return boxes.keySet();
    }
}
