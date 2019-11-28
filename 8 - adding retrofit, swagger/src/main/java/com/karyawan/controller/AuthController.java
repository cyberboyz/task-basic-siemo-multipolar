package com.karyawan.controller;

import com.karyawan.model.Admin;
import com.karyawan.repository.AdminRepository;
import io.swagger.annotations.ApiOperation;
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


    @ApiOperation(value = "${AuthController.register}")
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @ApiOperation(value = "${AuthController.login}")
    @PostMapping("/login")
    public Admin loginAdmin(@RequestBody Admin login) throws ServletException {
        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in email and password");
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

        admin.setJwtToken(jwtToken);
        return admin;
    }
}
