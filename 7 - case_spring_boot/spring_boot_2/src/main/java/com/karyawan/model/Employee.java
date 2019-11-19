package com.karyawan.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "karyawan")
public class Employee {

    private long id;
    private String name;
    private EmployeeGroup employeeGroup;
    private int age;

    public Employee() {
    }

    public Employee(long id, String name, EmployeeGroup employeeGroup, int age) {
        this.id = id;
        this.name = name;
        this.employeeGroup = employeeGroup;
        this.age = age;
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

    @ManyToOne
    @JoinColumn(name = "employee_group")
    @JsonProperty("employee_group")
    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
    }

    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", nama=" + name + ", golongan=" + employeeGroup + ", umur=" + age + "]";
    }
}