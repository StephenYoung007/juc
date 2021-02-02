package tech.ityoung.study.demo.juc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class ThreadCreattionDemo1 {
    public static void main(String[] args) throws InterruptedException {
        log.info("main thread begins");
        ThreadDemo demo = new ThreadDemo();
        demo.start();
        log.info("main thread end");
    }
}

@Slf4j
class ThreadDemo extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        log.info("this is subClass of Thread");
        Thread.sleep(10000);
        log.info("awake");
    }
}

class FutureDemo implements RunnableFuture{
    @Override
    public void run() {

    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
