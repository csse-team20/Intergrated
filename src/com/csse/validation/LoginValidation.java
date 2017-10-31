/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.validation;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class LoginValidation {
    
    public void checkEmpty(JTextField txtUserName,JPasswordField jpassword){
    
        if(txtUserName.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(txtUserName,"User Name Should be Entered");
        
        }
        if(jpassword.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(txtUserName,"Password Should be Entered");
        
        }
//        else if(txtUserName.getText().isEmpty() || jpassword.getText().isEmpty() ){
//        
//            JOptionPane.showMessageDialog(txtUserName,"Please Enter User Name and Password");
//        }
    
    }
    
    
    
      
    
}
