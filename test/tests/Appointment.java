/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Appointment.Add_Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Date;
import javafx.animation.Animation.Status;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashan
 */
public class Appointment {
    public void add(String Patient,String Time,String Doctor,String Atime,String Status,String Date,String ADate){
    Add_Appointment aa= new Add_Appointment();
    aa.getText();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
                    String sql = "INSERT INTO appointment (Date,Time,Doctor,ADate,ATime,Patient,Status) values ('"+Date+"','"+Time+"','"+Doctor+"','"+ADate+"','"+Atime+"','"+Patient+"','"+Status+"')";
                    pst = con.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Weldone,you added it perfectly.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Operation Failure" + e);
        }
        aa.clear();
}
}
