/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.AccountBUS;
import DTO.Staff;
import BUS.StaffBUS;
import DTO.Account;
import DTO.Staff;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author donha
 */
public class AccountManagement extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    AccountBUS accountBUS = new AccountBUS();
    StaffBUS staffBUS = new StaffBUS();
    ArrayList<Staff> staffls = staffBUS.getList();
    ArrayList<Account> accountls = accountBUS.getList();
    int staffID;
    
    public AccountManagement(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        staffBUS.listStaff();
        accountBUS.listAccount();
//        AutoCompleteDecorator.decorate(StaffIDJComboBox);
//        ArrayList<Integer> staffCombo = new ArrayList();
//            for(Staff s: staffls ){
//                if(accountBUS.CheckStaff(s.getStaffID())){
//                    if(s.getStatus() == 1){
//                        staffCombo.add(s.getStaffID());
//                    }
//                }    
//            }
//            for(int i=0; i<staffCombo.size(); i++){
//                StaffIDJComboBox.addItem(String.valueOf(staffCombo.get(i)));
//            }
//        setValueDiscountJcombo(discount);
        showTable(accountls);
    }
    
    private void showTable(ArrayList<Account> accountls)
    {   
        tbl_Account.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Account.getModel();
        defaultModel.setRowCount(0);
        for(Account a : accountls)
        {
            if(a.getStatus() == 1){
                    int accountID = a.getAccountID();
                    String accountName = a.getAccountName();
                    String password = a.getPassword();
                    int staffIDa = a.getStaffID();
                    defaultModel.addRow(new Object[]{accountID, accountName, password, staffIDa});
                    
            }
        }
    }
    
    private void showAccountValue(ArrayList<Account> accountls)
    {
        
        int row = tbl_Account.getSelectedRow();
        jlb_accountID.setText(tbl_Account.getModel().getValueAt(row, 0).toString());
        txt_accountName.setText(tbl_Account.getModel().getValueAt(row, 1).toString());
        txt_password.setText(tbl_Account.getModel().getValueAt(row, 2).toString());
//        StaffIDJComboBox.setSelectedItem(tbl_Account.getModel().getValueAt(row, 3).toString());
        jlb_staffID.setText(tbl_Account.getModel().getValueAt(row, 3).toString());
    }
    
    private void editAccount()
    {
        int staffID, accountID;
        String accountName = "", password;
        int row = tbl_Account.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn tài khoản để sửa", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
            accountID = Integer.parseInt(jlb_staffID.getText());
            for(Account a: accountls){
                if(txt_accountName.getText().isEmpty() || txt_accountName.getText().isBlank() || txt_accountName.getText().matches("accountname") || txt_accountName.getText().equals(a.getAccountName())){
                    JOptionPane.showMessageDialog(rootPane, "Tên tài khoản không hợp lệ","Dialog",JOptionPane.ERROR_MESSAGE);
                    return;
                } accountName = txt_accountName.getText();
            }
            if(txt_password.getText().isEmpty() || txt_password.getText().isBlank()){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập mật khẩu ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }password = txt_accountName.getText();
//            staffID = Integer.parseInt(StaffIDJComboBox.getSelectedItem().toString());
            staffID = Integer.parseInt(jlb_staffID.getText());

            int status =1; 
         
            Account a = new Account(accountID, accountName, password, staffID, status);
            int response = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa tài khoản nhân viên "+ staffID +" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
            if(response == JOptionPane.YES_OPTION){
                accountBUS.SetAccount(a);
                refresh();
                resetText();
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                return;
            }
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void delAccount(){
    int row = tbl_Account.getSelectedRow();    
    try {    
      if(row < 0)
      {
        JOptionPane.showMessageDialog(new JFrame(), "Chọn tài khoản cần xoá", "Dialog",
        JOptionPane.ERROR_MESSAGE);
        return; 
      }
         
      int accountID = Integer.parseInt(tbl_Account.getModel().getValueAt(row, 0).toString());
      String accountName = tbl_Account.getModel().getValueAt(row, 1).toString();
      String password = tbl_Account.getModel().getValueAt(row, 2).toString();
      int staffID = Integer.parseInt(tbl_Account.getModel().getValueAt(row, 3).toString());
      int status = 0;
      Account a = new Account(accountID, accountName, password, staffID, status);
      int response = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa tài khoản không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
      if(response == JOptionPane.YES_OPTION){
        accountBUS.SetAccount(a);
        refresh();
        resetText();
        JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
        return;
      }
      row = -1;
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetText(){
        jlb_accountID.setText("...");
        txt_accountName.setText("");
        txt_password.setText("");
        jlb_staffID.setText("...");
//        StaffIDJComboBox.setSelectedItem(this.staffID);
    }
    
    private void refresh(){
        try {
            accountBUS.listAccount();
            accountls = accountBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(accountls);
    }
    
    private void search(){
        String accountID = txt_sAccountID.getText();
        String accountName = txt_sAccountName.getText();
        String staffID = txt_sStaffID.getText();
        
        showTable(accountBUS.search(accountID, accountName, staffID));
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
        tbl_Account = new javax.swing.JTable();
        btn_restore = new javax.swing.JToggleButton();
        btn_del = new javax.swing.JToggleButton();
        btn_Update = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txt_sAccountID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_sStaffID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txt_sAccountName = new javax.swing.JTextField();
        jlb_staffID = new javax.swing.JLabel();
        jlb_lastName = new javax.swing.JLabel();
        txt_accountName = new javax.swing.JTextField();
        jlb_email = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btn_add1 = new javax.swing.JToggleButton();
        jlb_staff = new javax.swing.JLabel();
        jlb_firstName1 = new javax.swing.JLabel();
        jlb_accountID = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Account Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 300, 77));

        tbl_Account.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Account.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Account.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account ID", "Account Name", "Password", "Staff ID"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Account.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Account.setRowHeight(40);
    tbl_Account.setRowMargin(2);
    tbl_Account.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Account.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Account.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_AccountMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Account);

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
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 80, 50));

    txt_sAccountID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sAccountID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sAccountID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sAccountIDActionPerformed(evt);
        }
    });
    txt_sAccountID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sAccountIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sAccountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 150, 52));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("Account ID:");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 120, 52));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 153, 51));
    jLabel6.setText("Staff ID:");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 90, 52));

    txt_sStaffID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sStaffID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sStaffID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sStaffIDActionPerformed(evt);
        }
    });
    txt_sStaffID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sStaffIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sStaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 150, 52));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1340, 10));

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 51));
    jLabel9.setText("Account Name:");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 490, 150, 52));

    txt_sAccountName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sAccountName.setForeground(new java.awt.Color(255, 153, 51));
    txt_sAccountName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sAccountNameActionPerformed(evt);
        }
    });
    txt_sAccountName.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sAccountNameKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sAccountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 490, 320, 52));

    jlb_staffID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_staffID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_staffID.setText("...");
    jPanel1.add(jlb_staffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 138, 52));

    jlb_lastName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_lastName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_lastName.setText("Password:");
    jPanel1.add(jlb_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 110, 52));

    txt_accountName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_accountName.setForeground(new java.awt.Color(255, 153, 51));
    txt_accountName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_accountNameActionPerformed(evt);
        }
    });
    jPanel1.add(txt_accountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 350, 52));

    jlb_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_email.setForeground(new java.awt.Color(255, 153, 51));
    jlb_email.setText("Staff ID:");
    jPanel1.add(jlb_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 80, 52));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1360, 10));

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

    jlb_staff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_staff.setForeground(new java.awt.Color(255, 153, 51));
    jlb_staff.setText("Account ID:");
    jPanel1.add(jlb_staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 120, 52));

    jlb_firstName1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_firstName1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_firstName1.setText("Account Name:");
    jPanel1.add(jlb_firstName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 150, 52));

    jlb_accountID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_accountID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_accountID.setText("...");
    jPanel1.add(jlb_accountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 138, 52));

    txt_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_password.setForeground(new java.awt.Color(255, 153, 51));
    txt_password.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_passwordActionPerformed(evt);
        }
    });
    jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 350, 52));

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

    private void tbl_AccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_AccountMouseClicked
        showAccountValue(accountls);
    }//GEN-LAST:event_tbl_AccountMouseClicked

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        AccountRecovery a = new AccountRecovery();
        a.setVisible(true);

    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        delAccount();

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
            editAccount();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
//        showTable();

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_sAccountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sAccountIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sAccountIDActionPerformed

    private void txt_sStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sStaffIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sStaffIDActionPerformed

    private void txt_sAccountNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sAccountNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sAccountNameActionPerformed

    private void txt_accountNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_accountNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_accountNameActionPerformed

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
//        AddCourse a = new AddCourse();
    try {
           AddAccount a = new AddAccount();
            a.setVisible(true);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_sAccountIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sAccountIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sAccountIDKeyReleased

    private void txt_sAccountNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sAccountNameKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sAccountNameKeyReleased

    private void txt_sStaffIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sStaffIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sStaffIDKeyReleased

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

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
//                    new StaffManagement().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(StaffManagement.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JToggleButton btn_Update;
    private javax.swing.JToggleButton btn_add1;
    private javax.swing.JToggleButton btn_del;
    private javax.swing.JToggleButton btn_restore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_accountID;
    private javax.swing.JLabel jlb_email;
    private javax.swing.JLabel jlb_firstName1;
    private javax.swing.JLabel jlb_lastName;
    private javax.swing.JLabel jlb_staff;
    private javax.swing.JLabel jlb_staffID;
    private javax.swing.JTable tbl_Account;
    private javax.swing.JTextField txt_accountName;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_sAccountID;
    private javax.swing.JTextField txt_sAccountName;
    private javax.swing.JTextField txt_sStaffID;
    // End of variables declaration//GEN-END:variables
}
