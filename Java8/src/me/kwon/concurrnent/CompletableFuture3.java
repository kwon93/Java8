package me.kwon.concurrnent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("hello"+Thread.currentThread().getName());
            return "hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("world"+Thread.currentThread().getName());
            return "world";
        });

        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> {
            return h + " " + w;
        });

        System.out.println(future.get());

    }
}
