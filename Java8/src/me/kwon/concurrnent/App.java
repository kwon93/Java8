package me.kwon.concurrnent;

public class App {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) { //sleep 동안에 쓰레드를 꺠우면
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 2 : "+ Thread.currentThread().getName());
            }
        });

        thread.start();

        Thread thread2 = new Thread(() -> {
           while (true){
               System.out.println("Thread2 : "+Thread.currentThread().getName());
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   System.out.println("exit~~");
                   return;
               }
           }

        });

        System.out.println("hello!"); //main thread가 먼저 출력될 수 있다.
        //thread의 순서는 보장되지 않는다.
        thread2.start();
        thread.join(); //기다려주기
        thread2.interrupt(); //Tread 깨우기


    }

    static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("Thread: "+Thread.currentThread().getName());
        }
    }
}
