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
import pharmacy_lab.Payment_Order;

/**
 *
 * @author Orange
 */
public class payment_management {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    
    public void addPaymentHalf(String tpayid,String oid,String orPayAmount){
        
        c = DBconnection.getConnection();
        
        try {
                    String sql = "INSERT INTO payment(idpayment,oid,date,orderPayAmount,payment_status) "
                            + "values('" + tpayid + "','" + oid + "',current_date,'" + orPayAmount + "','half')";
                    p = c.prepareStatement(sql);
                    p.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(Payment_Order.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    }
    
    public void addPaymentFull(String tpayid,String oid,String orPayAmount){
        
        c = DBconnection.getConnection();
        
        try {
                    String sql = "INSERT INTO payment(idpayment,oid,date,orderPayAmount,payment_status) "
                            + "values('" + tpayid + "','" + oid + "',current_date,'" + orPayAmount + "','done')";
                    p = c.prepareStatement(sql);
                    p.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(Payment_Order.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    }
}
