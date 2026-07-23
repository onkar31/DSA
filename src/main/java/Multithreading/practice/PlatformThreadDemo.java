package Multithreading.practice;

public class PlatformThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; i <= 10000; i++) {
            int id = i;
            Thread t = new Thread(() -> {
                System.out.println("Platfrom Thread: " + id);
            });
            t.start();
        }
    }
}
