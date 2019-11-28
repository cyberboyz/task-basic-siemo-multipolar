package com.karyawan.controller;

import com.karyawan.model.Admin;
import com.karyawan.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@RestController
@RequestMapping("/v1")
public class AuthController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @PostMapping("/login")
    public String login(@RequestBody Admin login) throws ServletException {
        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        Admin admin = adminRepository.findByEmail(email);

        if (admin == null) {
            throw new ServletException("User email not found");
        }

        String realPassword = admin.getPassword();

        if (!password.equals(realPassword)) {
            throw new ServletException("Invalid login. Please check your name and password");
        }

        jwtToken = Jwts.builder()
                .setSubject(email).claim("roles", "admin")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 200000L))
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        return jwtToken;
    }
}
