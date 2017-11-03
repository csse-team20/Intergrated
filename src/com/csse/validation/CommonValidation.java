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
    
    public boolean nicValidation(JTextField txtNic){
       
        if(!txtNic.getText().isEmpty()){
             if(!(txtNic.getText().trim().matches("^[0-9]{9}[vVxX]$"))){
            
                JOptionPane.showMessageDialog(null,"Invalid NIC ");
                return true;
             }
        
        
        }
        return false;
    }
    
    public boolean emailAddressValidation(JTextField txtEmail){
    
        
        if(!txtEmail.getText().isEmpty()){
            
            if(!(txtEmail.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))){
            
            JOptionPane.showMessageDialog(txtEmail,"Invalid Email");
            return true;
            }
        
        
        
        }
        
        return false;
   
    }
    
    public boolean phoneNumberValidation(JTextField txtPhone){
        
       if(!txtPhone.getText().isEmpty()){
       
        if(!(txtPhone.getText().matches("^[0-9]{10}$"))){
            
            JOptionPane.showMessageDialog(null,"Invalid Phone Number ");
            return true;
        }
       
       
       }   
    return false;
    }
}
