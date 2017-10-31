/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo_Data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class UserDemo {
    
     JSONObject obj = new JSONObject();
    
    public JSONObject addUsers() throws JSONException{
    
       
        obj.put("tfirstName", "Sman");
        obj.put("tlastName","tab");
        obj.put("taddress","abc");
       // obj.put("tnic","930102140v");
        obj.put("temail","sumal@gmail.com");
        obj.put("tphone","0772145846");
        obj.put("tType","Doctor");
        obj.put("tImage","Sanjeewa/Desktop/images.jpg");
        return obj;
        
        
    }
    
}
