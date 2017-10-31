package com.csse.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dbaccess {

    Dbconnect dbconn = new Dbconnect();

    //To Insert
    
    public void insertData(String query) {

        try {
            Connection conn = dbconn.getConnection();

            PreparedStatement s = conn.prepareStatement(query);

            s.execute();
            //conn.close();

        } catch (SQLException | ClassNotFoundException | NullPointerException ex) {
            Logger.getLogger(Dbaccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //To 
    public ResultSet getData(String query){
        ResultSet result = null;

        try {
            Connection conn = dbconn.getConnection();
            Statement s = conn.prepareStatement(query);

            result = s.executeQuery(query);
            System.out.println(result);
           // conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
           Logger.getLogger(Dbaccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
