/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import Demo_Data.Chemical_Data;
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
public class chemical_managementTest {
    
    Chemical_Data cd = new Chemical_Data();
    chemical_management cm = new chemical_management();
    String chemCode = "";
    
    @Test
    public void testAddChemical() throws JSONException, SQLException {
        
        JSONObject exp = cd.AddChemical();
        
        chemCode = exp.getString("tchemCode");
        String tchemName = exp.getString("tchemName");
        String ttype = exp.getString("ttype");
        String tqty = exp.getString("qty");
        String supId = exp.getString("supId");
        double price = Double.parseDouble(exp.getString("price"));
        
        chemical_management instance = new chemical_management();
        instance.addChemical(chemCode, tchemName, ttype, tqty, supId,price);
        
        TestData td = new TestData();
        JSONObject act = td.chemicalTableData();
    }

    /**
     * Test of updateChemical method, of class chemical_management.
     */
    @Test
    public void testUpdateChemical() {
        
        String tchemCode = "";
        String tchemName = "";
        String ttype = "";
        String tqty = "";
        String supId = "";
        double price = 0.0;
        chemical_management instance = new chemical_management();
        instance.updateChemical(tchemCode, tchemName, ttype, tqty, supId,price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteChemical method, of class chemical_management.
     */
    @Test
    public void testDeleteChemical() {
        
        String chemCode = "";
        chemical_management instance = new chemical_management();
        instance.deleteChemical(chemCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
