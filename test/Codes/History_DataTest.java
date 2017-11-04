/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Demo_Test_Data.History_Test_Data;
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
public class History_DataTest {
    
    String pHisID = "";
    Testing_Data td = new Testing_Data();
    History_Test_Data dd = new History_Test_Data();
    /**
     * Test of save method, of class History_Data.
     */
 
    @Test
    public void testSave() throws JSONException, SQLException {
        System.out.println("save");
        
        JSONObject exp = dd.HistorySave(); 
       
        pHisID = exp.getString("pHisID");
        String pPid = exp.getString("pPid");
        String pHeight = exp.getString("pHeight");
        String pWeight = exp.getString("pWeight");
        String pState = exp.getString("pState");
        String pPain = exp.getString("pPain");
        String pIllness = exp.getString("pIllness");
        String pAllergy = exp.getString("pAllergy");
        String pNote = exp.getString("pNote");
        String pBlood = exp.getString("pBlood");
        
        History_Data instance = new History_Data();
        instance.save(pPid, pHisID, pHeight, pWeight, pState, pPain, pIllness, pAllergy, pNote, pBlood);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        JSONObject act = td.historyData();
        
        assertEquals(pIllness, act.getString("pIllness"));
    }
    /**
     * Test of update method, of class History_Data.
     */
 
    /*@Test
    public void testUpdate() throws JSONException, SQLException {
        System.out.println("update");
        
        JSONObject exp = dd.HistoryUpdate();
        
        pHisID = exp.getString("pHisID");
        String pPid = exp.getString("pPid");
        String pHeight = exp.getString("pHeight");
        String pWeight = exp.getString("pWeight");
        String pState = exp.getString("pState");
        String pPain = exp.getString("pPain");
        String pIllness = exp.getString("pIllness");
        String pAllergy = exp.getString("pAllergy");
        String pNote = exp.getString("pNote");
        String pBlood = exp.getString("pBlood");
        
        History_Data instance = new History_Data();
        instance.update(pPid, pHisID, pHeight, pWeight, pState, pPain, pIllness, pAllergy, pNote, pBlood);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        JSONObject act = td.historyData();
        
        assertEquals(pIllness, act.getString("pIllness"));
    }

    /**
     * Test of delete method, of class History_Data.
     */
  /*
    @Test
    public void testDelete() throws SQLException, JSONException {
        System.out.println("delete");

        JSONObject act = td.historyData();
        JSONObject exp = dd.HistoryDelete();
        
        History_Data instance = new History_Data();
        instance.delete(pHisID);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        assertFalse(Boolean.parseBoolean(act.getString("pHisID")));
    }
   */
    
}
