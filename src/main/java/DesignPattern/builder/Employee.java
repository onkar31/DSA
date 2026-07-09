package DesignPattern.builder;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;

    private Employee(EmployeeBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.salary = builder.salary;
        this.department = builder.department;
    }


    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + salary + " " + department;
    }

    public static class EmployeeBuilder {
        private int id;
        private String name;
        private int age;
        private double salary;
        private String department;

        public EmployeeBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public EmployeeBuilder age(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder salary(double salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder department(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
