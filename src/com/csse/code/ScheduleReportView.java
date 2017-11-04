/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csse.code;

import com.csse.db.Dbconnect;
import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Anuradha Sanjeewa
 */
public class ScheduleReportView extends JFrame{
    
    public ScheduleReportView(String fileName) throws ClassNotFoundException, JRException{
    
        this(fileName,null);
    }
     
    public ScheduleReportView(String fileName,HashMap para) throws ClassNotFoundException, JRException{
    
        super("ScheduleReport");
       
        Dbconnect conn = new Dbconnect();
        Connection con = conn.getConnection();
        
        
        try
        {
            JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);            
        } 
        catch (JRException jRException)
        {
            
        }
        setBounds(10, 10, 900, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
    
    }
    
    
    
}
