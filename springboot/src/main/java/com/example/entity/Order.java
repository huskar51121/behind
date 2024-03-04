package com.example.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    private int id;

    private String price;
    private String days;
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

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }

    public String getdays() {
        return days;
    }

    public void setdays(String days) {
        this.days = days;
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

    public Order() {
    }
}
