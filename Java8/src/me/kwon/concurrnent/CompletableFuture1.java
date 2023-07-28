package me.kwon.concurrnent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello"+Thread.currentThread().getName());
            return "hello";
        },executorService).thenApply((s)->{ //get 호출전에 정의 가능.
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });

        Thread.sleep(1000);
        System.out.println(future.get());//get하면 future의 작업이 return된다.


    }
}
