package JavaStreams.Phase2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question_09 {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Onkar", 75000),
                new Employee(2, "Rahul", 50000),
                new Employee(3, "Anagha", 80000),
                new Employee(4, "Priya", 90000)
        );

        salaryGreaterThan(employees);
        salaryGreaterThanCount(employees);
        getFistEmpAboveThreshold(employees);
        highestPaidAboveThreashold(employees);

    }

    // Return employees whose salary is greater than: 70000
    public static void salaryGreaterThan(List<Employee> employees){
        double threshold = 70000;
        List<Employee> result = employees.stream()
                .filter(emp -> emp.getSalary() > threshold)
                .toList();
        System.out.println("Salary greater than 70000"+ result);
    }

    // Count number of employees whose salary is greater than: 70000
    public static void salaryGreaterThanCount(List<Employee> employees){
        double threshold = 70000;
        long count = employees.stream()
                .filter(emp -> emp.getSalary() > threshold)
                        .count();
        System.out.println("Number of employees count whose Salary greater than 70000 is : "+ count);
    }

    // Find first employees whose salary is greater than: 70000
    public static void getFistEmpAboveThreshold(List<Employee> employees){
        double threshold = 70000;
        Employee emp = employees.stream()
                .filter(e -> e.getSalary() > threshold)
                        .findFirst()
                                .orElse(null);
//                        .max(Comparator.comparing(Employee::getSalary))
//                                .orElse(null);
        System.out.println("First Employee whose Salary greater than 70000 is : "+ emp);
    }

    // Find Highest paid employee over threshold 70000
    public static void highestPaidAboveThreashold(List<Employee> employees){
        double threshold = 70000;
        Employee emp = employees.stream()
                .filter(e -> e.getSalary() > threshold)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        System.out.println("Highest paid Employee above threashold salary 70000 is : "+ emp);
    }

}
