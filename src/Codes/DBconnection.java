/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Layangi
 */
public class DBconnection {
    
     public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/channeling_center?autoReconnect=true&useSSL=false", "root", "root");
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return conn;
    }
}