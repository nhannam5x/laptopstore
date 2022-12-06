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
public class AccountCheck extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    AccountBUS accountBUS = new AccountBUS();
    StaffBUS staffBUS = new StaffBUS();
    ArrayList<Staff> staffls = staffBUS.getList();
    ArrayList<Account> accountls = accountBUS.getList();
    int staffID;

    
    public AccountCheck(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        staffBUS.listStaff();
        accountBUS.listAccount();
        jlb_acctit.setText("Staff "+this.staffID+"'s Account");
//        setValueDiscountJcombo(discount);
        showTable(accountls);
    }
    
    private void showTable(ArrayList<Account> accountls)
    {   
        tbl_Staff.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Staff.getModel();
        defaultModel.setRowCount(0);
        for(Account a : accountls)
        {
            if(a.getStatus() == 1){
                if(a.getStaffID() == this.staffID){
                    int accountID = a.getAccountID();
                    String accountName = a.getAccountName();
                    String password = a.getPassword();
                    int staffID = a.getStaffID();
                    defaultModel.addRow(new Object[]{accountID, accountName, password, staffID});
                    
                }
            }
        }
    }
    
    private void showAccountValue(ArrayList<Account> accountls)
    {
        
        int row = tbl_Staff.getSelectedRow();
        jlb_accountID.setText(tbl_Staff.getModel().getValueAt(row, 0).toString());
        jlb_accountName.setText(tbl_Staff.getModel().getValueAt(row, 1).toString());
        txt_password.setText(tbl_Staff.getModel().getValueAt(row, 2).toString());
    }
    
    private void editAccount()
    {
        int staffID = this.staffID, accountID;
        String accountName, password;
        int row = tbl_Staff.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn trên table để sửa", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
            accountID = Integer.parseInt(jlb_accountID.getText());
            accountName = jlb_accountName.getText();
            if(txt_password.getText().equals("")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập mật khẩu ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }password = txt_password.getText();
            

            int status =1; 
         
            Account a = new Account(accountID, accountName, password, staffID, status);
            int response = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa lại mật khẩu không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
            if(response == JOptionPane.YES_OPTION){
                accountBUS.SetAccount(a);
                refresh();
                resetText();
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                return;
            }
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(AccountCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    private void delStaff(){
//    int row = tbl_Staff.getSelectedRow();    
//    try {    
//      if(row < 0)
//      {
//        JOptionPane.showMessageDialog(new JFrame(), "Chọn sản phẩm cần xoá", "Dialog",
//        JOptionPane.ERROR_MESSAGE);
//        return; 
//      }
//         
//      int staffID = (int)tbl_Staff.getModel().getValueAt(row, 0);
//      String firstName = tbl_Staff.getModel().getValueAt(row, 1).toString();
//      String lastName = tbl_Staff.getModel().getValueAt(row, 2).toString();
//      String email = tbl_Staff.getModel().getValueAt(row, 3).toString();
//      String phone = tbl_Staff.getModel().getValueAt(row, 4).toString();
//      int status = 0;
//      Staff s = new Staff(staffID, firstName, lastName, email, phone, status);
//      int response = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa sản phẩm "+ staffID +" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
//      if(response == JOptionPane.YES_OPTION){
//        staffBUS.SetStaff(s);
//        refresh();
//        resetText();
//        JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
//        return;
//      }
//      row = -1;
//            
//        } catch (ClassNotFoundException ex) { 
//            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    private void resetText(){
        jlb_accountID.setText("...");
        jlb_accountName.setText("...");
        txt_password.setText("");
    }
    
    private void refresh(){
        try {
            accountBUS.listAccount();
            accountls = accountBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountCheck.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(accountls);
    }
    
//    private void search(){
//        String staffID = txt_sStaffID.getText();
//        String firstName = txt_sFirstName.getText();
//        String lastName = txt_sLastName.getText();
//        String email = txt_sEmail.getText();
//        String phone = txt_sPhone.getText();
//        showTable(staffBUS.search(staffID, firstName, lastName, email, phone));
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlb_acctit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Staff = new javax.swing.JTable();
        btn_Update = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jlb_accountID = new javax.swing.JLabel();
        jlb_accountName = new javax.swing.JLabel();
        jlb_lastName = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        jlb_staff = new javax.swing.JLabel();
        jlb_firstName1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlb_acctit.setBackground(new java.awt.Color(255, 255, 255));
        jlb_acctit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlb_acctit.setForeground(new java.awt.Color(255, 153, 51));
        jlb_acctit.setText("...");
        jPanel1.add(jlb_acctit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 300, 77));

        tbl_Staff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Staff.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Staff.setModel(new javax.swing.table.DefaultTableModel(
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
    tbl_Staff.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Staff.setRowHeight(40);
    tbl_Staff.setRowMargin(2);
    tbl_Staff.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Staff.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Staff.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_StaffMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Staff);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1290, 157));

    btn_Update.setBackground(new java.awt.Color(51, 51, 255));
    btn_Update.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Update.setForeground(new java.awt.Color(255, 255, 255));
    btn_Update.setText("Sửa");
    btn_Update.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_UpdateActionPerformed(evt);
        }
    });
    jPanel1.add(btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, 230, 90));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1340, 10));

    jlb_accountID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_accountID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_accountID.setText("...");
    jPanel1.add(jlb_accountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 138, 52));

    jlb_accountName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_accountName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_accountName.setText("...");
    jPanel1.add(jlb_accountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 350, 52));

    jlb_lastName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_lastName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_lastName.setText("Password:");
    jPanel1.add(jlb_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 110, 52));

    txt_password.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_password.setForeground(new java.awt.Color(255, 153, 51));
    txt_password.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_passwordActionPerformed(evt);
        }
    });
    jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, 350, 52));

    jlb_staff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_staff.setForeground(new java.awt.Color(255, 153, 51));
    jlb_staff.setText("Account ID:");
    jPanel1.add(jlb_staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 120, 52));

    jlb_firstName1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_firstName1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_firstName1.setText("Account Name:");
    jPanel1.add(jlb_firstName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 150, 52));

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

    private void tbl_StaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StaffMouseClicked
        showAccountValue(accountls);
    }//GEN-LAST:event_tbl_StaffMouseClicked

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        editAccount();
    }//GEN-LAST:event_btn_UpdateActionPerformed

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
    private javax.swing.JToggleButton btn_Update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlb_accountID;
    private javax.swing.JLabel jlb_accountName;
    private javax.swing.JLabel jlb_acctit;
    private javax.swing.JLabel jlb_firstName1;
    private javax.swing.JLabel jlb_lastName;
    private javax.swing.JLabel jlb_staff;
    private javax.swing.JTable tbl_Staff;
    private javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables
}
