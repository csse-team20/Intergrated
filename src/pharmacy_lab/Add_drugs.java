/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy_lab;


import Demo_Data.drug_Data;
import code.DBconnection;
import code.IncrementId;
import code.drug_management;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.json.JSONException;
import org.json.JSONObject;
//import proteanit.sql.DbUtils;

/**
 *
 * @author Lakshika
 */
public class Add_drugs extends javax.swing.JInternalFrame {

    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;

    public Add_drugs() {
        initComponents();
        c = DBconnection.getConnection();

        IncrementId mf = new IncrementId();
        String did = mf.setId("presCode", "drug", "PRES");

        lblPresCode.setText(did);
        tableload();
    }

    public void tableload() {

        try {
            String ses = "SELECT supId as 'Supplier ID',supName as 'Supplier Name',brand as 'Company Name',email as 'Email' "
                    + "FROM supplier ";
            p = c.prepareStatement(ses);
            rs = p.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        try {
            
            String sql1 = "SELECT p.presCode as 'Prescription Code',p.presName as 'Prescription Name',p.category as 'Category',p.unitType as 'Unit Type',p.discription as 'Discription',p.supId as 'Supplier ID',p.price as 'Price' "
                    + "FROM drug p WHERE p.status='NT'";
            p = c.prepareStatement(sql1);
            rs = p.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void clearfield() {

        txtCategory.setText("");
        lblPresCode.setText("");
        txtUnitType.setText("");
        txtPresName.setText("");
        txtdiscription.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCategory = new javax.swing.JTextField();
        txtUnitType = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPresName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblPresCode = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdiscription = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        tprice = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtSname = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblSid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSname = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblBrand = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setTitle("Add Prescription Details");
        setMaximumSize(new java.awt.Dimension(2147483637, 2147483647));
        setMinimumSize(new java.awt.Dimension(2147483637, 2147483647));
        setPreferredSize(new java.awt.Dimension(1366, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Prescription Code", "Prescription Name", "Category", "Unit Type", "Discription", "Supplier ID", "Price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 640, 180));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 72, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Drug Detais"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 173, -1));
        jPanel1.add(txtUnitType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 173, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Category");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 93, 22));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Prescription Code");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, 22));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Prescription Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));
        jPanel1.add(txtPresName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 173, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Discription");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 77, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Unit Type");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 93, 22));

        lblPresCode.setText("PresID");
        jPanel1.add(lblPresCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 173, 22));

        txtdiscription.setColumns(20);
        txtdiscription.setRows(5);
        jScrollPane2.setViewportView(txtdiscription);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 173, 60));

        jLabel9.setText("Price");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));
        jPanel1.add(tprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 380, 300));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, -1, -1));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Serach Supplier By Name Or ID"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSnameKeyReleased(evt);
            }
        });
        jPanel2.add(txtSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 224, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 380, 60));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Supplier Name", "Comany Name", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 640, 130));

        jLabel6.setText("Supplier ID");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        lblSid.setText("Supplier ID");
        getContentPane().add(lblSid, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 150, -1));

        jLabel7.setText("Supplier Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        lblSname.setText("Supplier Name");
        getContentPane().add(lblSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 150, -1));

        jLabel8.setText("Company Name");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        lblBrand.setText("Company Name");
        getContentPane().add(lblBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 150, -1));

        jButton4.setText("Demo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String tpresCode = lblPresCode.getText();
        String tpresName = txtPresName.getText();
        String tunitType = txtUnitType.getText();
        String tcatagory = txtCategory.getText();
        String tdiscrption = txtdiscription.getText();
        String tsupId = lblSid.getText();
        double tprice = Double.parseDouble(this.tprice.getText());
        

        if (tpresCode.isEmpty() || tpresName.isEmpty() || tunitType.isEmpty() || tcatagory.isEmpty()||tsupId.isEmpty()) {

            JOptionPane.showMessageDialog(this, "You Should Fill All Fields");
        } else {
            drug_management a = new drug_management();
            a.addDrugs(tpresCode, tpresName, tcatagory, tunitType, tdiscrption,tsupId,tprice);

            tableload();
            clearfield();
            IncrementId mf = new IncrementId();
        String did = mf.setId("presCode", "drug", "PRES");

        lblPresCode.setText(did);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String tpresCode = lblPresCode.getText();
        String tpresName = txtPresName.getText();
        String tunitType = txtUnitType.getText();
        String tcatagory = txtCategory.getText();
        String tdiscrption = txtdiscription.getText();
        String tsupId = lblSid.getText();

        if (tpresCode.isEmpty() || tpresName.isEmpty() || tunitType.isEmpty() || tcatagory.isEmpty()) {

            JOptionPane.showMessageDialog(this, "You Should Fill All Fields");
        } else {
            drug_management up = new drug_management();
            up.updateDrug(tpresCode, tpresName, tunitType, tcatagory, tdiscrption,tsupId);
        }
        tableload();
        clearfield();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String tpresCode = lblPresCode.getText();

        int y = JOptionPane.showConfirmDialog(this, "Do You Want to delete");

        if (y == 0) {

            drug_management d = new drug_management();
            d.deleteDrug(tpresCode);
        }
        tableload();
        clearfield();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int r1 = jTable1.getSelectedRow();
        System.out.println(r1);

        lblPresCode.setText(jTable1.getValueAt(r1, 0).toString());
        txtPresName.setText(jTable1.getValueAt(r1, 1).toString());
        txtCategory.setText(jTable1.getValueAt(r1, 2).toString());
        txtUnitType.setText(jTable1.getValueAt(r1, 3).toString());
        txtdiscription.setText(jTable1.getValueAt(r1, 4).toString());
        lblSid.setText(jTable1.getValueAt(r1, 5).toString());
        
        
        try {
            String sql = "select supName,brand from supplier where supId = '"+jTable1.getValueAt(r1, 5).toString()+"'";
            p = c.prepareStatement(sql);
            rs = p.executeQuery();
            
            while (rs.next()) {
                String brand = rs.getString("brand");
                String name = rs.getString("supName");
                lblSname.setText(name);
                lblBrand.setText(brand);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtSnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSnameKeyReleased

        String sname = txtSname.getText();
        try {
            String ses = "SELECT supId as 'Supplier ID',supName as 'Supplier Name',brand as 'Company Name',email as 'Email' "
                    + "FROM supplier "
                    + "WHERE supName like '%" + sname + "%'or supId like '%" + sname + "%' or brand like '%" + sname + "%'";
            p = c.prepareStatement(ses);
            rs = p.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_txtSnameKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int r1 = jTable2.getSelectedRow();

        lblSid.setText(jTable2.getValueAt(r1, 0).toString());
        lblSname.setText(jTable2.getValueAt(r1, 1).toString());
        lblBrand.setText(jTable2.getValueAt(r1, 2).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        drug_Data d = new drug_Data();
        
        try {
            JSONObject o = d.AddDrugs();
            
            txtPresName.setText(o.getString("tpresName"));
            txtCategory.setText(o.getString("tcatagory"));
            txtUnitType.setText(o.getString("tunitType"));
            txtdiscription.setText(o.getString("tdiscrption"));
            tprice.setText(o.getString("tprice"));
            
        } catch (JSONException ex) {
            Logger.getLogger(Add_drugs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblPresCode;
    private javax.swing.JLabel lblSid;
    private javax.swing.JLabel lblSname;
    private javax.swing.JTextField tprice;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtPresName;
    private javax.swing.JTextField txtSname;
    private javax.swing.JTextField txtUnitType;
    private javax.swing.JTextArea txtdiscription;
    // End of variables declaration//GEN-END:variables
}
