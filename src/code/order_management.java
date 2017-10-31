/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Orange
 */
public class order_management {
    
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    
    public void orderDrug(String oid, String pid, int qty,String supid) {

        c = DBconnection.getConnection();

        try {
            String patient = "INSERT INTO `channeling_center`.`orders` (\n"
                    + "	`oid`,\n"
                    + "	`date`,\n"
                    + "	`order_status`,\n"
                    + "	`payment_status`,\n"
                    + "	`supId`\n"
                    + ")\n"
                    + "VALUES\n"
                    + "	('" + oid + "', current_date, 'Pending','Pending','"+supid+"');";
            p = c.prepareStatement(patient);
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        try {
            String patient = "INSERT INTO `channeling_center`.`order_drug` (\n"
                    + "	`orderId`,\n"
                    + "	`drugId`,\n"
                    + "	`order_qty`\n"
                    + ")\n"
                    + "VALUES\n"
                    + "	('" + oid + "', '" + pid + "','" + qty + "');";
            p = c.prepareStatement(patient);
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void orderChemical(String oid, String chemId, int qty) {

        c = DBconnection.getConnection();

        try {
            String patient = "INSERT INTO `channeling_center`.`order_chem` (\n"
                    + "	`orderId`,\n"
                    + "	`chemId`,\n"
                    + "	`date`,\n"
                    + "	`status`,\n"
                    + "	`order_qty`\n"
                    + ")\n"
                    + "VALUES\n"
                    + "	('" + oid + "', '" + chemId + "', current_date, 'Pending','" + qty + "');";
            p = c.prepareStatement(patient);
            p.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    public void deleteDrugOrder(String oid, String did) {

        String status = "";
        c = DBconnection.getConnection();
        try {
            String stst = "SELECT status FROM order_drug where orderId='" + oid + "' and drugId = '" + did + "'";
            p = c.prepareStatement(stst);
            rs = p.executeQuery();

            while (rs.next()) {
                status = rs.getString("status");
                System.out.println(status);
            }
            if (status.equals("Pending")) {
                JOptionPane.showMessageDialog(null, "You cannot delete pending order");
            } else {
                try {
                    String del = "DELETE FROM order_drug where orderId='" + oid + "' and drugId = '" + did + "'";
                    p = c.prepareStatement(del);
                    p.execute();
                    JOptionPane.showMessageDialog(null, "Delete is success");

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Delete Fail");
                    System.out.println(ex);

                }
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Delete Fail");
            System.out.println(ex);

        }

    }
    
    public void deleteChemicalOrder(String oid, String did) {

        String status = "";
        c = DBconnection.getConnection();
        try {
            String stst = "SELECT status FROM order_chem where orderId='" + oid + "' and chemId = '" + did + "'";
            p = c.prepareStatement(stst);
            rs = p.executeQuery();

            while (rs.next()) {
                status = rs.getString("status");
                System.out.println(status);
            }
            if (status.equals("Pending")) {
                JOptionPane.showMessageDialog(null, "You cannot delete pending order");
            } else {
                try {
                    String del = "DELETE FROM order_chem where orderId='" + oid + "' and chemId = '" + did + "'";
                    p = c.prepareStatement(del);
                    p.execute();
                    JOptionPane.showMessageDialog(null, "Delete is success");

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Delete Fail");
                    System.out.println(ex);

                }
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Delete Fail");
            System.out.println(ex);

        }

    }
}
