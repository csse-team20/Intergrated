/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import Demo_Data.drug_Data;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Orange
 */
public class drug_managementTest {

    String presCode = "";
    drug_Data dd = new drug_Data();
    drug_management dm = new drug_management();

    /**
     * Test of addDrugs method, of class drug_management.
     */
   @Test
    public void testAddDrugs() throws SQLException, JSONException {

        JSONObject exp = dd.AddDrugs();

        presCode = exp.getString("tpresCode");
        String tpresName = exp.getString("tpresName");
        String tcatagory = exp.getString("tcatagory");
        String tunitType = exp.getString("tunitType");
        String tdiscrption = exp.getString("tdiscrption");
        String tsupId = exp.getString("tsupId");
        double tprice = Double.parseDouble(exp.getString("tprice"));

        dm.addDrugs(presCode, tpresName, tcatagory, tunitType, tdiscrption, tsupId, tprice);

        TestData td = new TestData();
        JSONObject act = td.drugData();

        assertEquals(presCode, act.getString("tpresCode"));
        assertEquals(tpresName, act.getString("tpresName"));
        assertEquals(tcatagory, act.getString("tcatagory"));
        assertEquals(tunitType, act.getString("tunitType"));
    }

    @Test
    public void testUpdateDrug() throws SQLException, JSONException {

        JSONObject exp = dd.UpdateDrugs();

        String tpresName = exp.getString("tpresName");
        String tcatagory = exp.getString("tcatagory");
        String tunitType = exp.getString("tunitType");
        String tdiscrption = exp.getString("tdiscrption");
        String tsupId = exp.getString("tsupId");

        dm.updateDrug(presCode, tpresName, tunitType, tcatagory, tdiscrption, tsupId);

        TestData td = new TestData();
        JSONObject act = td.drugData();

        assertEquals(tpresName, act.getString("tpresName"));
        assertEquals(tcatagory, act.getString("tcatagory"));
        assertEquals(tunitType, act.getString("tunitType"));
    }

    @Test
    public void testDeleteDrug() throws SQLException, JSONException {

        dm.deleteDrug(presCode);

        TestData td = new TestData();
        JSONObject act = td.drugData();

        assertEquals("TE", act.getString("tstatus"));
    }

}
