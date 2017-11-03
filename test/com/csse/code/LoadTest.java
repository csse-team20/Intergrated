/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class LoadTest {
    
//    public LoadTest() {
//    }
//    
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
     * Test of getSecQuestion method, of class Load.
     */
    @Test
    public void testGetSecQuestion() {
        System.out.println("getSecQuestion");
        String nic = "950102144v";
        JTextField txtQuestion = null ;
       
        
        Load instance = new Load();
        instance.getSecQuestion(nic, txtQuestion);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Load.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String secQuestion = "nurse";
        String answer = "123";
        String nic = "950102144v";
        JButton jbtnSubmit = null;
        Load instance = new Load();
        instance.getPassword(secQuestion, answer, nic, jbtnSubmit);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of tableLoadUserDetails method, of class Load.
     */
    @Test
    public void testTableLoadUserDetails() {
        System.out.println("tableLoadUserDetails");
        JTable jTable4 = null;
        Load instance = new Load();
        instance.tableLoadUserDetails(jTable4);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of selectImage method, of class Load.
     */
    @Test
    public void testSelectImage() {
        System.out.println("selectImage");
        JFileChooser jFileChooser1 = null;
        JLabel lblImg2 = null;
        Load instance = new Load();
        instance.selectImage(jFileChooser1, lblImg2);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of tableClickUserDetails method, of class Load.
     */
    @Test
    public void testTableClickUserDetails() {
        System.out.println("tableClickUserDetails");
        JTable jTable4 = null;
        JLabel lblId = null;
        JTextField txtFirstName = null;
        JTextField txtNic = null;
        JTextField txtLastName = null;
        JTextField txtAddress = null;
        JTextField txtEmail = null;
        JTextField txtPhone = null;
        JComboBox cmbType = null;
        JLabel lblImg2 = null;
        Load instance = new Load();
        instance.tableClickUserDetails(jTable4, lblId, txtFirstName, txtNic, txtLastName, txtAddress, txtEmail, txtPhone, cmbType, lblImg2);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of findNoOfDays method, of class Load.
     */
    @Test
    public void testFindNoOfDays() {
        System.out.println("findNoOfDays");
        JTextField txtEmpId = null;
        JDateChooser jdateSalary = null;
        JTextField txtNoOfDays = null;
        Load instance = new Load();
        instance.findNoOfDays(txtEmpId, jdateSalary, txtNoOfDays);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Load.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        JTextField txtNic = null;
        JTextField txtUserName = null;
        JTable jtableReg = null;
        Load instance = new Load();
        instance.getUser(txtNic, txtUserName, jtableReg);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class Load.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        JTextField txtUserName = null;
        JPasswordField jpassword = null;
        txtUserName.setText("Anuradha");
        jpassword.setText("123456");
        Load instance = new Load();
        
  //      assertEquals("Result",23,instance.login(txtUserName,jpassword));
//        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadEmpDetails method, of class Load.
     */
    @Test
    public void testLoadEmpDetails() {
        System.out.println("loadEmpDetails");
        JTextField txtEmpID = null;
        JTextField txtEmpName = null;
        JTextField txtAnuLeave = null;
        JTextField txtCasuLeave = null;
        JTextField txtMediLeave = null;
        txtEmpID.setText("1");
        txtEmpID.setText("Anuradha");
        
        Load instance = new Load();
        instance.loadEmpDetails(txtEmpID, txtEmpName, txtAnuLeave, txtCasuLeave, txtMediLeave);
       //
       // assertEquals(instance.loadEmpDetails(txtEmpID, txtEmpName, txtAnuLeave, txtCasuLeave, txtMediLeave),1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
