package JavaStreams.Phase1_Basics;

import java.util.ArrayList;
import java.util.List;

public class ConvertStrings {
    public static void main(String[] args) {
        List<String> str1 = List.of("java", "spring", "boot");
        List<String> str2 = List.of("Java", "SPring", "MICROSERVICES");
        List<Integer> str3 = List.of(1, 2, 3, 4, 5);
        convertToUppercase(str1);
        convertToLowerCase(str2);
        convertIntIntoString(str3);
        squareNums(str3);
        lengthOfEachWord(str2);
    }

//    Convert List of Strings to Uppercase
    public static void convertToUppercase(List<String> str) {
        List<String> upper = str.stream()
               // .map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase: "+ upper);
    }

//   Convert List of Strings to Uppercase
    public static void convertToLowerCase(List<String> str) {
        List<String> lower = str.stream()
                .map(String::toLowerCase)
                        .toList();
        System.out.println("Lowercase: "+ lower);
    }

//    Convert Integer → String
public static void convertIntIntoString(List<Integer> nums) {
    List<String> result = nums.stream()
            .map(String::valueOf)
                    .toList();
    System.out.println("Nums: "+ result);
}

//    Square Numbers
    public static void squareNums(List<Integer> nums){
        List<Integer> result = nums.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("Squares: "+ result);
    }

//    Find length of each word.
    public static void lengthOfEachWord(List<String> str){
        List<Integer> wordLength = str.stream()
                .map(String::length)
                .toList();
        System.out.println("Length of each word: "+ wordLength);
    }


//    Extract Employee Names
/*    employees.stream()
        .map(Employee::getName)
         .toList();
 */
}
