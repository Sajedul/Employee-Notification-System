package com.model;

public class Employee {
    private String name;
    private int id;
    private String designation;
    private String month;
    private String email;

    // Constructor, getters, and setters

    public Employee(String name, int id, String designation, String month, String email) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.month = month;
        this.email = email;
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getDesignation() {

        return designation;
    }

    public void setDesignation(String designation) {

        this.designation = designation;
    }

    public String getMonth() {

        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}
