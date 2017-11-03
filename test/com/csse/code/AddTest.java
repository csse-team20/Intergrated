/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import Demo_Data.UserDemo;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.json.JSONException;
import org.json.JSONObject;
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
    @Test
    public void testAddUserDetails() throws JSONException, SQLException {

        
        
        UserDemo ud = new UserDemo();
        
        TestDataUser tu = new TestDataUser();
        
        JSONObject expObj = tu.getUsers();
        
        JSONObject actualObj = ud.addUsers();
        
        assertEquals(expObj.getString("tfirstName"), actualObj.getString("tfirstName"));
    }

    /**
     * Test of addSalaryDetails method, of class Add.
     */
    @Test
    public void testAddSalaryDetails() throws JSONException, SQLException {
        
        
        
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

        
    }

    /**
     * Test of applyLeave method, of class Add.
     */
    @Test
    public void testApplyLeave() {
        System.out.println("applyLeave");
        JRadioButton jbtnAnual = null;
        JTextField txtAnuLeave = null;
        JRadioButton jbtnCasual = null;
        JTextField txtCasuLeave = null;
        JRadioButton jbtnMedical = null;
        JTextField txtMediLeave = null;
        JTextField txtEmpID = null;
        JTextField txtEmpName = null;
        JDateChooser jdate = null;
        Add instance = new Add();
        instance.applyLeave(jbtnAnual, txtAnuLeave, jbtnCasual, txtCasuLeave, jbtnMedical, txtMediLeave, txtEmpID, txtEmpName, jdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class Add.
     */
    @Test
    public void testRegister() {
        try {
            System.out.println("register");
//        JTextField txtNic = null;
//        JTextField txtUserName = null;
//        JTextField txtPassword = null;
//        JTextField txtSecQuestion = null;
//        JTextField txtAnswer = null;
//        Add instance = new Add();
//        instance.register(txtNic, txtUserName, txtPassword, txtSecQuestion, txtAnswer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");


        UserDemo ud = new UserDemo();

        TestDataUser tu = new TestDataUser();

        JSONObject expObj = tu.getRegisteredUsers();

        JSONObject actualObj = ud.regiterUsers();

        assertEquals(expObj.getString("tnic"), actualObj.getString("tnic"));
        assertEquals(expObj.getString("tuserName"), actualObj.getString("tuserName"));
        assertEquals(expObj.getString("tPassword"), actualObj.getString("tPassword"));
        assertEquals(expObj.getString("tsecQuestion"), actualObj.getString("tsecQuestion"));
        
        
        
        } catch (JSONException | SQLException ex) {
            Logger.getLogger(AddTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
