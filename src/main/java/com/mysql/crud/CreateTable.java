package com.mysql.crud;

import com.mysql.MySQLConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        ResultSet resultSet;
        MySQLConnectionDB sqlObj = new MySQLConnectionDB();
        Connection conn = sqlObj.connectDB();                                        // Connection Built-in Class

        try {
            String createTableQuery = "create table emp_payroll(id int,name varchar(50),salary int(10))";            // Inserting Table Values
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(createTableQuery);
            System.out.println("Created Table Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
