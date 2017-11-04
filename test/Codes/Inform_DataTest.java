/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Demo_Test_Data.Inform_Test_Data;
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
public class Inform_DataTest {
    
    Testing_Data td = new Testing_Data();
    Inform_Test_Data it = new Inform_Test_Data(); 
    /**
     * Test of cancel method, of class Inform_Data.
     */
  @Test
    public void testCancel() throws SQLException, JSONException {
        System.out.println("canceled");
        String pSid = "";
        
        JSONObject exp = td.informData();
        
        JSONObject act = it.InformDelete();
        
        Inform_Data instance = new Inform_Data();
        instance.cancel(pSid);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        assertFalse(Boolean.parseBoolean(act.getString("pSid")));
    }
  
}
