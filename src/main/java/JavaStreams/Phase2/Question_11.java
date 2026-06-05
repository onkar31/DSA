package JavaStreams.Phase2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question_11 {
    public static void main(String[] args) {
        List<String> words = List.of("madam", "java", "level", "spring", "radar");
        getPalindromes(words);
        convertPalindromesToUppercase(words);
        getFirstPalindrome(words);
    }


    // Return all palindromes from List
    private static void getPalindromes(List<String> words) {
        List<String> palindromes = words.stream()
                .filter(Objects::nonNull)
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .toList();
        System.out.println(palindromes);
    }

    // Find first palindromes from List
    private static void getFirstPalindrome(List<String> words) {
       String firstPalindrome = words.stream()
                .filter(Objects::nonNull)
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
               .findFirst()
                       .orElse(null);
        System.out.println("First Palindrome: "+firstPalindrome);
    }

    // Convert all palindomes to Uppercase
    private static void convertPalindromesToUppercase(List<String> words) {
        List<String> palindromes = words.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .map(String::toUpperCase)
                .toList();
        System.out.println(palindromes);
    }
}
