package com.demo.model;

import java.util.Date;

public class Employee {
    protected String id;
    protected String name;
    protected String entryDate;
    protected String group;

    public Employee(String id, String name, String entryDate, String group) {
        this.id = id;
        this.name = name;
        this.entryDate = entryDate;
        this.group = group;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
