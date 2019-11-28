package com.karyawan.retrofit;

import com.karyawan.model.Employee;
import com.karyawan.model.EmployeeGroup;
import retrofit2.Call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeCRUD {
    public static final String API_URL = "http://localhost:8080";

    // Without authorization

    public static void getAllEmployees(CRUD github) throws IOException {
        try {
            System.out.println("=== Read all employees ===");

            // Create a call instance for looking up employees
            Call<List<Employee>> call = github.getAllEmployees();

            // Fetch and print a list of the employees
            List<Employee> employees = call.execute().body();
            for (Employee employee : employees) {
                System.out.println(employee.getId() + ". Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Group: " + employee.getEmployeeGroup().getName() + ", Group ID: " + employee.getEmployeeGroup().getId() + " Salary: " + employee.getEmployeeGroup().getMonthlySalary());
            }
        } catch (Exception e) {
            System.out.println("Cannot perform the operation");
        }
    }

    public static void getEmployee(CRUD github, int employeeId) {
        try {
            System.out.println("=== Read an employee by the employee ID ===");

            // Create a call instance for looking up employee by the employee ID
            Call<Employee> call = github.getEmployee(employeeId);

            // Fetch and print an employee with a certain employee ID
            Employee employee = call.execute().body();
            System.out.println(employee.getId() + ". Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Group: " + employee.getEmployeeGroup().getName() + ", Group ID: " + employee.getEmployeeGroup().getId() + " Salary: " + employee.getEmployeeGroup().getMonthlySalary());
        }
        catch (Exception e) {
            System.out.println("Cannot perform the operation");
        }
    }

    public static void postEmployee(CRUD github) throws IOException {
        System.out.println("=== Post an employee without authentication ===");

        // Create an employee instance
        Employee employeeSample = new Employee("Eko", 1, 30);

        // Insert the employee instance
        Employee body = github.createEmployee(employeeSample).execute().body();
        System.out.println(body);
    }

    public static void postSeveralEmployees(CRUD github) throws IOException {
        System.out.println("=== Post several employees ===");

        // Create several employees instance
        List<Employee> employees = employeesList();

        // Insert the employee instance
        for (Employee employee : employees) {
            github.createEmployee(employee).execute().body();
        }
    }

    public static void updateEmployeePatch(CRUD github, int employeeId, String name, int age) throws IOException {
        System.out.println("=== Update an employee using PATCH ===");

        // Create a HashMap to update the employee
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name", name);
        stringObjectHashMap.put("age", age);

        // Create a call instance for updating the employee by the employee ID
        Call<Employee> call = github.updateEmployeePatch(employeeId, stringObjectHashMap);
        call.execute();
    }

    public static void updateEmployeePut(CRUD github, int employeeId, String name, int age, int employeeGroupId) throws IOException {
        System.out.println("=== Update an employee using PUT ===");

        // Create an employee instance to update the employee
        Employee employee = new Employee();
        employee.setId(employeeId).setName(name).setAge(age).setEmployeeGroup(new EmployeeGroup(employeeGroupId));

        // Create a call instance for updating the employee by the employee ID
        Call<Employee> call = github.updateEmployeePut(employeeId, employee);
        call.execute();
    }

    public static void deleteEmployee(CRUD github, int employeeId) throws IOException {
        System.out.println("=== Delete an employee ===");

        // Create a call instance for deleting the employee by the employee ID
        Call<Employee> call = github.deleteEmployee(employeeId);
        call.execute();
    }

    // With authorization

    public static void getAllEmployeesWithAuth(CRUD github, String authToken) throws IOException {
        System.out.println("=== Read all employees with authorization ===");

        // Create a call instance for looking up employees
        Call<List<Employee>> call = github.getAllEmployeesWithAuth(authToken);

        // Fetch and print a list of the employees
        List<Employee> employees = call.execute().body();
        for (Employee employee : employees) {
            System.out.println(employee.getId() + ". Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Group: " + employee.getEmployeeGroup().getName() + ", Group ID: " + employee.getEmployeeGroup().getId() + " Salary: " + employee.getEmployeeGroup().getMonthlySalary());
        }
    }

    public static void getEmployeeWithAuth(CRUD github, int employeeId, String authToken) throws IOException {
        System.out.println("=== Read an employee by the employee ID with authorization ===");

        // Create a call instance for looking up employee by the employee ID
        Call<Employee> call = github.getEmployeeWithAuth(employeeId, authToken);

        // Fetch and print an employee with a certain employee ID
        Employee employee = call.execute().body();
        System.out.println(employee.getId() + ". Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Group: " + employee.getEmployeeGroup().getName() + ", Group ID: " + employee.getEmployeeGroup().getId() + " Salary: " + employee.getEmployeeGroup().getMonthlySalary());
    }

    public static void postEmployeeWithAuth(CRUD github, String authToken) throws IOException {
        System.out.println("=== Post an employee with authorization ===");

        // Create an employee instance
        Employee employeeSample = new Employee("Aji", 2, 32);

        // Insert the employee instance
        Employee body = github.createEmployeeWithAuth(employeeSample, authToken).execute().body();
        System.out.println(body);
    }

    public static void postSeveralEmployeesWithAuth(CRUD github, String authToken) throws IOException {
        System.out.println("=== Post several employees with authorization ===");

        // Create several employees instance
        List<Employee> employees = employeesList();

        // Insert the employee instance
        for (Employee employee : employees) {
            github.createEmployeeWithAuth(employee, authToken).execute().body();
        }
    }

    private static List<Employee> employeesList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Dian", 1, 16));
        employees.add(new Employee("Putra", 2, 17));
        employees.add(new Employee("Nur", 1, 18));
        employees.add(new Employee("Adi", 2, 19));
        employees.add(new Employee("Siti", 1, 20));
        employees.add(new Employee("Andi", 2, 28));
        employees.add(new Employee("Yudi", 1, 38));

        return employees;
    }

    public static void updateEmployeePatchWithAuth(CRUD github, int employeeId, String name, int age, String authToken) throws IOException {
        System.out.println("=== Update an employee using PATCH with authorization ===");

        // Create a HashMap to update the employee
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name", name);
        stringObjectHashMap.put("age", age);

        // Create a call instance for updating the employee by the employee ID
        Call<Employee> call = github.updateEmployeePatchWithAuth(employeeId, stringObjectHashMap, authToken);
        call.execute();
    }

    public static void updateEmployeePutWithAuth(CRUD github, int employeeId, String name, int age, int employeeGroupId, String authToken) throws IOException {
        System.out.println("=== Update an employee using PUT with authorization ===");

        // Create an employee instance to update the employee
        Employee employee = new Employee();
        employee.setId(employeeId).setName(name).setAge(age).setEmployeeGroup(new EmployeeGroup(employeeGroupId));

        // Create a call instance for updating the employee by the employee ID
        Call<Employee> call = github.updateEmployeePutWithAuth(employeeId, employee, authToken);
        call.execute();
    }

    public static void deleteEmployeeWithAuth(CRUD github, int employeeId, String authToken) throws IOException {
        System.out.println("=== Delete an employee with authorization ===");

        // Create a call instance for deleting the employee by the employee ID
        Call<Employee> call = github.deleteEmployeeWithAuth(employeeId, authToken);
        call.execute();
    }
}
