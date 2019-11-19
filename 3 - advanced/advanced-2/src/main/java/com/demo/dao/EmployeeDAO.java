package com.demo.dao;

import com.demo.model.EmployeeProfile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DataAccessObject{
    private static final String SELECT_EMPLOYEE = "SELECT * FROM EMPLOYEE INNER JOIN EMPLOYEE_GROUP ON EMPLOYEE.EMPLOYEE_GROUP=EMPLOYEE_GROUP.EMPLOYEE_GROUP WHERE id = (?)";

    public EmployeeDAO() {
    }

    public EmployeeProfile selectEmployee(int employeeId) {
        EmployeeProfile employee = new EmployeeProfile();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE);){
            preparedStatement.setString(1, String.valueOf(employeeId));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String entryDate = rs.getString("entry_date");
                String employeeGroup = rs.getString("employee_group");
                String monthlySalary = rs.getString("monthly_salary");
                String incentivePercentage = rs.getString("incentive_percentage");

                employee.setId(id);
                employee.setName(name);
                employee.setEntryDate(entryDate);
                employee.setEmployeeGroup(employeeGroup);
                employee.setMonthlySalary(monthlySalary);
                employee.setIncentivePercentage(incentivePercentage);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }
}
