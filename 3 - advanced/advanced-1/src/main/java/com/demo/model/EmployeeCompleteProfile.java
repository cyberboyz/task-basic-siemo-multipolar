package com.demo.model;

public class EmployeeCompleteProfile {
    protected Employee employee;
    protected EmployeeGroup employeeGroup;

    public EmployeeCompleteProfile(Employee employee, EmployeeGroup employeeGroup) {
        this.employee = employee;
        this.employeeGroup = employeeGroup;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
    }
}
