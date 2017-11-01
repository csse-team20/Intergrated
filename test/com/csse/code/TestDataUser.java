/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import com.csse.db.Dbaccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class TestDataUser {
    
     public JSONObject getUsers() throws JSONException, SQLException{
         
         
         JSONObject jsonObject = new JSONObject();
        
        
            Dbaccess da = new Dbaccess();
            ResultSet rs;
            String tId = null;
            String tFirstName = null;
            String query ="SELECT\n" +
                    "	users.ID,\n" +
                    "	users.FIRST_NAME,\n" +
                    "	users.LAST_NAME,\n" +
                    "	users.ADDRESS,\n" +
                    "	users.NIC,\n" +
                    "	users.EMAIL,\n" +
                    "	users.PHONE,\n" +
                    "	users.TYPE,\n" +
                    "	users.IMAGE \n" +
                    "FROM\n" +
                    "	users \n" +
                    "ORDER BY\n" +
                    "	users.FIRST_NAME ASC";
            rs = da.getData(query);
            
            while(rs.next()){
                
                tId = rs.getString("ID");
                tFirstName = rs.getString("FIRST_NAME");
                
                
            }
                 
                 jsonObject.put("tfirstName", tFirstName);
                 jsonObject.put("tfirstName", tFirstName);
            //     System.out.println("data "+jsonObject.toString());
                 System.out.println("data "+jsonObject.toString());
                 return jsonObject;
      
        
     
    }
    
    
}
