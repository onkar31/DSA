package JavaStreams.Phase3_Sorting;

import java.util.Comparator;
import java.util.List;

public class Question18 {
    public static void main(String[] args) {
        List<String> names = List.of("onkar", "Rahul", "amit", "Priya", "Zebra");
        sortStrings(names);
        descSortStrings(names);

        List<Employee> employees = List.of(
                new Employee("Rahul", 80000, 30),
                new Employee("Amit", 80000, 25),
                new Employee("Priya", 90000, 28),
                new Employee("Anagha", 90000, 27),
                new Employee("Anuja", 190000, 37),
                new Employee("onkar", 95000, 27)
        );

        sortEmployeeNames(employees);
    }

    //Sort String Ignoring case
    public static void sortStrings(List<String> names) {
     /*
        List<String> sortedNames = names.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();
        System.out.println(sortedNames);
     */
        //alternative solution
        List<String> sortedNames = names.stream()
                .sorted(String::compareToIgnoreCase)
                .toList();
        System.out.println(sortedNames);
    }

    //Descending sort String Ignoring case
    public static void descSortStrings(List<String> names) {
        List<String> sortedNames = names.stream()
                .sorted(String::compareToIgnoreCase)
                .toList().reversed();
        System.out.println(sortedNames);
    }

    //Sort employee names by length then alphabets
    public static void sortEmployeeNames(List<Employee> employees) {
        List<Employee> sortedNames = employees.stream()
                        .sorted(
                                Comparator.comparingInt((Employee e) -> e.getName().length())
                                        .thenComparing((Employee e) -> e.getName(), String.CASE_INSENSITIVE_ORDER)
                        ).toList();
        System.out.println(sortedNames);
    }
}
