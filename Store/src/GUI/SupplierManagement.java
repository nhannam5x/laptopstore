/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Supplier;
import BUS.SupplierBUS;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author donha
 */
public class SupplierManagement extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    SupplierBUS supplierBUS = new SupplierBUS();
    ArrayList<Supplier> supplierls = supplierBUS.getList();
    int staffID;
    
    public SupplierManagement(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        supplierBUS.listSupplier();

        showTable(supplierls);
    }
    
    private void showTable(ArrayList<Supplier> supplierls)
    {   
        tbl_Supplier.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Supplier.getModel();
        defaultModel.setRowCount(0);
        for(Supplier s : supplierls)
        {
            if(s.getStatus() == 1){
                int supplierID = s.getSupplierID();
                String supplierName = s.getSupplierName();
                String address = s.getAddress();
                defaultModel.addRow(new Object[]{supplierID, supplierName, address});
            }
        }
    }
    
    private void showSupplierValue(ArrayList<Supplier> supplierls)
    {
        int row = tbl_Supplier.getSelectedRow();
        jlb_supplierID.setText(tbl_Supplier.getModel().getValueAt(row, 0).toString());
        txt_supplierName.setText(tbl_Supplier.getModel().getValueAt(row, 1).toString());
        txt_address.setText(tbl_Supplier.getModel().getValueAt(row, 2).toString());
    }
    
    private void editSupplier()
    {
        int supplierID;
        String supplierName , address;
        int row = tbl_Supplier.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn nhà cung cấp cần sửa", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           supplierID = Integer.parseInt(jlb_supplierID.getText());
           if(txt_supplierName.getText().equals("") || txt_supplierName.getText().equals("Name")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }supplierName = txt_supplierName.getText();
            
            if(txt_address.getText().equals("") || txt_address.getText().equals("Address")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập địa chỉ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }address = txt_address.getText();
           
           int status =1; 
           
           Supplier su = new Supplier(supplierID, supplierName, address, status);
           int response = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa nhà cung cấp "+ supplierID +" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
           if(response == JOptionPane.YES_OPTION){
               supplierBUS.SetSupplier(su);
               refresh();
               resetText();
               
               JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
               return;
           }
           row = -1;
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(SupplierManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void delSupplier(){
        int row = tbl_Supplier.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn nhà cung cấp cần xoá", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           int supplierID = (int)tbl_Supplier.getModel().getValueAt(row, 0);
           String supplierName = tbl_Supplier.getModel().getValueAt(row, 1).toString();
           String address = tbl_Supplier.getModel().getValueAt(row, 2).toString();
           int status = 0;
           Supplier su = new Supplier(supplierID, supplierName, address, status);
           
           int response = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa nhà cung cấp "+ supplierID +" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
           if(response == JOptionPane.YES_OPTION){
               supplierBUS.SetSupplier(su);
               refresh();
               resetText();
               JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
               return;
           }      
            row = -1;
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetText(){
        jlb_supplierID.setText("...");
        txt_supplierName.setText("");
        txt_address.setText("");
    }
    
    private void refresh(){
        try {
            supplierBUS.listSupplier();
            supplierls = supplierBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(supplierls);
    }
    
    private void search(){
        String supplierID = txt_sSupplierID.getText();
        String supplierName = txt_sSupplierName.getText();
        String address = txt_sAddress.getText();
        showTable(supplierBUS.search(supplierID, supplierName, address));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Supplier = new javax.swing.JTable();
        btn_restore = new javax.swing.JToggleButton();
        btn_del = new javax.swing.JToggleButton();
        btn_Update = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txt_sSupplierID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txt_sSupplierName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_sAddress = new javax.swing.JTextField();
        jlb_supplierID = new javax.swing.JLabel();
        jlb_supplierName = new javax.swing.JLabel();
        txt_supplierName = new javax.swing.JTextField();
        jlb_address = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btn_add1 = new javax.swing.JToggleButton();
        jlb_supplier = new javax.swing.JLabel();
        btn_exportExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Supplier Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 290, 77));

        tbl_Supplier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Supplier.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "supplierID", "supplierName", "address"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Supplier.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Supplier.setRowHeight(40);
    tbl_Supplier.setRowMargin(2);
    tbl_Supplier.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Supplier.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Supplier.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_SupplierMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Supplier);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1290, 157));

    btn_restore.setBackground(new java.awt.Color(204, 204, 204));
    btn_restore.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_restore.setForeground(new java.awt.Color(255, 255, 255));
    btn_restore.setText("Khôi phục");
    btn_restore.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_restoreMouseClicked(evt);
        }
    });
    btn_restore.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_restoreActionPerformed(evt);
        }
    });
    jPanel1.add(btn_restore, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 230, 90));

    btn_del.setBackground(new java.awt.Color(255, 0, 0));
    btn_del.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_del.setForeground(new java.awt.Color(255, 255, 255));
    btn_del.setText("Xóa");
    btn_del.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_delActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 230, 90));

    btn_Update.setBackground(new java.awt.Color(51, 51, 255));
    btn_Update.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Update.setForeground(new java.awt.Color(255, 255, 255));
    btn_Update.setText("Sửa");
    btn_Update.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_UpdateActionPerformed(evt);
        }
    });
    jPanel1.add(btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 230, 90));

    btn_Refresh.setBackground(new java.awt.Color(102, 255, 255));
    btn_Refresh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Refresh.setForeground(new java.awt.Color(255, 255, 255));
    btn_Refresh.setText("Làm Mới");
    btn_Refresh.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_RefreshMouseClicked(evt);
        }
    });
    btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_RefreshActionPerformed(evt);
        }
    });
    jPanel1.add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 610, 230, 90));

    jLabel3.setBackground(new java.awt.Color(255, 255, 255));
    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 153, 51));
    jLabel3.setText("SEARCH");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 80, 50));

    txt_sSupplierID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sSupplierID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sSupplierID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sSupplierIDActionPerformed(evt);
        }
    });
    txt_sSupplierID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sSupplierIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 130, 52));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("SupplierID:");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 110, 52));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1320, 10));

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 51));
    jLabel9.setText("Name:");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 70, 52));

    txt_sSupplierName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sSupplierName.setForeground(new java.awt.Color(255, 153, 51));
    txt_sSupplierName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sSupplierNameActionPerformed(evt);
        }
    });
    txt_sSupplierName.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sSupplierNameKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 310, 52));

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 153, 51));
    jLabel10.setText("Address:");
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 90, 52));

    txt_sAddress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sAddress.setForeground(new java.awt.Color(255, 153, 51));
    txt_sAddress.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sAddressActionPerformed(evt);
        }
    });
    txt_sAddress.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sAddressKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 460, 260, 52));

    jlb_supplierID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_supplierID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_supplierID.setText("...");
    jPanel1.add(jlb_supplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 138, 52));

    jlb_supplierName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_supplierName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_supplierName.setText("Name:");
    jPanel1.add(jlb_supplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 70, 52));

    txt_supplierName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_supplierName.setForeground(new java.awt.Color(255, 153, 51));
    txt_supplierName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_supplierNameActionPerformed(evt);
        }
    });
    jPanel1.add(txt_supplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 310, 52));

    jlb_address.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_address.setForeground(new java.awt.Color(255, 153, 51));
    jlb_address.setText("Address:");
    jPanel1.add(jlb_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, 100, 52));

    txt_address.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_address.setForeground(new java.awt.Color(255, 153, 51));
    txt_address.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_addressActionPerformed(evt);
        }
    });
    jPanel1.add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 290, 260, 52));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1320, 10));

    btn_add1.setBackground(new java.awt.Color(102, 255, 102));
    btn_add1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_add1.setForeground(new java.awt.Color(255, 255, 255));
    btn_add1.setText("Thêm");
    btn_add1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_add1MouseClicked(evt);
        }
    });
    btn_add1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_add1ActionPerformed(evt);
        }
    });
    jPanel1.add(btn_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 230, 90));

    jlb_supplier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_supplier.setForeground(new java.awt.Color(255, 153, 51));
    jlb_supplier.setText("SupplierID:");
    jPanel1.add(jlb_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 138, 52));

    btn_exportExcel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/a1.png"))); // NOI18N
    btn_exportExcel.setText("XUẤT EXCEL");
    btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_exportExcelActionPerformed(evt);
        }
    });
    jPanel1.add(btn_exportExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 210, 60));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_SupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SupplierMouseClicked
        showSupplierValue(supplierls);
    }//GEN-LAST:event_tbl_SupplierMouseClicked

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        SupplierRecovery s = new SupplierRecovery();
        s.setVisible(true);
    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        delSupplier();

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        editSupplier();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
//        showTable();

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_sSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sSupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sSupplierIDActionPerformed

    private void txt_sSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sSupplierNameActionPerformed

    private void txt_sAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sAddressActionPerformed

    private void txt_supplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_supplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_supplierNameActionPerformed

    private void txt_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addressActionPerformed

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
//        AddCourse a = new AddCourse();
        try {
           AddSupplier s = new AddSupplier();
           s.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupplierManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_sSupplierIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sSupplierIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sSupplierIDKeyReleased

    private void txt_sSupplierNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sSupplierNameKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sSupplierNameKeyReleased

    private void txt_sAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sAddressKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sAddressKeyReleased

    private void btn_exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportExcelActionPerformed
        // TODO add your handling code here:
//        try {
//            // TODO add your handling code here:
//            String date = java.time.LocalDate.now().toString();
//            final String excelFilePath = "C:/Users/donha/Desktop/Product_Excel_"+date+".xlsx";
//            writeExcel(this.productls,excelFilePath);
//        } catch (IOException ex) {
//            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btn_exportExcelActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Window Vista".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(StaffManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StaffManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StaffManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StaffManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new SupplierManagement().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(SupplierManagement.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JToggleButton btn_Update;
    private javax.swing.JToggleButton btn_add1;
    private javax.swing.JToggleButton btn_del;
    private javax.swing.JButton btn_exportExcel;
    private javax.swing.JToggleButton btn_restore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_address;
    private javax.swing.JLabel jlb_supplier;
    private javax.swing.JLabel jlb_supplierID;
    private javax.swing.JLabel jlb_supplierName;
    private javax.swing.JTable tbl_Supplier;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_sAddress;
    private javax.swing.JTextField txt_sSupplierID;
    private javax.swing.JTextField txt_sSupplierName;
    private javax.swing.JTextField txt_supplierName;
    // End of variables declaration//GEN-END:variables
}
