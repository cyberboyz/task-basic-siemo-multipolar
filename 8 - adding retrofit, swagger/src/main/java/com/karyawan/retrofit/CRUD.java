package com.karyawan.retrofit;

import com.karyawan.model.Admin;
import com.karyawan.model.Employee;
import com.karyawan.model.EmployeeGroup;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface CRUD {
    // With authorization
    @POST("/v1/employees")
    Call<Employee> createEmployeeWithAuth(@Body Employee employee, @Header("Authorization") String token);

    @GET("/v1/employees")
    Call<List<Employee>> getAllEmployeesWithAuth(@Header("Authorization") String token);

    @GET("/v1/employees/{employeeId}")
    Call<Employee> getEmployeeWithAuth(
            @Path("employeeId") int employeeId, @Header("Authorization") String token);

    @PATCH("/v1/employees/{employeeId}")
    Call<Employee> updateEmployeePatchWithAuth(@Path("employeeId") int employeeId, @Body Map<String, Object> body, @Header("Authorization") String token);

    @PUT("/v1/employees/{employeeId}")
    Call<Employee> updateEmployeePutWithAuth(@Path("employeeId") int employeeId, @Body Employee employee, @Header("Authorization") String token);

    @DELETE("/v1/employees/{employeeId}")
    Call<Employee> deleteEmployeeWithAuth(@Path("employeeId") int employeeId, @Header("Authorization") String token);

    @POST("/v1/employee_groups")
    Call<EmployeeGroup> createEmployeeGroupWithAuth(@Body EmployeeGroup employeeGroup, @Header("Authorization") String token);


    // Without authorization
    @POST("/v1/employees")
    Call<Employee> createEmployee(@Body Employee employee);

    @GET("/v1/employees")
    Call<List<Employee>> getAllEmployees();

    @GET("/v1/employees/{employeeId}")
    Call<Employee> getEmployee(
            @Path("employeeId") int employeeId);

    @PATCH("/v1/employees/{employeeId}")
    Call<Employee> updateEmployeePatch(@Path("employeeId") int employeeId, @Body Map<String, Object> body);

    @PUT("/v1/employees/{employeeId}")
    Call<Employee> updateEmployeePut(@Path("employeeId") int employeeId, @Body Employee employee);

    @DELETE("/v1/employees/{employeeId}")
    Call<Employee> deleteEmployee(@Path("employeeId") int employeeId);

    @POST("/v1/employee_groups")
    Call<EmployeeGroup> createEmployeeGroup(@Body EmployeeGroup employeeGroup);

    @POST("/v1/register")
    Call<Admin> registerAdmin(@Body Admin admin);

    @POST("/v1/login")
    Call<Admin> loginAdmin(@Body Map<String, Object> admin);
}