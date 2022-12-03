/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import DTO.Product;
import BUS.ProductBUS;
import DTO.Bill;
import BUS.BillBUS;
import BUS.BilldetailBUS;
import DTO.Billdetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author TruongMinhNhat
 */
public class ThongKeSP extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeSP
     */
    ProductBUS productBUS = new ProductBUS();
    BillBUS billBUS = new BillBUS();
    BilldetailBUS billdetailBUS = new BilldetailBUS();
    ArrayList<Product> productls = productBUS.getList();
    ArrayList<Bill> billls = billBUS.getList();
    ArrayList<Billdetail> billdetaills = billdetailBUS.getList();
    int staffID;
    public ThongKeSP(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        jlb_staffID.setText("Staff ID: " +staffID);
        productBUS.getList();
        billBUS.getList();
        billdetailBUS.getList();
        
//        list();
    }

    public void showTable(ArrayList<Billdetail> billdetail) // Xuất ra Table từ ArrayList
    {
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_product.getModel();
        Vector data;
        int quantity =0;
        defaultModel.setRowCount(0);
        for (Billdetail p : billdetail) {
            data = new Vector();
            data.add(billdetailBUS.getBillID(p.getProductID()));
            data.add(productBUS.getProductByID(p.getProductID()).getProductName());
            data.add(productBUS.getProductByID(p.getProductID()).getPrice());
            data.add(billdetailBUS.getBillID(p.getQuantity()));
            defaultModel.addRow(data);
        }
        tbl_product.setModel(defaultModel);
    }
    
//    public void list() // Chép ArrayList lên table
//    {
//        if (bBUS.getList() == null) {
//            bBUS.list();
//        }
//        
//        if (bdBUS.getList() == null) {
//            bdBUS.list();
//        }
//        
//        if (pBUS.getList() == null) {
//            pBUS.list();
//        }
//    }
//    
//    private boolean checkItemCart(ArrayList<product> cart,int id){
//        for(product c : cart){
//            if(c.getProductID() == id){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    private int getItemCart(ArrayList<product> cart,int id){
//        int i = 0;
//        for(product c : cart){
//            if(c.getProductID() == id){
//                return i;
//            }else{
//                i++;
//            }
//        }
//        return i;
//    }
//     
//    private void filter(ArrayList<bill> arrBill) throws ParseException{
//        ArrayList<billdetail> arrBilldetail = (ArrayList<billdetail>) bdBUS.getList();
//        ArrayList<product> product = (ArrayList<product>) pBUS.getList();
//        ArrayList<billdetail> arrbilldetailFilter = new ArrayList<>();
//        ArrayList<product> arrProdutFilter = new ArrayList<>();
//        
//        Date start = jDateChooseFrom.getDate(); 
//        Date end = jDateChooserTo.getDate();
//        
//        for(bill b : arrBill){      //lọc hóa đơn bán theo ngày
//            if(start.before(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(b.getDate())) && end.after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(b.getDate())) ){
//                for(billdetail bd : arrBilldetail) 
//                    if(b.getBillID() == bd.getBillID()){
//                        arrbilldetailFilter.add(bd);
//                    }
//            }
//        }    
//        
//        for(product p : product){   //dựa theo mảng product đếm số lượng sản phẩm 
//            int qty = 0;
//            for(billdetail a : arrbilldetailFilter){
//                if(p.getProductID() == a.getProductID()){
//                    qty += a.getQuantity();
//                }
//            }
//            if(checkItemCart(arrProdutFilter,p.getProductID())){
//                product pro = p;
//                pro.setAmount(qty);
//                arrProdutFilter.set(getItemCart(arrProdutFilter,p.getProductID()), pro);
//            }else{
//                product pro = p;
//                pro.setAmount(qty);
//                arrProdutFilter.add(pro);
//            }
//        }
//        Collections.sort(arrProdutFilter, new Comparator<product>(){        //sắp xếp mảng product theo số lượng giảm dần
//            @Override
//            public int compare(product p1, product p2){
//                return (int) (p2.getAmount() - p1.getAmount());
//            }
//        });
//        outModel(arrProdutFilter);
//        lb_count.setText(String.valueOf(tbl_product.getRowCount()));
//    }
//
//    
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_product = new javax.swing.JTable();
        btn_search = new javax.swing.JToggleButton();
        jDateChooseFrom = new com.toedter.calendar.JDateChooser();
        jDateChooserTo = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lb_total = new javax.swing.JLabel();
        lb_count = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JToggleButton();
        jlb_staffID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Product Satistics");

        tbl_product.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_product.setForeground(new java.awt.Color(255, 153, 51));
        tbl_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID","Product Name","Price","Quantity"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_product.setRowHeight(40);
    tbl_product.setRowMargin(2);
    tbl_product.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_product.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_productMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_product);

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

    lb_total.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
    lb_total.setForeground(new java.awt.Color(255, 102, 0));
    lb_total.setText("Total Revenue: ");

    lb_count.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
    lb_count.setForeground(new java.awt.Color(255, 102, 0));
    lb_count.setText("Count: ");

    btn_refresh.setBackground(new java.awt.Color(102, 255, 102));
    btn_refresh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_refresh.setForeground(new java.awt.Color(255, 255, 255));
    btn_refresh.setText("Làm mới");
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
                    .addContainerGap(99, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(84, 84, 84)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jDateChooseFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jDateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(82, 82, 82))
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(527, 527, 527)
                            .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(lb_total, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_count, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(93, 93, 93)))
            .addContainerGap())
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(477, 477, 477)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(118, 118, 118)
            .addComponent(jlb_staffID, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jlb_staffID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(26, 26, 26)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(25, 25, 25)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lb_total)
                .addComponent(lb_count))
            .addGap(18, 18, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDateChooserTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooseFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productMouseClicked
        //        showStudentValue();
    }//GEN-LAST:event_tbl_productMouseClicked

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
//        try {
//            filter((ArrayList<bill>) bBUS.getList());
//        } catch (ParseException ex) {
//            Logger.getLogger(ThongKeSP.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refreshMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refreshMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
       
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
//            java.util.logging.Logger.getLogger(ThongKeSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThongKeSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThongKeSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThongKeSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new ThongKeSP().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(ThongKeSP.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_refresh;
    private javax.swing.JToggleButton btn_search;
    private com.toedter.calendar.JDateChooser jDateChooseFrom;
    private com.toedter.calendar.JDateChooser jDateChooserTo;
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
    private javax.swing.JTable tbl_product;
    // End of variables declaration//GEN-END:variables
}
