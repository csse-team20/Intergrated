/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lakshika
 */
public class IncrementId {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public String setId(String pmKey, String table, String id) {
        con = DBconnection.getConnection();
        String previous = "";
        int tempNo = 0;
        int nextNo = 0;
        String tempNum = "";
        String next = "";
        try {
            String qry = "Select " + pmKey + " from " + table + " ORDER BY " + pmKey + "";
            pst = con.prepareStatement(qry);
            rs = pst.executeQuery();
            if (rs.last()) {
                previous = rs.getString(pmKey);
            }
        } catch (Exception e) {
            System.out.println("sql error "+e);
        }
        if (previous.equals("")) {
            previous = id + "1000";
        }

        for (int x = 0; x < previous.length(); x++) {
            if (Character.isDigit(previous.charAt(x))) {
                tempNum = tempNum + previous.charAt(x) + "";
            }
        }
        tempNo = Integer.parseInt(tempNum);
        nextNo = tempNo + 1;

        next = id + "" + nextNo;
        return next;
    }
}
