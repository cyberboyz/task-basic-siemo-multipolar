package com.demo;

import com.demo.model.Employee;
import com.demo.model.EmployeeGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static List<Employee> readDataFromText(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        sc.useDelimiter("\\Z");
        String fileTextContent = sc.next();
        List<Employee> employees = convertStringToEmployeeObject(fileTextContent);
        return employees;
    }

    public static List<Employee> convertStringToEmployeeObject(String employeeString) {
        List<Employee> employeeList = new ArrayList<>();

        String regexPattern = "(.+),\\s*(.+),\\s*(.+),\\s*(\\{(.)+\\}.*)";
        Pattern r = Pattern.compile(regexPattern);

        String[] employeeStringLines = employeeString.split("\\r\\n");
        for (String employeeStringLine: employeeStringLines) {
            Matcher m = r.matcher(employeeStringLine);
            if (m.find()) {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(m.group(1)));
                employee.setName(m.group(2));
                employee.setDate(m.group(3));

                List<String> employeeGroupArrayList = Arrays.asList(m.group(4).replaceAll("[{}]", "").split(", "));

                EmployeeGroup employeeGroup = new EmployeeGroup(employeeGroupArrayList.get(0), employeeGroupArrayList.get(1));
                employee.setEmployeeGroup(employeeGroup);
                employeeList.add(employee);
            }
        }
        return employeeList;
    }
}
