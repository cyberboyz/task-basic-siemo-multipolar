package com.demo.model;

public class EmployeeProfileWithIncentive {
    protected String id;
    protected String name;
    protected String entryDate;
    protected String employeeGroup;
    protected String monthlySalary;
    protected String incentivePercentage;
    protected String incentiveNominal;

    public EmployeeProfileWithIncentive() {
    }

    public EmployeeProfileWithIncentive(String id, String name, String entryDate, String employeeGroup, String monthlySalary, String incentivePercentage, String incentiveNominal) {
        this.id = id;
        this.name = name;
        this.entryDate = entryDate;
        this.employeeGroup = employeeGroup;
        this.monthlySalary = monthlySalary;
        this.incentivePercentage = incentivePercentage;
        this.incentiveNominal = incentiveNominal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
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

    public String getIncentiveNominal() {
        return incentiveNominal;
    }

    public void setIncentiveNominal(String incentiveNominal) {
        this.incentiveNominal = incentiveNominal;
    }
}
