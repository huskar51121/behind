package com.example.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;
    private String password;
    private String phone;
    private String enddate;

    public String getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getpssword() {
        return password;
    }

    public String phone() {
        return phone;
    }

    public String enddate() {
        return enddate;
    }

}
