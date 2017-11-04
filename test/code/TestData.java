/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lakshika
 */
public class TestData {

    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;

    JSONObject jsonObject = new JSONObject();

    public JSONObject drugData() throws SQLException, JSONException {

        c = DBconnection.getConnection();

        String tpresCode = "";
        String tpresName = "";
        String tcatagory = "";
        String tunitType = "";
        String tdiscrption = "";
        String tsupId = "";
        double tprice = 0.0;
        int tcurrent_qty = 0;
        String tstatus = "";

        String drug = "SELECT presCode,presName,category,unitType,discription,supId,price,status "
                + "FROM drug ORDER BY presCode DESC LIMIT 1";
        p = c.prepareStatement(drug);
        rs = p.executeQuery();

        while (rs.next()) {
            tpresCode = rs.getString("presCode");
            tpresName = rs.getString("presName");
            tcatagory = rs.getString("category");
            tunitType = rs.getString("unitType");
            tdiscrption = rs.getString("discription");
            tsupId = rs.getString("supId");
            //tprice = Double.parseDouble(rs.getString("price"));
            //tcurrent_qty = Integer.parseInt(rs.getString("current_qty"));
            tstatus = rs.getString("status");

        }
        jsonObject.put("tpresCode", tpresCode);
        jsonObject.put("tpresName", tpresName);
        jsonObject.put("tcatagory", tcatagory);
        jsonObject.put("tunitType", tunitType);
        jsonObject.put("tdiscrption", tdiscrption);
        jsonObject.put("tsupId", tsupId);
        jsonObject.put("tprice", tprice);
        jsonObject.put("tcurrent_qty", tcurrent_qty);
        jsonObject.put("tstatus", tstatus);

        return jsonObject;
    }

    public JSONObject chemicalData() throws SQLException, JSONException {

        c = DBconnection.getConnection();

        String tchemCode = "";
        String tchemName = "";
        String ttype = "";
        int tqty = 0;
        String supId = "";
        String status = "";
        double price = 0.0;

        String chemical = "SELECT chemCode,chemName,type,qty,supId,status,price "
                + "FROM chemical ORDER BY chemCode DESC LIMIT 1";
        p = c.prepareStatement(chemical);
        rs = p.executeQuery();

        while (rs.next()) {
            tchemCode = rs.getString("chemCode");
            tchemName = rs.getString("chemName");
            ttype = rs.getString("type");
            tqty = Integer.parseInt(rs.getString("qty"));
            supId = rs.getString("supId");
            status = rs.getString("status");
            price = Double.parseDouble(rs.getString("price"));

        }

        jsonObject.put("tchemCode", tchemCode);
        jsonObject.put("tchemName", tchemName);
        jsonObject.put("ttype", ttype);
        jsonObject.put("tqty", tqty);
        jsonObject.put("supId", supId);
        jsonObject.put("status", status);
        jsonObject.put("price", price);

        return jsonObject;

    }

    public JSONObject labTestData() throws SQLException, JSONException {

        c = DBconnection.getConnection();

        String ttestCode = "";
        String ttestsName = "";
        String ttestType = "";
        String tdiscrption = "";
        String tstatus = "";

        String labTest = "SELECT testCode,testName,testType,discription,statua "
                + "FROM lab ORDER BY testCode DESC LIMIT 1";
        p = c.prepareStatement(labTest);
        rs = p.executeQuery();

        while (rs.next()) {
            ttestCode = rs.getString("testCode");
            ttestsName = rs.getString("testName");
            ttestType = rs.getString("testType");
            tdiscrption = rs.getString("discription");
            tstatus = rs.getString("statua");

        }
        jsonObject.put("ttestCode", ttestCode);
        jsonObject.put("ttestsName", ttestsName);
        jsonObject.put("ttestType", ttestType);
        jsonObject.put("tdiscrption", tdiscrption);
        jsonObject.put("tsatus", tstatus);

        return jsonObject;
    }

    public JSONObject labTestChemicalData() throws SQLException, JSONException {

        c = DBconnection.getConnection();

        String ttestCode = "";
        String[] chemical = new String[10];
        int count = 0;

        String labTest = "SELECT lab.testCode as testcode,chemical.chemName as chemname "
                + "FROM lab,labchem,chemical "
                + "WHERE lab.testCode = labchem.testCode and labchem.chemCode = chemical.chemCode "
                + "ORDER BY testCode DESC";
        p = c.prepareStatement(labTest);
        rs = p.executeQuery();
        while (rs.next()) {
            ttestCode = rs.getString("testcode");

            if (rs.getString("chemname") != null) {
                System.out.println(rs.getString("chemname"));
                chemical[count] = rs.getString("chemname");
            }
            count++;

        }
        jsonObject.put("ttestCode", ttestCode);
        jsonObject.put("chemicals", new JSONArray(chemical));
        System.out.println("chemical " + jsonObject.toString());
        return jsonObject;
    }

    public JSONArray PatientlabTestData() throws SQLException, JSONException {
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        c = DBconnection.getConnection();

        String labId = "";
        String patientName = "";
        String patientTestId = "";
        String status = "";
        String priority = "";
        String date = "";

        String labTest = "select lp.labid as 'patientTestId',lp.patient_name as 'patientName',lpt.testCode as 'labId',lpt.status as 'status',lpt.priority 'priority',lpt.duedate as 'DueDate' \n"
                + "from lab_patient_test lpt,lab_patient lp\n"
                + "where lpt.labid = lp.labid\n"
                + "group by lp.labid,lp.patient_name,lpt.testCode,lpt.status,lpt.priority,lpt.duedate\n"
                + "ORDER BY lp.labid DESC ";
        p = c.prepareStatement(labTest);
        rs = p.executeQuery();

        while (rs.next()) {

            labId = rs.getString("patientTestId");
            patientName = rs.getString("patientName");
            patientTestId = rs.getString("labId");
            status = rs.getString("status");
            priority = rs.getString("priority");
            date = rs.getString("DueDate");

            obj.put("labId", labId);
            obj.put("patientName", patientName);
            obj.put("patientTestId", patientTestId);
            obj.put("priority", priority);
            obj.put("status", status);
            obj.put("date", date);
            
            arr.put(obj);
           System.out.println(arr.toString());
            
        }
        return arr;
    }
}
