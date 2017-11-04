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
 * @author Lakshika
 */
public class Chemical_Data {
    
    JSONObject obj = new JSONObject();
    
    public JSONObject AddChemical() throws JSONException{
    
        obj.put("tchemCode", "CHEM1007");
        obj.put("tchemName", "H2SO4");
        obj.put("ttype","Hydraulic");
        obj.put("qty", "100");
        obj.put("supId", "SUP1002");
        obj.put("price", 1050.00);
                        
        return obj;
    }
    
    public JSONObject UpdateChemical() throws JSONException{
    
        obj.put("tchemName", "testing");
        obj.put("ttype","testing");
        obj.put("qty", "50");
        obj.put("supId", "SUP1002");
        obj.put("price", 105.00);
                        
        return obj;
    }
}
