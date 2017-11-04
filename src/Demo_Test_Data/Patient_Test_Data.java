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
public class Patient_Test_Data {
    
    JSONObject obj = new JSONObject();
    
    public JSONObject PatientSave() throws JSONException{
        
        obj.put("pPid", "REG1007");
        obj.put("pFName","Saman");
        obj.put("pLName", "Perera");
        obj.put("pAge",28);
        obj.put("pGender","Male");
        obj.put("pAddress", "Kandy");
        obj.put("pContact","011-2345678");
        obj.put("pNic", "783456788V");
        obj.put("pCat","Critical");
        obj.put("pDate", "2017-11-01");
        
        return obj;
    }
    
     public JSONObject PatientUpdate() throws JSONException{
    
        obj.put("pPid", "REG1007");
        obj.put("pFName","testing");
        obj.put("pLName", "testing");
        obj.put("pAge",28);
        obj.put("pGender","testing");
        obj.put("pAddress", "testing");
        obj.put("pContact","011-2345678");
        obj.put("pNic", "783456788V");
        obj.put("pCat","Critical");
        obj.put("pDate", "2017-11-01");
       
        return obj;        
    }
    public JSONObject PatientDelete() throws JSONException{
   
        obj.put("pPid", "REG1007");
        
        return obj;
           
    }
  
}
