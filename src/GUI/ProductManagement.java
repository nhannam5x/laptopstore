/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Product;
import BUS.ProductBUS;
import DTO.Category;
import BUS.CategoryBUS;
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
public class ProductManagement extends javax.swing.JFrame {

    ProductBUS productBUS = new ProductBUS();
    CategoryBUS categoryBUS = new CategoryBUS();
    SupplierBUS supplierBUS = new SupplierBUS();
    ArrayList<Product> productls = productBUS.getList();
    ArrayList<Category> category = categoryBUS.getList();
    ArrayList<Supplier> supplier = supplierBUS.getList();
    
    public ProductManagement() throws ClassNotFoundException {
        initComponents();
        productBUS.listProduct();
        categoryBUS.listCategory();
        supplierBUS.listSupplier();

        showTable(productls);
    }
    
    private void showTable(ArrayList<Product> productls)
    {   
        tbl_Product.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Product.getModel();
        defaultModel.setRowCount(0);
        for(Product p : productls)
        {
            if(p.getStatus() == 1){
                int productID = p.getProductID();
                String productName = p.getProductName();
                String categoryName = categoryBUS.getCategoryID(p.getCategoryID()).getCategoryName();
                String supplierName = supplierBUS.getSupplierID(p.getSupplierID()).getSupplierName();
                float price = p.getPrice();
                int quantity = p.getQuantity();
                defaultModel.addRow(new Object[]{productID, productName,categoryName,supplierName, price, quantity});
            }
        }
    }
    
    private void showProductValue(ArrayList<Product> productls)
    {
        
        int row = tbl_Product.getSelectedRow();
        int value = (int) tbl_Product.getModel().getValueAt(row, 0);
        for(Product p : productls)
        {
            if (productBUS.CheckProductID(value))
            {
                jlb_productID.setText(tbl_Product.getModel().getValueAt(row, 0).toString());
                txt_productName.setText(tbl_Product.getModel().getValueAt(row, 1).toString());
                txt_category.setText(tbl_Product.getModel().getValueAt(row, 2).toString());
                txt_supplierID.setText(tbl_Product.getModel().getValueAt(row, 3).toString());
                txt_price.setText(tbl_Product.getModel().getValueAt(row, 4).toString());
                txt_quantity.setText(tbl_Product.getModel().getValueAt(row, 5).toString());
            }
        }
    }   
    
     private void editProduct()
    {
        int productID;
        int row = tbl_Product.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn sản phẩm cần sửa", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           
           productID = Integer.parseInt(jlb_productID.getText());
           String productName = txt_productName.getText();
           int category = Integer.parseInt(txt_category.getText());
           int supplierID = Integer.parseInt(txt_supplierID.getText());
           float price = Integer.parseInt(txt_price.getText());
           int quantity = Integer.parseInt(txt_quantity.getText());
           int status =1; 
         
           Product p = new Product(productID, productName, category, supplierID, price, quantity, status);
                        
            productBUS.SetProduct(p);
            refresh();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void delProduct(){
        int row = tbl_Product.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn sản phẩm cần xoá", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
         
           int productID = (int)tbl_Product.getModel().getValueAt(row, 0);
           String productName = tbl_Product.getModel().getValueAt(row, 1).toString();
           int categoryID = productBUS.getProductID(productID).getCategoryID();
           int supplierID = productBUS.getProductID(productID).getSupplierID();
           float price = (float)tbl_Product.getModel().getValueAt(row, 4);
           int quantity = (int)tbl_Product.getModel().getValueAt(row, 5);
           int status = 0;
           Product p = new Product(productID, productName, categoryID, supplierID, price, quantity, status);
            productBUS.SetProduct(p);
            refresh();
            resetText();
            row = -1;
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetText(){
        jlb_productID.setText("...");
        txt_productName.setText("");
        txt_category.setText("");
        txt_supplierID.setText("");
        txt_price.setText("");
        txt_quantity.setText("");
    }
    
    private void refresh(){
        try {
            productBUS.listProduct();
            productls = productBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(productls);
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
        tbl_Product = new javax.swing.JTable();
        btn_restore = new javax.swing.JToggleButton();
        btn_del = new javax.swing.JToggleButton();
        btn_Update = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        sdtJbl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tenkhachJlb = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tenkhachJlb1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tenkhachJlb2 = new javax.swing.JTextField();
        jlb_productID = new javax.swing.JLabel();
        jlb_productName = new javax.swing.JLabel();
        txt_productName = new javax.swing.JTextField();
        jlb_category = new javax.swing.JLabel();
        txt_category = new javax.swing.JTextField();
        jlb_supplier = new javax.swing.JLabel();
        txt_supplierID = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btn_add1 = new javax.swing.JToggleButton();
        jlb_price = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jlb_quantity = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        jlb_productID1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Course Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 261, 77));

        tbl_Product.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Product.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productID", "productName", "category", "supplier", "price", "quantity"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Product.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Product.setRowHeight(40);
    tbl_Product.setRowMargin(2);
    tbl_Product.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Product.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Product.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_ProductMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Product);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1270, 157));

    btn_restore.setBackground(new java.awt.Color(102, 255, 102));
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
    btn_del.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del.setForeground(new java.awt.Color(255, 255, 255));
    btn_del.setText("Xóa");
    btn_del.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_delActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 230, 90));

    btn_Update.setBackground(new java.awt.Color(102, 255, 102));
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
    jLabel3.setText("Search:");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 146, 50));

    sdtJbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    sdtJbl.setForeground(new java.awt.Color(255, 153, 51));
    sdtJbl.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            sdtJblActionPerformed(evt);
        }
    });
    jPanel1.add(sdtJbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 190, 52));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("TeacherID:");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 138, 52));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 153, 51));
    jLabel6.setText("HireDate:");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 490, 110, 52));

    tenkhachJlb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    tenkhachJlb.setForeground(new java.awt.Color(255, 153, 51));
    tenkhachJlb.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tenkhachJlbActionPerformed(evt);
        }
    });
    jPanel1.add(tenkhachJlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 490, 250, 52));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 1270, 10));

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 51));
    jLabel9.setText("Lastname:");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 110, 52));

    tenkhachJlb1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    tenkhachJlb1.setForeground(new java.awt.Color(255, 153, 51));
    tenkhachJlb1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tenkhachJlb1ActionPerformed(evt);
        }
    });
    jPanel1.add(tenkhachJlb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 200, 52));

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 153, 51));
    jLabel10.setText("Firstname:");
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 110, 52));

    tenkhachJlb2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    tenkhachJlb2.setForeground(new java.awt.Color(255, 153, 51));
    tenkhachJlb2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tenkhachJlb2ActionPerformed(evt);
        }
    });
    jPanel1.add(tenkhachJlb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 200, 52));

    jlb_productID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_productID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_productID.setText("...");
    jPanel1.add(jlb_productID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 138, 52));

    jlb_productName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_productName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_productName.setText("Name:");
    jPanel1.add(jlb_productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 70, 52));

    txt_productName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_productName.setForeground(new java.awt.Color(255, 153, 51));
    txt_productName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_productNameActionPerformed(evt);
        }
    });
    jPanel1.add(txt_productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 200, 52));

    jlb_category.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_category.setForeground(new java.awt.Color(255, 153, 51));
    jlb_category.setText("Category:");
    jPanel1.add(jlb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 110, 52));

    txt_category.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_category.setForeground(new java.awt.Color(255, 153, 51));
    txt_category.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_categoryActionPerformed(evt);
        }
    });
    jPanel1.add(txt_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 260, 200, 52));

    jlb_supplier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_supplier.setForeground(new java.awt.Color(255, 153, 51));
    jlb_supplier.setText("Supplier:");
    jPanel1.add(jlb_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 140, 52));

    txt_supplierID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_supplierID.setForeground(new java.awt.Color(255, 153, 51));
    txt_supplierID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_supplierIDActionPerformed(evt);
        }
    });
    jPanel1.add(txt_supplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 250, 52));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1270, 10));

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

    jlb_price.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_price.setForeground(new java.awt.Color(255, 153, 51));
    jlb_price.setText("Price:");
    jPanel1.add(jlb_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 60, 52));

    txt_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_price.setForeground(new java.awt.Color(255, 153, 51));
    txt_price.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_priceActionPerformed(evt);
        }
    });
    jPanel1.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 190, 52));

    jlb_quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_quantity.setForeground(new java.awt.Color(255, 153, 51));
    jlb_quantity.setText("Quantity:");
    jPanel1.add(jlb_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 138, 52));

    txt_quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_quantity.setForeground(new java.awt.Color(255, 153, 51));
    txt_quantity.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_quantityActionPerformed(evt);
        }
    });
    jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 340, 190, 52));

    jlb_productID1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_productID1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_productID1.setText("ProductID:");
    jPanel1.add(jlb_productID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 138, 52));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProductMouseClicked
        showProductValue(productls);
    }//GEN-LAST:event_tbl_ProductMouseClicked

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
//        CourseRecovery a = new CourseRecovery();
//        a.setVisible(true);

    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        delProduct();

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
//        editCourse();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
        
      

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void sdtJblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtJblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtJblActionPerformed

    private void tenkhachJlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlbActionPerformed

    private void tenkhachJlb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlb1ActionPerformed

    private void tenkhachJlb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlb2ActionPerformed

    private void txt_productNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productNameActionPerformed

    private void txt_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryActionPerformed

    private void txt_supplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_supplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_supplierIDActionPerformed

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        try {
           AddProduct p = new AddProduct();
            p.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window Vista".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ProductManagement().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JToggleButton btn_Update;
    private javax.swing.JToggleButton btn_add1;
    private javax.swing.JToggleButton btn_del;
    private javax.swing.JToggleButton btn_restore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_category;
    private javax.swing.JLabel jlb_price;
    private javax.swing.JLabel jlb_productID;
    private javax.swing.JLabel jlb_productID1;
    private javax.swing.JLabel jlb_productName;
    private javax.swing.JLabel jlb_quantity;
    private javax.swing.JLabel jlb_supplier;
    private javax.swing.JTextField sdtJbl;
    private javax.swing.JTable tbl_Product;
    private javax.swing.JTextField tenkhachJlb;
    private javax.swing.JTextField tenkhachJlb1;
    private javax.swing.JTextField tenkhachJlb2;
    private javax.swing.JTextField txt_category;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_productName;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_supplierID;
    // End of variables declaration//GEN-END:variables
}
