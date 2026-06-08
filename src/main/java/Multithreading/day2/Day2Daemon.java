package Multithreading.day2;

/*
Daemon threads are low priority
Used for background tasks only
Must be called before start()
*/

public class Day2Daemon {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while(true){
                System.out.println("Daemon thread running..." );
                try{
                    Thread.sleep(1500);
                }catch (Exception e){}
            }

        });
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main thread ends!");
    }
}

