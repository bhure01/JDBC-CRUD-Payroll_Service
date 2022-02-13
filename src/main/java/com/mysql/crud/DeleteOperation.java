package com.mysql.crud;
import com.mysql.MySQLConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteOperation {
    public static void main(String[] args) {
        ResultSet resultSet;
        MySQLConnectionDB sqlObj = new MySQLConnectionDB();
        Connection conn = sqlObj.connectDB();                                        // Connection Built-in Class

        try {
            String deleteQuery = "delete from emp_payroll where id=5";
            Statement deleteStmt = conn.createStatement();
            deleteStmt.executeUpdate(deleteQuery);
            // Showing Table Details after insertion
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
