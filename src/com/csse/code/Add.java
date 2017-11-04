/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import com.csse.db.Dbaccess;
import com.csse.validation.RegisterValidation;
import com.csse.validation.UsersValidation;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class Add {

    public void addUserDetails(String firstName, String lastName, String address, JTextField txtNic, String email, String phone, String type, JFileChooser jFileChooser1) {

        UsersValidation userval = new UsersValidation();

        userval.isExistingNic(txtNic);

        String nic = txtNic.getText();

        if (userval.isExistingNic(txtNic)) {

            JOptionPane.showMessageDialog(jFileChooser1, "NIC is Existing");

        } else {
            File picFile = jFileChooser1.getSelectedFile();
            //String path = picFile.getAbsolutePath();
            //path = path.replace("\\", "/");

            if (picFile != null) {
                String path = picFile.getAbsolutePath();
                path = path.replace("\\", "/");

                String query = "INSERT INTO `channeling_center`.`users` (\n"
                        + "	`FIRST_NAME`,\n"
                        + "	`LAST_NAME`,\n"
                        + "	`ADDRESS`,\n"
                        + "	`NIC`,\n"
                        + "	`EMAIL`,\n"
                        + "	`PHONE`,\n"
                        + "	`TYPE`,\n"
                        + "	`IMAGE`\n"
                        + ")\n"
                        + "VALUES\n"
                        + "	(\n"
                        + " '" + firstName + "',\n"
                        + " '" + lastName + "',\n"
                        + "	'" + address + "',\n"
                        + "	'" + nic + "',\n"
                        + "	'" + email + "',\n"
                        + "	'" + phone + "',\n"
                        + "	'" + type + "',\n"
                        + "	'" + path + "'\n"
                        + "	);";
                Dbaccess da = new Dbaccess();

                da.insertData(query);

                JOptionPane.showMessageDialog(jFileChooser1, "Data Saved Successfuly");
                //  JOptionPane.showMessageDialog(jFileChooser1,"Data Saved to users table");
            }
        }
    }

    public void addSalaryDetails(JTextField txtEmpId, JTextField txtPayment, JTextField txtNoOfDays, JLabel lblSalary, JTextField txtbonus, JDateChooser jdateSalary) {

        String empId = txtEmpId.getText();
        String paymentFee = txtPayment.getText();
        String noOfDays = txtNoOfDays.getText();
        String salary = lblSalary.getText();
        String bonus = txtbonus.getText();

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String year = date.format(jdateSalary.getDate());

        String query = "INSERT INTO `channeling_center`.`salary` ( `EMP_ID`, `PAYMENT_FEE`, `BONUS`, `NOOF_DAYS`, `SALARY`, `DATE` )\n"
                + "VALUES\n"
                + "	('" + empId + "', '" + paymentFee + "','" + noOfDays + "', '" + salary + "', '" + bonus + "', '" + year + "' );";
        Dbaccess da = new Dbaccess();
        da.insertData(query);
        JOptionPane.showMessageDialog(txtPayment, "Data Saved Succesfuly");

    }

    public void applyLeave(JRadioButton jbtnAnual, JTextField txtAnuLeave, JRadioButton jbtnCasual,
            JTextField txtCasuLeave, JRadioButton jbtnMedical, JTextField txtMediLeave,
            JTextField txtEmpID, JTextField txtEmpName, JDateChooser jdate) {

        String s = jbtnAnual.getText();
        System.out.println(s);

        if (jbtnAnual.isSelected()) {

            int anual = Integer.parseInt(txtAnuLeave.getText());
            if (anual > 1) {
                anual = anual - 1;
                txtAnuLeave.setText(Integer.toString(anual));
            } else {
                jbtnAnual.setEnabled(false);
            }
        }
        if (jbtnCasual.isSelected()) {

            int casual = Integer.parseInt(txtCasuLeave.getText());
            casual = casual - 1;
            txtCasuLeave.setText(Integer.toString(casual));

        } else if (jbtnMedical.isSelected()) {

            int medical = Integer.parseInt(txtMediLeave.getText());
            medical = medical - 1;
            txtMediLeave.setText(Integer.toString(medical));
            System.out.println("mvd");

        }

        String anualLeave = txtAnuLeave.getText();
        String casualLeave = txtCasuLeave.getText();
        String mediLeave = txtMediLeave.getText();
        String empId = txtEmpID.getText();
        String empName = txtEmpName.getText();

        String query = "UPDATE `channeling_center`.`leave`\n"
                + "SET `EMP_ID` = '" + empId + "',\n"
                + " `EMP_NAME` = '" + empName + "',\n"
                + " `CASUAL_LEAVE` = '" + casualLeave + "',\n"
                + " `ANUAL_LEAVE` = '" + anualLeave + "',\n"
                + " `MEDICAL_LEAVE` = '" + mediLeave + "'\n"
                + "WHERE\n"
                + "	(`EMP_ID` = '" + empId + "');";

        Dbaccess da = new Dbaccess();
        da.insertData(query);

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        String year = date.format(jdate.getDate());

        String queryAttendance = "UPDATE `channeling_center`.`attendance`\n"
                + "SET \n"
                + " `STATUS` = 'Leave'\n"
                + "WHERE\n"
                + "	(`EMP_ID` = '" + empId + "') AND (`DATE` = '" + year + "');";

        da.insertData(queryAttendance);
        JOptionPane.showMessageDialog(txtEmpName, "Data Saved Successfuly");
    }

    public void register(JTextField txtNic, JTextField txtUserName, JTextField txtPassword, JTextField txtSecQuestion, JTextField txtAnswer) {

        String nic = txtNic.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        // String confPassword = txtCpassword.getText();
        String secQuestion = txtSecQuestion.getText();
        String answer = txtAnswer.getText();
        RegisterValidation reg = new RegisterValidation();
        reg.isRegExistingNic(txtNic);

        if (reg.isRegExistingNic(txtNic)) {
            JOptionPane.showMessageDialog(txtAnswer, "Nic Existing");

        } else {
            String query = "INSERT INTO `channeling_center`.`login` (\n"
                    + "	`NIC`,\n"
                    + "	`USER_NAME`,\n"
                    + "	`PASSWORD`,\n"
                    + "	`SEC_QUESTION`,\n"
                    + "	`ANSWER`\n"
                    + ")\n"
                    + "VALUES\n"
                    + "	(\n"
                    + "		'" + nic + "',\n"
                    + "		'" + userName + "',\n"
                    + "		'" + password + "',\n"
                    + "		'" + secQuestion + "',\n"
                    + "		'" + answer + "'\n"
                    + "	);";

            Dbaccess da = new Dbaccess();

            da.insertData(query);

            JOptionPane.showMessageDialog(txtAnswer, "Data Saved Succesfuly");
        }
    }
}
