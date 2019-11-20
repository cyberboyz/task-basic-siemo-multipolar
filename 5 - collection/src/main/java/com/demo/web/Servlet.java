package com.demo.web;

import com.demo.Helper;
import com.demo.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private List<Employee> employees;
    public void init() {
        try {
            employees = Helper.readDataFromText("db_karyawan.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/golongan":
                    showEmployeeGroup(request, response);
                    break;
                case "/data_karyawan":
                    showEmployee(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showEmployeeGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        for (Employee employee: employees) {
            if (employee.getId() == id) {
                request.setAttribute("employee", employee);
                RequestDispatcher dispatcher = request.getRequestDispatcher("tampilan-2.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employees", this.employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("tampilan-1.jsp");
        dispatcher.forward(request, response);
    }
}
