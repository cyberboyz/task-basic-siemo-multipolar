package com.karyawan.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "golongan")
public class EmployeeGroup {

    private long id;
    private String name;
    private double monthlySalary;

    public EmployeeGroup() {
    }

    public EmployeeGroup(long id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "monthly_salary", nullable = false)
    @JsonProperty("monthly_salary")
    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "Employee Group [id=" + id + ", nama=" + name + ", gaji bulanan=" + monthlySalary + "]";
    }
}