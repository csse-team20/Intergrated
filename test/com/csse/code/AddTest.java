/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import Demo_Data.UserDemo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * Test of addUserDetails method, of class Add.
     */
    @Test
    public void testAddUserDetails() {

        try {
            UserDemo ud = new UserDemo();

            TestDataUser tu = new TestDataUser();

            JSONObject expObj = tu.getUsers();

            JSONObject actualObj = ud.addUsers();

            assertEquals(expObj.getString("tfirstName"), actualObj.getString("tfirstName"));
        } catch (JSONException | SQLException ex) {
            Logger.getLogger(AddTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of addSalaryDetails method, of class Add.
     */
    @Test
    public void testAddSalaryDetails() {

        try {
            System.out.println("salaryDetails");

            UserDemo ud = new UserDemo();

            TestDataUser tu = new TestDataUser();

            JSONObject expObj = tu.getSalaryDetails();

            JSONObject actualObj = ud.addEmpLeaves();

            assertEquals(expObj.getString("tempId"), actualObj.getString("tempId"));
        } catch (JSONException | SQLException ex) {
            Logger.getLogger(AddTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of applyLeave method, of class Add.
     */
    @Test
    public void testApplyLeave() {
        try {
            System.out.println("applyLeave");

            UserDemo ud = new UserDemo();

            TestDataUser tu = new TestDataUser();

            JSONObject expObj = tu.getEmpLeaves();

            JSONObject actualObj = ud.addEmpLeaves();

            assertEquals(expObj.getString("tempId"), actualObj.getString("tempId"));

        } catch (JSONException | SQLException ex) {
            Logger.getLogger(AddTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of register method, of class Add.
     */
    @Test
    public void testRegister() {
        try {
            System.out.println("register");
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
