/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.validation;

import com.csse.db.Dbaccess;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class UsersValidation {

    public void UserValidation(java.awt.event.KeyEvent evt, JTextField txtFirstName) {

        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(txtFirstName, "Enter Letters Only");

        }

    }

    public void imageSelect(JLabel lblImg2) {

        if (lblImg2.getText() == "Img") {

            JOptionPane.showMessageDialog(lblImg2, "Select Image");
        }

    }

    public void checkEmptyUser(JTextField txtFirstName, JTextField txtLastName, JTextField txtAddress, JTextField txtNic, JTextField txtEmail, JTextField txtPhone) {

        if (txtFirstName.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "First Name should be entered");

        }
        if (txtLastName.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Last Name should be entered");

        }
        if (txtAddress.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Address should be entered");

        }
        if (txtNic.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Nic should be entered");

        }
        if (txtEmail.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Email should be entered");

        }
        if (txtPhone.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Phone should be entered");

        }

    }

    public boolean isExistingNic(JTextField txtNic) {

        boolean status = false;
        try {
            Dbaccess da = new Dbaccess();
            String nic = txtNic.getText();

            ResultSet rs;

            String query = "SELECT\n"
                    + "	users.NIC,\n"
                    + "	users.FIRST_NAME,\n"
                    + "	users.ID \n"
                    + "FROM\n"
                    + "	users \n"
                    + "WHERE\n"
                    + "	users.NIC = '" + nic + "'";
            rs = da.getData(query);

            while (rs.next()) {

                String exNic = rs.getString("NIC");
                System.out.println(exNic);
                if (nic.equals(exNic)) {

                    status = true;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public void userPermission(String nic, JMenuItem jmAddUsers, JMenuItem jmNewUser, JMenuItem jmEmpDtl,
            JMenuItem jmPatientManage, JMenuItem jmLabTest) {
        try {

            ResultSet rs;
            Dbaccess da = new Dbaccess();
            String query = "SELECT\n"
                    + "	users.TYPE,\n"
                    + "	users.NIC,\n"
                    + "	users.FIRST_NAME,\n"
                    + "	users.ID \n"
                    + "FROM\n"
                    + "	users \n"
                    + "WHERE\n"
                    + "	users.NIC = '" + nic + "'";

            rs = da.getData(query);

            while (rs.next()) {

                String type = rs.getString("TYPE");
                System.out.println(type);

                if (type.equals("Nurse")) {

                    jmNewUser.hide();
                    jmEmpDtl.hide();

                }
                if (type.equals("Doctor")) {

                    jmNewUser.hide();
                    jmEmpDtl.hide();
                    jmPatientManage.hide();

                }
                if (type.equals("Pharmacist")) {

                    jmNewUser.hide();
                    jmEmpDtl.hide();

                }
                if (type.equals("Receptionist")) {

                    jmLabTest.hide();

                }
                if (type.equals("Lab Assistant")) {

                    jmNewUser.hide();
                    jmEmpDtl.hide();

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsersValidation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
