package Multithreading.day4;

class SharedBuffer{
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value){
        while (hasData){
            try{
                wait();
            }catch (InterruptedException e){}
        }
        data = value;
        System.out.println("Produced: "+ value);
        hasData = true;
        notify();
    }

    public synchronized void consume(){
        while (!hasData){
            try{
                wait();
            }catch (InterruptedException e){}
        }
        System.out.println("Consumed: "+ data);
        hasData = false;
        notify();
    }
}


public class ProducerConsumerProblem {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                buffer.produce(i);
            }
        });

        Thread consumer = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                buffer.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}
