package JavaStreams.Phase1_Basics;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatingChar {

    public static void main(String[] args) {
        String str = "engineering";
        getFirstNonRepeatingChar(str);
        getFirstRepeatingChar(str);

        List<String> words = List.of("java", "spring", "sql", "spring", "java");
        getNonRepeatingString(words);

        int[] arr = {10, 20, 10 , 30, 10};
        getFirstNonRepeatingInt(arr);
    }

    //First Non Repeating char
    public static void getFirstNonRepeatingChar(String str){
        //Time complexity: O(n)
        Character result = str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(
                        ch -> ch,
                        LinkedHashMap::new,
                        Collectors.counting()
                        ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

    /*
        //alternative approach  -> Not efficient Time Complexity: O(n2)
        Character result = str.chars()
                        .mapToObj(c -> (char)c)
                                .filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch))
                                        .findFirst()
                                                .orElse(null);

    */
        System.out.println("First Non Repeating Char: "+result);
    }

//First Repeating character
    public static void getFirstRepeatingChar(String str) {
        //Time complexity: O(n)
        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        ch -> ch,
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First Repeating Char: "+result);
    }

    // First Non Repeating word
    public static void getNonRepeatingString(List<String> words){
        String word = words.stream()
                        .collect(Collectors.groupingBy(
                                str -> str,
                                LinkedHashMap::new,
                                Collectors.counting()
                        ))
                                .entrySet()
                                        .stream()
                                                .filter(entry -> entry.getValue() == 1)
                                                        .map(Map.Entry::getKey)
                                                                .findFirst()
                                                                        .orElse(null);
        System.out.println("Non Repeating String: "+word);
    }

//    First Unique Number
public static void getFirstNonRepeatingInt(int[] nums){
    Integer result = Arrays.stream(nums)
                    .boxed()
                            .filter(num -> Arrays.stream(nums).filter(n -> n ==num).count() == 1)
                                    .findFirst()
                                            .orElse(null);
    System.out.println("First Non Repeating Integer: "+result);
}
}
