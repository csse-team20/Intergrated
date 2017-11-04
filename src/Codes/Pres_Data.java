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
import javax.swing.JOptionPane;

/**
 *
 * @author Layangi
 */
public class Pres_Data {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    
     public void presSave(String presId,String ptId,String pDrugs,String pNote){
        
        c = DBconnection.getConnection();

        try {
            String query = " INSERT INTO `channeling_center`.`preslist` (\n"
                    + "	`presId`,\n"
                    + "	`ptId`,\n"
                    + "	`presName`,\n"
                    + " `note`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + presId + "','" + ptId + "','" +pDrugs + "','" + pNote + "');";
         
                p = c.prepareStatement(query);
                p.execute();
                
              } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
                
                
     public void presMDSave(String pdiagId,String presId){
        
        c = DBconnection.getConnection();

        try {
            String query2 = " INSERT INTO `channeling_center`.`pres_diag` (\n"
                    + "	`dId`,\n"
                    + " `presId`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + pdiagId + "','" + presId + "');";
            
                p = c.prepareStatement(query2);
                p.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
    public void presMUSave(String ppresId,String docID){
        
        c = DBconnection.getConnection();

        try {
            String query = " INSERT INTO `channeling_center`.`pres_user` (\n"
                    + "	`presId`,\n"
                    + " `ID`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + ppresId + "','" + docID + "');";

                p = c.prepareStatement(query);
                p.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     public void labSave(String plabId,String labType){
        
        c = DBconnection.getConnection();

        try {
            String query = " INSERT INTO `channeling_center`.`labs` (\n"
                    + "	`labId`,\n"
                    + " `type`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + plabId + "','" + labType + "');";
            
                p = c.prepareStatement(query);
                p.execute();
                
              } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
                
     public void labDocSave(String plabId,String docId){
        
        c = DBconnection.getConnection();
 
          try {
               String query5 = " INSERT INTO `channeling_center`.`lab_user` (\n"
                    + "	`labId`,\n"
                    + " `ID`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + plabId + "','" + docId + "');";

                p = c.prepareStatement(query5);
                p.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     //Updating 
     
    //Updating  preslist
    public void presUpdate(String presId,String ptId,String pDrugs,String pNote){
        
        c = DBconnection.getConnection();
        
        try {
                String qry1= "UPDATE `channeling_center`.`preslist`\n" 
                            + "SET `presId` = '"+presId+"',\n" 
                            + " `ptId` = '"+ptId+"',\n" 
                            + " `presName` = '"+pDrugs+"',\n" 
                            + " `note` = '"+pNote+"'\n" 
                            + "WHERE\n" 
                            + "	(`presId` = '"+presId+"');\n" 
                            + "";             
                p = c.prepareStatement(qry1);
                p.execute();

                JOptionPane.showMessageDialog(null, "Prescription Information Successfully Updated!");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " ERROR! Update Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }      
    }
    //Updating pres_diag
    public void presDiagUpdate(String pdiagId,String presId){
        
        c = DBconnection.getConnection();
        
        try {
                String qry1= "UPDATE `channeling_center`.`pres_diag`\n" 
                             + "SET `dId` = '"+pdiagId+"',\n" 
                             + " `presId` = '"+presId+"'\n" 
                             + "WHERE\n" 
                             + "(`dId` = '"+pdiagId+"')\n" 
                             + "AND (`presId` = '"+presId+"');\n" 
                             + "" ;
              
                p = c.prepareStatement(qry1);
                p.execute();

               // JOptionPane.showMessageDialog(null, "Prescription Information Successfully Updated!");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " ERROR! Update Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }      
    }
    
    //Updating pres_user
    public void presUserUpdate(String ppresId,String docID){
        
        c = DBconnection.getConnection();
        
        try {
                String qry1= "UPDATE `channeling_center`.`pres_user`\n" 
                            + "SET `presId` = '"+ppresId+"',\n" 
                            + "`ID` = '"+docID+"'\n" 
                            + "WHERE\n" 
                            + "	(`presId` = '"+ppresId+"')\n" 
                            + "AND (`ID` = '"+docID+"');"
                            + "";
                
                p = c.prepareStatement(qry1);
                p.execute();

             //   JOptionPane.showMessageDialog(null, "Prescription Information Successfully Updated!");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " ERROR! Update Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }      
    }
    
    //Update labs
    public void labUpdate(String plabId,String labType){
        
        c = DBconnection.getConnection();
        
        try {
                String qry = "UPDATE `channeling_center`.`labs`\n" 
                           + "SET `labId` = '"+plabId+"',\n" 
                           + " `type` = '"+labType+"'\n" 
                           + "WHERE\n" 
                           + "	(`labId` = '"+plabId+"');\n" 
                           + "";              
                p = c.prepareStatement(qry);
                p.execute();

                JOptionPane.showMessageDialog(null, "Lab Details Successfully Updated!");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " ERROR! Update Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }      
    } 
    
    //Update lab_user
    public void labUserUpdate(String plabId,String docId){
        
        c = DBconnection.getConnection();
        
        try {
                String qry = "UPDATE `channeling_center`.`lab_user`\n" 
                             + "SET `labId` = '"+plabId+"',\n" 
                             + " `ID` = '"+docId+"'\n" 
                             + "WHERE\n" 
                             + "	(`labId` = '"+plabId+"')\n" 
                             + "AND (`ID` = '"+docId+"');\n" 
                             + "";
                
                p = c.prepareStatement(qry);
                p.execute();

              //  JOptionPane.showMessageDialog(null, "Lab Details Successfully Updated!");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " ERROR! Update Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }      
    } 
}

     
     
     