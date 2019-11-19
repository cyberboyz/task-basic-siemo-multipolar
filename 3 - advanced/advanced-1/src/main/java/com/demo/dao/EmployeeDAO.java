package com.demo.dao;

import com.demo.model.Employee;
import com.demo.model.EmployeeCompleteProfile;
import com.demo.model.EmployeeGroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DataAccessObject{
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + " (id, name, entry_date, employee_group) VALUES "
            + " (?, ?, ?, ?);";
    private static final String SELECT_ALL_EMPLOYEES = "SELECT EMPLOYEE.*, monthly_salary FROM EMPLOYEE INNER JOIN EMPLOYEE_GROUP ON EMPLOYEE.EMPLOYEE_GROUP=EMPLOYEE_GROUP.EMPLOYEE_GROUP ORDER BY monthly_salary DESC, entry_date ASC";

    public EmployeeDAO() {
    }

    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE_SQL);

        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getEntryDate());
            preparedStatement.setString(4, employee.getGroup());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<EmployeeCompleteProfile> selectAllEmployees() {
        List<EmployeeCompleteProfile> employeeCompleteProfiles = new ArrayList<>();

        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);){
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String entryDate = rs.getString("entry_date");
                String group = rs.getString("employee_group");
                String monthlySalary = rs.getString("monthly_salary");
                Employee employee = new Employee(id, name, entryDate, group);
                EmployeeGroup employeeGroup = new EmployeeGroup(group, monthlySalary);
                employeeCompleteProfiles.add(new EmployeeCompleteProfile(employee, employeeGroup));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeCompleteProfiles;
    }
}
