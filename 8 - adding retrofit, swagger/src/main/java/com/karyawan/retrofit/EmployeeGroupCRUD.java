package com.karyawan.retrofit;

import com.karyawan.model.EmployeeGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeGroupCRUD {
    public static void postEmployeeGroup(CRUD github) throws IOException {
        System.out.println("=== Post an employee group ===");

        // Create an employee group instance
        EmployeeGroup employeeGroupSample = new EmployeeGroup(1, "admin", 7000000);

        // Insert the employee group instance
        EmployeeGroup body = github.createEmployeeGroup(employeeGroupSample).execute().body();
        System.out.println(body);
    }

    public static void postSeveralEmployeeGroups(CRUD github) throws IOException {
        System.out.println("=== Post several employee groups ===");

        // Create several employee groups instance
        List<EmployeeGroup> employeeGroups = new ArrayList<>();
        employeeGroups.add(new EmployeeGroup(2, "user", 5000000));
        employeeGroups.add(new EmployeeGroup(3, "secretary", 6000000));

        // Insert the employee group instance
        for (EmployeeGroup employeeGroup : employeeGroups) {
            github.createEmployeeGroup(employeeGroup).execute().body();
        }
    }
}
