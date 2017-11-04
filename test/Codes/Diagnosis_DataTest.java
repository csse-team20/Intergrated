/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Demo_Test_Data.diagnosis_Test_Data;
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
public class Diagnosis_DataTest {
    
    String pdiagId = "";
    Testing_Data td = new Testing_Data();
 
    diagnosis_Test_Data dd = new diagnosis_Test_Data();
            
     /**
     * Test of save method, of class Diagnosis_Data.
     */
 
   /* @Test
    public void testSave() throws JSONException, SQLException {
        System.out.println("save");
        
        JSONObject exp = dd.SaveDiagnosis();
        
        pdiagId = exp.getString("pdiagId");
        String pPid = exp.getString("pPid");
        String pSigns = exp.getString("pSigns");
        String pGeneral = exp.getString("pGeneral");
        String pSystemic = exp.getString("pSystemic");
        String pDiagnosis = exp.getString("pDiagnosis");    

        Diagnosis_Data instance = new Diagnosis_Data();
        instance.save(pdiagId, pPid, pSigns, pGeneral, pSystemic, pDiagnosis);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
        
        JSONObject act = td.diagnosisData();
        
      //  assertEquals(exp, act);
        assertEquals(pSigns , act.getString("pSigns"));      
    }

    /**
     * Test of update method, of class Diagnosis_Data.
     */
 
 /*   @Test
    public void testUpdate() throws JSONException, SQLException {
        System.out.println("update");
        
        JSONObject exp = dd.SaveDiagnosis();
        
        pdiagId = exp.getString("pdiagId");
        String pPid = exp.getString("pPid");
        String pSigns = exp.getString("pSigns");
        String pGeneral = exp.getString("pGeneral");
        String pSystemic = exp.getString("pSystemic");
        String pDiagnosis = exp.getString("pDiagnosis"); 
        
        Diagnosis_Data instance = new Diagnosis_Data();
        instance.update(pdiagId, pPid, pSigns, pGeneral, pSystemic, pDiagnosis);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
        
        JSONObject act = td.diagnosisData();
        assertEquals(pSigns, act.getString("pSigns"));
    }
   */ 
}
