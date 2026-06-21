package JavaStreams.Phase4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question24 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Rahul", 80000, 30, "IT"),
                new Employee("Chitty", 55000, 20, "HR"),
                new Employee("Onkar", 90000, 29, "IT"),
                new Employee("Anagha", 95000, 27, "IT"),
                new Employee("Chamya", 60000, 26, "HR")
        );

        groupEmpByDept(employees);
        groupSalariesByDept(employees);
        getEmpCountPerDept(employees);
    }

    // Group Department by Employees
    public static void groupEmpByDept( List<Employee> employees) {
        Map<String, List<String>> result = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName, Collectors.toList()
                                )
                        )
                );
        System.out.println(result);
    }

    // Group Department by Salaries
    public static void groupSalariesByDept(List<Employee> employees) {
        Map<String, List<Double>> result = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee :: getDepartment,
                                Collectors.mapping(Employee::getSalary, Collectors.toList())
                        )
                );
        System.out.println(result);
    }

    // Group Department and get Employee count per Department
    public static void getEmpCountPerDept(List<Employee> employees) {
        Map<String, Long> result = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee :: getDepartment,
                                Collectors.mapping(Employee::getSalary, Collectors.counting())
                        )
                );
        System.out.println(result);
    }
}
