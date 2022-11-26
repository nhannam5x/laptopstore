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
                int staffID = staffBUS.getStaffID(b.getStaffID()).getStaffID();
                String staffName = staffBUS.getStaffID(b.getStaffID()).getFirstName()+ " "+staffBUS.getStaffID(b.getCustomerID()).getLastName();
                int customerID = customerBUS.getCustomerID(b.getCustomerID()).getCustomerID();
                String customerName = customerBUS.getCustomerID(b.getCustomerID()).getFirstName() +" "+ customerBUS.getCustomerID(b.getCustomerID()).getLastName();
                int discount = discountBUS.getDiscountID(b.getDiscountID()).getDiscountValue();
                float totalPrice = b.getTotalPrice();
                String date = b.getDate();
                
                defaultModel.addRow(new Object[]{billID, staffID, staffName, customerID, customerName, discount, totalPrice, date});
            }
        }
    }
    
    private void showBillValue(ArrayList<Bill> billls)
    {
        
        int row = tbl_Bill.getSelectedRow();
        jlb_billID.setText(tbl_Bill.getModel().getValueAt(row, 0).toString());
        jlb_staffID.setText(tbl_Bill.getModel().getValueAt(row, 1).toString());
        jlb_customerID.setText(tbl_Bill.getModel().getValueAt(row, 3).toString());
        jlb_discountID.setText(tbl_Bill.getModel().getValueAt(row, 5).toString());
        jlb_totalPrice.setText(tbl_Bill.getModel().getValueAt(row, 6).toString());
        jlb_date.setText(tbl_Bill.getModel().getValueAt(row, 7).toString());
                
    }   
    
    
    private void resetText(){
        jlb_billID.setText("...");
        jlb_staffID.setText("");
        jlb_customerID.setText("");
        jlb_discountID.setText("");
        jlb_totalPrice.setText("");
        jlb_date.setText("");
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
    
    private void search(){
        String billID = txt_sBillID.getText();
        String staffID = txt_sStaffID.getText();
        String customerID = txt_sCustomerID.getText();
        String date = txt_sDate.getText();
        showTable(billBUS.search(billID, staffID, customerID, date));
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
        btn_Check = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txt_sBillID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_sDate = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txt_sStaffID = new javax.swing.JTextField();
        jlb_billID = new javax.swing.JLabel();
        jlb_staff = new javax.swing.JLabel();
        jlb_date = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jlb_totalPrice1 = new javax.swing.JLabel();
        jlb_date1 = new javax.swing.JLabel();
        jlb_customer = new javax.swing.JLabel();
        jlb_bill = new javax.swing.JLabel();
        jlb_discount = new javax.swing.JLabel();
        jlb_discountID = new javax.swing.JLabel();
        jlb_staffID = new javax.swing.JLabel();
        jlb_totalPrice = new javax.swing.JLabel();
        jlb_customerID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_sCustomerID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
                "billID", "staffID", "staffName", "customer", "customerName", "discount", "totalPrice", "date"
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

    btn_Check.setBackground(new java.awt.Color(102, 255, 102));
    btn_Check.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Check.setForeground(new java.awt.Color(255, 255, 255));
    btn_Check.setText("Xem");
    btn_Check.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_CheckActionPerformed(evt);
        }
    });
    jPanel1.add(btn_Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 230, 90));

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
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 90, 50));

    txt_sBillID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sBillID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sBillID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sBillIDActionPerformed(evt);
        }
    });
    txt_sBillID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sBillIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sBillID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 200, 52));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("BillID:");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 138, 52));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 153, 51));
    jLabel6.setText("Date:");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 520, 60, 52));

    txt_sDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sDate.setForeground(new java.awt.Color(255, 153, 51));
    txt_sDate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sDateActionPerformed(evt);
        }
    });
    txt_sDate.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sDateKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 520, 210, 52));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1270, 10));

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 153, 51));
    jLabel10.setText("StaffID:");
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 80, 52));

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
    jPanel1.add(txt_sStaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, 200, 52));

    jlb_billID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_billID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_billID.setText("...");
    jPanel1.add(jlb_billID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 140, 52));

    jlb_staff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_staff.setForeground(new java.awt.Color(255, 153, 51));
    jlb_staff.setText("Staff:");
    jPanel1.add(jlb_staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 60, 52));

    jlb_date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_date.setForeground(new java.awt.Color(255, 153, 51));
    jlb_date.setText("...");
    jPanel1.add(jlb_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 320, 52));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1270, 10));

    jlb_totalPrice1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_totalPrice1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_totalPrice1.setText("TotalPrice:");
    jPanel1.add(jlb_totalPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 110, 52));

    jlb_date1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_date1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_date1.setText("Date:");
    jPanel1.add(jlb_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 60, 52));

    jlb_customer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_customer.setForeground(new java.awt.Color(255, 153, 51));
    jlb_customer.setText("Customer:");
    jPanel1.add(jlb_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 270, 120, 52));

    jlb_bill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_bill.setForeground(new java.awt.Color(255, 153, 51));
    jlb_bill.setText("BillID:");
    jPanel1.add(jlb_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 60, 52));

    jlb_discount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_discount.setForeground(new java.awt.Color(255, 153, 51));
    jlb_discount.setText("Discount:");
    jPanel1.add(jlb_discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 90, 52));

    jlb_discountID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_discountID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_discountID.setText("...");
    jPanel1.add(jlb_discountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 90, 52));

    jlb_staffID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_staffID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_staffID.setText("...");
    jPanel1.add(jlb_staffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 270, 52));

    jlb_totalPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_totalPrice.setForeground(new java.awt.Color(255, 153, 51));
    jlb_totalPrice.setText("...");
    jPanel1.add(jlb_totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 90, 52));

    jlb_customerID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_customerID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_customerID.setText("...");
    jPanel1.add(jlb_customerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 320, 52));

    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 153, 51));
    jLabel7.setText("CustomerID:");
    jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 120, 52));

    txt_sCustomerID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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
    jPanel1.add(txt_sCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 210, 52));

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

    private void btn_CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CheckActionPerformed
        int billID;
        int row = tbl_Bill.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn hóa đơn cần xem", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           
           billID = Integer.parseInt(jlb_billID.getText());    
           BilldetailManagement bd = new BilldetailManagement(billID);
            bd.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_CheckActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
//        showTable();

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_sBillIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sBillIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sBillIDActionPerformed

    private void txt_sDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sDateActionPerformed

    private void txt_sStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sStaffIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sStaffIDActionPerformed

    private void txt_sCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sCustomerIDActionPerformed

    private void txt_sBillIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sBillIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sBillIDKeyReleased

    private void txt_sStaffIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sStaffIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sStaffIDKeyReleased

    private void txt_sCustomerIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sCustomerIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sCustomerIDKeyReleased

    private void txt_sDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sDateKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sDateKeyReleased

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
    private javax.swing.JToggleButton btn_Check;
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_bill;
    private javax.swing.JLabel jlb_billID;
    private javax.swing.JLabel jlb_customer;
    private javax.swing.JLabel jlb_customerID;
    private javax.swing.JLabel jlb_date;
    private javax.swing.JLabel jlb_date1;
    private javax.swing.JLabel jlb_discount;
    private javax.swing.JLabel jlb_discountID;
    private javax.swing.JLabel jlb_staff;
    private javax.swing.JLabel jlb_staffID;
    private javax.swing.JLabel jlb_totalPrice;
    private javax.swing.JLabel jlb_totalPrice1;
    private javax.swing.JTable tbl_Bill;
    private javax.swing.JTextField txt_sBillID;
    private javax.swing.JTextField txt_sCustomerID;
    private javax.swing.JTextField txt_sDate;
    private javax.swing.JTextField txt_sStaffID;
    // End of variables declaration//GEN-END:variables
}
