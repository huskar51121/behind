package com.example.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripid;

    private int id;

    private int beginid;
    private int endid;

    public int gettripid() {
        return tripid;
    }

    public void settripid(int tripid) {
        this.tripid = tripid;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getbeginid() {
        return beginid;
    }

    public void setbeginid(int beginid) {
        this.beginid = beginid;
    }

    public int getendid() {
        return endid;
    }

    public void setendid(int endid) {
        this.endid = endid;
    }

    public Trip() {
    }
}
