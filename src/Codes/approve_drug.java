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

/**
 *
 * @author Layangi
 */
public class approve_drug {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;

    public void updateOrderStatus(String order_id,double amount) {

        c = DBconnection.getConnection();
       
        try {
            String sql = "UPDATE orders "
                         + "SET  order_status='done',amount='"+amount+"'"
                         + "WHERE (oid='" + order_id + "');";
            
            p = c.prepareStatement(sql);
            p.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }       
    }
    
    public void updateDrugQty(String did,int qty){
    
    c = DBconnection.getConnection();

        int cur_qty=0; 
        int tot = 0;
        
        try {
            String sql = "SELECT current_qty FROM drug WHERE presCode = '"+did+"'";
            p = c.prepareStatement(sql);
            rs = p.executeQuery();
            while(rs.next()){
                cur_qty = Integer.parseInt(rs.getString("current_qty"));
            }
            
            tot = qty+cur_qty;
            
            String up = "UPDATE drug "
                        + "SET  current_qty='"+tot+"'"
                        + "WHERE (presCode='" + did + "');";
            
         //   p = c.prepareStatement(sql);
            p = c.prepareStatement(up);
            p.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    
}
