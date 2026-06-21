package JavaStreams.Phase5;

import java.util.Arrays;
import java.util.List;

public class Question25 {
    public static void main(String[] args) {
        List<List<Integer>> nums = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );

        getflattenList(nums);

        List<List<String>> department = List.of(
                List.of("Chamya", "Onkar"),
                List.of("Anmol", "Jimya" ),
                List.of("Chitty", "Sonya")
        );
        getflattenNames(department);

        List<String> words  = List.of(
                "Hello there",
                "Hello world",
                "Hi, there and Hello"
        );
        getUniqueWords(words);
    }

    // flatten the list of list and get numbers
    public static void getflattenList(List<List<Integer>> nums) {
        List<Integer> list = nums.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(list);
    }

    // flatten the list of list and get names
    public static void getflattenNames(List<List<String>> names) {
        List<String> res = names.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(res);
    }

    // find unique words from the list
    public static void getUniqueWords(List<String> words) {
        List<String> res = words.stream()
                        .flatMap(word -> Arrays.stream(word.split(" ")))
                                .distinct().toList();
        System.out.println(res);
    }

}
