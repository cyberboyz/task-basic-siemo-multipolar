package com.demo.dao;

import com.demo.model.Employee;
import com.demo.model.EmployeeGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeGroupDAO extends DataAccessObject{
    private static final String INSERT_EMPLOYEE_GROUP_SQL = "INSERT INTO employee_group" + " (employee_group, monthly_salary, incentive_percentage) VALUES "
            + " (?, ?, ?);";

    public EmployeeGroupDAO() {
    }

    public void insertEmployeeGroup(EmployeeGroup employeeGroup) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_GROUP_SQL);

        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_GROUP_SQL)) {
            preparedStatement.setString(1, employeeGroup.getEmployeeGroup());
            preparedStatement.setString(2, employeeGroup.getMonthlySalary());
            preparedStatement.setString(3, employeeGroup.getIncentivePercentage());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
