/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import Demo_Data.patient_lab_test;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lakshika
 */
public class patient_lab_test_managementTest {

    String tlabid = "";
    String ttestCode = "";
    patient_lab_test plt = new patient_lab_test();
    patient_lab_test_management pl = new patient_lab_test_management();

    @Test
    public void testAddPatientLabTest() throws SQLException, JSONException, ParseException {

        JSONObject exp = plt.AddPatientLab();
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        
        tlabid = exp.getString("labId");
        String tname = exp.getString("patientName");
        ttestCode = exp.getString("testId");
        Date dueDate = df.parse(exp.getString("date"));
        //Date dueDate = (Date)(exp.getString("date"));
        String tststus = exp.getString("status");
        String tpriority = exp.getString("priority");
        System.out.println("test date:"+dueDate);
        patient_lab_test_management instance = new patient_lab_test_management();
        instance.addPatientLabTest(tlabid, tname,ttestCode,dueDate, tststus, tpriority);
        
        TestData td = new TestData();
        JSONArray act = td.PatientlabTestData();
        
        assertEquals(tlabid, act.getJSONObject(0).getString("labId"));
    }

    /**
     * Test of updatePatientLab method, of class patient_lab_test_management.
     */
    @Test
    public void testUpdatePatientLab() throws JSONException, ParseException, SQLException {
    
        JSONObject exp = plt.UpdatePatientLab();
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        
        String tname = exp.getString("patientName");
        Date dueDate = df.parse(exp.getString("date"));
        //Date dueDate = (Date)(exp.getString("date"));
        String tststus = exp.getString("status");
        String tpriority = exp.getString("priority");
        
        patient_lab_test_management instance = new patient_lab_test_management();
        instance.updatePatientLab(tlabid, ttestCode, tststus, tpriority, dueDate);
        
        TestData td = new TestData();
        JSONArray act = td.PatientlabTestData();
        
        assertEquals(tststus, act.getJSONObject(0).getString("status"));
    }

   /* @Test
    public void testUpdatePatient() {
        System.out.println("updatePatient");
        String labid = "";
        String name = "";
        patient_lab_test_management instance = new patient_lab_test_management();
        instance.updatePatient(labid, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testDeletePatientTest() {
        System.out.println("deletePatientTest");
        String labid = "";
        String ttestCode = "";
        patient_lab_test_management instance = new patient_lab_test_management();
        instance.deletePatientTest(labid, ttestCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
