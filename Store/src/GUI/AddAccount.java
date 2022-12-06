package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
//import DTO.Customer;
//import BUS.CustomerBUS;

import BUS.StaffBUS;
import BUS.AccountBUS;
import DTO.Account;
import DTO.Staff;
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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author LacKhaiMinh
 */
public class AddAccount extends javax.swing.JFrame {

    StaffBUS staffBUS = new StaffBUS();
    AccountBUS accountBUS = new AccountBUS();
    ArrayList<Staff> staffls = staffBUS.getList();
    ArrayList<Account> accountls = accountBUS.getList();
    
    public AddAccount() throws ClassNotFoundException {
        initComponents();
        staffBUS.listStaff();
        accountBUS.listAccount();
        AutoCompleteDecorator.decorate(StaffIDJComboBox);
        ArrayList<Integer> staffCombo = new ArrayList();
            for(Staff s: staffls ){
                if(s.getStatus() ==1)
                if(!accountBUS.CheckStaff(s.getStaffID()))
                staffCombo.add(s.getStaffID());
            }
            for(int i=0; i<staffCombo.size(); i++){
                StaffIDJComboBox.addItem(String.valueOf(staffCombo.get(i)));
            }
        
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
        txt_accountID.setText("Accounnt ID");
        txt_accountName.setText("Account Name");
        txt_password.setText("Password");
        StaffIDJComboBox.setSelectedIndex(0);
    }

    
    
    public void addAccount() throws ClassNotFoundException{
        int accountID, staffID= Integer.parseInt(StaffIDJComboBox.getSelectedItem().toString()); ;
        String accountName = "", password;
        accountBUS.listAccount();
        
        try {
            if(!isNumeric(txt_accountID.getText()) || txt_accountID.getText().isEmpty()){
                JOptionPane.showMessageDialog(new JFrame(), "Mã tài khoản không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else accountID = Integer.parseInt(txt_accountID.getText());
            
            for(Account a: accountls){
            if(txt_accountName.getText().isBlank() || txt_accountName.getText().isEmpty() || txt_accountName.getText().matches("accountname") || txt_accountName.getText().equals(a.getAccountName())){
                JOptionPane.showMessageDialog(new JFrame(), "Tên tài khoản không hợp lệ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }accountName = txt_accountName.getText();
           
            }
            if(txt_password.getText().isEmpty() || txt_password.getText().isBlank()){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập mật khẩu ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }password = txt_password.getText();
            
            
            int status = 1;
            Account ac = new Account(accountID, accountName, password, staffID, status);
            
            if(!accountBUS.CheckAccountID(accountID)) {
                        accountBUS.AddAccount(ac);
                        this.refeshText();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Mã tài khoản bị trùng", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                    }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_accountID = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_accountName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        StaffIDJComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD ACCOUNT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD ACCOUNT");

        txt_accountID.setBackground(new java.awt.Color(255, 153, 51));
        txt_accountID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_accountID.setForeground(new java.awt.Color(255, 255, 255));
        txt_accountID.setText("AccountID");
        txt_accountID.setBorder(null);
        txt_accountID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_accountIDFocusGained(evt);
            }
        });
        txt_accountID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_accountIDActionPerformed(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(255, 153, 51));
        txt_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setText("Password");
        txt_password.setBorder(null);
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
        });
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
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

        txt_accountName.setBackground(new java.awt.Color(255, 153, 51));
        txt_accountName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_accountName.setForeground(new java.awt.Color(255, 255, 255));
        txt_accountName.setText("Account Name");
        txt_accountName.setBorder(null);
        txt_accountName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_accountNameFocusGained(evt);
            }
        });
        txt_accountName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_accountNameActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator4.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Staff ID:");

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
                                    .addComponent(txt_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txt_accountID, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_accountName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(StaffIDJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(txt_accountID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_accountName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StaffIDJComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
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

    private void txt_accountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_accountIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_accountIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
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
addAccount();
//        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_accountIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_accountIDFocusGained
        // TODO add your handling code here:
        txt_accountID.setText("");
    }//GEN-LAST:event_txt_accountIDFocusGained

    private void txt_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusGained
        // TODO add your handling code here:
        txt_password.setText("");
    }//GEN-LAST:event_txt_passwordFocusGained

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.refeshText();
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void txt_accountNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_accountNameFocusGained
        // TODO add your handling code here:
        txt_accountName.setText("");
    }//GEN-LAST:event_txt_accountNameFocusGained

    private void txt_accountNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_accountNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_accountNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> StaffIDJComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txt_accountID;
    private javax.swing.JTextField txt_accountName;
    private javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables
}
