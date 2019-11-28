package com.karyawan.retrofit;

import com.karyawan.model.Admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AdminCRUD {
    public static void registerAdmin(CRUD github) throws IOException {
        System.out.println("=== Register as an admin ===");

        // Create an employee group instance
        Admin admin = new Admin().setFirstName("fattah").setLastName("azzuhry").setEmail("far@here.com").setPassword("abcdefgh");

        // Insert the employee group instance
        Admin body = github.registerAdmin(admin).execute().body();
        System.out.println(body);
    }


    public static Admin loginAdmin(CRUD github) throws IOException {
        System.out.println("=== Login as an admin ===");

        // Create an employee group instance
        Map<String, Object> credentials = new HashMap<>();
        credentials.put("email", "far@here.com");
        credentials.put("password", "abcdefgh");

        // Insert the employee group instance
        Admin body = github.loginAdmin(credentials).execute().body();
        return body;
    }
}
