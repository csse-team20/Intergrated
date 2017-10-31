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
public class History_Data {

    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;

    public void save(String pPid, String pHisID, String pHeight, String pWeight, String pState, String pPain, String pIllness, String pAllergy, String pNote, String pBlood) {

        c = DBconnection.getConnection();

        try {
            String query = " INSERT INTO `channeling_center`.`patient_history` (\n"
                    + "	`phid`,\n"
                    + "	`ppid`,\n"
                    + "	`height`,\n"
                    + "	`weight`,\n"
                    + "	`state`,\n"
                    + "	`pain`,\n"
                    + "	`blood`,\n"
                    + "	`illness`,\n"
                    + "	`allergy`,\n"
                    + " `note`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + pHisID + "','" + pPid + "','" + pHeight + "','" + pWeight + "','" + pState + "','" + pPain + "','" + pBlood + "' , '" + pIllness + "','" + pAllergy + "','" + pNote + "');";

            p = c.prepareStatement(query);
            p.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(String pPid, String pHisID, String pHeight, String pWeight, String pState, String pPain, String pIllness, String pAllergy, String pNote, String pBlood) {

        c = DBconnection.getConnection();

        try {
            String qry = "UPDATE `channeling_center`.`patient_history`\n"
                    + "SET `phid` = '"+pHisID+"',\n"
                    + " `ppid` = '"+pPid+"',\n"
                    + " `height` = '"+pHeight+"',\n"
                    + " `weight` = '"+pWeight+"',\n"
                    + " `state` = '"+pState+"',\n"
                    + " `pain` = '"+pPain+"',\n"
                    + " `blood` = '"+pBlood+"',\n"
                    + " `illness` = '"+pIllness+"',\n"
                    + " `allergy` = '"+pAllergy+"',\n"
                    + " `note` = '"+pNote+"'\n"
                    + "WHERE\n"
                    + "	(`phid` = '"+pHisID+"');\n"
                    + "";
            //String qry= "Update patient_history set ppid='"+ pPid +"',height='"+pHeight+"',weight='"+pWeight+"',state='"+pState+"',pain='"+pPain+"',blood='"+pBlood+"',illness='"+ pIllness +"', allergy = '"+ pAllergy +"',note='"+ pNote +"' where phid='"+ pHisID +"'";     
            p = c.prepareStatement(qry);
            p.execute();

            JOptionPane.showMessageDialog(null, "Successfully Updated!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " ERROR! Update Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(String pHisID) {

        c = DBconnection.getConnection();

        try {
            String de = "DELETE FROM patient_history where phid='" + pHisID + "'";
            p = c.prepareStatement(de);
            p.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " ERROR! Delete Failed!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}
