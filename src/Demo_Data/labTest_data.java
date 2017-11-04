/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo_Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lakshika
 */
public class labTest_data {
    
    JSONObject obj = new JSONObject();
    
    public JSONObject AddLabTest() throws JSONException{
    
        obj.put("ttestCode", "LAB1010");
        obj.put("ttestsName", "ffff");
        obj.put("ttestType","my");
        obj.put("tdiscrption", "abc");
                        
        return obj;
    }
    
    public JSONObject UpdateLabTest() throws JSONException{
            
        obj.put("ttestsName", "testing");
        obj.put("ttestType","testing");
        obj.put("tdiscrption", "testing");
                       
        return obj;
    }
}
