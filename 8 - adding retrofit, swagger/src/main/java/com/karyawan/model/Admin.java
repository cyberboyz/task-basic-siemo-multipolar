package com.karyawan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @SerializedName("admin_id")
    @Expose
    private Long adminId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("jwt_token")
    @Expose
    @Transient
    private String jwtToken;

    public Admin() {
    }

    public Admin(Long adminId, String firstName, String lastName, String email, String password) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAdminId() {
        return adminId;
    }

    public Admin setAdminId(Long adminId) {
        this.adminId = adminId;
        return this;
    }

    @Column(name = "first_name", nullable = false)
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    public Admin setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false)
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    public Admin setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public Admin setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public Admin setPassword(String password) {
        this.password = password;
        return this;
    }

    @JsonProperty("jwt_token")
    public String getJwtToken() {
        return jwtToken;
    }

    public Admin setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
        return this;
    }
}
