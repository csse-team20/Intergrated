/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.csse.db.Dbaccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Anuradha Sanjeewa
 */
public class TestUser {
    JSONObject jsonObject = new JSONObject();
    public TestUser() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    
    
    public JSONObject getUsers() throws JSONException, SQLException{
    
        
        
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
