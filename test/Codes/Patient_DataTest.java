/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Demo_Test_Data.Patient_Test_Data;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Layangi
 */
public class Patient_DataTest {
    
    String pPid = "";  
    Testing_Data td = new Testing_Data();
    
    Patient_Test_Data dd = new Patient_Test_Data();
    /**
     * Test of save method, of class Patient_Data.
     */
    
    @Test
    public void testSave() throws JSONException, SQLException {
        System.out.println("save");
        
        JSONObject exp = dd.PatientSave();
        
        pPid = exp.getString("pPid");
        String pFName = exp.getString("pFName");
        String pLName = exp.getString("pLName");
        String pAge = exp.getString("pAge");
        String pGender = exp.getString("pGender");
        String pAddress = exp.getString("pAddress");
        String pContact = exp.getString("pContact");
        String pNic = exp.getString("pNic");
        String pCat = exp.getString("pCat");
        String pDate = exp.getString("pDate");
        
        Patient_Data instance = new Patient_Data();
        instance.save(pPid, pFName, pLName, pAge, pGender, pAddress, pContact, pNic, pCat, pDate);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        JSONObject act = td.patientData();
      
        assertEquals(pFName, act.getString("pFName"));
    }
    

    /**
     * Test of update method, of class Patient_Data.
     */
   /*  
    @Test
   
    public void testUpdate() throws JSONException, SQLException {
        System.out.println("update");
        
        JSONObject exp = dd.PatientUpdate();
        
        pPid = exp.getString("pPid");
        String pFName = exp.getString("pFName");
        String pLName = exp.getString("pLName");
        String pAge = exp.getString("pAge");
        String pGender = exp.getString("pGender");
        String pAddress = exp.getString("pAddress");
        String pContact = exp.getString("pContact");
        String pNic = exp.getString("pNic");
        String pCat = exp.getString("pCat");
        
        Patient_Data instance = new Patient_Data();
        instance.update(pPid, pFName, pLName, pAge, pGender, pAddress, pContact, pNic, pCat);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        
        JSONObject act = td.patientData();
      
        assertEquals(pFName, act.getString("pFName"));        
    }
*/
    /**
     * Test of delete method, of class Patient_Data.
     */
   
    /*
    @Test
    public void testDelete() throws SQLException, JSONException {
        System.out.println("delete");
        
        JSONObject exp = td.patientData();
        
        JSONObject act = dd.PatientDelete();
        
        Patient_Data instance = new Patient_Data();
        instance.delete(pPid);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        assertFalse(Boolean.parseBoolean(act.getString("pPid")));
    }
    
    */
}
