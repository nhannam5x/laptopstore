package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
//import DTO.Customer;
//import BUS.CustomerBUS;

import BUS.CustomerBUS;
import DTO.Customer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static org.apache.logging.log4j.util.Strings.isEmpty;


/**
 *
 * @author LacKhaiMinh
 */
public class AddCustomer extends javax.swing.JFrame {

    CustomerBUS customerBUS = new CustomerBUS() ;
   
    public AddCustomer() throws ClassNotFoundException {
        initComponents();
        customerBUS.listCustomer();

        
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
    
    private static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    
    private static boolean isValidPhone(String phone1) {
        boolean isValid = phone1.matches("^0[987654321]{1}\\d{8}$");
        return isValid;
    }
    
    public void refeshText(){
        txt_customerID.setText("CustomerID");
        txt_firstName.setText("FirstName");
        txt_lastName.setText("LastName");
        txt_email.setText("Email");
        txt_phone.setText("Phone");
    }

    
    
    public void addCustomer(){
        int customerID;
        String email, phone, firstName, lastName;
        System.out.println(isValidPhone(txt_phone.getText()));
        try {
            if(!isNumeric(txt_customerID.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Mã khách hàng không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else customerID = Integer.parseInt(txt_customerID.getText());
            
            if(txt_firstName.getText().equals("") || txt_firstName.getText().equals("FirstName")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }firstName = txt_firstName.getText();
            
            if(txt_lastName.getText().equals("") || txt_lastName.getText().equals("LastName")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập họ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }lastName = txt_lastName.getText();
            
            if(!isValidEmailAddress(txt_email.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Email không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else email = txt_email.getText();
            
            if(!isValidPhone(txt_phone.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Số điện thoại không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else phone = txt_phone.getText();
            
            
            int status = 1;
            Customer cu = new Customer(customerID, firstName, lastName, email, phone, status);
            
            if(!customerBUS.CheckCustomerID(customerID)) {
                        customerBUS.AddCustomer(cu);
                        this.refeshText();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Mã khách hàng bị trùng", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                    }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_customerID = new javax.swing.JTextField();
        txt_lastName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_firstName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_email = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txt_phone = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD CUSTOMER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD CUSTOMER");

        txt_customerID.setBackground(new java.awt.Color(255, 153, 51));
        txt_customerID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_customerID.setForeground(new java.awt.Color(255, 255, 255));
        txt_customerID.setText("CustomerID");
        txt_customerID.setBorder(null);
        txt_customerID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_customerIDFocusGained(evt);
            }
        });
        txt_customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customerIDActionPerformed(evt);
            }
        });

        txt_lastName.setBackground(new java.awt.Color(255, 153, 51));
        txt_lastName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_lastName.setForeground(new java.awt.Color(255, 255, 255));
        txt_lastName.setText("LastName");
        txt_lastName.setBorder(null);
        txt_lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_lastNameFocusGained(evt);
            }
        });
        txt_lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lastNameActionPerformed(evt);
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

        txt_firstName.setBackground(new java.awt.Color(255, 153, 51));
        txt_firstName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_firstName.setForeground(new java.awt.Color(255, 255, 255));
        txt_firstName.setText("FirstName");
        txt_firstName.setBorder(null);
        txt_firstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_firstNameFocusGained(evt);
            }
        });
        txt_firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_firstNameActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        txt_email.setBackground(new java.awt.Color(255, 153, 51));
        txt_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setText("Email");
        txt_email.setBorder(null);
        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_emailFocusGained(evt);
            }
        });
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        txt_phone.setBackground(new java.awt.Color(255, 153, 51));
        txt_phone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_phone.setForeground(new java.awt.Color(255, 255, 255));
        txt_phone.setText("Phone");
        txt_phone.setBorder(null);
        txt_phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_phoneFocusGained(evt);
            }
        });
        txt_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_lastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_customerID, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_phone)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(txt_customerID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
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

    private void txt_customerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customerIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_customerIDActionPerformed

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
        addCustomer();
//        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_customerIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_customerIDFocusGained
        // TODO add your handling code here:
        txt_customerID.setText("");
    }//GEN-LAST:event_txt_customerIDFocusGained

    private void txt_lastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_lastNameFocusGained
        // TODO add your handling code here:
        txt_lastName.setText("");
    }//GEN-LAST:event_txt_lastNameFocusGained

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.refeshText();
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void txt_firstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_firstNameFocusGained
        // TODO add your handling code here:
        txt_firstName.setText("");
    }//GEN-LAST:event_txt_firstNameFocusGained

    private void txt_firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_firstNameActionPerformed

    private void txt_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusGained
        // TODO add your handling code here:
        txt_email.setText("");
    }//GEN-LAST:event_txt_emailFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastNameActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_phoneFocusGained
        // TODO add your handling code here:
        txt_phone.setText("");
    }//GEN-LAST:event_txt_phoneFocusGained

    private void txt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneActionPerformed

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
    private javax.swing.JTextField txt_customerID;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
