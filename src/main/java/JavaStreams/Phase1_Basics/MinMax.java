package JavaStreams.Phase1_Basics;

import java.util.*;

public class MinMax {

    public static class Employee{
        int id;
        String name;
        double salary;

        Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 2, 9, 1, 7);
        List<Integer> nums1 = List.of();
        List<String> words = List.of("java", "springBoot", "Microservices", "Git");

        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 30000),
                new Employee(2, "Ram", 40000),
                new Employee(3, "Chamya", 80000)
        );
        getMinMax(nums);
        getMinMaxHandleNull(nums1);
        getMinMaxString(words);
        getHighestSalaryEmp(employees);
    }

//    Find Min & Max Using Stream API
    public static void getMinMax(List<Integer> numbers) {
        int min = numbers.stream()
                .min(Integer::compareTo).get();

        int max = numbers.stream()
                .max(Integer::compareTo).get();

        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    //    Find Min & Max Using Stream API Handle Null
    public static void getMinMaxHandleNull(List<Integer> numbers) {
        int min = numbers.stream()
                .mapToInt(Integer::intValue).min().orElse(0);

        int max = numbers.stream()
                .mapToInt(Integer::intValue).max().orElse(0);

        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    //    Find Min/Max string length
    public static void getMinMaxString(List<String> words) {
        String smallest = words.stream()
                        .min(Comparator.comparing(String::length)).orElse("");
        String largest = words.stream()
                .max(Comparator.comparing(String::length)).orElse("");

        System.out.println("Smallest String = " + smallest);
        System.out.println("Largest String = " + largest);
    }

    //    Find employee with Highest Salary
    public static void getHighestSalaryEmp(List<Employee> employees) {
//        Optional<Employee> highestPaid = employees.stream()
//                .max(Comparator.comparingDouble(Employee::getSalary));

        Employee highestPaid = employees.stream()
                        .max(Comparator.comparingDouble(Employee::getSalary))
                                .orElse(null);
        System.out.println("Highest Paid = " + highestPaid);
    }

}
