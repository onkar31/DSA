package Multithreading.practice;

class NumberPrinter {
    private boolean oddTurn = true;

    public synchronized void printOdd(int num){
        while(!oddTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd: "+ num);
        oddTurn = false;
        notify();
    }

    public synchronized void printEven(int num) {
        while(oddTurn){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even: "+ num);
        oddTurn = true;
        notify();
    }

    static class EvenThread extends Thread {
        NumberPrinter np;

        EvenThread(NumberPrinter np) {
            this.np = np;
        }

        @Override
        public void run() {
            for (int i = 2; i <= 10; i+=2) {
                np.printEven(i);
            }
        }
    }

    static class OddThread extends Thread {
        NumberPrinter np;

        OddThread(NumberPrinter np) {
            this.np = np;
        }
        @Override
        public void run() {
            for (int i = 1; i <= 10; i+=2) {
                np.printOdd(i);
            }
        }
    }

}

public class OddEvenAlternate {

    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();
        NumberPrinter.EvenThread evenThread = new NumberPrinter.EvenThread(np);
        NumberPrinter.OddThread oddThread = new NumberPrinter.OddThread(np);
        evenThread.start();
        oddThread.start();
    }
}
