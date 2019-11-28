package com.karyawan.retrofit;

import java.io.IOException;

import com.karyawan.model.Admin;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

import static com.karyawan.retrofit.AdminCRUD.loginAdmin;
import static com.karyawan.retrofit.AdminCRUD.registerAdmin;
import static com.karyawan.retrofit.EmployeeCRUD.*;
import static com.karyawan.retrofit.EmployeeGroupCRUD.*;

public final class SimpleService {
    public static final String API_URL = "http://localhost:8080";

    public static void main(String... args) throws IOException {
        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        CRUD github = retrofit.create(CRUD.class);

        // Register as an admin
        registerAdmin(github);

        // Login as an admin
        Admin adminCredentials = loginAdmin(github);
        String jwtToken = "Bearer " + adminCredentials.getJwtToken();

        // Create several employee groups
        postEmployeeGroup(github);
        postSeveralEmployeeGroups(github);
//
//        // Execute CRUD operations on employee
        postEmployee(github);
        postEmployeeWithAuth(github, jwtToken);
        getAllEmployees(github);
        getAllEmployeesWithAuth(github, jwtToken);
        postSeveralEmployees(github);
        postSeveralEmployeesWithAuth(github, jwtToken);
        getAllEmployees(github);
        getAllEmployeesWithAuth(github, jwtToken);
        getEmployee(github,7);
        getEmployeeWithAuth(github,7, jwtToken);
        updateEmployeePut(github, 5, "Muji", 32, 2);
        updateEmployeePutWithAuth(github, 5, "Muji", 32, 2, jwtToken);
        getAllEmployees(github);
        getAllEmployeesWithAuth(github, jwtToken);
        updateEmployeePatch(github, 3, "Seto", 39);
        updateEmployeePatchWithAuth(github, 3, "Seto", 39, jwtToken);
        getAllEmployees(github);
        getAllEmployeesWithAuth(github, jwtToken);
        deleteEmployee(github, 4);
        deleteEmployeeWithAuth(github, 4, jwtToken);
        getAllEmployees(github);
        getAllEmployeesWithAuth(github, jwtToken);
    }
}
