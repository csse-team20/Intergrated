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
        
        obj.put("pHisID", "HIS1002");
        obj.put("pPid","REG1006");
        obj.put("pHeight", 56);
        obj.put("pWeight",67);
        obj.put("pState","Normal");
        obj.put("pPain", "No");
        obj.put("pIllness", "uuu");
        obj.put("pAllergy","i");
        obj.put("pNote", "klk");
        obj.put("pBlood","AB+");
        
        return obj;
    }
    public JSONObject HistoryUpdate() throws JSONException{
    
        obj.put("pHisID", "HIS1002");
        obj.put("pPid","REG1006");
        obj.put("pHeight", 56);
        obj.put("pWeight",67);
        obj.put("pState","testing");
        obj.put("pPain", "testing");
        obj.put("pIllness", "testing");
        obj.put("pAllergy","testing");
        obj.put("pNote", "testing");
        obj.put("pBlood","testing");
    
        return obj;
    }
    
    public JSONObject HistoryDelete() throws JSONException{
    
        obj.put("hphid", "HIS1002");
        
        return obj;
    }
    
    
}
