/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import com.csse.db.Dbaccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class TestDataUser {

    public JSONObject getUsers() throws JSONException, SQLException {

        JSONObject jsonObject = new JSONObject();

        Dbaccess da = new Dbaccess();
        ResultSet rs;
        String tId = null;
        String tFirstName = null;
        String tnic = null;
        String temail = null;
        String query = "SELECT\n"
                + "	users.ID,\n"
                + "	users.FIRST_NAME,\n"
                + "	users.LAST_NAME,\n"
                + "	users.ADDRESS,\n"
                + "	users.NIC,\n"
                + "	users.EMAIL,\n"
                + "	users.PHONE,\n"
                + "	users.TYPE,\n"
                + "	users.IMAGE \n"
                + "FROM\n"
                + "	users \n"
                + "ORDER BY\n"
                + "	users.FIRST_NAME ASC";
        rs = da.getData(query);

        while (rs.next()) {

            tId = rs.getString("ID");
            tFirstName = rs.getString("FIRST_NAME");
            tnic = rs.getString("NIC");
            temail = rs.getString("Email");

        }

        jsonObject.put("tfirstName", tFirstName);
        jsonObject.put("tnic", tnic);
        //     System.out.println("data "+jsonObject.toString());
        System.out.println("data " + jsonObject.toString());
        return jsonObject;

    }

    public JSONObject getRegisteredUsers() throws JSONException, SQLException {

        JSONObject jsonObject = new JSONObject();

        Dbaccess da = new Dbaccess();
        ResultSet rs;
        String tnic = null;
        String tuserName = null;
        String tPassword = null;
        String tsecQuestion = null;
        String tanswer = null;
        String query = "SELECT\n"
                + "	login.ID,\n"
                + "	login.NIC,\n"
                + "	login.USER_NAME,\n"
                + "	login.`PASSWORD`,\n"
                + "	login.SEC_QUESTION,\n"
                + "	login.ANSWER \n"
                + "FROM\n"
                + "	login \n"
                + "WHERE\n"
                + "	login.NIC = '950102144v'";
        rs = da.getData(query);

        while (rs.next()) {

            tnic = rs.getString("NIC");

            tuserName = rs.getString("USER_NAME");
            tPassword = rs.getString("PASSWORD");
            tsecQuestion = rs.getString("SEC_QUESTION");
            tanswer = rs.getString("ANSWER");

        }
        jsonObject.put("tnic", tnic);
        jsonObject.put("tuserName", tuserName);
        jsonObject.put("tPassword", tPassword);
        jsonObject.put("tsecQuestion", tsecQuestion);
        jsonObject.put("tanswer", tanswer);

        System.out.println("data " + jsonObject.toString());
        return jsonObject;

    }

    public JSONObject getEmpLeaves() throws JSONException, SQLException {

        JSONObject jsonObject = new JSONObject();

        Dbaccess da = new Dbaccess();
        ResultSet rs;
        String tempId = null;
        String tempName = null;
        String tcasual = null;
        String tanual = null;
        String tmedical = null;
        String query = "SELECT\n"
                + "	`leave`.EMP_ID,\n"
                + "	`leave`.EMP_NAME,\n"
                + "	`leave`.CASUAL_LEAVE,\n"
                + "	`leave`.ANUAL_LEAVE,\n"
                + "	`leave`.MEDICAL_LEAVE \n"
                + "FROM\n"
                + "	`leave` \n"
                + "WHERE\n"
                + "	`leave`.EMP_ID = '1' ";
        rs = da.getData(query);

        while (rs.next()) {

            tempId = rs.getString("EMP_ID");

            tempName = rs.getString("EMP_NAME");
            tcasual = rs.getString("CASUAL_LEAVE");
            tanual = rs.getString("ANUAL_LEAVE");
            tmedical = rs.getString("MEDICAL_LEAVE");

        }
        jsonObject.put("tempId", tempId);
        jsonObject.put("tempName", tempName);
        jsonObject.put("tcasual", tcasual);
        jsonObject.put("tsecQuestion", tanual);
        jsonObject.put("tmedical", tmedical);

        System.out.println("data " + jsonObject.toString());
        return jsonObject;

    }

    public JSONObject getSalaryDetails() throws JSONException, SQLException {

        JSONObject jsonObject = new JSONObject();

        Dbaccess da = new Dbaccess();
        ResultSet rs;
        String tempId = null;
        String tpayementFee = null;
        String tbonus = null;
        String tnoOfDays = null;
        String tsalary = null;
        String tdate = null;
        String query = "SELECT\n"
                + "	salary.EMP_ID,\n"
                + "	salary.PAYMENT_FEE,\n"
                + "	salary.BONUS,\n"
                + "	salary.NOOF_DAYS,\n"
                + "	salary.SALARY,\n"
                + "	salary.DATE \n"
                + "FROM\n"
                + "	salary \n"
                + "WHERE\n"
                + "	salary.EMP_ID = '1'";
        rs = da.getData(query);

        while (rs.next()) {

            tempId = rs.getString("EMP_ID");

            tpayementFee = rs.getString("PAYMENT_FEE");
            tbonus = rs.getString("BONUS");
            tnoOfDays = rs.getString("NOOF_DAYS");
            tsalary = rs.getString("SALARY");
            tdate = rs.getString("DATE");

        }
        jsonObject.put("tempId", tempId);
        jsonObject.put("tpayementFee", tpayementFee);
        jsonObject.put("tbonus", tbonus);
        jsonObject.put("tnoOfDays", tnoOfDays);
        jsonObject.put("tsalary", tsalary);
        jsonObject.put("tdate", tdate);

        System.out.println("data " + jsonObject.toString());
        return jsonObject;

    }
}
