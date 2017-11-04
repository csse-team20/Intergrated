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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
/**
 *
 * @author Lakshika
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class chemical_managementTest {
    
    Chemical_Data cd = new Chemical_Data();
    //chemical_management cm = new chemical_management();
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
        JSONObject act = td.chemicalData();
        
        assertEquals(chemCode, act.getString("tchemCode"));
        assertEquals(tchemName, act.getString("tchemName"));
        assertEquals(ttype, act.getString("ttype"));
        assertEquals(supId, act.getString("supId"));
        
    }

   @Test
    public void testUpdateChemical() throws JSONException, SQLException {
        
        JSONObject exp = cd.UpdateChemical();
        
        String tchemName = exp.getString("tchemName");
        String ttype = exp.getString("ttype");
        String tqty = exp.getString("qty");
        String supId = exp.getString("supId");
        double price = Double.parseDouble(exp.getString("price"));
        
        chemical_management instance = new chemical_management();
        instance.updateChemical(chemCode, tchemName, ttype, tqty, supId,price);
        
        TestData td = new TestData();
        JSONObject act = td.chemicalData();
        
        assertEquals(chemCode, act.getString("tchemCode"));
        assertEquals(tchemName, act.getString("tchemName"));
        assertEquals(ttype, act.getString("ttype"));
        assertEquals(supId, act.getString("supId"));
        
    }

    @Test
    public void testDeleteChemical() throws SQLException, JSONException {
                
        chemical_management instance = new chemical_management();
        instance.deleteChemical(chemCode);
       
        TestData td = new TestData();
        JSONObject act = td.chemicalData();
        
        assertEquals("TE", act.getString("status"));
    }
    
}
