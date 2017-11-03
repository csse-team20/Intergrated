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
public class lab_test_management {

    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;

    public void addLabTest(String ttestCode, String ttestsName, String ttestType, String tdiscrption) {

        c = DBconnection.getConnection();

        try {

            String test = "INSERT INTO lab(testCode,testName,testType,discription,statua) values('" + ttestCode + "','" + ttestsName + "','" + ttestType + "','" + tdiscrption + "','NT')";
            p = c.prepareStatement(test);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void addLabTestChemecal(String ttestCode, String chemical[]) {
        
        c = DBconnection.getConnection();
        
        try {
            for (int j = 0; j < chemical.length; j++) {
                String chem = "INSERT INTO labchem(testCode,chemCode) values('" + ttestCode + "',(select chemCode from chemical where chemName='" + chemical[j] + "'))";
                p = c.prepareStatement(chem);
                p.execute();
            }
        } catch (SQLException ex) {
            //System.out.println(ex);
        }
    }

    public void updateLab(String ttestCode, String ttestsName, String ttestType, String tdiscrption, String chemicals[]) {

        c = DBconnection.getConnection();

        try {

            String up = "UPDATE lab SET testName='" + ttestsName + "',testType='" + ttestType + "',discription='" + tdiscrption + "' WHERE testCode='" + ttestCode + "'";
            p = c.prepareStatement(up);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "update fail ");
        }
       
    }

    public void updateLabChemicals(String ttestCode, String chemicals[]) throws SQLException {

        int chemCount = 0;
        String equalCode = "";
        c = DBconnection.getConnection();

//        String sql = "SELECT chemName,lc.chemCode FROM labchem lc,chemical c"
//                + " WHERE lc.testCode='" + ttestCode + "' and lc.chemCode = c.chemCode";
//        p = c.prepareStatement(sql);
//        rs = p.executeQuery();
//        System.out.println("did");
//        String code = "";
//        while (rs.next()) {
//
//            String chem = rs.getString("chemName");
//            code = rs.getString("chemCode");
//            System.out.println(chem + "/" + code);
//            chemCount++;
//            for (int i = 0; i < chemicals.length; i++) {
//
//                if (chem.equals(chemicals[i])) {
//                    chemCount++;
//                }
//                else{
//                    
//                }
//            }
//        }
//        if (chemCount < chemicals.length) {
//            try {
//                String del = "DELETE FROM labchem where chemCode='" + code + "' and testCode = '" + ttestCode + "'";
//                p = c.prepareStatement(del);
//                p.execute();
//
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Delete Fail");
//                System.out.println(ex);
//
//            }
//        }
        try {
            String del = "DELETE FROM labchem where testCode='" + ttestCode + "'";
            p = c.prepareStatement(del);
            p.execute();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "update/Delete Fail");
            System.out.println(ex);

        }
        
        addLabTestChemecal(ttestCode, chemicals);

    }

    public void deleteLab(String tlabCode) {
        c = DBconnection.getConnection();

        try {

            String up = "UPDATE lab SET statua='TE' WHERE testCode='" + tlabCode + "'";
            p = c.prepareStatement(up);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "delete fail ");
        }
    }
}
