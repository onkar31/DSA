package JavaStreams.Phase1_Basics;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<String> str = Arrays.asList("java", "springboot", "sql");
        List<String> concat = Arrays.asList("java", "streams", "are", "fun");
        prodOfNumbers(list);
        getMax(list);
        findLongestString(str);
        concatStrings(concat);
        sumOfNumbers(list);
        totalLengthOfWords(str);

    }
//  Product of Numbers
    public static void prodOfNumbers(List<Integer> list){
        int product = list.stream()
                .reduce(1, (a,b) -> a*b);
        System.out.println("Product of Array: "+product);
    }

//  Find Maximum using Reduce
    public static void getMax(List<Integer> list){
        int max = list.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Max number from array: "+max);
    }

//    Find longest string
    public static void concatStrings(List<String> word){
        String conc = word.stream()
                .reduce("", (a, b) -> a+ " "+ b).trim();
        System.out.println("Concated words are: "+ conc);
    }

//    Concatenate String
    public static void findLongestString(List<String> word){
        String longestStr = word.stream()
                .reduce("", (a, b) -> a.length() > b.length() ? a : b) ;
        System.out.println("Longest String: "+longestStr);
    }

//    Find total length of all words
    public static void totalLengthOfWords(List<String> word){
        int totalLength = word.stream()
                .map(String::length)
                .reduce(0, Integer::sum) ;
        System.out.println("Total Length of words: "+ totalLength);
}

    // ----------------------------------------------------------------  //
//    Find sum of Numbers
    public static void sumOfNumbers(List<Integer> list){
//        int sum = list.stream()
//                .reduce(0, (a,b) -> a+b);

    // Note: For integer sums prefer mapToInt().sum() instead od reduce
        int sum = list.stream()
                        .mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Array: "+sum);
    }

}
