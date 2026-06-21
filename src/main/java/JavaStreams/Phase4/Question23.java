package JavaStreams.Phase4;

import java.util.*;
import java.util.stream.Collectors;

public class Question23 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Rahul", 80000, 30, "IT"),
                new Employee("Chitty", 55000, 20, "HR"),
                new Employee("Onkar", 90000, 29, "IT"),
                new Employee("Anagha", 95000, 27, "IT"),
                new Employee("Chamya", 60000, 26, "HR")
        );

        getHighestSalaryEmployeePerDepartment(employees);
        getHighestSalaryPerDepartment(employees);
        getLowestSalaryPerDepartment(employees);
        getLowestSalaryPerDepartmentNames(employees);
    }

    // Get Highest Salaried Employee per Department
    public static void getHighestSalaryEmployeePerDepartment(List<Employee> employees) {
        Map<String, Optional<Employee>> result = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment, Collectors.maxBy(
                                        Comparator.comparing(Employee::getSalary)

                                ))
                        );
        System.out.println(result);
    }

    // Get Highest Salary per Department
    public static void getHighestSalaryPerDepartment(List<Employee> employees) {
        Map<String, Double> result= employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee :: getDepartment,
                                 Collectors.collectingAndThen(
                                    Collectors.maxBy(
                                            Comparator.comparing(
                                                    Employee :: getSalary
                                            )
                                    ),
                                         emp -> emp.get().getSalary()
                                )
                        )
                );
        System.out.println(result);
    }


    // Get Lowest Salary per Department
    public static void getLowestSalaryPerDepartment(List<Employee> employees) {
        Map<String, Double> result= employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee :: getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.minBy(
                                                Comparator.comparing(
                                                        Employee :: getSalary
                                                )
                                        ),
                                        emp -> emp.get().getSalary()
                                )
                        )
                );
        System.out.println(result);
    }

    // Get Highest Salary per Department names only
    public static void getLowestSalaryPerDepartmentNames(List<Employee> employees) {
        Map<String, String> result= employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee :: getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparing(
                                                        Employee :: getSalary
                                                )
                                        ),
                                        emp -> emp.get().getName()
                                )
                        )
                );
        System.out.println(result);
    }
}
