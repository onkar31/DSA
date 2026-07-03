package JavaStreams.Phase5;

import java.util.List;
import java.util.stream.Collectors;

public class Question_26 {
    public static void main(String[] args) {
        List<String> technologies = List.of("Java", "Spring Boot", "Kafka", "AWS");
        convertListToCommaSeperatedList(technologies);
        addDPrefixSuffix(technologies);

        List<Employee> employees = List.of(
                new Employee(100,"Chamya", 80000, "IT"),
                new Employee(101, "Chitty", 55000, "HR"),
                new Employee(102, "Onkar", 90000, "IT")
        );
        getEmployeeIds(employees);
    }

    // Convert List into Comma seperated values
    public static void convertListToCommaSeperatedList(List<String> technologies) {
        String result = technologies.stream()
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }

    // Add delimeter, prefix and suffix to a given List
    public static void addDPrefixSuffix(List<String> technologies) {
        String result = technologies.stream()
                .collect(Collectors.joining(" --> ", "{", "}"));
        System.out.println(result);
    }

    // Get Employee Ids and convert them into CSv form
    public static void getEmployeeIds(List<Employee> employees) {
        String ids = employees.stream()
                .map(emp -> String.valueOf(emp.getEmployeeID()))  //Converted ids into string as Collectors.joining() only work on Stream<String>
                .collect(Collectors.joining(", "));

//      Or -->  .map(Employee::getEmployeeID)
//              .collect(Collectors.joining(", "))

        System.out.println(ids);
    }
}
