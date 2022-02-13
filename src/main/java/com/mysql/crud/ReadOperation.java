package com.mysql.crud;

import com.mysql.MySQLConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadOperation {
    public static void main(String[] args) {
        ResultSet resultSet;
        MySQLConnectionDB sqlObj = new MySQLConnectionDB();
        Connection conn = sqlObj.connectDB();                                                    // Connection Built-in Class

        try {
//            String readQuery = "select salary from emp_payroll where id=1";
            String readQuery = "select salary,name from emp_payroll";

            Statement updateStmt = conn.createStatement();
            ResultSet result = updateStmt.executeQuery(readQuery);
            while (result.next()) {
//                System.out.println(result.getInt(1));
                System.out.println(result.getInt(1) + " " + result.getString(2));

            }
            // Showing All Info From Table
            PreparedStatement stmt = conn.prepareStatement("select * from emp_payroll");
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                System.out.println(id + " " + name + " " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
