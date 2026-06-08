package Multithreading.day1;

// ways to create Threads

import java.util.concurrent.*;

// Extending Thread class
class MyThread extends Thread {

    public void run() {
        System.out.println("Thread Running: "+ Thread.currentThread().getName());
    }
}

// Implementing Runnable
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable Running: "+ Thread.currentThread().getName());
    }
}


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread1 = new MyThread();
        thread1.start();
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        //Using lambda
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread Running: "+ Thread.currentThread().getName());
        });
        thread3.start();

        //Using Callable + Future
        Callable<Integer> task = () -> {
            return 10 + 20;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);
        System.out.println("Result: "+ future.get());
        executor.shutdown();
    }
}
