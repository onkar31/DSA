package JavaStreams.Phase2;

import java.util.List;

public class Question_12 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 4, 5);
        uniqueNumbers(numbers);
        countUniqueNumbers(numbers);
    }

    //Remove duplicate using streams
    public static void uniqueNumbers(List<Integer> numbers){
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println(uniqueNumbers);
    }

    //Count unique nums
    public static void countUniqueNumbers(List<Integer> numbers){
        long count = numbers.stream()
                .distinct().count();
        System.out.println("Unique Number count: "+count);
    }
}
