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
public class Patient_Data {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    
    
    public void save(String pPid,String pFName,String pLName,String pAge,String pGender,String pAddress,String pContact,String pNic,String pCat,String pDate){
        
        c = DBconnection.getConnection();

        try {
            String qry = " INSERT INTO `channeling_center`.`patient` (\n"
                    + "	`pid`,\n"
                    + "	`fName`,\n"
                    + "	`lName`,\n"
                    + "	`age`,\n"
                    + "	`gender`,\n"
                    + "	`address`,\n"
                    + "	`contact`,\n"
                    + "	`nic`,\n"
                    + "	`catecory`,\n"
                    + " `regDate`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + pPid + "','" + pFName + "','" + pLName + "','" + pAge + "','" + pGender + "','" + pAddress + "','" + pContact + "' , '" + pNic + "','" + pCat + "','" + pDate + "');";

            p = c.prepareStatement(qry);
            p.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    public void update(String pPid,String pFName,String pLName,String pAge,String pGender,String pAddress,String pContact,String pNic,String pCat){
        
        c = DBconnection.getConnection();
        
        try {
            
            String qry= "Update patient set fName='"+ pFName +"',lName='"+pLName+"',age='"+pAge+"',gender='"+pGender+"',address='"+pAddress+"',contact='"+pContact+"',nic='"+ pNic +"',catecory='"+ pCat +"' where pid='"+ pPid +"'";
            
                p = c.prepareStatement(qry);
                p.execute();

                JOptionPane.showMessageDialog(null, "Successfully Updated!");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, " ERROR! Update Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }      
    }
    public void delete(String pPid){
        
        c = DBconnection.getConnection();
        
        try {
            String de = "DELETE FROM patient where pid='" + pPid + "'";
            p = c.prepareStatement(de);
            p.execute();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Delete Fail");
            System.out.println(ex);      
         }    
    }
    /*
     public void tableLoad() {

         try {
            String sql1 = "SELECT p.presCode as 'Prescription Code',p.presName as 'Prescription Name',p.category as 'Category',p.unitType as 'Unit Type',p.discription as 'Discription',pd.date as 'Date' FROM patients p";
            p = c.prepareStatement(sql1);
            rs = p.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    */
}
    
    
    
    


            