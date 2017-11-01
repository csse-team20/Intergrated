/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.code;

import Demo_Data.drug_Data;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author Orange
 */
public class drug_managementTest {
    TestData td = new TestData();
    
    drug_Data dd = new drug_Data();
       /**
     * Test of addDrugs method, of class drug_management.
     */
    @Test
    public void testAddDrugs() throws SQLException, JSONException {
        
        
        JSONObject exp = td.drugData();
               
        JSONObject act = dd.AddDrugs();
        
        String tpresCode = exp.getString("tpresCode");
        String tpresName = exp.getString("tpresName");
        String tcatagory = exp.getString("tcatagory");
        String tunitType = exp.getString("tunitType");
        String tdiscrption = exp.getString("tdiscrption");
        String tsupId = exp.getString("tsupId");
        
        assertEquals(tpresName, act.getString("tpresName"));
    }

    
   @Test
    public void testUpdateDrug() throws SQLException, JSONException {
        
        JSONObject exp = td.drugData();
        
        JSONObject act = dd.UpdateDrugs();
        
        String tpresCode = exp.getString("tpresCode");
        String tpresName = exp.getString("tpresName");
        String tcatagory = exp.getString("tcatagory");
        String tunitType = exp.getString("tunitType");
        String tdiscrption = exp.getString("tdiscrption");
        String tsupId = exp.getString("tsupId");
        
        assertEquals(tpresName, act.getString("tpresName"));
    }

    @Test
    public void testDeleteDrug() throws SQLException, JSONException {
        
        JSONObject exp = td.drugData();
        
        JSONObject act = dd.DeleteDrugs();
        
        String tpresCode = exp.getString("tpresCode");
        
        assertFalse(Boolean.parseBoolean(act.getString("tpresCode")));
    }
    
}
