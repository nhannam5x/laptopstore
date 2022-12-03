/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author TruongMinhNhat
 */
public class ThongKeDT extends javax.swing.JFrame {
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
    int staffID;
    /**
     * Creates new form NewJFrame
     */
    public ThongKeDT(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        jlb_staffID.setText("Staff ID: " +staffID);
        billBUS.listBill();
        productBUS.listProduct();
        staffBUS.listStaff();
        customerBUS.listCustomer();
        discountBUS.listDiscount();
        Date date = new Date();
//        jDateChooseFrom.setDate(date);
//        jDateChooseTo.setDate(date);
        showTable(billls);
    }
    
    public void showTable(ArrayList<Bill> billls) // Xuất ra Table từ ArrayList
    {
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_revenue.getModel();
        Vector data;
        defaultModel.setRowCount(0);
        float revenue=0;
        for (Bill b : billls) {
            data = new Vector();
            data.add(b.getBillID());
            data.add(staffBUS.getStaffID(b.getStaffID()).getStaffID());
            data.add(staffBUS.getStaffID(b.getStaffID()).getFirstName() + " " + staffBUS.getStaffID(b.getStaffID()).getLastName());
            data.add(customerBUS.getCustomerID(b.getCustomerID()).getCustomerID());
            data.add(customerBUS.getCustomerID(b.getCustomerID()).getFirstName() + " " + customerBUS.getCustomerID(b.getCustomerID()).getLastName());
            data.add(discountBUS.getDiscountID(b.getDiscountID()).getDiscountValue());
            data.add(b.getTotalPrice());
            data.add(b.getDate());
            lb_count.setText("Count: " + String.valueOf(tbl_revenue.getRowCount() + 1));            
            revenue += b.getTotalPrice();
            lb_total.setText("Total Revenue: " + String.valueOf(revenue));
            defaultModel.addRow(data);
        }
        tbl_revenue.setModel(defaultModel);
    }

    public void list() // Chép ArrayList lên table
    {
        if (billBUS.getList() == null) {
            try {
                billBUS.listBill();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThongKeDT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ArrayList<Bill> billls = (ArrayList<Bill>) billBUS.getList();
//        model.setRowCount(0);
        showTable(billls);
    }
     
    private void filter(ArrayList<Bill> billls) throws ParseException{
//        ArrayList<Bill> arrFilter = new ArrayList<>();
//        float total = 0;
//        Date start = jDateChooseFrom.getDate(); 
//        Date end = jDateChooseTo.getDate();
//        
//        if(end.before(start)){
//             JOptionPane.showMessageDialog(new JFrame(), "Ngày kết thúc phải lớn hơn ngày bắt đầu ", "Dialog",JOptionPane.ERROR_MESSAGE);
//                return;
//        }
//        
//        for(Bill b : billls){
//            if(start.before(new SimpleDateFormat("dd-MM-yyyy").parse(b.getDate())) && end.after(new SimpleDateFormat("dd-MM-yyyy").parse(b.getDate())) ){
//                arrFilter.add(b);
//            }
//        }  
//       
//        
//        showTable(arrFilter);
//        
//        for(int i = 0; i < tbl_revenue.getRowCount(); i++){
//            total += (float) tbl_revenue.getValueAt(i, 3);
//        }
//        
//        lb_count.setText("Count: " +String.valueOf(tbl_revenue.getRowCount()));
//        lb_total.setText("Total Revenue: " +String.valueOf(total));
    }
//    private void filter(ArrayList<Bill> billls) throws ParseException{
//        ArrayList<Bill> arrFilter = new ArrayList<>();
//        float total = 0;
////        Date start = jDateChooseFrom.getDate(); 
////        Date end = jDateChooseTo.getDate();
////        
//        for(Bill b : billls){
//            if(start.before(new SimpleDateFormat("dd-MM-yyyy").parse(b.getDate())) && end.after(new SimpleDateFormat("dd-MM-yyyy").parse(b.getDate())) ){
//                arrFilter.add(b);
//            }
//        }  
//        
//        showTable(arrFilter);
//        
//        for(int i = 0; i < tbl_revenue.getRowCount(); i++){
//            total += (float) tbl_revenue.getValueAt(i, 3);
//        }
//        
//        lb_count.setText("Count: " +String.valueOf(tbl_revenue.getRowCount()));
//        lb_total.setText("Total Revenue: " +String.valueOf(total));
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_revenue = new javax.swing.JTable();
        btn_search = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lb_count = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JToggleButton();
        jlb_staffID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Revenue Satistics");

        tbl_revenue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_revenue.setForeground(new java.awt.Color(255, 153, 51));
        tbl_revenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "bill ID", "staff ID", "staff Name", "customer ID", "customer Name", "discount", "total Price", "date"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_revenue.setRowHeight(40);
    tbl_revenue.setRowMargin(2);
    tbl_revenue.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_revenue.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_revenueMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_revenue);

    btn_search.setBackground(new java.awt.Color(102, 255, 102));
    btn_search.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_search.setForeground(new java.awt.Color(255, 255, 255));
    btn_search.setText("Search");
    btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_searchMouseClicked(evt);
        }
    });
    btn_search.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_searchActionPerformed(evt);
        }
    });

    jSeparator1.setBackground(new java.awt.Color(255, 153, 0));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 0));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    jLabel6.setText("To");

    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 153, 51));
    jLabel7.setText("Search by date");

    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    jLabel8.setText("From");

    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));

    lb_count.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
    lb_count.setForeground(new java.awt.Color(255, 102, 0));
    lb_count.setText("Count: ");

    lb_total.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
    lb_total.setForeground(new java.awt.Color(255, 102, 0));
    lb_total.setText("Total Revenue: ");

    btn_refresh.setBackground(new java.awt.Color(102, 255, 255));
    btn_refresh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_refresh.setForeground(new java.awt.Color(255, 255, 255));
    btn_refresh.setText("Refresh");
    btn_refresh.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_refreshMouseClicked(evt);
        }
    });
    btn_refresh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_refreshActionPerformed(evt);
        }
    });

    jlb_staffID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jlb_staffID.setForeground(new java.awt.Color(255, 102, 0));
    jlb_staffID.setText("Staff ID:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(142, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(84, 84, 84)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(379, 379, 379)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(423, 423, 423))
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(477, 477, 477)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlb_staffID, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(150, 150, 150))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(lb_total, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51)
                    .addComponent(lb_count, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(148, 148, 148))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jLabel1))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jlb_staffID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)))
            .addGap(26, 26, 26)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lb_count)
                .addComponent(lb_total))
            .addGap(18, 52, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(29, 29, 29))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    
/*public ArrayList<bill> search(String billID, String customerID, String date)
    {
        ArrayList<bill> search = new ArrayList<>();
        date = date.isEmpty()?date = "": date;
        Date date1 = jDateChooseFrom.getDate();
        Date date3 = jDateChooseTo.getDate();
        
        if(date1.before(date2) && date3.after(date2)) {
            System.out.println("Date lies between from and to date");    } 
  */  
    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
  
    }//GEN-LAST:event_btn_searchMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
//         try {
//             filter((ArrayList<Bill>) billBUS.getList());
//         } catch (ParseException ex) {
//             Logger.getLogger(ThongKeDT.class.getName()).log(Level.SEVERE, null, ex);
//         }

        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tbl_revenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_revenueMouseClicked
//                showStudentValue();
    }//GEN-LAST:event_tbl_revenueMouseClicked

    private void btn_refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        tbl_revenue.removeAll();
        showTable(billls);
    }//GEN-LAST:event_btn_refreshActionPerformed

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
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ThongKeDT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThongKeDT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThongKeDT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThongKeDT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//                    new ThongKeDT().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(ThongKeDT.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_refresh;
    private javax.swing.JToggleButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_staffID;
    private javax.swing.JLabel lb_count;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTable tbl_revenue;
    // End of variables declaration//GEN-END:variables
}
