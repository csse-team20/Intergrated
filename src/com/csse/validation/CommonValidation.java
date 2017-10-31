/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.validation;


import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class CommonValidation {
    
    public void nicValidation(JTextField txtNic){
       
        if(!txtNic.getText().isEmpty()){
             if(!(txtNic.getText().trim().matches("^[0-9]{9}[vVxX]$"))){
            
                JOptionPane.showMessageDialog(null,"Invalid NIC ");
             }
        
        
        }
    
    }
    
    public void emailAddressValidation(JTextField txtEmail){
    
        
        if(!txtEmail.getText().isEmpty()){
            
            if(!(txtEmail.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))){
            
            JOptionPane.showMessageDialog(txtEmail,"Invalid Email");
            
            }
        
        
        
        }
        
        
   
    }
    
    public void phoneNumberValidation(JTextField txtPhone){
        
       if(!txtPhone.getText().isEmpty()){
       
        if(!(txtPhone.getText().matches("^[0-9]{10}$"))){
            
            JOptionPane.showMessageDialog(null,"Invalid Phone Number ");
        }
       
       
       }   
    
    }
}
