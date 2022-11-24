/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Bill;
import BUS.BillBUS;
import DTO.Product;
import BUS.ProductBUS;
import DTO.Staff;
import BUS.StaffBUS;
import DTO.Customer;
import BUS.CustomerBUS;
import DTO.Discount;
import BUS.DiscountBUS;
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
public class BillManagement extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    BillBUS billBUS = new BillBUS();
    ProductBUS productBUS = new ProductBUS();
    StaffBUS staffBUS = new StaffBUS();
    CustomerBUS customerBUS = new CustomerBUS();
    DiscountBUS discountBUS = new DiscountBUS();
    ArrayList<Bill> billls = billBUS.getList();
    ArrayList<Product> product = productBUS.getList();
    ArrayList<Staff> staff = staffBUS.getList();
    ArrayList<Customer> customer = customerBUS.getList();
    ArrayList<Discount> discount = discountBUS.getList();
    
    public BillManagement() throws ClassNotFoundException {
        initComponents();
        billBUS.listBill();
        productBUS.listProduct();
        staffBUS.listStaff();
        customerBUS.listCustomer();
        discountBUS.listDiscount();
        showTable(billls);
    }
    
    private void showTable(ArrayList<Bill> billls)
    {   
        tbl_Bill.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Bill.getModel();
        defaultModel.setRowCount(0);
        for(Bill b : billls)
        {
            if(b.getStatus() == 1){
                int billID = b.getBillID();
                String product = productBUS.getProductID(b.getProductID()).getProductName();
                String staff = staffBUS.getStaffID(b.getStaffID()).getFirstName()+ " "+staffBUS.getStaffID(b.getCustomerID()).getLastName();
                String customer = customerBUS.getCustomerID(b.getCustomerID()).getFirstName() +" "+ customerBUS.getCustomerID(b.getCustomerID()).getLastName();
                int discount = discountBUS.getDiscountID(b.getDiscountID()).getDiscountValue();
                float totalPrice = b.getTotalPrice();
                String date = b.getDate();
                defaultModel.addRow(new Object[]{billID, product, staff, customer, discount, totalPrice, date});
            }
        }
    }
    
    private void showBillValue(ArrayList<Bill> billls)
    {
        
        int row = tbl_Bill.getSelectedRow();
        int value = (int) tbl_Bill.getModel().getValueAt(row, 0);
        for(Bill b : billls)
        {
            if (billBUS.CheckBillID(value))
            {
                jlb_product.setText(tbl_Bill.getModel().getValueAt(row, 0).toString());
                txt_product.setText(tbl_Bill.getModel().getValueAt(row, 1).toString());
                txt_staff.setText(tbl_Bill.getModel().getValueAt(row, 2).toString());
                txt_customer.setText(tbl_Bill.getModel().getValueAt(row, 3).toString());
                txt_discount.setText(tbl_Bill.getModel().getValueAt(row, 4).toString());
                txt_totalPrice.setText(tbl_Bill.getModel().getValueAt(row, 5).toString());
                txt_date.setText(tbl_Bill.getModel().getValueAt(row, 5).toString());
                
            }
        }
    }   
    
     private void editBill()
    {
        int billID;
        int row = tbl_Bill.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn sản phẩm cần sửa", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           
           billID = Integer.parseInt(jlb_billID.getText());
           int product = Integer.parseInt(txt_product.getText());
           int staff = Integer.parseInt(txt_staff.getText());
           int customer = Integer.parseInt(txt_customer.getText());
           int discount = Integer.parseInt(txt_discount.getText());
           float totalPrice = Integer.parseInt(txt_totalPrice.getText());
           String date = txt_date.getText();
           int status =1; 
         
           Bill b = new Bill(billID, product, staff, customer, discount, totalPrice, date, status);
                        
            billBUS.SetBill(b);
            refresh();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(BillManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void delBill(){
        int row = tbl_Bill.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn sản phẩm cần xoá", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           int billID = (int)tbl_Bill.getModel().getValueAt(row, 0);
           int product = billBUS.getBillID(billID).getProductID();
           int staff = billBUS.getBillID(billID).getStaffID();
           int customer = billBUS.getBillID(billID).getCustomerID();
           int discount = billBUS.getBillID(billID).getDiscountID();
           float totalPrice = (float)tbl_Bill.getModel().getValueAt(row, 5);
           String date = tbl_Bill.getModel().getValueAt(row, 6).toString();
           int status = 0;
           Bill b = new Bill(billID, product, staff, customer, discount, totalPrice, date, status);
          
            billBUS.SetBill(b);
            refresh();
            resetText();
            row = -1;
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetText(){
        jlb_bill.setText("...");
        txt_product.setText("");
        txt_staff.setText("");
        txt_customer.setText("");
        txt_discount.setText("");
        txt_totalPrice.setText("");
        txt_date.setText("");
    }
    
    private void refresh(){
        try {
            billBUS.listBill();
            billls = billBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(billls);
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
        tbl_Bill = new javax.swing.JTable();
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
        jlb_bill = new javax.swing.JLabel();
        jlb_product = new javax.swing.JLabel();
        txt_product = new javax.swing.JTextField();
        jlb_staff = new javax.swing.JLabel();
        txt_staff = new javax.swing.JTextField();
        jlb_discountID = new javax.swing.JLabel();
        txt_discount = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btn_add1 = new javax.swing.JToggleButton();
        jlb_totalPrice = new javax.swing.JLabel();
        txt_totalPrice = new javax.swing.JTextField();
        jlb_date = new javax.swing.JLabel();
        txt_date = new javax.swing.JTextField();
        jlb_customer = new javax.swing.JLabel();
        txt_customer = new javax.swing.JTextField();
        jlb_billID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Bill Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 261, 77));

        tbl_Bill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Bill.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "billID", "productID", "staffID", "customerID", "discountID", "totalPrice", "date"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Bill.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Bill.setRowHeight(40);
    tbl_Bill.setRowMargin(2);
    tbl_Bill.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Bill.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Bill.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_BillMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Bill);

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

    jlb_bill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_bill.setForeground(new java.awt.Color(255, 153, 51));
    jlb_bill.setText("...");
    jPanel1.add(jlb_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 140, 52));

    jlb_product.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_product.setForeground(new java.awt.Color(255, 153, 51));
    jlb_product.setText("Product:");
    jPanel1.add(jlb_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 110, 52));

    txt_product.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_product.setForeground(new java.awt.Color(255, 153, 51));
    txt_product.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_productActionPerformed(evt);
        }
    });
    jPanel1.add(txt_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 200, 52));

    jlb_staff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_staff.setForeground(new java.awt.Color(255, 153, 51));
    jlb_staff.setText("Staff:");
    jPanel1.add(jlb_staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 110, 52));

    txt_staff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_staff.setForeground(new java.awt.Color(255, 153, 51));
    txt_staff.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_staffActionPerformed(evt);
        }
    });
    jPanel1.add(txt_staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 200, 52));

    jlb_discountID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_discountID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_discountID.setText("Discount:");
    jPanel1.add(jlb_discountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 140, 52));

    txt_discount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_discount.setForeground(new java.awt.Color(255, 153, 51));
    txt_discount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_discountActionPerformed(evt);
        }
    });
    jPanel1.add(txt_discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 220, 52));

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

    jlb_totalPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_totalPrice.setForeground(new java.awt.Color(255, 153, 51));
    jlb_totalPrice.setText("TotalPrice:");
    jPanel1.add(jlb_totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 110, 52));

    txt_totalPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_totalPrice.setForeground(new java.awt.Color(255, 153, 51));
    txt_totalPrice.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_totalPriceActionPerformed(evt);
        }
    });
    jPanel1.add(txt_totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 220, 52));

    jlb_date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_date.setForeground(new java.awt.Color(255, 153, 51));
    jlb_date.setText("Date:");
    jPanel1.add(jlb_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 60, 52));

    txt_date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_date.setForeground(new java.awt.Color(255, 153, 51));
    txt_date.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_dateActionPerformed(evt);
        }
    });
    jPanel1.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 190, 52));

    jlb_customer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_customer.setForeground(new java.awt.Color(255, 153, 51));
    jlb_customer.setText("Customer:");
    jPanel1.add(jlb_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, 120, 52));

    txt_customer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_customer.setForeground(new java.awt.Color(255, 153, 51));
    txt_customer.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_customerActionPerformed(evt);
        }
    });
    jPanel1.add(txt_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 270, 200, 52));

    jlb_billID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_billID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_billID.setText("BillID:");
    jPanel1.add(jlb_billID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 138, 52));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1320, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_BillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_BillMouseClicked
        showBillValue(billls);
    }//GEN-LAST:event_tbl_BillMouseClicked

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
//        CourseRecovery a = new CourseRecovery();
//        a.setVisible(true);

    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        delBill();

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
//        editCourse();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
//        showTable();

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

    private void txt_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productActionPerformed

    private void txt_staffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_staffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_staffActionPerformed

    private void txt_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_discountActionPerformed

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
//        try {
//           AddBill b = new AddBill();
//            b.setVisible(true);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ProductManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_totalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalPriceActionPerformed

    private void txt_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateActionPerformed

    private void txt_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customerActionPerformed

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
            java.util.logging.Logger.getLogger(BillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BillManagement().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BillManagement.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jlb_bill;
    private javax.swing.JLabel jlb_billID;
    private javax.swing.JLabel jlb_customer;
    private javax.swing.JLabel jlb_date;
    private javax.swing.JLabel jlb_discountID;
    private javax.swing.JLabel jlb_product;
    private javax.swing.JLabel jlb_staff;
    private javax.swing.JLabel jlb_totalPrice;
    private javax.swing.JTextField sdtJbl;
    private javax.swing.JTable tbl_Bill;
    private javax.swing.JTextField tenkhachJlb;
    private javax.swing.JTextField tenkhachJlb1;
    private javax.swing.JTextField tenkhachJlb2;
    private javax.swing.JTextField txt_customer;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_discount;
    private javax.swing.JTextField txt_product;
    private javax.swing.JTextField txt_staff;
    private javax.swing.JTextField txt_totalPrice;
    // End of variables declaration//GEN-END:variables
}
