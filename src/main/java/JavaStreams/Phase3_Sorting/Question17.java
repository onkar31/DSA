package JavaStreams.Phase3_Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question17 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Rahul", 80000, 30),
                new Employee("Amit", 80000, 25),
                new Employee("Priya", 90000, 28),
                new Employee("Anagha", 90000, 27),
                new Employee("Onkar", 95000, 27)
        );

        sortbySalaryThenAge(employees);
        sortbySalaryDesc(employees);
        sortSalaryAscAgeDesc(employees);
        highestPaid(employees);
    }

    //Sort Employees by salary -> Then by Age
    public static void sortbySalaryThenAge(List<Employee> employees) {
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getAge)).toList();
        System.out.println(sortedEmployees);
    }

    //Sort Employees by salary -> Descending
    public static void sortbySalaryDesc(List<Employee> employees) {
        List<Employee> sortedSalary= employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed()).toList();
        System.out.println(sortedSalary);
    }

    //Sort Employees by salary ascending -> Then by Age Descending
    public static void sortSalaryAscAgeDesc(List<Employee> employees) {
        List<Employee> sortedResult = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .thenComparing(Employee::getAge).reversed()).toList();
        System.out.println(sortedResult);
    }

    //Highest paid employee
    public static void highestPaid(List<Employee> employees) {
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .findFirst().stream().toList();
        System.out.println(result);
    }
}
