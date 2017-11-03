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
public class diagnosis_Test_Data {
    JSONObject obj = new JSONObject();
    
    public JSONObject SaveDiagnosis() throws JSONException{
    
        obj.put("pdiagId", "DIAG1007");
        obj.put("pPid", "REG1005");
        obj.put("pSigns","testing");
        obj.put("pGeneral", "cough");
        obj.put("pSystemic","good");
        obj.put("pDiagnosis", "Fever");

        return obj;
    }
    
    public JSONObject UpdateDiagnosis() throws JSONException{
           
       obj.put("pdiagId", "DIAG1007");
       obj.put("pPid", "REG1005");
       obj.put("pSigns","testing");
       obj.put("pGeneral", "testing");
       obj.put("pSystemic","testing");
       obj.put("pDiagnosis", "testing");
       
        return obj;
    }
}
