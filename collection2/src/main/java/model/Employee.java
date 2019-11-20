package model;

public class Employee {
    protected int id;
    protected String name;
    protected String date;
    protected EmployeeGroup employeeGroup;

    public Employee() {
    }

    public Employee(int id, String name, String date, EmployeeGroup employeeGroup) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.employeeGroup = employeeGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
    }
}
