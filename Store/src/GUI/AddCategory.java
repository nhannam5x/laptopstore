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
import DTO.Category;
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
public class AddCategory extends javax.swing.JFrame {

    CategoryBUS categoryBUS = new CategoryBUS() ;
   
    public AddCategory() throws ClassNotFoundException {
        initComponents();
        categoryBUS.listCategory();

        
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
        txt_categoryID.setText("ProductID");
        txt_categoryName.setText("productName");

    }

    
    
    public void addCategory(){
        int categoryID;
        String categoryName;
        System.out.println(isNumeric(txt_categoryID.getText()));
        try {
            
            if(!isNumeric(txt_categoryID.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Mã loại không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else categoryID = Integer.parseInt(txt_categoryID.getText());
            
            if(txt_categoryName.getText().equals("")||txt_categoryName.getText().equals("CategoryName")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên loại ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }categoryName = txt_categoryName.getText();
            int status = 1;
            Category c = new Category(categoryID, categoryName, status);
            
            if(!categoryBUS.CheckCategoryID(categoryID)) {
                        categoryBUS.AddCategory(c);
                        this.refeshText();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Mã loại bị trùng", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                    }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_categoryID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_categoryName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD CATEGORY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD CATEGORY");

        txt_categoryID.setBackground(new java.awt.Color(255, 153, 51));
        txt_categoryID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_categoryID.setForeground(new java.awt.Color(255, 255, 255));
        txt_categoryID.setText("CategoryID");
        txt_categoryID.setBorder(null);
        txt_categoryID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_categoryIDFocusGained(evt);
            }
        });
        txt_categoryID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoryIDActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

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

        txt_categoryName.setBackground(new java.awt.Color(255, 153, 51));
        txt_categoryName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_categoryName.setForeground(new java.awt.Color(255, 255, 255));
        txt_categoryName.setText("CategoryName");
        txt_categoryName.setBorder(null);
        txt_categoryName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_categoryNameFocusGained(evt);
            }
        });
        txt_categoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoryNameActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(txt_categoryID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_categoryName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
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
                    .addComponent(txt_categoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_categoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
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

    private void txt_categoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryNameActionPerformed

    private void txt_categoryNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_categoryNameFocusGained
        // TODO add your handling code here:
        txt_categoryName.setText("");
    }//GEN-LAST:event_txt_categoryNameFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.refeshText();
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void txt_categoryIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoryIDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_categoryIDActionPerformed

    private void txt_categoryIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_categoryIDFocusGained
        // TODO add your handling code here:
        txt_categoryID.setText("");
    }//GEN-LAST:event_txt_categoryIDFocusGained

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
        addCategory();
        //
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txt_categoryID;
    private javax.swing.JTextField txt_categoryName;
    // End of variables declaration//GEN-END:variables
}
