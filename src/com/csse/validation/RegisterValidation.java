/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.validation;

import com.csse.db.Dbaccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class RegisterValidation {
    
    public void chechRegEmpty(){
    
    
    
    }
    
    public boolean isRegExistingNic(JTextField txtNic){
    
            boolean status = false;
        try {
            Dbaccess da = new Dbaccess();
            String nic = txtNic.getText();
            
            
            ResultSet rs;

            String query = "SELECT\n" +
                            "	users.NIC,\n" +
                            "	users.FIRST_NAME,\n" +
                            "	users.ID \n" +
                            "FROM\n" +
                            "	users \n" +
                            "WHERE\n" +
                            "	users.NIC = '"+nic+"'" ;
            rs = da.getData(query);
            
            while(rs.next()){
                
                String exNic = rs.getString("NIC");
                System.out.println(exNic);
                if(nic.equals(exNic)){
                  //  JOptionPane.showMessageDialog(txtNic,"NIC is Existing");
                  // throw new Exception("exist");
                  status = true;  
                   
                   
                    
                }
                
            }   
                                
           
        } catch (SQLException ex) {
            Logger.getLogger(UsersValidation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RegisterValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    
    }
    
}
