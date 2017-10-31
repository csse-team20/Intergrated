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
public class Diagnosis_Data {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    
     public void save(String pdiagId,String pPid,String pSigns,String pGeneral,String pSystemic,String pDiagnosis){
        
        c = DBconnection.getConnection();

        try {
            String query = " INSERT INTO `channeling_center`.`diagnosis` (\n"
                    + "	`dId`,\n"
                    + "	`ptpid`,\n"
                    + "	`signs`,\n"
                    + "	`general`,\n"
                    + "	`systemic`,\n"
                    + " `disease`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + pdiagId + "','" + pPid + "','" + pSigns + "','" + pGeneral + "','" + pSystemic + "','" + pDiagnosis + "');";
            
                p = c.prepareStatement(query);
                p.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
    public void update(String pdiagId,String pPid,String pSigns,String pGeneral,String pSystemic,String pDiagnosis){
        
        c = DBconnection.getConnection();
        
        try {
                String qry= "Update diagnosis set ptpid='"+ pPid +"',signs='"+pSigns+"',general='"+pGeneral+"',systemic='"+pSystemic+"' ,disease='"+pDiagnosis +"' where dId='"+ pdiagId +"'";
               
                p = c.prepareStatement(qry);
                p.execute();

                JOptionPane.showMessageDialog(null, "Successfully Updated!");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " ERROR! Update Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }      
    }
    
}
