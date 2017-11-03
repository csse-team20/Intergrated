/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo_Data;

import javax.swing.JTextField;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class UserDemo {
    
     
    
    public JSONObject addUsers() throws JSONException{
        JSONObject obj = new JSONObject();
       
        obj.put("tfirstName", "Sman");
        obj.put("tlastName","tab");
        obj.put("taddress","abc");
        obj.put("tnic","930102140v");
        obj.put("temail","sumal@gmail.com");
        obj.put("tphone","0772145846");
        obj.put("tType","Doctor");
        obj.put("tImage","Sanjeewa/Desktop/images.jpg");
        return obj;
        
        //new 
//        new cmment
        
        
    }
    
    
    public JSONObject regiterUsers() throws JSONException{
        
        JSONObject obj = new JSONObject();
       
        obj.put("tnic", "950102144v");
        obj.put("tuserName","Anuradha");
        obj.put("tPassword","123456");
        obj.put("tsecQuestion","nurse");
        obj.put("tanswer","123");
        
        
        return obj;
              
    }
    
    
    
    public JSONObject addEmpLeaves() throws JSONException{
        
        JSONObject obj = new JSONObject();
       
        obj.put("txtEmpID", "1");
        obj.put("txtEmpName","Anuradha");
        obj.put("txtAnuLeave","14");
        obj.put("txtCasuLeave","7");
        obj.put("txtMediLeave","7");
        
        
        return obj;
              
    }
    
}
