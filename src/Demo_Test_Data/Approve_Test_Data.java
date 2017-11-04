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
public class Approve_Test_Data {
    
     JSONObject obj = new JSONObject();
     
      public JSONObject UpdateDrugs() throws JSONException{
    
        obj.put("torder_id", "ORD1006");
        obj.put("tamount", 3000);
        obj.put("torder_status","done");
        obj.put("OsupId", "SUP1001");

        return obj;
    }
      
      public JSONObject UpdateQunty() throws JSONException{
    
        obj.put("torder_id", "ORD1006");
        obj.put("tamount", 3000);
        obj.put("torder_status","done");
        obj.put("OsupId", "SUP1001");

        return obj;
    }
    
}
