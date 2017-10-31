/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lakshika
 */
public class DBconnection {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/channeling_center?autoReconnect=true&useSSL=false", "root", "1234");
            //conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/channeling_center?autoReconnect=true&useSSL=false", "root", "");
        } catch (Exception e) {

            System.out.println(e);
        }
        return conn;
    }
}
