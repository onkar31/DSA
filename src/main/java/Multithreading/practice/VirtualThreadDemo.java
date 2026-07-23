package Multithreading.practice;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 50000; i++) {
            int id = i;
            Thread.ofVirtual()
                    .start(() -> System.out.println("Virtual Thread: " + id));
        }
    }
}
