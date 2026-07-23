package Multithreading.practice;

class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i+=2) {
            System.out.println("Thread Name: "+EvenThread.currentThread().getName() +" Even: "+ i);
        }
    }
}

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i+=2) {
            System.out.println("Thread Name: "+OddThread.currentThread().getName()+ " Odd: "+ i);
        }
    }
}


public class EvenOdd {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        evenThread.start();
        oddThread.start();
    }
}
