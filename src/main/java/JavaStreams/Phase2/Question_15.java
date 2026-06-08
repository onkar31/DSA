package JavaStreams.Phase2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question_15 {

    public static void main(String[] args) {
        List<String> words = List.of("Chitty", "Raj", "Amit", "Priyansh", "Onkar", "Anmol", "Chamya");
        sortNamesByLength(words);
        sortNamesByLengthDesc(words);
        sortByNameAndAlphabets(words);
        sortByLastChar(words);
    }


    // Get names in sorted order - Default order: Ascending
    public static void sortNamesByLength(List<String> words){
        List<String> result = words.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
        System.out.println(result);
    }

    // Get names in sorted order - Descending
    public static void sortNamesByLengthDesc(List<String> words){
        List<String> result = words.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .toList();
        System.out.println(result);
    }

    // Sort By name and then alphabetically
    public static void sortByNameAndAlphabets(List<String> words){
        List<String> result = words.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(String::compareTo))
                .toList();
        System.out.println(result);
    }

    // Sort words by Last Character
    public static void sortByLastChar(List<String> words){
        List<String> result = words.stream()
                .sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
                .toList();
        System.out.println(result);
    }
}
