package tech.ityoung.study.demo.juc;

import java.util.LinkedList;
import java.util.concurrent.locks.LockSupport;

public class MessageQueenDemo {
    public static void main(String[] args) {
        LockSupport.park();
    }
}

class MessageQueue {
    private LinkedList<Message> list = new LinkedList();
    private int capacity;

    public Message take() throws InterruptedException {
        synchronized (list){
            while (list.isEmpty()) {
                list.wait();
            }
            Message first = list.removeFirst();
            list.notifyAll();
            return first;
        }
    }

    public void put(Message message) throws InterruptedException {
        synchronized (list) {
            while (list.size() == capacity) {
                list.wait();
            }
            list.addLast(message);
            list.notifyAll();
        }
    }

}

class Message{
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}


