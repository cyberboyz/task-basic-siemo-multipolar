package com.demo.web;

import com.demo.dao.EmployeeDAO;
import com.demo.model.EmployeeProfile;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get_incentive")
public class IncentiveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;
    private Gson gson;

    public void init() {
        employeeDAO = new EmployeeDAO();
        gson = new Gson();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            default:
                getIncentive(request, response);
                break;
        }
    }

    private void getIncentive(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeProfile employeeProfile = employeeDAO.selectEmployee(id);
        String incentiveNominal = calculateIncentiveNominal(employeeProfile);
        employeeProfile.setIncentiveNominal(incentiveNominal);
        returnJson(response, employeeProfile);
    }

    private String calculateIncentiveNominal(EmployeeProfile employeeProfile) {
        int monthlySalary = Integer.parseInt(employeeProfile.getMonthlySalary());
        float incentivePercentage = Float.parseFloat(employeeProfile.getIncentivePercentage());
        float incentiveNominal = monthlySalary * incentivePercentage;
        return String.valueOf(Math.round(incentiveNominal));
    }

    private void returnJson(HttpServletResponse response, EmployeeProfile employeeProfile) throws IOException {
        String employeeJsonString = this.gson.toJson(employeeProfile);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }
}
