package com.demo.web;

import com.demo.dao.EmployeeDAO;
import com.demo.dao.EmployeeGroupDAO;
import com.demo.model.Employee;
import com.demo.model.EmployeeCompleteProfile;
import com.demo.model.EmployeeGroup;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;
    private EmployeeGroupDAO employeeGroupDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
        employeeGroupDAO = new EmployeeGroupDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new_employee":
                    showEmployeeForm(request, response);
                    break;
                case "/new_employee_group":
                    showEmployeeGroupForm(request, response);
                    break;
                case "/insert_employee":
                    insertEmployee(request, response);
                    break;
                case "/insert_employee_group":
                    insertEmployeeGroup(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void showEmployeeGroupForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("input-golongan-gaji.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        List<EmployeeCompleteProfile> employeeCompleteProfiles = employeeDAO.selectAllEmployees();
        request.setAttribute("employeeList", employeeCompleteProfiles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("daftar-karyawan.jsp");
        dispatcher.forward(request, response);
    }

    private void showEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("input-data-karyawan.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmployeeGroup(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String employeeGroup = request.getParameter("employeeGroup");
        String monthlySalary = request.getParameter("monthlySalary");

        EmployeeGroup newEmployeeGroup = new EmployeeGroup(employeeGroup, monthlySalary);

        employeeGroupDAO.insertEmployeeGroup(newEmployeeGroup);
        response.sendRedirect("list");
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String employeeName = request.getParameter("employeeName");
        String employeeID = request.getParameter("employeeID");
        String employeeEntryDate = request.getParameter("employeeEntryDate");
        String employeeGroup = request.getParameter("employeeGroup");

        Employee newEmployee = new Employee(employeeID, employeeName, employeeEntryDate, employeeGroup);

        employeeDAO.insertEmployee(newEmployee);
        response.sendRedirect("list");
    }
}
