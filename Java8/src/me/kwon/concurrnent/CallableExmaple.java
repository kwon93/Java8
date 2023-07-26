package me.kwon.concurrnent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableExmaple {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(3000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(2000L);
            return "java";
        };

        Callable<String> kwon = () -> {
            Thread.sleep(1000L);
            return "kwon";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println("started");
        System.out.println(helloFuture.isDone()); //끝났으면 true
//        helloFuture.cancel(false);
        helloFuture.get(); //blocking call
        System.out.println("end");
        System.out.println(helloFuture.isDone());


        String invokeAny = executorService.invokeAny(Arrays.asList(hello, java, kwon));
        System.out.println(invokeAny); // 제일 먼저 끝나는거만 호출함.

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, kwon));
        //여러개 한꺼번에 출력하기, 마지막 하나가 다 끝날때 까지 기다림. ex) 실시간 주가 정보를 다 가져와서 한번에 출력할 때

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }




        executorService.shutdown();

    }
}
