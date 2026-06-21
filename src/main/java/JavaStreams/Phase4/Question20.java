package JavaStreams.Phase4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Grouping
public class Question20 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "ant", "banana", "ball", "cat");
        groupByFirstLetter(words);

        List<Integer> numbers = List.of(1,2,3,4,5,6);
        groupByEvenOdd(numbers);

        List<Employee> employees = List.of(
                new Employee("Rahul", 80000, 30, "IT"),
                new Employee("Chitty", 55000, 20, "HR"),
                new Employee("Onkar", 90000, 29, "IT"),
                new Employee("Anagha", 95000, 27, "IT"),
                new Employee("Chamya", 60000, 26, "HR")
        );
        groupByDepartment(employees);
        groupByNameLength(employees);
    }

    //Group by first character
    public static void groupByFirstLetter(List<String> words) {
        Map<Character, List<String>> result = words.stream()
                .collect(
                        Collectors.groupingBy(word -> word.charAt(0))
                );
        System.out.println(result);
    }

    //Group numbers by even/odd
    public static void groupByEvenOdd(List<Integer> numbers) {
        Map<String, List<Integer>> result = numbers.stream()
                .collect(
                        Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd")
                );
        System.out.println(result);
    }

    //Group Employee by Department
    public static void groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> result = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment)
                );
        System.out.println(result);
    }

    //Group Employee by name length
    public static void groupByNameLength(List<Employee> employees) {
        Map<Integer, List<Employee>> result = employees.stream()
                .collect(
                        Collectors.groupingBy(e -> e.getName().length())
                );
        System.out.println(result);
    }
}
