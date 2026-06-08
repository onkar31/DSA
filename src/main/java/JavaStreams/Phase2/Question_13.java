package JavaStreams.Phase2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Question_13 {

    public static void main(String[] args) {
        List<String> words = List.of("java", "spring", "javascript", "advance java", "python");
        getSubstringWordList(words);
        returnUppercaseWords(words);

        List<String> words_Uppercase = List.of("Java", "spring", "javascript", "advance Java", "python");
        getSubstringCaseInsensitive(words_Uppercase);

        List<String> wordsWithNull = Arrays.asList("java", null, "spring", "javascript", "advance java", "python");
        getSubstringWordList(wordsWithNull);

        List<Employee> employees = List.of(
                new Employee(1, "Onkar", 75000),
                new Employee(2, "Rahul", 50000),
                new Employee(3, "Anagha", 80000),
                new Employee(4, "Priya", 90000)
        );
        getEmployeeDetails(employees);
    }

    // Filter Strings containing a Given substring -> 'java'
    public static void getSubstringWordList(List<String> words) {
        List<String> substrings = words.stream()
                .filter(Objects::nonNull)           //to handle Null values
                .filter(word -> word.contains("java"))
                .toList();
        System.out.println(substrings);
    }

    // Filter Strings containing a Given substring -> 'java'
    // Case-Insensitive Solution
    public static void getSubstringCaseInsensitive(List<String> words) {
        String searchWord = "java".toLowerCase();
        List<String> result = words.stream()
                .filter(word -> word.toLowerCase().contains(searchWord))
                .toList();
        System.out.println(result);
    }

    //Return employee: salary > 50000 and name contains "n"
    public static void getEmployeeDetails(List<Employee> employees) {
        List<Employee> employeeDetails = employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .filter(emp -> emp.getName().toLowerCase().contains("n"))
                .toList();
        System.out.println(employeeDetails);
    }

    // Return uppercase words containing -> 'java'
    public static void returnUppercaseWords(List<String> words) {
        List<String> uppercase = words.stream()
                .filter(word -> word.contains("java"))
                .map(String::toUpperCase)
                .toList();
        System.out.println(uppercase);
    }
}
