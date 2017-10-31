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
public class chemical_management {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    
    public void addChemical(String tchemCode, String tchemName, String ttype, String tqty, String supId) {
        
        c = DBconnection.getConnection();

        try {
            String chem = "INSERT INTO `channeling_center`.`chemical` (\n"
                    + "	`chemCode`,\n"
                    + "	`chemName`,\n"
                    + "	`type`,\n"
                    + "	`qty`,\n"
                    + "	`supId`,\n"
                    + "     `statua`\n"
                    + ")\n"
                    + "VALUES\n"
                    + "	(\n"
                    + "'" + tchemCode + "',\n"
                    + "'" + tchemName + "',\n"
                    + "'" + ttype + "',\n"
                    + "'" + tqty + "',\n"
                    + "'" + supId + "',\n"
                    + "'NT'\n"
                    + "	);";

            p = c.prepareStatement(chem);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updateChemical(String tchemCode, String tchemName, String ttype, String tqty, String supId){
        
        c = DBconnection.getConnection();
        
        try {

            String up = "UPDATE chemical "
                    + "SET chemName = '" + tchemName + "',"
                    + "type = '" + ttype + "',"
                    + "qty = '" + tqty + "',"
                    + "supId = '" + supId + "'"
                    + "WHERE chemCode = '" + tchemCode + "'";
            p = c.prepareStatement(up);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "test update fail ");
        }
    }
    
    public void deleteChemical(String chemCode) {

        c = DBconnection.getConnection();

        try {

            String up = "UPDATE chemical SET status='TE' WHERE chemCode='" + chemCode + "'";
            p = c.prepareStatement(up);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "delete fail ");
        }

    }
}
