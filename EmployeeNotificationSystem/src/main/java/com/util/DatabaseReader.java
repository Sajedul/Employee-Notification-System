package com.util;

import com.model.Employee;
import com.service.FileReaderService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReader implements FileReaderService {

    private String dbUrl;
    private String user;
    private String password;

    public DatabaseReader(String dbUrl, String user, String password) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = password;
    }
    @Override
    public List<Employee> readEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT name, id, designation, month, email FROM employees";

        System.out.println("Connecting to database...");

        try (Connection connection = DriverManager.getConnection(dbUrl, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Connected to database. Executing query...");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                String designation = resultSet.getString("designation");
                String month = resultSet.getString("month");
                String email = resultSet.getString("email");

                Employee employee = new Employee(name, id, designation, month, email);
                employees.add(employee);
            }
            System.out.println("Query executed. Number of employees retrieved: " + employees.size());
        } catch (SQLException e) {
            System.err.println("SQL exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return employees;
    }
}
