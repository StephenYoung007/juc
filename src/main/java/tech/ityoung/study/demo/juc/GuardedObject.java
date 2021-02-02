package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuardedObject {
    private Integer id;

    public GuardedObject(Integer id) {
        this.id = id;
    }

    public GuardedObject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Object lock = new Object();
    private Object response = null;

    public Object get(long waitTime) {
        synchronized (lock) {
            long begin = System.currentTimeMillis();
            long start = 0;
            while (response == null) {
                if (waitTime - start <= 0) {
                    break;
                }
                try {
                    lock.wait(waitTime - start);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long now = System.currentTimeMillis();
                start = now - begin;
            }
            log.info("get response completed");
            return response;
        }
    }

    public void complete(Object response) {
        synchronized (lock) {
            while (response != null) {
                this.response = response;
                lock.notifyAll();
                break;
            }
        }
    }
}
