/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.validation;

import com.csse.code.Load;
import com.csse.db.Dbaccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class SalaryValidation {

    public void isExisting(JTextField txtEmpId, JTextField txtEmpName) {

        try {
            Dbaccess da = new Dbaccess();
            String empId = txtEmpId.getText();
            String id = null;
            ResultSet rs;

            String query = "SELECT\n"
                    + "	users.ID,\n"
                    + "	users.FIRST_NAME \n"
                    + "FROM\n"
                    + "	users \n"
                    + "WHERE\n"
                    + "	users.ID = '" + empId + "'";
            rs = da.getData(query);

            while (rs.next()) {

                id = rs.getString("ID");
                System.out.println(id);
                if (id.equals(empId)) {
                    txtEmpName.setText(rs.getString("FIRST_NAME"));

                }

            }
            if (id == null) {

                JOptionPane.showMessageDialog(txtEmpName, "User not In the Data Base");
                System.out.println("Not equals");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
