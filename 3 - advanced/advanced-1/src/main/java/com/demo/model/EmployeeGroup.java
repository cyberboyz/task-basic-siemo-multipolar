package com.demo.model;

public class EmployeeGroup {
    protected String employeeGroup;
    protected String monthlySalary;
    protected String incentivePercentage;

    public EmployeeGroup(String employeeGroup, String monthlySalary, String incentivePercentage) {
        this.employeeGroup = employeeGroup;
        this.monthlySalary = monthlySalary;
        this.incentivePercentage = incentivePercentage;
    }

    public EmployeeGroup(String employeeGroup, String monthlySalary) {
        this.employeeGroup = employeeGroup;
        this.monthlySalary = monthlySalary;
    }

    public String getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(String employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    public String getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getIncentivePercentage() {
        return incentivePercentage;
    }

    public void setIncentivePercentage(String incentivePercentage) {
        this.incentivePercentage = incentivePercentage;
    }
}
