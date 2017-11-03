/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import Demo_Data.labTest_data;
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
 * @author Lakshika
 */
public class lab_test_managementTest {

    labTest_data dl = new labTest_data();
    TestData td = new TestData();
    String testCode = "";

    @Test
    public void testAddLabTest() throws JSONException, SQLException {
        
        JSONObject exp = dl.AddLabTest();
        
        testCode = exp.getString("ttestCode");
        String ttestsName = exp.getString("ttestsName");
        String ttestType = exp.getString("ttestType");
        String tdiscrption = exp.getString("tdiscrption");
        
        lab_test_management instance = new lab_test_management();
        instance.addLabTest(testCode, ttestsName, ttestType, tdiscrption);
        
        JSONObject act = td.labTestTableData();
        
        assertEquals(testCode, act.getString("ttestCode"));
        assertEquals(ttestsName, act.getString("ttestsName"));
        assertEquals(ttestType, act.getString("ttestType"));
        assertEquals(tdiscrption, act.getString("tdiscrption"));
    }
    
  /*  @Test
    public void testAddLabTestChemecal() throws JSONException, SQLException {

        int count=0;
    
        String ttestCode = "LAB1010";
        String chemical[] = {"abcd", "hkj"};

        lab_test_management instance = new lab_test_management();
        instance.addLabTestChemecal(ttestCode, chemical);

        JSONObject act = td.labTestChemicalTableData();

        assertEquals(testCode, act.getString("testcode"));
        while (act.getString("chemicals") != null) {
            assertEquals(chemical[count], act.getString("chemicals"));
            count++;
        }

    }*/

    @Test
    public void testUpdateLab() throws JSONException, SQLException {
        
        JSONObject exp = dl.UpdateLabTest();
        
        String ttestsName = exp.getString("ttestsName");
        String ttestType = exp.getString("ttestType");
        String tdiscrption = exp.getString("tdiscrption");
        
        lab_test_management instance = new lab_test_management();
        instance.updateLab(testCode, ttestsName, ttestType, tdiscrption);
        
        JSONObject act = td.labTestTableData();
        
        assertEquals(ttestsName, act.getString("ttestsName"));
        assertEquals(ttestType, act.getString("ttestType"));
        assertEquals(tdiscrption, act.getString("tdiscrption"));

    }

    /*@Test
    public void testUpdateLabChemicals() throws Exception {
        
        int count=0;
        String[] chemicals = {"abcd"};
        
        lab_test_management instance = new lab_test_management();
        instance.updateLabChemicals(testCode, chemicals);
        
        JSONObject act = td.labTestChemicalTableData();
        
        while (act.getString("chemicals") != null) {
            assertEquals(chemicals[count], act.getString("chemicals"));
            count++;
        }
    }*/

    @Test
    public void testDeleteLab() throws SQLException, JSONException {
        
        lab_test_management instance = new lab_test_management();
        instance.deleteLab("LAB1010");
        
        JSONObject act = td.labTestTableData();
        
        assertEquals("TE", act.getString("tsatus"));
    }
}
