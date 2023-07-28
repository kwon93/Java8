package me.kwon.concurrnent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello"+Thread.currentThread().getName());
            return "hello";
        });

        CompletableFuture<String> world = getWorld("world");

        CompletableFuture<String> future = hello.thenCompose(CompletableFuture2::getWorld);

        System.out.println(future.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("world" + Thread.currentThread().getName());
            return message+" world";
        });
    }
}
