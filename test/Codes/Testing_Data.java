/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Layangi
 */
public class Testing_Data {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
 
    JSONObject jsonObject = new JSONObject();
    
    public JSONObject patientData() throws SQLException, JSONException {

        c = DBconnection.getConnection();
        
        String pPid = "";
        String pFName = "";
        String pLName = "";
        String pAge = "";
        String pGender = "";
        String pAddress = "";
        String pContact = "";
        String pNic = "";
        String pCat = "";
        String pDate = "";

        String pData = "SELECT pid,fName,lName,age,gender,address,contact,nic,catecory,regDate "
                      + "FROM patient ORDER BY pid DESC LIMIT 1";
        
        p = c.prepareStatement(pData);
        rs = p.executeQuery();
        
        while(rs.next()){
            pPid = rs.getString("pid");
            pFName = rs.getString("fName");
            pLName = rs.getString("lName");
            pAge = rs.getString("age");
            //page = Integer.parseInt(rs.getString("age"));
            pGender = rs.getString("gender");
            pAddress = rs.getString("address");
            pContact = rs.getString("contact");
            pNic = rs.getString("nic");
            pCat = rs.getString("catecory");
            pDate = rs.getString("regDate");
            
            
        }
        jsonObject.put("pPid", pPid);
        jsonObject.put("pFName", pFName);
        jsonObject.put("pLName", pLName);
        jsonObject.put("pAge", pAge);
        jsonObject.put("pGender", pGender);
        jsonObject.put("pAddress", pAddress);
        jsonObject.put("pContact", pContact);
        jsonObject.put("pNic", pNic);
        jsonObject.put("pCat", pCat);
        jsonObject.put("pDate", pDate);
        
        System.out.println("data "+jsonObject.toString());
        return jsonObject;
    }
    
   // --------------------
    
    public JSONObject historyData() throws SQLException, JSONException {

        c = DBconnection.getConnection();
        
        String pHisID = "";
        String pPid = "";
        String pHeight = "";
        String pWeight = "";
        String pState = "";
        String pPain = "";
        String pIllness = "";
        String pAllergy = "";
        String pNote = "";
        String pBlood = "";

        String hData = "SELECT phid,ppid,height,weight,state,pain,illness,allergy,note,blood "
                      + "FROM patient_history ORDER BY phid DESC LIMIT 1";
        
        p = c.prepareStatement(hData);
        rs = p.executeQuery();
        
        while(rs.next()){
            pHisID = rs.getString("phid");
            pPid = rs.getString("ppid");
            pHeight = rs.getString("height");
            pWeight = rs.getString("weight");
            pState = rs.getString("state");
            pPain = rs.getString("pain");
            pIllness = rs.getString("illness");
            pAllergy = rs.getString("allergy");
            pNote = rs.getString("note");
            pBlood = rs.getString("blood");
                       
        }
        jsonObject.put("pHisID", pHisID);
        jsonObject.put("pPid", pPid);
        jsonObject.put("pHeight", pHeight);
        jsonObject.put("pWeight", pWeight);
        jsonObject.put("pState", pState);
        jsonObject.put("pPain", pPain);
        jsonObject.put("pIllness", pIllness);
        jsonObject.put("pAllergy", pAllergy);
        jsonObject.put("pNote", pNote);
        jsonObject.put("pBlood", pBlood);
        
        System.out.println("data "+jsonObject.toString());
        return jsonObject;
    }
    //--------------------------------
    
     public JSONObject diagnosisData() throws SQLException, JSONException {

        c = DBconnection.getConnection();
        
        String pdiagId = "";
        String pPid = "";
        String pSigns = "";
        String pGeneral = "";
        String pSystemic = "";
        String pDiagnosis = "";

        String diag = "SELECT dId,ptpid,signs,general,systemic,disease "
                    + "FROM diagnosis ORDER BY dId DESC LIMIT 1";
        
        p = c.prepareStatement(diag);
        rs = p.executeQuery();
        
        while(rs.next()){
            pdiagId = rs.getString("dId");
            pPid = rs.getString("ptpid");
            pSigns = rs.getString("signs");
            pGeneral = rs.getString("general");
            pSystemic = rs.getString("systemic");
            pDiagnosis = rs.getString("disease");
            
        }
        jsonObject.put("pdiagId", pdiagId);
        jsonObject.put("pPid", pPid);
        jsonObject.put("pSigns", pSigns);
        jsonObject.put("pGeneral", pGeneral);
        jsonObject.put("pSystemic", pSystemic);
        jsonObject.put("pDiagnosis", pDiagnosis);
        
        System.out.println("data "+jsonObject.toString());
        return jsonObject;
    }
     
    //----------------------------------------------- 
     
      public JSONObject informData() throws SQLException, JSONException {

        c = DBconnection.getConnection();
        
        String sId = "";
        String sDoc = "";
        String sDate = "";
        String sTime = "";
        String sPatient = "";

        String diag = "SELECT Sid,Doctor,Date,Time,Patient "
                    + "FROM schedule ORDER BY Sid DESC LIMIT 1";
        
        p = c.prepareStatement(diag);
        rs = p.executeQuery();
        
        while(rs.next()){
            sId = rs.getString("Sid");
            sDoc = rs.getString("Doctor");
            sDate = rs.getString("Date");
            sTime = rs.getString("Time");
            sPatient = rs.getString("Patient");
            
        }
        jsonObject.put("pdiagId", sId);
        jsonObject.put("pPid", sDoc);
        jsonObject.put("pSigns", sDate);
        jsonObject.put("pGeneral", sTime);
        jsonObject.put("pSystemic", sPatient);
        
        System.out.println("data "+jsonObject.toString());
        return jsonObject;
}
      
      //-------------------------------

      public JSONObject OrderStatus() throws SQLException, JSONException {

        c = DBconnection.getConnection();
        
        String torder_id = "";
        double tamount = 0.0;
        String torder_status = "";
        String OsupId = "";

        String diag = "SELECT oid,order_status,amount,supId "
                    + "FROM orders ORDER BY oid DESC LIMIT 1";
        
        p = c.prepareStatement(diag);
        rs = p.executeQuery();
        
        while(rs.next()){
            torder_id = rs.getString("oid");
            tamount = Double.parseDouble(rs.getString("amount"));
            torder_status = rs.getString("order_status");
            OsupId = rs.getString("supId");
            
        }
        jsonObject.put("torder_id", torder_id);
        jsonObject.put("tamount", tamount);
        jsonObject.put("torder_status", torder_status);
        jsonObject.put("OsupId", OsupId);

        System.out.println("data "+jsonObject.toString());
        return jsonObject;
    }
    //-------------------------------

    public JSONObject DrugQty() throws SQLException, JSONException {

        c = DBconnection.getConnection();
        
        String pdiagId = "";
        String pPid = "";
        String pSigns = "";
        String pGeneral = "";
        String pSystemic = "";
        String pDiagnosis = "";

        String diag = "SELECT dId,ptpid,signs,general,systemic,disease "
                    + "FROM diagnosis ORDER BY dId DESC LIMIT 1";
        
        p = c.prepareStatement(diag);
        rs = p.executeQuery();
        
        while(rs.next()){
            pdiagId = rs.getString("dId");
            pPid = rs.getString("ptpid");
            pSigns = rs.getString("signs");
            pGeneral = rs.getString("general");
            pSystemic = rs.getString("systemic");
            pDiagnosis = rs.getString("disease");
            
        }
        jsonObject.put("pdiagId", pdiagId);
        jsonObject.put("pPid", pPid);
        jsonObject.put("pSigns", pSigns);
        jsonObject.put("pGeneral", pGeneral);
        jsonObject.put("pSystemic", pSystemic);
        jsonObject.put("pDiagnosis", pDiagnosis);
        
        System.out.println("data "+jsonObject.toString());
        return jsonObject;
    }
  


}