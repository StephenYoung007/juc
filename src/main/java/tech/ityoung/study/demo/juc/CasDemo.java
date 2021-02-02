package tech.ityoung.study.demo.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
class BankAccount {
    private AtomicInteger account;

    public BankAccount(Integer account) {
        this.account = new AtomicInteger(account);
    }

/*    public void withdraw(int amount) {
        account -= amount;
    }*/

    /*public void withdraw(int amount) {
        while (true) {
            int init = account.get();
            int next = init - amount;
            if (account.compareAndSet(init, next)) {
                break;
            }
        }
    }*/

    public void withdraw(int amount) {
        account.addAndGet(-1 * amount);
    }

    public void concurrentWithdraw(int amount) throws InterruptedException {
        long begin = System.nanoTime();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(() -> {
                withdraw(10);
            });
            threads.add(t);
        }
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
        }
        long end = System.nanoTime();
        log.info("the left account is: {}", account);
        log.info("total time is: {}ms", (end - begin) / (1000 * 1000));
    }
}

public class CasDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(10000);
        bankAccount.concurrentWithdraw(10);
    }
}
