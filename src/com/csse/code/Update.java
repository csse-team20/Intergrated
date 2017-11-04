/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import com.csse.db.Dbaccess;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class Update {

    public void updateUserDetails(String id, String firstName, String lastName, String address, String nic, String email, String phone, String type, JFileChooser jFileChooser1, JLabel lblImg2) {

        String path;

        File picFile = jFileChooser1.getSelectedFile();
        if (picFile != null) {
            path = picFile.getAbsolutePath();
            path = path.replace("\\", "/");
            lblImg2.setText(path);
        }

        path = lblImg2.getText();

        System.out.println(path);
        Dbaccess da = new Dbaccess();

        String query = "UPDATE `channeling_center`.`users`\n"
                + "SET `ID` = '" + id + "',\n"
                + " `FIRST_NAME` = '" + firstName + "',\n"
                + " `LAST_NAME` = '" + lastName + "',\n"
                + " `ADDRESS` = '" + address + "',\n"
                + " `NIC` = '" + nic + "',\n"
                + " `EMAIL` = '" + email + "',\n"
                + " `PHONE` = '" + phone + "',\n"
                + " `TYPE` = '" + type + "',\n"
                + " `IMAGE` = '" + path + "'\n"
                + "WHERE\n"
                + "	(`ID` = '" + id + "')\n"
                + "AND (`NIC` = '" + nic + "');";

        da.insertData(query);

        JOptionPane.showMessageDialog(jFileChooser1, "Data Updated Succesfuly");

    }

}
