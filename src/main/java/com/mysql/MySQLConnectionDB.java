package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionDB {
    Connection conn = null;
    public Connection connectDB() {
        String jdbcurl = "jdbc:mysql://localhost:3306/payroll_service_db?useSSL=false";
        String userName = "root";
        String password = "password";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            Connection conn = DriverManager.getConnection(jdbcurl, userName, password);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}