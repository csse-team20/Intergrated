/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Orange
 */
public class notification {

    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;

    public int countNoytification() {
        c = DBconnection.getConnection();
        
        int count = 0;
        String code = "";
        

        try {
            String sql = "SELECT presCode,current_qty FROM drug WHERE current_qty < 10";
            p = c.prepareStatement(sql);
            rs = p.executeQuery();
            
            while(rs.next()){
                count++;
                code = rs.getString("presCode");                
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return count;
    }
    
    public void getDetails(){
        
    c = DBconnection.getConnection();
    String name="";
    int qty = 0;
    
    try {
            String sql = "SELECT presName,current_qty FROM drug WHERE current_qty < 10";
            p = c.prepareStatement(sql);
            rs = p.executeQuery();
            
            while(rs.next()){
                
                name = rs.getString("presName");
                qty = Integer.parseInt(rs.getString("current_qty"));
                JOptionPane.showMessageDialog(null, "Stock of the "+name+" is "+qty);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
