package me.kwon.concurrnent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample2 {
    public static void main(String[] args) {
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.submit(getRunnable("hello~"));
        executorService2.submit(getRunnable("world~"));
        executorService2.submit(getRunnable("bye~"));
        executorService2.submit(getRunnable("kwon~~"));
        executorService2.submit(getRunnable("hyeok~~"));

        executorService2.shutdown();

        ScheduledExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();
        executorService3.scheduleAtFixedRate(getRunnable("hi"), 1,2, TimeUnit.SECONDS); //1초 기다렸다가 2초에 한번 출력

        executorService3.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () ->{
            System.out.println(message+Thread.currentThread().getName());
        };
    }
}
