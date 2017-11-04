/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo_Test_Data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Layangi
 */
public class Inform_Test_Data {
    
    JSONObject obj = new JSONObject();
    
     public JSONObject InformDelete() throws JSONException{
   
        obj.put("pSid", "1");
        
        return obj;
           
    }
    
}
