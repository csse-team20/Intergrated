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
import javax.swing.JOptionPane;

/**
 *
 * @author Orange
 */
public class drug_management {
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    
    public void addDrugs(String tpresCode, String tpresName, String tcatagory, String tunitType, String tdiscrption, String tsupId, double tprice) {

        
        c = DBconnection.getConnection();

        try {
            String pro = " INSERT INTO `channeling_center`.`drug` (\n"
                    + "	`presCode`,\n"
                    + "	`presName`,\n"
                    + "	`category`,\n"
                    + "	`unitType`,\n"
                    + "	`discription`,\n"
                    + "	`supId`,\n"
                    + "`price`,\n"
                    + "`current_qty`,\n"
                    + "`status`\n"
                    + "       )\n"
                    + "       VALUES\n"
                    + "	('" + tpresCode + "','" + tpresName + "','" + tcatagory + "','" + tunitType + "','" + tdiscrption + "','" + tsupId + "','" + tprice + "',0,'NT');";

            p = c.prepareStatement(pro);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateDrug(String tpresCode, String tpresName, String tunitType, String tcatagory, String tdiscrption, String tsupId) {

        c = DBconnection.getConnection();

        try {

            String up = "UPDATE drug SET presName='" + tpresName + "',unitType='" + tunitType + "',category='" + tcatagory + "',discription='" + tdiscrption + "',supId = '" + tsupId + "' "
                    + "WHERE presCode='" + tpresCode + "'";
            p = c.prepareStatement(up);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "update fail ");
        }
    }
    
    public void deleteDrug(String tpresCode) {

        c = DBconnection.getConnection();

        try {

            String d = "UPDATE drug SET status='TE' WHERE presCode='" + tpresCode + "'";
            p = c.prepareStatement(d);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "delete fail ");
        }

    }
}
