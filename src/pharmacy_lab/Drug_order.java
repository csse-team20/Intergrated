package pharmacy_lab;

import code.DBconnection;
import code.IncrementId;
import code.order_management;
import code.validation;
import com.sun.istack.internal.logging.Logger;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

/**
 *
 * @author Janaka Perera
 */
public class Drug_order extends javax.swing.JInternalFrame {

    /**
     * Creates new form Drug_order
     */
    Connection c = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    public boolean tableIsPresed = false;
    public boolean addIdPresed = false;

    public Drug_order() {
        initComponents();
        c = DBconnection.getConnection();
        SupplierTableload();
        //oderTableload();
        drugTableload();
//
        IncrementId mf = new IncrementId();
        String did = mf.setId("orderId", "order_drug", "ORD");
        lblOid.setText(did);
//
//        try {
//            String sql = "SELECT pname,curQty from product";
//            p = c.prepareStatement(sql);
//            rs = p.executeQuery();
//
//            while (rs.next()) {
//                String pname = rs.getString("pname");
//                int qty = Integer.parseInt(rs.getString("curQty"));
//
//                if (qty < 10) {
//                    JOptionPane.showMessageDialog(this, pname + " stock is " + qty);
//                }
//            }
//        } catch (SQLException ex) {
//            java.util.logging.Logger.getLogger(Drug_order.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public void SupplierTableload() {

        try {
            String ses = "SELECT supId as 'Supplier ID',supName as 'Supplier Name',brand as 'Company Name',email as 'Email'"
                    + " FROM supplier ";
            p = c.prepareStatement(ses);
            rs = p.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void drugTableload() {
        try {

            String sql1 = "SELECT p.presCode as 'Prescription Code',p.presName as 'Prescription Name',p.category as 'Category',p.unitType as 'Unit Type',p.discription as 'Discription',p.price as 'Price',p.current_qty as 'Current Qyantity' "
                    + "FROM drug p WHERE p.status='NT'";
            p = c.prepareStatement(sql1);
            rs = p.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void oderTableload() {

        try {

            String sql1 = "SELECT o.oid as 'Order ID',od.drugId as 'Prescription Code',p.presName as 'Prescription Name',p.category as 'Category',\n"
                    + "p.unitType as 'Unit Type',p.price as 'Price',od.order_qty as 'Qyantity',o.date as 'Ordered Date',o.order_status as 'Status' \n"
                    + "FROM drug p , order_drug od, orders o \n"
                    + "WHERE od.drugId = p.presCode and o.oid=od.orderId";
            p = c.prepareStatement(sql1);
            rs = p.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void clearfield() {

        lblOid.setText("");
        lblPid.setText("");
        lblPname.setText("");
        lblPPrice.setText("");
        lblType.setText("");
        lblUnit.setText("");
        txtQty.setText("");
        lblTPrice.setText("");

    }

    public void clearTable(int row) {
        //int filledRowCount = 0;
//        rowSearch:
//        for (int row = 0; row < jTable3.getRowCount(); row++) {
//
//            for (int col = 0; col < jTable3.getColumnCount(); col++) {
//                if (jTable3.getValueAt(row, col) == null) {
//                    break rowSearch;
//                } else {
//                    filledRowCount++;
//                    continue rowSearch;
//                }
//            }
//        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= 9; j++) {
                jTable3.setValueAt("", i, j);
            }
        }
    }

    public void setvalue() {

        lblPid.setText("Product ID");
        lblPname.setText("Product Name");
        lblPPrice.setText("Purchased Price");
        lblType.setText("Type");
        lblUnit.setText("Unit");
        txtQty.setText("");
        lblTPrice.setText("Total Price");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtSeSname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtSePname = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPid = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lblPname = new javax.swing.JLabel();
        lblPPrice = new javax.swing.JLabel();
        lblTPrice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblOid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblUnit = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lblOCost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();

        setTitle("Make An Order");
        setMaximumSize(new java.awt.Dimension(1366, 570));
        setMinimumSize(new java.awt.Dimension(1366, 570));
        setPreferredSize(new java.awt.Dimension(1366, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Supplier Name", "Company", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 11, 989, 106));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Serach Supplier By Name"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSeSname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSeSnameKeyReleased(evt);
            }
        });
        jPanel4.add(txtSeSname, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 27, 220, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 335, 70));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Precription Code", "Prescription Name", "Category", "Unit Type", "Description", "Purchased Price", "Current Quantity"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 135, 989, 107));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Serach Product By Name "));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSePname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSePnameKeyReleased(evt);
            }
        });
        jPanel5.add(txtSePname, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 220, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 335, 70));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Products"));

        jLabel2.setText("Product ID");

        jLabel4.setText("Product Name");

        jLabel8.setText("Purchased Price");

        jLabel9.setText("Quantity");

        lblPid.setText("Product ID");

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });

        jLabel11.setText("Total Price");

        lblPname.setText("Product Name");

        lblPPrice.setText("Purchased Price");

        lblTPrice.setText("Total Price");

        jLabel3.setText("Oredr ID");

        lblOid.setText("Order ID");

        jLabel5.setText("Categoty");

        lblType.setText("Type");

        jLabel7.setText("Unit Type");

        lblUnit.setText("Unit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblOid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(lblPPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblOid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPid)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPname))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblPPrice))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblType))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblUnit))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTPrice))
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 330, 300));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Product ID", "Product Name", "Type", "Unit", "Price", "Quantity", "Amount", "Date"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 260, 989, 160));

        lblOCost.setEditable(false);
        getContentPane().add(lblOCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(1093, 432, 148, -1));

        jLabel1.setText("Total Order Cost");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 435, -1, -1));

        jButton11.setText("Place Order");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1251, 431, -1, -1));

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, -1, -1));

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, -1, -1));

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int r = jTable2.getSelectedRow();

        lblPid.setText(jTable2.getValueAt(r, 0).toString());
        lblPname.setText(jTable2.getValueAt(r, 1).toString());
        lblType.setText(jTable2.getValueAt(r, 2).toString());
        lblUnit.setText(jTable2.getValueAt(r, 3).toString());
        lblPPrice.setText(jTable2.getValueAt(r, 5).toString());

        txtSePname.setEnabled(true);
        txtSeSname.setEnabled(true);
        //clearTable();
        jTable1.setVisible(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

        int r = jTable3.getSelectedRow();

        lblOid.setText(jTable3.getValueAt(r, 0).toString());
        lblPid.setText(jTable3.getValueAt(r, 1).toString());
        lblPname.setText(jTable3.getValueAt(r, 2).toString());
        lblType.setText(jTable3.getValueAt(r, 3).toString());
        lblUnit.setText(jTable3.getValueAt(r, 4).toString());
        lblPPrice.setText(jTable3.getValueAt(r, 5).toString());
        if (tableIsPresed == false) {
            txtQty.setText(jTable3.getValueAt(r, 6).toString());
        }
        if (tableIsPresed == true) {
            txtQty.setVisible(false);
            jLabel9.setVisible(false);
            jLabel11.setVisible(false);
            lblTPrice.setVisible(false);
        }

//        lblTPrice.setText(jTable3.getValueAt(r, 7).toString());
    }//GEN-LAST:event_jTable3MouseClicked

    private void txtSeSnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeSnameKeyReleased

        String sname = txtSeSname.getText();
        try {
            String ses = "SELECT supId as 'Supplier ID',supName as 'Supplier Name',brand as 'Company Name',email as 'Email' "
                    + "FROM supplier "
                    + "WHERE supName like '%" + sname + "%'or supId like '%" + sname + "%' ";
            p = c.prepareStatement(ses);
            rs = p.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        txtSePname.setEnabled(false);
    }//GEN-LAST:event_txtSeSnameKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        tableIsPresed = true;

        int r = jTable1.getSelectedRow();

        String sid = jTable1.getValueAt(r, 0).toString();

        try {
            String ms = "SELECT p.presCode as 'Prescription Code',p.presName as 'Prescription Name',p.category as 'Category',p.unitType as 'Unit Type',p.discription as 'Discription',p.price as 'Price',p.current_qty as 'Current Qyantity' "
                    + "FROM drug p  "
                    + "WHERE p.supId like '%" + sid + "%' and p.status='NT'";
            p = c.prepareStatement(ms);
            rs = p.executeQuery();
            jTable2.setModel((TableModel) DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            String ms = "SELECT o.oid as 'Order ID',od.drugId as 'Prescription Code',p.presName as 'Prescription Name',p.category as 'Category',\n"
                    + "p.unitType as 'Unit Type',p.price as 'Price',od.order_qty as 'Qyantity',o.date as 'Ordered Date',o.order_status as 'Status' \n"
                    + "FROM drug p , order_drug od, orders o,supplier s \n"
                    + "WHERE od.drugId = p.presCode and o.oid=od.orderId and s.supId=p.supId and s.supId = '" + sid + "'";

            p = c.prepareStatement(ms);
            rs = p.executeQuery();
            jTable3.setModel((TableModel) DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed

        int cqty = 0, newqty;
        String pid = lblPid.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(lblPPrice.getText());
        double amount = (qty * price);
        lblTPrice.setText("" + amount);

//        try {
//            String q = "SELECT curQty FROM product WHERE idproduct=?";
//            p = c.prepareStatement(q);
//            p.setString(1, pid);
//            rs = p.executeQuery();
//            if (rs.next()) {
//                cqty = Integer.parseInt(rs.getString("curQty"));
//            }
//            newqty = cqty + qty;
//
//            String sqty = "UPDATE product SET curQty='" + newqty + "' WHERE idproduct=?";
//            p = c.prepareStatement(sqty);
//            p.setString(1, pid);
//            p.execute();
//
//        } catch (SQLException ex) {
//
//            System.out.println(ex);
//        }

    }//GEN-LAST:event_txtQtyActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed

        String oid = lblOid.getText();
        String pid = lblPid.getText();
        String pname = lblPname.getText();
        String price = lblPPrice.getText();
        String category = lblType.getText();
        String unit = lblUnit.getText();
        double amount = Double.parseDouble(lblTPrice.getText());
        String qty = txtQty.getText();
        String sup = "";
        String tsup = "";
        System.out.println(oid + " " + pid + " " + pname + " " + price + " " + category + " " + unit + " " + amount + " " + qty);
        int x = 0;

        validation vi = new validation();
        if (oid.isEmpty() || pid.isEmpty() || qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You should fill all fields");
        } else if (vi.isnumber(qty)) {

            if (x == 0) {
                int filledRowCount = 0;
                rowSearch:
                for (int row = 0; row < jTable3.getRowCount(); row++) {

                    for (int col = 0; col < jTable3.getColumnCount(); col++) {
                        if (jTable3.getValueAt(row, col) == null) {
                            break rowSearch;
                        } else {
                            filledRowCount++;
                            continue rowSearch;
                        }
                    }
                }
                if (filledRowCount > 0) {
                    String proid = jTable3.getModel().getValueAt(0, 1).toString();

                    try {
                        String sql = "SELECT supId from drug where presCode = '" + proid + "'";
                        p = c.prepareStatement(sql);
                        rs = p.executeQuery();

                        while (rs.next()) {
                            sup = rs.getString("supId");
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

                    try {
                        String sql2 = "SELECT supId from drug where presCode = '" + pid + "'";
                        p = c.prepareStatement(sql2);
                        rs = p.executeQuery();

                        while (rs.next()) {
                            tsup = rs.getString("supId");
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

                }
                System.out.println("filled " + filledRowCount);
                if (addIdPresed == false) {
                    jTable3.removeColumn(jTable3.getColumnModel().getColumn(8));
                }
                if (filledRowCount == 0 && sup.equals(tsup)) {

                    jTable3.setValueAt(oid, 0, 0);
                    jTable3.setValueAt(pid, 0, 1);
                    jTable3.setValueAt(pname, 0, 2);
                    jTable3.setValueAt(category, 0, 3);
                    jTable3.setValueAt(unit, 0, 4);
                    jTable3.setValueAt(price, 0, 5);
                    jTable3.setValueAt(qty, 0, 6);
                    jTable3.setValueAt(amount, 0, 7);

                } else if (filledRowCount > 0 && sup.equals(tsup)) {
                    for (int i = 0; i < filledRowCount; i++) {
                        String code = jTable3.getValueAt(i, 1).toString();
                        if (code.equals(pid)) {
                            JOptionPane.showMessageDialog(this, "Prescription has already added");
                        } else {
                            jTable3.setValueAt(oid, filledRowCount, 0);
                            jTable3.setValueAt(pid, filledRowCount, 1);
                            jTable3.setValueAt(pname, filledRowCount, 2);
                            jTable3.setValueAt(category, filledRowCount, 3);
                            jTable3.setValueAt(unit, filledRowCount, 4);
                            jTable3.setValueAt(price, filledRowCount, 5);
                            jTable3.setValueAt(qty, filledRowCount, 6);
                            jTable3.setValueAt(amount, filledRowCount, 7);

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "You cannot add diffrent suppler products");
                }
                x = JOptionPane.showConfirmDialog(this, "Do you want to place the order to same supplier");
                setvalue();
            } else {
                JOptionPane.showMessageDialog(this, "Quantity should have (0-9) digits only");
            }
        }
        addIdPresed = true;
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed

        int qty = Integer.parseInt(txtQty.getText());
        String oid = lblOid.getText();
        String pid = lblPid.getText();
        String pname = lblPname.getText();
        String price = lblPPrice.getText();
        String category = lblType.getText();
        String unit = lblUnit.getText();
        double amount = Double.parseDouble(lblTPrice.getText());
        if (!txtQty.getText().isEmpty() || !lblTPrice.getText().isEmpty()) {

            rowSearch:
            for (int row = 0; row < jTable3.getRowCount(); row++) {

                for (int col = 1; col < jTable3.getColumnCount(); col++) {
                    if (jTable3.getValueAt(row, col) == pid) {

                        jTable3.setValueAt(oid, row, 0);
                        jTable3.setValueAt(pid, row, 1);
                        jTable3.setValueAt(pname, row, 2);
                        jTable3.setValueAt(category, row, 3);
                        jTable3.setValueAt(unit, row, 4);
                        jTable3.setValueAt(price, row, 5);
                        jTable3.setValueAt(qty, row, 6);
                        jTable3.setValueAt(amount, row, 7);

                        break rowSearch;
                    } else {
                        continue rowSearch;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed

        String oid = lblOid.getText();
        String pid = lblPid.getText();
        if (tableIsPresed == true) {
            order_management d = new order_management();
            d.deleteDrugOrder(oid, pid);
            SupplierTableload();

        } else if (addIdPresed == true) {

            rowSearch:
            for (int row = 0; row < jTable3.getRowCount(); row++) {

                for (int col = 1; col < jTable3.getColumnCount(); col++) {
                    if (jTable3.getValueAt(row, col) == pid) {
                        System.out.println("come");
                        jTable3.removeRowSelectionInterval(row, row);
                        System.out.println("done");
                        break rowSearch;
                    } else {
                        continue rowSearch;
                    }
                }
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.out.println("order");
        String oid = "";
        String pid = "";
        String sup = "";

        int qty = 0;

        int filledRowCount = 0;
        rowSearch:
        for (int row = 0; row < jTable3.getRowCount(); row++) {
            System.out.println("fill");
            for (int col = 0; col < jTable3.getColumnCount(); col++) {
                if (jTable3.getValueAt(row, col) == null) {
                    break rowSearch;
                } else {
                    filledRowCount++;
                    continue rowSearch;
                }
            }
        }
        if (filledRowCount > 0) {
            String proid = jTable3.getModel().getValueAt(0, 1).toString();

            try {
                String sql = "SELECT supId from drug where presCode = '" + proid + "'";
                p = c.prepareStatement(sql);
                rs = p.executeQuery();

                while (rs.next()) {
                    sup = rs.getString("supId");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        for (int i = 0; i < filledRowCount; i++) {

            oid = jTable3.getValueAt(i, 0).toString();
            pid = jTable3.getValueAt(i, 1).toString();
            qty = Integer.parseInt((String) jTable3.getValueAt(i, 6));

            order_management a = new order_management();
            a.orderDrug(oid, pid, qty,sup);
            SupplierTableload();
            // clearTable(filledRowCount);

        }

        IncrementId mf = new IncrementId();
        String did = mf.setId("orderId", "order_drug", "ORD");
        lblOid.setText(did);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void txtSePnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSePnameKeyReleased

        String sepname = txtSePname.getText();
        jTable1.setVisible(false);
        txtSeSname.setEnabled(false);

        try {

            String sql1 = "SELECT p.presCode as 'Prescription Code',p.presName as 'Prescription Name',p.category as 'Category',p.unitType as 'Unit Type',p.discription as 'Discription',p.price as 'Price',p.current_qty as 'Current Qyantity' "
                    + "FROM drug p "
                    + "WHERE p.presCode like '%" + sepname + "%'or p.presName like '%" + sepname + "%'";
            p = c.prepareStatement(sql1);
            rs = p.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_txtSePnameKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField lblOCost;
    private javax.swing.JLabel lblOid;
    private javax.swing.JLabel lblPPrice;
    private javax.swing.JLabel lblPid;
    private javax.swing.JLabel lblPname;
    private javax.swing.JLabel lblTPrice;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblUnit;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSePname;
    private javax.swing.JTextField txtSeSname;
    // End of variables declaration//GEN-END:variables
}