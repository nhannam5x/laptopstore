/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class SaleGUI extends javax.swing.JFrame {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    /**
     * Creates new form SaleGUI
     */
    public SaleGUI() {
        initComponents();
//        listproduct();
    }
    
//    private void showTableProduct()
//    {        
//        tbl_product.removeAll();
//        DefaultTableModel defaultModel = (DefaultTableModel) tbl_product.getModel();
//        defaultModel.setRowCount(0);
//        Vector data;
//        for(product pro : arrProduct)
//        {   
//            if(pro.getAmount()>0){
//                data = new Vector();
//                data.add(pro.getProductID());//indext table = 0
//                data.add(pro.getCategoryID());//1
//                data.add(pro.getProductName());//2
//                data.add(pro.getAmount());//3
//                data.add(pro.getPrice());//4
//                defaultModel.addRow(data);
//            }
//        }
//        tbl_product.setModel(defaultModel);
//    }
//    
//    private void showTableProductFilter(int categoryID)
//    {
//        tbl_product.removeAll();
//        DefaultTableModel defaultModel = (DefaultTableModel) tbl_product.getModel();
//        defaultModel.setRowCount(0);
//        Vector data;
//        for(product pro : arrProduct)
//        {   
//            if(pro.getAmount()>0){
//                if(pro.getCategoryID()== categoryID){       // lọc sản phẩm
//                    data = new Vector();
//                    data.add(pro.getProductID());
//                    data.add(pro.getCategoryID());
//                    data.add(pro.getProductName());
//                    data.add(pro.getAmount());
//                    data.add(pro.getPrice());
//                    defaultModel.addRow(data);
//                }
//            }
//        }
//        tbl_product.setModel(defaultModel);
//    }
//    
//    private void showTableCart(ArrayList<product> arrCart)
//    {
//        tbl_cart.removeAll();
//        DefaultTableModel defaultModel = (DefaultTableModel) tbl_cart.getModel();
//        defaultModel.setRowCount(0);
//        Vector data;
//        for(product pro : arrCart)
//        {
//            data = new Vector();
//            data.add(pro.getProductID());//indext table = 0
//            data.add(pro.getCategoryID());//1
//            data.add(pro.getProductName());//2
//            data.add(pro.getAmount());//3
//            data.add(pro.getPrice());//4
//            defaultModel.addRow(data);
//        }
//        tbl_cart.setModel(defaultModel);
//    }
//        
//    private void listproduct() // Chép ArrayList lên table
//    {
//        if (proBUS.getList() == null) {
//            proBUS.list();
//        }
//        if (cBUS.getList() == null) {
//            cBUS.list();
//        }
//        
//        arrProduct = (ArrayList<product>) proBUS.getList();
//        arrCategory = (ArrayList<category>) cBUS.getList();
//        
//        for(category c : arrCategory){
//            categoryCBB.addItem(String.valueOf(c.getCategoryID()));
//        }
//        
//        showTableProduct();
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
    
//    private void delCartItem(){
//        int row = tbl_cart.getSelectedRow();
//        if(row == -1)
//        {
//           JOptionPane.showMessageDialog(new JFrame(), "Chưa chọn dòng để xoá", "Dialog",
//           JOptionPane.ERROR_MESSAGE);
//        }else{
//           product p = proBUS.getProductById(tbl_product.getModel().getValueAt(row, 0).toString());
//           proBUS.delete(p);
//           showTableCart(Cart);
//           
//           JOptionPane.showMessageDialog(new JFrame(), "Xoá thành công", "Dialog",
//           JOptionPane.INFORMATION_MESSAGE);
//     
//        }
//    }
//    
//    private void delCart(){
//        Cart.clear();
//        showTableCart(Cart);
//    }
//    
//    private float getTotal(){ //tính tổng tiền bill
//        float total = 0;
//        for (product c: Cart){
//            total += (float)c.getPrice() * (float)c.getAmount();
//        }
//        return total;
//    }
    
//    private void Pay()
//    {
//        int customerID = Integer.parseInt(txt_customerID.getText());   
//        String date = dateFormat.format(LocalDateTime.now()); // Lấy ngày hiện tại trên local
//        float total = getTotal();  
//        
//        bill b = new bill(customerID,date,total);
//        bBUS.add(b);
//        bBUS.list();
//        
//        int billID = bBUS.getList().size(); //lấy số billID vừa thêm
//        for (product c: Cart){      //với mỗi sản phẩm trong giỏ add 1 billdetail
//            billdetail bd = new billdetail(billID,c.getProductID(),c.getAmount(),c.getPrice());
//            bdBUS.add(bd);      
//        }
//        Cart.clear();
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
        btn_add = new javax.swing.JToggleButton();
        btn_del = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_restore = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_cart = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Qty = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        categoryCBB = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_productID = new javax.swing.JTextField();
        btn_del1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        categoryCBB1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        btn_del2 = new javax.swing.JToggleButton();
        btn_del3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add.setBackground(new java.awt.Color(102, 255, 102));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm sản phẩm");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 330, 60));

        btn_del.setBackground(new java.awt.Color(255, 0, 0));
        btn_del.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_del.setForeground(new java.awt.Color(255, 255, 255));
        btn_del.setText("Giảm");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });
        jPanel1.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 390, 160, 60));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 60));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 352, -1, -1));

        btn_restore.setBackground(new java.awt.Color(102, 255, 102));
        btn_restore.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_restore.setForeground(new java.awt.Color(255, 255, 255));
        btn_restore.setText("Thanh Toán");
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
        jPanel1.add(btn_restore, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 620, 330, 90));

        tbl_cart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_cart.setForeground(new java.awt.Color(255, 153, 51));
        tbl_cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "CategoryID", "Name", "Amount","Price"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_cart.setRowHeight(40);
    tbl_cart.setRowMargin(2);
    tbl_cart.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_cart.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_cart.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_cartMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tbl_cart);

    jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 940, 670));

    jLabel3.setBackground(new java.awt.Color(255, 255, 255));
    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 153, 51));
    jLabel3.setText("Giỏ hàng");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 90, 50));

    jLabel5.setBackground(new java.awt.Color(255, 255, 255));
    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("VNĐ");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 560, 50, 50));

    jLabel7.setBackground(new java.awt.Color(255, 255, 255));
    jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 153, 51));
    jLabel7.setText("Số lượng:");
    jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 210, 100, 50));
    jPanel1.add(txt_Qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 220, 220, 40));

    jLabel8.setBackground(new java.awt.Color(255, 255, 255));
    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 153, 51));
    jLabel8.setText("ID SP:");
    jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 160, 100, 50));

    categoryCBB.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryCBBActionPerformed(evt);
        }
    });
    jPanel1.add(categoryCBB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 60, 180, 40));

    jLabel9.setBackground(new java.awt.Color(255, 255, 255));
    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 51));
    jLabel9.setText("Mã KM:");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 110, 80, 50));
    jPanel1.add(txt_productID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 170, 220, 40));

    btn_del1.setBackground(new java.awt.Color(102, 255, 102));
    btn_del1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del1.setForeground(new java.awt.Color(255, 255, 255));
    btn_del1.setText("Tăng");
    btn_del1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del1ActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 390, 170, 60));

    jButton1.setText("...");
    jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 110, 40, 40));

    btn_Refresh.setBackground(new java.awt.Color(102, 255, 255));
    btn_Refresh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Refresh.setForeground(new java.awt.Color(255, 255, 255));
    btn_Refresh.setText("Cập nhật số lượng");
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
    jPanel1.add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 450, 330, 70));

    jLabel10.setBackground(new java.awt.Color(255, 255, 255));
    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 153, 51));
    jLabel10.setText("Mã KH:");
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 80, 50));

    jLabel11.setBackground(new java.awt.Color(255, 255, 255));
    jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 153, 51));
    jLabel11.setText("Thành tiền:");
    jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 560, 130, 50));

    lb_total.setBackground(new java.awt.Color(255, 255, 255));
    lb_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    lb_total.setForeground(new java.awt.Color(255, 153, 51));
    lb_total.setText("...");
    jPanel1.add(lb_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 560, 170, 50));

    jLabel12.setBackground(new java.awt.Color(255, 255, 255));
    jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(255, 153, 51));
    jLabel12.setText("Số lượng:");
    jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 210, 100, 50));

    categoryCBB1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryCBB1ActionPerformed(evt);
        }
    });
    jPanel1.add(categoryCBB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 110, 180, 40));

    jButton2.setText("...");
    jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 60, 40, 40));

    btn_del2.setBackground(new java.awt.Color(255, 0, 0));
    btn_del2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del2.setForeground(new java.awt.Color(255, 255, 255));
    btn_del2.setText("Xóa");
    btn_del2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del2ActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 170, 60));

    btn_del3.setBackground(new java.awt.Color(255, 0, 0));
    btn_del3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del3.setForeground(new java.awt.Color(255, 255, 255));
    btn_del3.setText("Hủy giỏ hàng");
    btn_del3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del3ActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 330, 160, 60));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1300, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 720, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed

    }//GEN-LAST:event_btn_restoreActionPerformed

    private void tbl_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cartMouseClicked

    private void btn_del1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del1ActionPerformed

    }//GEN-LAST:event_btn_del1ActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
        //        showTable(category);
    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        //        try {
            //            // TODO add your handling code here:
            //            cateBUS.listCategory();
            //            category = cateBUS.getList();
            //            showTable(category);
            //        } catch (ClassNotFoundException ex) {
            //            Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
            //        }
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void categoryCBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBBActionPerformed

    }//GEN-LAST:event_categoryCBBActionPerformed

    private void categoryCBB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryCBB1ActionPerformed

    private void btn_del2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_del2ActionPerformed

    private void btn_del3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_del3ActionPerformed

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
            java.util.logging.Logger.getLogger(SaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JToggleButton btn_add;
    private javax.swing.JToggleButton btn_del;
    private javax.swing.JToggleButton btn_del1;
    private javax.swing.JToggleButton btn_del2;
    private javax.swing.JToggleButton btn_del3;
    private javax.swing.JToggleButton btn_restore;
    private javax.swing.JComboBox<String> categoryCBB;
    private javax.swing.JComboBox<String> categoryCBB1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTable tbl_cart;
    private javax.swing.JTextField txt_Qty;
    private javax.swing.JTextField txt_productID;
    // End of variables declaration//GEN-END:variables
}
