package com.karyawan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;

@Entity
@Table(name = "karyawan")
public class Employee {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private int age;
    @SerializedName("employee_group")
    @Expose
    private EmployeeGroup employeeGroup;

    public Employee() {
    }

    public Employee(String name, int employeeGroupId, int age) {
        this.name = name;
        this.age = age;
        this.employeeGroup = new EmployeeGroup(employeeGroupId);
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
    public Employee setId(long id) {
        this.id = id;
        return this;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "employee_group")
    @JsonProperty("employee_group")
    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public Employee setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
        return this;
    }

    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", nama=" + name + ", golongan=" + employeeGroup + ", umur=" + age + "]";
    }
}