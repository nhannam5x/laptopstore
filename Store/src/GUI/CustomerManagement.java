/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Customer;
import BUS.CustomerBUS;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.apache.logging.log4j.util.Strings.isEmpty;
/**
 *
 * @author donha
 */
public class CustomerManagement extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    CustomerBUS customerBUS = new CustomerBUS();
    ArrayList<Customer> customerls = customerBUS.getList();
    int staffID;
    
    public CustomerManagement(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        customerBUS.listCustomer();
        showTable(customerls);
    }
    
    private void showTable(ArrayList<Customer> customerls)
    {   
        tbl_Customer.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Customer.getModel();
        defaultModel.setRowCount(0);
        for(Customer cu : customerls)
        {
            if(cu.getStatus() == 1){
                int customerID = cu.getCustomerID();
                String firstName = cu.getFirstName();
                String lastName = cu.getLastName();
                String email = cu.getEmail();
                String phone = cu.getPhone();
                defaultModel.addRow(new Object[]{customerID, firstName, lastName, email, phone});
            }
        }
    }
    
    private void showCustomerValue(ArrayList<Customer> customerls)
    {
        
        int row = tbl_Customer.getSelectedRow();
        jlb_customerID.setText(tbl_Customer.getModel().getValueAt(row, 0).toString());
        txt_firstName.setText(tbl_Customer.getModel().getValueAt(row, 1).toString());
        txt_lastName.setText(tbl_Customer.getModel().getValueAt(row, 2).toString());
        txt_email.setText(tbl_Customer.getModel().getValueAt(row, 3).toString());
        txt_phone.setText(tbl_Customer.getModel().getValueAt(row, 4).toString());
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
    
     private void editCustomer()
    {
        int customerID;
        String email, phone,firstName, lastName;
        int row = tbl_Customer.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn khách hàng cần sửa", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           
           customerID = Integer.parseInt(jlb_customerID.getText());
           
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
           

           int status =1; 
         
           Customer cu = new Customer(customerID, firstName, lastName, email, phone, status);
           
           int response = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa khách hàng "+ customerID +" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
           if(response == JOptionPane.YES_OPTION){
               customerBUS.SetCustomer(cu);
               refresh();
               resetText();
               JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
               return;
           }
           
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void delCustomer(){
    int row = tbl_Customer.getSelectedRow();    
    try {    
      if(row < 0)
      {
        JOptionPane.showMessageDialog(new JFrame(), "Chọn khách hàng cần xoá", "Dialog",
        JOptionPane.ERROR_MESSAGE);
        return; 
      }
         
      int customerID = (int)tbl_Customer.getModel().getValueAt(row, 0);
      String firstName = tbl_Customer.getModel().getValueAt(row, 1).toString();
      String lastName = tbl_Customer.getModel().getValueAt(row, 2).toString();
      String email = tbl_Customer.getModel().getValueAt(row, 3).toString();
      String phone = tbl_Customer.getModel().getValueAt(row, 4).toString();
      int status = 0;
      Customer cu = new Customer(customerID, firstName, lastName, email, phone, status);
      int response = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa khách hàng "+ customerID +" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
           if(response == JOptionPane.YES_OPTION){
               customerBUS.SetCustomer(cu);
               refresh();
               resetText();
               JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
               return;
           }
      resetText();
      row = -1;
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetText(){
        jlb_customerID.setText("...");
        txt_firstName.setText("");
        txt_lastName.setText("");
        txt_email.setText("");
        txt_phone.setText("");
    }
    
    private void refresh(){
        try {
            customerBUS.listCustomer();
            customerls = customerBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(customerls);
    }
    
    private void search(){
        String customerID = txt_sCustomerID.getText();
        String firstName = txt_sFirstName.getText();
        String lastName = txt_sLastName.getText();
        String email = txt_sEmail.getText();
        String phone = txt_sPhone.getText();
        showTable(customerBUS.search(customerID, firstName, lastName, email, phone));
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
        tbl_Customer = new javax.swing.JTable();
        btn_restore = new javax.swing.JToggleButton();
        btn_del = new javax.swing.JToggleButton();
        btn_Update = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txt_sCustomerID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_sPhone = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txt_sFirstName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_sLastName = new javax.swing.JTextField();
        jlb_customerID = new javax.swing.JLabel();
        jlb_firstName = new javax.swing.JLabel();
        txt_firstName = new javax.swing.JTextField();
        jlb_lastName = new javax.swing.JLabel();
        txt_lastName = new javax.swing.JTextField();
        jlb_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btn_add1 = new javax.swing.JToggleButton();
        jlb_phone = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jlb_product = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_sEmail = new javax.swing.JTextField();
        btn_exportExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Customer Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 300, 77));

        tbl_Customer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Customer.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "customerID", "firstName", "lastName", "email", "phone"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Customer.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Customer.setRowHeight(40);
    tbl_Customer.setRowMargin(2);
    tbl_Customer.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Customer.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Customer.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_CustomerMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Customer);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1300, 157));

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
    jLabel3.setText("SEARCH:");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 110, 50));

    txt_sCustomerID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sCustomerID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sCustomerID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sCustomerIDActionPerformed(evt);
        }
    });
    txt_sCustomerID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sCustomerIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 130, 52));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("CustomerID:");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 138, 52));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 153, 51));
    jLabel6.setText("Phone:");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, 110, 52));

    txt_sPhone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sPhone.setForeground(new java.awt.Color(255, 153, 51));
    txt_sPhone.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sPhoneActionPerformed(evt);
        }
    });
    txt_sPhone.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sPhoneKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 520, 280, 52));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1360, 10));

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 51));
    jLabel9.setText("First Name:");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 110, 52));

    txt_sFirstName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sFirstName.setForeground(new java.awt.Color(255, 153, 51));
    txt_sFirstName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sFirstNameActionPerformed(evt);
        }
    });
    txt_sFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sFirstNameKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 280, 52));

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 153, 51));
    jLabel10.setText("Last Name:");
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 110, 52));

    txt_sLastName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sLastName.setForeground(new java.awt.Color(255, 153, 51));
    txt_sLastName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sLastNameActionPerformed(evt);
        }
    });
    txt_sLastName.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sLastNameKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, 280, 52));

    jlb_customerID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_customerID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_customerID.setText("...");
    jPanel1.add(jlb_customerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 138, 52));

    jlb_firstName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_firstName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_firstName.setText("First Name:");
    jPanel1.add(jlb_firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 120, 52));

    txt_firstName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_firstName.setForeground(new java.awt.Color(255, 153, 51));
    txt_firstName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_firstNameActionPerformed(evt);
        }
    });
    jPanel1.add(txt_firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 280, 52));

    jlb_lastName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_lastName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_lastName.setText("Last Name:");
    jPanel1.add(jlb_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 270, 110, 52));

    txt_lastName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_lastName.setForeground(new java.awt.Color(255, 153, 51));
    txt_lastName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_lastNameActionPerformed(evt);
        }
    });
    jPanel1.add(txt_lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 270, 280, 52));

    jlb_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_email.setForeground(new java.awt.Color(255, 153, 51));
    jlb_email.setText("Email:");
    jPanel1.add(jlb_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 140, 52));

    txt_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_email.setForeground(new java.awt.Color(255, 153, 51));
    txt_email.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_emailActionPerformed(evt);
        }
    });
    jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 290, 52));

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

    jlb_phone.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_phone.setForeground(new java.awt.Color(255, 153, 51));
    jlb_phone.setText("Phone:");
    jPanel1.add(jlb_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 80, 52));

    txt_phone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_phone.setForeground(new java.awt.Color(255, 153, 51));
    txt_phone.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_phoneActionPerformed(evt);
        }
    });
    jPanel1.add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 280, 52));

    jlb_product.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_product.setForeground(new java.awt.Color(255, 153, 51));
    jlb_product.setText("CustomerID:");
    jPanel1.add(jlb_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 138, 52));

    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 153, 51));
    jLabel7.setText("Email:");
    jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, 110, 52));

    txt_sEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sEmail.setForeground(new java.awt.Color(255, 153, 51));
    txt_sEmail.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sEmailActionPerformed(evt);
        }
    });
    txt_sEmail.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sEmailKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, 330, 52));

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
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CustomerMouseClicked
        showCustomerValue(customerls);
    }//GEN-LAST:event_tbl_CustomerMouseClicked

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        CustomerRecovery c = new CustomerRecovery();
        c.setVisible(true);

    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        delCustomer();

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        editCustomer();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
//        showTable();

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_sCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sCustomerIDActionPerformed

    private void txt_sPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sPhoneActionPerformed

    private void txt_sFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sFirstNameActionPerformed

    private void txt_sLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sLastNameActionPerformed

    private void txt_firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_firstNameActionPerformed

    private void txt_lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastNameActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        try {
           AddCustomer cu = new AddCustomer();
            cu.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneActionPerformed

    private void txt_sEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sEmailActionPerformed

    private void txt_sFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sFirstNameKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sFirstNameKeyReleased

    private void txt_sLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sLastNameKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sLastNameKeyReleased

    private void txt_sCustomerIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sCustomerIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sCustomerIDKeyReleased

    private void txt_sEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sEmailKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sEmailKeyReleased

    private void txt_sPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sPhoneKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sPhoneKeyReleased

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
//            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CustomerManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
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
//                    new CustomerManagement().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_customerID;
    private javax.swing.JLabel jlb_email;
    private javax.swing.JLabel jlb_firstName;
    private javax.swing.JLabel jlb_lastName;
    private javax.swing.JLabel jlb_phone;
    private javax.swing.JLabel jlb_product;
    private javax.swing.JTable tbl_Customer;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_sCustomerID;
    private javax.swing.JTextField txt_sEmail;
    private javax.swing.JTextField txt_sFirstName;
    private javax.swing.JTextField txt_sLastName;
    private javax.swing.JTextField txt_sPhone;
    // End of variables declaration//GEN-END:variables
}
