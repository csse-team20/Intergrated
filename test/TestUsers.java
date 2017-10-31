//
//import com.csse.db.Dbaccess;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.json.JSONException;
//import org.json.JSONObject;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Anuradha Sanjeewa
// */
//public class TestUsers {
//    
//    JSONObject jsonObject = new JSONObject();
//    
//    public JSONObject getUsers(){
//    
//        try {
//            Dbaccess da = new Dbaccess();
//            ResultSet rs;
//            String tId = null;
//            String tFirstName = null;
//            String query ="SELECT\n" +
//                    "	users.ID,\n" +
//                    "	users.FIRST_NAME,\n" +
//                    "	users.LAST_NAME,\n" +
//                    "	users.ADDRESS,\n" +
//                    "	users.NIC,\n" +
//                    "	users.EMAIL,\n" +
//                    "	users.PHONE,\n" +
//                    "	users.TYPE,\n" +
//                    "	users.IMAGE \n" +
//                    "FROM\n" +
//                    "	users \n" +
//                    "ORDER BY\n" +
//                    "	users.FIRST_NAME ASC";
//            rs = da.getData(query);
//            
//            while(rs.next()){
//                
//                tId = rs.getString("ID");
//                tFirstName = rs.getString("FIRST_NAME");
//                
//                
//            }
//            jsonObject.put("ID", tId);
//            System.out.println("data "+jsonObject.toString());
//            //return jsonObject;
//        } catch (SQLException | JSONException ex) {
//            Logger.getLogger(TestUsers.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return jsonObject;
//    }
//    
//}
