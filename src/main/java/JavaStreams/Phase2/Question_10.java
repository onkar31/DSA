package JavaStreams.Phase2;

import java.util.List;

public class Question_10 {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "Onkar", 75000),
                new Employee(2, "Rahul", 50000),
                new Employee(3, "Anagha", 80000),
                new Employee(4, "Priya", 90000)
        );
        extractNames(employees);
        extractNameSalary(employees);
        extractNameAboveThreshold(employees);
        convertEmpIntoString(employees);
    }

    // Extarct Name from Employee List
    public static void extractNames(List<Employee> employees) {
       List<String> names = employees.stream()
               .map(Employee::getName)
               .toList();
       System.out.println("Employee Names: "+names);
    }

    // Extarct Name & Salary from Employee List
    public static void extractNameSalary(List<Employee> employees) {
        List<String> nameSalary = employees.stream()
                .map(emp -> emp.getName() + " - " + emp.getSalary())
                .toList();
        System.out.println("Employee: "+nameSalary);
    }

    // Get name of employees whose salary is above 70000
    public static void extractNameAboveThreshold(List<Employee> employees) {
        List<String> names =  employees.stream()
                .filter(emp -> emp.getSalary() > 70000)
                .map(Employee::getName)
                .toList();
        System.out.println("Employee names whose salary above 70K: "+names);
    }

    // Convert Employee into String
    public static void convertEmpIntoString(List<Employee> employees) {
        List<String> names = employees.stream()
                .map(emp -> "\n" + emp.getName() + " works here.")
                .toList();
        String result = String.join(" ", names);
        System.out.println(result);
    }
}
