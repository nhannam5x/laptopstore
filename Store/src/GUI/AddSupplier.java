package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
//import DTO.Customer;
//import BUS.CustomerBUS;

import BUS.SupplierBUS;
import DTO.Supplier;
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
public class AddSupplier extends javax.swing.JFrame {

    SupplierBUS supplierBUS = new SupplierBUS() ;
   
    public AddSupplier() throws ClassNotFoundException {
        initComponents();
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
        txt_supplierID.setText("supplierID");
        txt_supplierName.setText("supplierName");
        txt_address.setText("address");
    }

    
    
    public void addSupplier(){
        int supplierID;
        String supplierName, address;
        System.out.println(isNumeric(txt_supplierID.getText()));
        try {
            
            if(!isNumeric(txt_supplierID.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Mã nhà cung cấp không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else supplierID = Integer.parseInt(txt_supplierID.getText());
            
            if(txt_supplierName.getText().equals("") || txt_supplierName.getText().equals("SupplierName")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }supplierName = txt_supplierName.getText();
            
            if(txt_address.getText().equals("") || txt_address.getText().equals("Address")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập địa chỉ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }address = txt_address.getText();
            int status = 1;
            Supplier s = new Supplier(supplierID, supplierName, address, status);
            
            if(!supplierBUS.CheckSupplierID(supplierID)) {
                        supplierBUS.AddSupplier(s);
                        this.refeshText();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Mã nhà cung cấp bị trùng", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                    }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_supplierID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_supplierName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_address = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        jSeparator4.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD SUPPLIER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD SUPPLIER");

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

        txt_supplierName.setBackground(new java.awt.Color(255, 153, 51));
        txt_supplierName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_supplierName.setForeground(new java.awt.Color(255, 255, 255));
        txt_supplierName.setText("SupplierName");
        txt_supplierName.setBorder(null);
        txt_supplierName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_supplierNameFocusGained(evt);
            }
        });
        txt_supplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_supplierNameActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        txt_address.setBackground(new java.awt.Color(255, 153, 51));
        txt_address.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_address.setForeground(new java.awt.Color(255, 255, 255));
        txt_address.setText("Address");
        txt_address.setBorder(null);
        txt_address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_addressFocusGained(evt);
            }
        });
        txt_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addressActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_supplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
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
                    .addComponent(txt_supplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_supplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
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

    private void txt_supplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_supplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_supplierNameActionPerformed

    private void txt_supplierNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_supplierNameFocusGained
        // TODO add your handling code here:
        txt_supplierName.setText("");
    }//GEN-LAST:event_txt_supplierNameFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.refeshText();
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void txt_supplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_supplierIDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_supplierIDActionPerformed

    private void txt_supplierIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_supplierIDFocusGained
        // TODO add your handling code here:
        txt_supplierID.setText("");
    }//GEN-LAST:event_txt_supplierIDFocusGained

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
        addSupplier();
        //
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_addressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_addressFocusGained
        // TODO add your handling code here:
        txt_address.setText("");
    }//GEN-LAST:event_txt_addressFocusGained

    private void txt_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addressActionPerformed

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
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_supplierID;
    private javax.swing.JTextField txt_supplierName;
    // End of variables declaration//GEN-END:variables
}
