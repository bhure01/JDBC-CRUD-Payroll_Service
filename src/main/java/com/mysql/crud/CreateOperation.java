package com.mysql.crud;
import com.mysql.MySQLConnectionDB;
import java.sql.*;


public class CreateOperation {
    public static void main(String[] args) {
        ResultSet resultSet;
        MySQLConnectionDB sqlObj = new MySQLConnectionDB();
        Connection conn = sqlObj.connectDB();                                        // Connection Built-in Class

        try {
            String insertQuery = "insert into emp_payroll values(?,?,?)";            // Inserting Table Values
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setInt(1, 5);
            insertStmt.setString(2, "xyz");
            insertStmt.setInt(3, 4000);
            insertStmt.executeUpdate();

            // Showing Table Details after insertion
            PreparedStatement stmt2 = conn.prepareStatement("select * from emp_payroll");
            resultSet = stmt2.executeQuery();
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
