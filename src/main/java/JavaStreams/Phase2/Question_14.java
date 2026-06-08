package JavaStreams.Phase2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Question_14 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("a", null, "hi", "Hello", "World", "go", "java", "sql");
        getWords(words);
        convertWordsIntoUppercase(words);
        getWordsContainsA(words);
    }

    // Return words with length >=3
    public static void getWords(List<String> words){
        List<String> result = words.stream()
                .filter(Objects::nonNull)
                .filter(word -> word.length() >= 3)
                .toList();
        System.out.println(result);
    }

    //Convert to Uppercase
    public static void convertWordsIntoUppercase(List<String> words){
        List<String> result = words.stream()
                .filter(Objects::nonNull)
                .filter(word -> word.length() >= 3)
                .map(String::toUpperCase).toList();
        System.out.println(result);
    }

    // Return words with length >=3 and contains "a"
    public static void getWordsContainsA(List<String> words){
        List<String> result = words.stream()
                .filter(Objects::nonNull)
                .filter(word -> word.length() >= 3)
                .filter(word -> word.contains("a"))
                .toList();
        System.out.println(result);
    }
}
