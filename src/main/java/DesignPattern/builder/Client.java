package DesignPattern.builder;

public class Client {
    public static void main(String[] args) {
        Employee emp = new Employee.EmployeeBuilder(101, "Chamya")
                .department("Security")
                .salary(20000)
                .age(2)
                .build();
        System.out.println(emp);
    }
}
