package JavaStreams.Phase4;

class Employee {

    private int age;
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, int age, String department) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "{" + " name= " + name +"}";
    }
}
