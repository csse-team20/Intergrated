/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import Demo_Data.UserDemo;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class AddTest {
    
    public AddTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of addUserDetails method, of class Add.
     */
//    @Test
//    public void testAddUserDetails() {
//        System.out.println("addUserDetails");
//        String firstName = "";
//        String lastName = "";
//        String address = "";
//        JTextField txtNic = null;
//        String email = "";
//        String phone = "";
//        String type = "";
//        JFileChooser jFileChooser1 = null;
//        Add instance = new Add();
//        instance.addUserDetails(firstName, lastName, address, txtNic, email, phone, type, jFileChooser1);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addSalaryDetails method, of class Add.
     */
    @Test
    public void testAddSalaryDetails() throws JSONException, SQLException {
        
        UserDemo ud = new UserDemo();
        
        TestDataUser tu = new TestDataUser();
        
        JSONObject expObj = tu.getUsers();
        
        JSONObject actualObj = ud.addUsers();
        
//        System.out.println("addSalaryDetails");
//        JTextField txtEmpId = null;
//        JTextField txtPayment = null;
//        JTextField txtNoOfDays = null;
//        JLabel lblSalary = null;
//        JTextField txtbonus = null;
//        JDateChooser jdateSalary = null;
//        Add instance = new Add();
//        instance.addSalaryDetails(txtEmpId, txtPayment, txtNoOfDays, lblSalary, txtbonus, jdateSalary);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");

        assertEquals(expObj.getString("tfirstName"), actualObj.getString("tfirstName"));
    }

//    /**
//     * Test of applyLeave method, of class Add.
//     */
//    @Test
//    public void testApplyLeave() {
//        System.out.println("applyLeave");
//        JRadioButton jbtnAnual = null;
//        JTextField txtAnuLeave = null;
//        JRadioButton jbtnCasual = null;
//        JTextField txtCasuLeave = null;
//        JRadioButton jbtnMedical = null;
//        JTextField txtMediLeave = null;
//        JTextField txtEmpID = null;
//        JTextField txtEmpName = null;
//        JDateChooser jdate = null;
//        Add instance = new Add();
//        instance.applyLeave(jbtnAnual, txtAnuLeave, jbtnCasual, txtCasuLeave, jbtnMedical, txtMediLeave, txtEmpID, txtEmpName, jdate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of register method, of class Add.
//     */
//    @Test
//    public void testRegister() {
//        System.out.println("register");
//        JTextField txtNic = null;
//        JTextField txtUserName = null;
//        JTextField txtPassword = null;
//        JTextField txtSecQuestion = null;
//        JTextField txtAnswer = null;
//        Add instance = new Add();
//        instance.register(txtNic, txtUserName, txtPassword, txtSecQuestion, txtAnswer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
