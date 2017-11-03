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
        
        while(rs.next()){
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
        System.out.println("data "+jsonObject.toString());
        return jsonObject;
    }
    
    public void chemicalData() throws SQLException{
    
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
        
        while(rs.next()){
            tchemCode = rs.getString("chemCode");
            tchemName = rs.getString("chemName");
            ttype = rs.getString("type");
            tqty = Integer.parseInt(rs.getString("qty"));
            supId = rs.getString("supId");
            status = rs.getString("status");
            price = Double.parseDouble(rs.getString("price"));
                       
        }

    }
    
    public void labTestData() throws SQLException{
    
        c = DBconnection.getConnection();
        
        String ttestCode = "";
        String ttestsName = "";
        String ttestType = "";
        String tdiscrption = "";
        String[] chemical = null;
        String tstatus = "";
        
        String labTest = "SELECT testCode,testName,testType,discription,statua "
                + "FROM lab ORDER BY testCode DESC LIMIT 1";
        p = c.prepareStatement(labTest);
        rs = p.executeQuery();
        
        while(rs.next()){
            ttestCode = rs.getString("testCode");
            ttestsName = rs.getString("testName");
            ttestType = rs.getString("discription");
            tdiscrption = rs.getString("");
            tstatus = rs.getString("statua");
            //chemical = rs.getString("qty")
            
                       
        }
    }
}
