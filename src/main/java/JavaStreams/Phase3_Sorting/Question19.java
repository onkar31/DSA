package JavaStreams.Phase3_Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question19 {
    public static void main(String[] args) {
        List<NewEmployee> employees = List.of(
                new NewEmployee("Rahul", "IT", 80000, 30),
                new NewEmployee("Amit", "IT", 80000, 25),
                new NewEmployee("Priya", "HR", 90000, 28),
                new NewEmployee("Onkar", "IT", 90000, 27),
                new NewEmployee("Sneha", "HR", 90000, 24)
        );
        customSort(employees);
    }

    //Sort by Department Desc, Salary Desc, Age Asc
    public static void customSort(List<NewEmployee> employees) {
        List<NewEmployee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(NewEmployee::getDepartment)
                        .thenComparing(NewEmployee::getSalary).reversed()
                        .thenComparing(NewEmployee::getAge)).toList();
        System.out.println(sortedEmployees);
    }

}
