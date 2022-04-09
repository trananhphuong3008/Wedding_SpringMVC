/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.models;

import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Phuong
 */
public class JdbcDemo {
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Step 1. Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Step 2. Connecting to the database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mysaledbv3", 
                "root", "Phuong@300800");
        
        // Step 3: Statement, PreparedStatement, CallableStatement
            // + definition --> executeUpdate
            // + query --> executeQuery --> ResultSet
            
//        Statement stm = conn.createStatement();
//        PreparedStatement stm = conn.prepareStatement("INSERT INTO category(name) VALUES(?)");
//        stm.setString(1, "TABLET");
//        int row = stm.executeUpdate();
//        System.out.println("Number: " + row);
//        Statement stm = conn.createStatement();
        CallableStatement stm = (CallableStatement) conn.prepareCall("{ CALL count_prod_by_cate(?, ?) }");
        stm.setInt(1, 3);
        stm.registerOutParameter(2, Types.INTEGER);
        stm.execute();
        
        System.out.println(stm.getInt(2));
//        stm.setString(1, "TOP");
//        ResultSet rs = stm.executeQuery();
//        
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            
//            System.out.printf("%d - %s\n", id, name);
//        }

        // Step 4. Closing
        stm.close();
        conn.close();
    }       
}
