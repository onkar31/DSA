package JavaStreams.Phase4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question21 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Rahul", 80000, 30, "IT"),
                new Employee("Chitty", 55000, 20, "HR"),
                new Employee("Onkar", 90000, 29, "IT"),
                new Employee("Anagha", 95000, 27, "IT"),
                new Employee("Chamya", 60000, 26, "HR")
        );

        getGroupByDepartment(employees);
        getEmployeeCount(employees);
        getAverageSalaryByDepartment(employees);
    }

    // Group Employees by Department and return String (not Object).
    public static void getGroupByDepartment(List<Employee> employees) {
        Map<String, List<String>> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toList()
                        )
                ));
        System.out.println(result);
    }

    // Count Employees per Department
    public static void getEmployeeCount(List<Employee> employees) {
        Map<String, Long> result = employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.counting()
                                )
                        );
        System.out.println(result);
    }

    // Get Average salary by Department
    public static void getAverageSalaryByDepartment(List<Employee> employees) {
        Map<String,Double> result = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );
        System.out.println(result);
    }
}
