package com.marinagaisina;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// get out password and username from our database
        // Connection
        // Statement
        String url = "jdbc:mysql://127.0.0.1:3308/classicmodels";
        //DriverManager.registerDriver(new MySQL.jdbc.driver.MysqlDriver());
        ResultSet sqlRows;
        try{
            Connection myConn = DriverManager.getConnection(url, "root", "Great2021!");
            //Statement stmt = myConn.createStatement();
            //sqlRows = stmt.executeQuery("SELECT * FROM employees");
            //System.out.println("SQL print out "+sqlRows);
    /* traverse through sqlResult (an instance of the result)
            while (sqlRows.next()) {
                String firstName = sqlRows.getString("firstName");
                String lastName = sqlRows.getString("lastName");
                String email = sqlRows.getString("email");
                System.out.println(firstName+" "+lastName+": "+email);
            }
     */
            //Prepared statements: replaces ? with the given data
            String sqlFindCustomerById = "SELECT customerName, phone FROM CUSTOMERS WHERE customerName=?";
            PreparedStatement ps = myConn.prepareStatement(sqlFindCustomerById);
            ps.setString(1, "Herkku Gifts");
            ResultSet result = ps.executeQuery();
            while (result.next()) {                          // обязательно через цикл! без итерации - Exception
                String customerName = result.getString("customerName");
                String phone = result.getString("phone").replaceAll("[.,-,+, ]", "");
                System.out.println(customerName+"'s phone number is : "+phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
