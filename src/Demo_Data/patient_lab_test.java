/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo_Data;

import org.json.JSONException;
import org.json.JSONObject;

/**testId
 *
 * @author Lakshika
 */
public class patient_lab_test {
    
    JSONObject obj = new JSONObject();
    
    public JSONObject AddPatientLab() throws JSONException{
    
        obj.put("labId", "TESP1006");
        obj.put("patientName", "Iyangi");
        obj.put("testId","LAB1002");
        obj.put("priority", "Medium");
        obj.put("status", "Pending");
        obj.put("date", "2017-11-11");
                        
        return obj;
    }
    
    public JSONObject UpdatePatientLab() throws JSONException{
    
        
        obj.put("patientName", "Iyangi Gamage");
        obj.put("priority", "Medium");
        obj.put("status", "Done");
        obj.put("date", "2017-11-11");
                        
        return obj;
    }
}
