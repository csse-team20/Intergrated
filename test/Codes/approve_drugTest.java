/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import Demo_Test_Data.Approve_Test_Data;
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
public class approve_drugTest {
    
    Testing_Data td = new Testing_Data();
    Approve_Test_Data ad = new Approve_Test_Data();
    
    /**
     * Test of updateOrderStatus method, of class approve_drug.
     */
 /*   @Test
    public void testUpdateOrderStatus() throws JSONException, SQLException {
        System.out.println("update Order Status");
        
        JSONObject exp = ad.UpdateDrugs();
        
        String torder_id = "";
        torder_id =  exp.getString("torder_id");
        double tamount = Double.parseDouble(exp.getString("tamount"));
        String torder_status = exp.getString("torder_status");
        String OsupId = exp.getString("OsupId");

        approve_drug instance = new approve_drug();
        instance.updateOrderStatus(torder_id, tamount);
        JSONObject act = td.OrderStatus();
      
        assertEquals(torder_status, act.getString("torder_status"));
    }
   */

    /**
     * Test of updateDrugQty method, of class approve_drug.
     */
    @Test
    public void testUpdateDrugQty() {
        System.out.println("update Drug Qty");
        
        String did = "";
        int qty = 0;
        
        approve_drug instance = new approve_drug();
        instance.updateDrugQty(did, qty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
  
}
