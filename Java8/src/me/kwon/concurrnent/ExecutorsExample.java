package me.kwon.concurrnent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {
    public static void main(String[] args) {
        //고수준 concurrency programing
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread"+Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }); //다음 작업이 들어올 때 까지 대기함. shutdown 필요
        executorService.shutdown(); //graceful shutdown : 작업을 마무리하고 셧다운
//        executorService.shutdownNow(); //바로 그냥 셧다운.



    }
}
