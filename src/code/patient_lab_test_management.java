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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Orange
 */
public class patient_lab_test_management {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    
    public void addPatientLabTest(String tlabid, String tname,  String ttestCode,Date dueDate, String tststus, String tpriority) {

        c = DBconnection.getConnection();

        try {
            String patient = "INSERT INTO lab_patient (labid, patient_name) "
                    + "VALUES ('" + tlabid + "', '" + tname + "')";
            p = c.prepareStatement(patient);
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println("after patient");
        try {
            String patientlab = "INSERT INTO lab_patient_test (testCode, labid, status, priority, duedate) "
                    + "VALUES ('" + ttestCode + "', '" + tlabid + "', '" + tststus + "', '" + tpriority + "', '" + dueDate + "')";
            p = c.prepareStatement(patientlab);
            p.execute();
            System.out.println("after patient lab");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void updatePatientLab(String labid, String testCode, String status, String priority, Date dudeDate) {

        c = DBconnection.getConnection();

        try {

            String up = "UPDATE lab_patient_test "
                    + "SET testCode = '" + testCode + "',labid = '" + labid + "',status = '" + status + "',priority = '" + priority + "',duedate ='" + dudeDate + "' "
                    + "WHERE testCode = '" + testCode + "' and labid = '" + labid + "'";
            p = c.prepareStatement(up);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "test update fail ");
        }

    }

    public void updatePatient(String labid, String name) {

        c = DBconnection.getConnection();

        try {

            String up = "UPDATE lab_patient SET patient_name = '" + name + "' WHERE labid = '" + labid + "' ";

            p = c.prepareStatement(up);
            p.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "name update fail ");
        }
    }
    
    public void deletePatientTest(String labid, String ttestCode) {
        c = DBconnection.getConnection();

        try {
            String de = "DELETE FROM lab_patient_test where testCode='" + ttestCode + "' and labid = '" + labid + "'";
            p = c.prepareStatement(de);
            p.execute();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Delete Fail");
            System.out.println(ex);

        }
    }
}
