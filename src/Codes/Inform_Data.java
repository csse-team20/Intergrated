/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Layangi
 */
public class Inform_Data {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    //change
    
    public void cancel(String pSid){
        
        c = DBconnection.getConnection();
        
        try {
            String de = "DELETE FROM schedule where Sid='" + pSid + "'";
            p = c.prepareStatement(de);
            p.execute();
            
            JOptionPane.showMessageDialog(null, "Appointment Successfully Cancelled !!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Appointment not Cancelled !!");
            System.out.println(ex);      
         }    
    }
    
    
}
