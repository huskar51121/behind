package com.example.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "gps_data")
public class Gps_data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private java.math.BigDecimal latitude;
    private java.math.BigDecimal longitude;
    private String timestamp;
}
