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
public class drug_Data {
    
    JSONObject obj = new JSONObject();
    
    public JSONObject AddDrugs() throws JSONException{
    
        obj.put("tpresName", "Amox");
        obj.put("tunitType","tab");
        obj.put("tcatagory", "abc");
        obj.put("tdiscrption","flem");
        obj.put("tprice", 1.50);
        
        return obj;
    }
    
    public JSONObject UpdateDrugs() throws JSONException{
    
        obj.put("tpresCode", "PRES1007");
        obj.put("tpresName", "testing");
        obj.put("tunitType","testing");
        obj.put("tcatagory", "testing");
        obj.put("tdiscrption","testing");
        obj.put("tprice", 15.50);
        
        return obj;
    }
    
    public JSONObject DeleteDrugs() throws JSONException{
    
        obj.put("tpresCode", "PRES1007");
        
        return obj;
    }
}
