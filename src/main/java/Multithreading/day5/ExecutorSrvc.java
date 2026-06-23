package Multithreading.day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSrvc {
    public static void main(String[] args) {
        ExecutorService exucutor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            exucutor.submit(() -> {
                System.out.println("Task "+taskId+" executed by "+ Thread.currentThread().getName());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {}
            });
        }
        exucutor.shutdown();
    }
}
