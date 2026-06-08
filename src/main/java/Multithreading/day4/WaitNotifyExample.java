package Multithreading.day4;

public class WaitNotifyExample {
    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1 waiting...");
                try{
                    lock.wait();
                } catch (Exception e) {}
                System.out.println("Thread 1 resumes...");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 notifying...");
                lock.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
