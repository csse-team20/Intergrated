/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import com.csse.db.Dbaccess;
import com.csse.ui.EmpLeaves;
import com.csse.ui.Login;
import com.csse.ui.MainMenu;
import com.csse.validation.LoginValidation;
import com.toedter.calendar.JDateChooser;
import static groovy.ui.text.FindReplaceUtility.dispose;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class Load {

    public void getSecQuestion(String nic, JTextField txtQuestion) {

        
        try {
            ResultSet rs;
            String query = "SELECT\n"
                    + "	login.SEC_QUESTION,\n"
                    + "	login.ANSWER,\n"
                    + "	login.`PASSWORD`\n"
                    + "FROM\n"
                    + "	login\n"
                    + "WHERE\n"
                    + "	login.NIC = '" + nic + "' ";
            Dbaccess da = new Dbaccess();
            rs = da.getData(query);

            while (rs.next()) {

                txtQuestion.setText(rs.getString("SEC_QUESTION"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }

    public void getPassword(String secQuestion, String answer, String nic, JButton jbtnSubmit) {

        try {
            String query = "SELECT * FROM login WHERE NIC = '" + nic + "'";
            
            Dbaccess da = new Dbaccess();
            
            
            ResultSet rs;

            rs = da.getData(query);

            while (rs.next()) {

                if (secQuestion.equals(rs.getString("SEC_QUESTION")) && answer.equals(rs.getString("ANSWER"))) {
                    String password = rs.getString("PASSWORD");
                    JOptionPane.showMessageDialog(jbtnSubmit, "Your Password is : " + password);

                } else {
                    JOptionPane.showMessageDialog(jbtnSubmit, "Data Inserted Wrong");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }

    public void tableLoadUserDetails(JTable jTable4) {

        String q = "SELECT ID,FIRST_NAME,NIC FROM users";

        
        Dbaccess da = new Dbaccess();

        jTable4.setModel(DbUtils.resultSetToTableModel(da.getData(q)));

        
    }

    public void selectImage(JFileChooser jFileChooser1, JLabel lblImg2) {

        
        try {
            jFileChooser1.showOpenDialog(null);
            File file = jFileChooser1.getSelectedFile();
            String path = file.getAbsolutePath();
            path = path.replace("\\", "/");
            File file1 = new File(path);

            Image im = ImageIO.read(file1);
            im = im.getScaledInstance(lblImg2.getWidth(), lblImg2.getHeight(), Image.SCALE_SMOOTH);
            lblImg2.setIcon(new ImageIcon(im));
            lblImg2.setText(path);//newly added 
        } catch (IOException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public void tableClickUserDetails(JTable jTable4, JLabel lblId, JTextField txtFirstName, JTextField txtNic, JTextField txtLastName,
            JTextField txtAddress, JTextField txtEmail, JTextField txtPhone, JComboBox cmbType, JLabel lblImg2) {

        try {
            ResultSet rs;
            int row = jTable4.getSelectedRow();
            
            String id = jTable4.getValueAt(row, 0).toString();
            String firstName = jTable4.getValueAt(row, 1).toString();
            String nic = jTable4.getValueAt(row, 2).toString();
            
            lblId.setText(id);
            txtFirstName.setText(firstName);
            
            txtNic.setText(nic);
            
            
            
            Dbaccess da = new Dbaccess();
            String query = "SELECT * FROM users WHERE ID ='" + id + "';";
            rs = da.getData(query);

            while (rs.next()) {

                txtLastName.setText(rs.getString("LAST_NAME"));
                txtAddress.setText(rs.getString("ADDRESS"));
                txtEmail.setText(rs.getString("Email"));
                txtPhone.setText(rs.getString("PHONE"));
                cmbType.setSelectedItem(rs.getString("TYPE"));

                lblImg2.setText(rs.getString("IMAGE"));
                File f1 = new File(rs.getString("IMAGE"));
                Image im = ImageIO.read(f1);
                im = im.getScaledInstance(lblImg2.getWidth(), lblImg2.getHeight(), Image.SCALE_AREA_AVERAGING);
                lblImg2.setIcon(new ImageIcon(im));
                lblImg2.setText(rs.getString("IMAGE"));
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }

    public void findNoOfDays(JTextField txtEmpId, JDateChooser jdateSalary, JTextField txtNoOfDays) {

        try {
            Dbaccess da = new Dbaccess();
            String empId = txtEmpId.getText();
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            String year = date.format(jdateSalary.getDate());
            
            
            ResultSet rs;

            String query = "SELECT\n"
                    + "	attendance.EMP_ID,\n"
                    + "	attendance.TOTAL\n"
                    + "FROM\n"
                    + "	attendance\n"
                    + "WHERE\n"
                    + "	attendance.EMP_ID = '" + empId + "'\n"
                    + "AND attendance.DATE = '" + year + "'";

            rs = da.getData(query);
            while (rs.next()) {

                txtNoOfDays.setText(rs.getString("TOTAL"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }

       

    }

    public void getUser(JTextField txtNic, JTextField txtUserName, JTable jtableReg) {
        Dbaccess da = new Dbaccess();
        String nic = txtNic.getText();

        try {
            ResultSet rs;

            String query = "SELECT\n"
                    + "	users.ID,\n"
                    + "	users.FIRST_NAME\n"
                    + "FROM\n"
                    + "	users\n"
                    + "WHERE\n"
                    + "	users.NIC = '" + nic + "'";

            rs = da.getData(query);
            // JOptionPane.showMessageDialog(txtUserName, "Saved");

            while (rs.next()) {
                txtUserName.setText(rs.getString("FIRST_NAME"));

            }
            jtableReg.setModel(DbUtils.resultSetToTableModel(da.getData(query)));
        } 
        catch (SQLException ex) {
            Logger.getLogger(EmpLeaves.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void login(JTextField txtUserName, JPasswordField jpassword) {

        try {
            LoginValidation loginVal = new LoginValidation();
            loginVal.checkEmpty(txtUserName, jpassword);

            String userName = txtUserName.getText();
            String password = String.valueOf(jpassword.getPassword());

            String query = "SELECT\n"
                    + "	login.`PASSWORD`,\n"
                    + "	login.USER_NAME,\n"
                    + "	login.NIC \n"
                    + "FROM\n"
                    + "	login \n"
                    + "WHERE\n"
                    + "	login.USER_NAME = '" + userName + "' \n"
                    + "	AND login.`PASSWORD` = '" + password + "'";
            Dbaccess da = new Dbaccess();

            ResultSet rs;
            String name = null;
            String pass = null;
            rs = da.getData(query);

            while (rs.next()) {
                name = rs.getString("USER_NAME");
                pass = rs.getString("PASSWORD");

                if (userName.equals(name) && password.equals(pass)) {

                    JOptionPane.showMessageDialog(jpassword, "Login Success");
                    dispose();
                    MainMenu menu = new MainMenu();
                    menu.setVisible(true);

                }

            }
            if (!userName.equals(name) || !password.equals(pass)) {
                JOptionPane.showMessageDialog(jpassword, "Login Failed");

            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadEmpDetails(JTextField txtEmpID, JTextField txtEmpName, JTextField txtAnuLeave, JTextField txtCasuLeave, JTextField txtMediLeave) {

        try {
            Dbaccess da = new Dbaccess();
            String empId = txtEmpID.getText();

            ResultSet rs;

            String query = "SELECT\n"
                    + "	`leave`.EMP_ID,\n"
                    + "	`leave`.EMP_NAME,\n"
                    + "	`leave`.CASUAL_LEAVE,\n"
                    + "	`leave`.ANUAL_LEAVE,\n"
                    + "	`leave`.MEDICAL_LEAVE\n"
                    + "FROM\n"
                    + "	`leave`\n"
                    + "WHERE\n"
                    + "`leave`.EMP_ID = '" + empId + "'";

            rs = da.getData(query);

            while (rs.next()) {
                txtEmpName.setText(rs.getString("EMP_NAME"));
                txtAnuLeave.setText(rs.getString("ANUAL_LEAVE"));
                txtCasuLeave.setText(rs.getString("CASUAL_LEAVE"));
                txtMediLeave.setText(rs.getString("MEDICAL_LEAVE"));
            }
        
        }catch (SQLException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   
    
}
