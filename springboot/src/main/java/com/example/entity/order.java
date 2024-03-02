package com.example.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "order")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    private int id;

    @Column(name = "name")
    private String name;
    private String password;
    private String purchaseDate;
    private int payornot;

    public int getorderid() {
        return orderid;
    }

    public void setorderid(int orderid) {
        this.orderid = orderid;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getpssword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getpurchaseDate() {
        return purchaseDate;
    }

    public void setpurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getpayornot() {
        return payornot;
    }

    public void setpayornot(int payornot) {
        this.payornot = payornot;
    }

    public order() {
    }
}
