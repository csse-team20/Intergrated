/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import com.csse.db.Dbaccess;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class Delete {
    
     public void deleteUser(JLabel lblId){
     
     
    
            String id = lblId.getText();

            String q = "DELETE FROM users WHERE ID = '" + id + "' ";

            Dbaccess da = new Dbaccess();

            da.insertData(q);

        }
     
     
     
     
    
    
}
