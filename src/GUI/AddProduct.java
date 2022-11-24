package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
//import DTO.Customer;
//import BUS.CustomerBUS;

import BUS.CategoryBUS;
import BUS.ProductBUS;
import BUS.SupplierBUS;
import DTO.Product;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static org.apache.logging.log4j.util.Strings.isEmpty;


/**
 *
 * @author LacKhaiMinh
 */
public class AddProduct extends javax.swing.JFrame {

    ProductBUS productBUS = new ProductBUS() ;
    CategoryBUS categoryBUS = new CategoryBUS() ;
    SupplierBUS supplierBUS = new SupplierBUS() ;    
   
    public AddProduct() throws ClassNotFoundException {
        initComponents();
        productBUS.listProduct();
        categoryBUS.listCategory();
        supplierBUS.listSupplier();

        
    }
    
    private boolean isNumeric(CharSequence cs) {
        if (isEmpty(cs)) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public void refeshText(){
        txt_productID.setText("ProductID");
        txt_productName.setText("productName");
        txt_category.setText("Category");
        txt_supplierID.setText("DepartmentID");
        txt_price.setText("Price");
        txt_quantity.setText("Quantity");
    }

    
    
    public void addProduct(){
        int productID, category ,supplierID, quantity;
        float price;
        System.out.println(isNumeric(txt_productID.getText()));
        try {
            if(!isNumeric(txt_productID.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Mã sản phẩm không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else productID = Integer.parseInt(txt_productID.getText());
            
            if(!isNumeric(txt_category.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Mã loại không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else category = Integer.parseInt(txt_category.getText());
            
            if(!isNumeric(txt_supplierID.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Mã nhà cung cấp không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else supplierID = Integer.parseInt(txt_supplierID.getText());
                        
            if(!isNumeric(txt_price.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Giá tiền không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else price = Float.parseFloat(txt_price.getText()); 
            
            if(!isNumeric(txt_quantity.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Số lượng không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else quantity = Integer.parseInt(txt_quantity.getText());
            
            String productName = txt_productName.getText();
            int status = 1;
            Product p = new Product(productID, productName, category, supplierID, price, quantity, status);
            
            if(!productBUS.CheckProductID(productID)) {
                if(categoryBUS.CheckCategoryID(category)){
                    if(supplierBUS.CheckSupplierID(supplierID)){
                        productBUS.AddProduct(p);
                        this.refeshText();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Mã Nhà cung cấp không có trong dữ liệu", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Mã loại không có trong dữ liệu", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
                }

            }    
            else {
               JOptionPane.showMessageDialog(new JFrame(), "Mã sản phẩm bị trùng", "Dialog",
               JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_productID = new javax.swing.JTextField();
        txt_category = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_productName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_supplierID = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txt_quantity = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD PRODUCT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD PRODUCT");

        txt_productID.setBackground(new java.awt.Color(255, 153, 51));
        txt_productID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_productID.setForeground(new java.awt.Color(255, 255, 255));
        txt_productID.setText("ProductID");
        txt_productID.setBorder(null);
        txt_productID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_productIDFocusGained(evt);
            }
        });
        txt_productID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_productIDActionPerformed(evt);
            }
        });

        txt_category.setBackground(new java.awt.Color(255, 153, 51));
        txt_category.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_category.setForeground(new java.awt.Color(255, 255, 255));
        txt_category.setText("Category");
        txt_category.setBorder(null);
        txt_category.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_categoryFocusGained(evt);
            }
        });
        txt_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoryActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_50px_4.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_productName.setBackground(new java.awt.Color(255, 153, 51));
        txt_productName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_productName.setForeground(new java.awt.Color(255, 255, 255));
        txt_productName.setText("ProductName");
        txt_productName.setBorder(null);
        txt_productName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_productNameFocusGained(evt);
            }
        });
        txt_productName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_productNameActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        txt_supplierID.setBackground(new java.awt.Color(255, 153, 51));
        txt_supplierID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_supplierID.setForeground(new java.awt.Color(255, 255, 255));
        txt_supplierID.setText("SupplierID");
        txt_supplierID.setBorder(null);
        txt_supplierID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_supplierIDFocusGained(evt);
            }
        });
        txt_supplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_supplierIDActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        txt_quantity.setBackground(new java.awt.Color(255, 153, 51));
        txt_quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_quantity.setForeground(new java.awt.Color(255, 255, 255));
        txt_quantity.setText("Quantity");
        txt_quantity.setBorder(null);
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_quantityFocusGained(evt);
            }
        });
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });

        txt_price.setBackground(new java.awt.Color(255, 153, 51));
        txt_price.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_price.setForeground(new java.awt.Color(255, 255, 255));
        txt_price.setText("Price");
        txt_price.setBorder(null);
        txt_price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_priceFocusGained(evt);
            }
        });
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator6.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_category, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_productID, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_price, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_supplierID)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_productName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                        .addComponent(jSeparator4))
                                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_productID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_productName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_category, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_supplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_productIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_productIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        String Phone = customerPhoneTxt.getText();
//        String Name = customerNameTxt.getText();
//          
//        if(CustomerBUS.check(Phone)){
//            JOptionPane.showMessageDialog(null, "Số điện thoại bạn nhập đã tồn tại");
//        }else{
//            if(Name.equals("")){
//                JOptionPane.showMessageDialog(null, "Vui lòng nhập tên khách");
//            }else if(Phone.equals("")){
//                JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại khách");
//            }else{
//                JOptionPane.showMessageDialog(null, "Khách hàng đã được thêm");
//                Customer a = new Customer(Phone,Name);
//                CustomerBUS.addCustomer(a);
//                this.dispose();
//        }
//        }
        addProduct();
//        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_productIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_productIDFocusGained
        // TODO add your handling code here:
        txt_productID.setText("");
    }//GEN-LAST:event_txt_productIDFocusGained

    private void txt_categoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_categoryFocusGained
        // TODO add your handling code here:
        txt_category.setText("");
    }//GEN-LAST:event_txt_categoryFocusGained

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.refeshText();
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void txt_productNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_productNameFocusGained
        // TODO add your handling code here:
        txt_productName.setText("");
    }//GEN-LAST:event_txt_productNameFocusGained

    private void txt_productNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productNameActionPerformed

    private void txt_supplierIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_supplierIDFocusGained
        // TODO add your handling code here:
        txt_supplierID.setText("");
    }//GEN-LAST:event_txt_supplierIDFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryActionPerformed

    private void txt_supplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_supplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_supplierIDActionPerformed

    private void txt_quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusGained
        // TODO add your handling code here:
        txt_quantity.setText("");
    }//GEN-LAST:event_txt_quantityFocusGained

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void txt_priceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_priceFocusGained
        // TODO add your handling code here:
        txt_price.setText("");
    }//GEN-LAST:event_txt_priceFocusGained

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField txt_category;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_productID;
    private javax.swing.JTextField txt_productName;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_supplierID;
    // End of variables declaration//GEN-END:variables
}
