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
public class History_Test_Data {
    
    JSONObject obj = new JSONObject();
    
    public JSONObject HistorySave() throws JSONException{
        
        obj.put("hphid", "HIS1002");
        obj.put("hppid","REG1006");
        obj.put("hheight", 56);
        obj.put("hweight",67);
        obj.put("hstate","Normal");
        obj.put("hpain", "No");
        obj.put("hblood","AB+");
        obj.put("hillness", "uuu");
        obj.put("hallergy","i");
        obj.put("hnote", "klk");
        
        return obj;
    }
    public JSONObject HistoryUpdate() throws JSONException{
    
        obj.put("hphid", "HIS1002");
        obj.put("hppid","REG1006");
        obj.put("hheight", 56);
        obj.put("hweight",67);
        obj.put("hstate","Normal");
        obj.put("hpain", "No");
        obj.put("hblood","AB+");
        obj.put("hillness", "uuu");
        obj.put("hallergy","i");
        obj.put("hnote", "klk");
        
        
        return obj;
    }
    
    public JSONObject HistoryDelete() throws JSONException{
    
        obj.put("hphid", "HIS1006");
        
        return obj;
    }
    
    
}
