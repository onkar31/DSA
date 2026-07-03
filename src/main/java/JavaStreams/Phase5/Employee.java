package JavaStreams.Phase5;

class Employee {

    private int employeeID;
    private String name;
    private double salary;
    private String department;

    public Employee(int employeeID, String name, double salary, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getEmployeeID() {
        return employeeID;
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
        return "{" + " employeeID= " + employeeID +"}";
    }
}
