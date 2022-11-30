/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Inventorybilldetail;
import BUS.InventorybilldetailBUS;
import DTO.Inventorybill;
import BUS.InventorybillBUS;
import BUS.SupplierBUS;
import BUS.CategoryBUS;
import DTO.Product;
import BUS.ProductBUS;
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
public class InventorybilldetailManagement extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    InventorybilldetailBUS inventorybilldetailBUS = new InventorybilldetailBUS();
    InventorybillBUS inventorybillBUS = new InventorybillBUS();
    ProductBUS productBUS = new ProductBUS();
    CategoryBUS categoryBUS = new CategoryBUS();
    SupplierBUS supplierBUS = new SupplierBUS();
    ArrayList<Inventorybilldetail> billdls = inventorybilldetailBUS.getList();
    ArrayList<Inventorybill> bill = inventorybillBUS.getList();
    ArrayList<Product> product = productBUS.getList();
    int inventorybillID;
    
    public InventorybilldetailManagement(int inventorybillID) throws ClassNotFoundException {
        initComponents();
        this.inventorybillID = inventorybillID;
        System.out.println(inventorybillID);
        inventorybilldetailBUS.listInventorybilldetail();
        inventorybillBUS.listInventorybill();
        productBUS.listProduct();
        categoryBUS.listCategory();
        supplierBUS.listSupplier();
        showTable(billdls);
        
    }
    
    private void showTable(ArrayList<Inventorybilldetail> billdls)
    {   
        tbl_Inventorybilldetail.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Inventorybilldetail.getModel();
        defaultModel.setRowCount(0);
        int totalRow = 0, totalQuantity=0;
        
        for(Inventorybilldetail bd : billdls)
        {
            if(bd.getStatus() == 1){
                if(bd.getInventorybillID() == this.inventorybillID){
                    int productID = productBUS.getProductID(bd.getProductID()).getProductID();
                    int quantity = bd.getQuantity();
                    String productName = productBUS.getProductID(bd.getProductID()).getProductName();
                    int categoryID = categoryBUS.getCategoryID(bd.getCategoryID()).getCategoryID();
                    int supplierID = supplierBUS.getSupplierID(bd.getSupplierID()).getSupplierID();
                    float price = productBUS.getProductID(bd.getProductID()).getPrice();
                    defaultModel.addRow(new Object[]{this.inventorybillID, productID, productName,categoryID,supplierID, price, quantity});
                    totalRow ++;
                    totalQuantity += quantity;
                    jlb_rowCount.setText(String.valueOf(totalRow));
                    jlb_totalQuantity.setText(String.valueOf(totalQuantity));
                }
                
            }
        }
    }
    
    private void showBillValue(ArrayList<Inventorybilldetail> billdls)
    {
        
        int row = tbl_Inventorybilldetail.getSelectedRow();
        int quantity = (int) tbl_Inventorybilldetail.getModel().getValueAt(row, 4);
        float price = (float) tbl_Inventorybilldetail.getModel().getValueAt(row, 3);
        jlb_productID.setText(tbl_Inventorybilldetail.getModel().getValueAt(row, 1).toString());
        jlb_productName.setText(tbl_Inventorybilldetail.getModel().getValueAt(row, 2).toString());
        
        jlb_price.setText(tbl_Inventorybilldetail.getModel().getValueAt(row, 3).toString());
        jlb_quantity.setText(tbl_Inventorybilldetail.getModel().getValueAt(row, 4).toString());
        jlb_subTotal.setText(String.valueOf(quantity*price));
                
            
        
    }   
    
    private void Search()
    {
        String productID = txt_sProductID.getText();
        String quantity = txt_sQuantity.getText();
        showTable(inventorybilldetailBUS.search(productID, quantity));
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
        tbl_Inventorybilldetail = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_sProductID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jlb_rowCount = new javax.swing.JLabel();
        jlb_productID = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jlb_totalQuantity = new javax.swing.JLabel();
        jlb_bill = new javax.swing.JLabel();
        jlb_product = new javax.swing.JLabel();
        jlb_quantity1 = new javax.swing.JLabel();
        jlb_product1 = new javax.swing.JLabel();
        jlb_productName = new javax.swing.JLabel();
        jlb_product2 = new javax.swing.JLabel();
        jlb_price = new javax.swing.JLabel();
        jlb_quantity2 = new javax.swing.JLabel();
        jlb_quantity = new javax.swing.JLabel();
        jlb_product3 = new javax.swing.JLabel();
        jlb_subTotal = new javax.swing.JLabel();
        jlb_product4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_sQuantity = new javax.swing.JTextField();
        jlb_product5 = new javax.swing.JLabel();
        jlb_productName1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Inventory Bill detail Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 420, 77));

        tbl_Inventorybilldetail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Inventorybilldetail.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Inventorybilldetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "billID", "productID", "productName", "categoryID", "supplierID", "price", "quantity"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Inventorybilldetail.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Inventorybilldetail.setRowHeight(40);
    tbl_Inventorybilldetail.setRowMargin(2);
    tbl_Inventorybilldetail.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Inventorybilldetail.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Inventorybilldetail.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_InventorybilldetailMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Inventorybilldetail);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1270, 290));

    jLabel3.setBackground(new java.awt.Color(255, 255, 255));
    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 153, 51));
    jLabel3.setText("Search:");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 146, 50));

    txt_sProductID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sProductID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sProductID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sProductIDActionPerformed(evt);
        }
    });
    txt_sProductID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sProductIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sProductID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 260, 52));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("ProductID:");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, 138, 52));

    jlb_rowCount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_rowCount.setForeground(new java.awt.Color(255, 153, 51));
    jlb_rowCount.setText("...");
    jPanel1.add(jlb_rowCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 50, 52));

    jlb_productID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_productID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_productID.setText("...");
    jPanel1.add(jlb_productID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 100, 52));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1310, 10));

    jlb_totalQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_totalQuantity.setForeground(new java.awt.Color(255, 153, 51));
    jlb_totalQuantity.setText("...");
    jPanel1.add(jlb_totalQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 90, 52));

    jlb_bill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_bill.setForeground(new java.awt.Color(255, 153, 51));
    jlb_bill.setText("Row counts:");
    jPanel1.add(jlb_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 130, 52));

    jlb_product.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_product.setForeground(new java.awt.Color(255, 153, 51));
    jlb_product.setText("ProductID:");
    jPanel1.add(jlb_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 110, 52));

    jlb_quantity1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_quantity1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_quantity1.setText("Quantity:");
    jPanel1.add(jlb_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 90, 52));

    jlb_product1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_product1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_product1.setText("Name:");
    jPanel1.add(jlb_product1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 80, 52));

    jlb_productName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_productName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_productName.setText("...");
    jPanel1.add(jlb_productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 250, 52));

    jlb_product2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_product2.setForeground(new java.awt.Color(255, 153, 51));
    jlb_product2.setText("Price:");
    jPanel1.add(jlb_product2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 80, 52));

    jlb_price.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_price.setForeground(new java.awt.Color(255, 153, 51));
    jlb_price.setText("...");
    jPanel1.add(jlb_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 180, 52));

    jlb_quantity2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_quantity2.setForeground(new java.awt.Color(255, 153, 51));
    jlb_quantity2.setText("Quantity:");
    jPanel1.add(jlb_quantity2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 90, 52));

    jlb_quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_quantity.setForeground(new java.awt.Color(255, 153, 51));
    jlb_quantity.setText("...");
    jPanel1.add(jlb_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, 60, 52));

    jlb_product3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_product3.setForeground(new java.awt.Color(255, 153, 51));
    jlb_product3.setText("VNĐ");
    jPanel1.add(jlb_product3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 470, 60, 52));

    jlb_subTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_subTotal.setForeground(new java.awt.Color(255, 153, 51));
    jlb_subTotal.setText("...");
    jPanel1.add(jlb_subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 470, 180, 52));

    jlb_product4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_product4.setForeground(new java.awt.Color(255, 153, 51));
    jlb_product4.setText("Sub Total:");
    jPanel1.add(jlb_product4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 470, 110, 52));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 153, 51));
    jLabel6.setText("Quantity:");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, 138, 52));

    txt_sQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sQuantity.setForeground(new java.awt.Color(255, 153, 51));
    txt_sQuantity.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sQuantityActionPerformed(evt);
        }
    });
    txt_sQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sQuantityKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 260, 52));

    jlb_product5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_product5.setForeground(new java.awt.Color(255, 153, 51));
    jlb_product5.setText("CategoryID:");
    jPanel1.add(jlb_product5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 120, 52));

    jlb_productName1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_productName1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_productName1.setText("...");
    jPanel1.add(jlb_productName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 250, 52));

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

    private void tbl_InventorybilldetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_InventorybilldetailMouseClicked
        showBillValue(billdls);
    }//GEN-LAST:event_tbl_InventorybilldetailMouseClicked

    private void txt_sProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sProductIDActionPerformed

    private void txt_sProductIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sProductIDKeyReleased
        // TODO add your handling code here:
        Search();
    }//GEN-LAST:event_txt_sProductIDKeyReleased

    private void txt_sQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sQuantityActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_sQuantityActionPerformed

    private void txt_sQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sQuantityKeyReleased
        // TODO add your handling code here:
        Search();
    }//GEN-LAST:event_txt_sQuantityKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_bill;
    private javax.swing.JLabel jlb_price;
    private javax.swing.JLabel jlb_product;
    private javax.swing.JLabel jlb_product1;
    private javax.swing.JLabel jlb_product2;
    private javax.swing.JLabel jlb_product3;
    private javax.swing.JLabel jlb_product4;
    private javax.swing.JLabel jlb_product5;
    private javax.swing.JLabel jlb_productID;
    private javax.swing.JLabel jlb_productName;
    private javax.swing.JLabel jlb_productName1;
    private javax.swing.JLabel jlb_quantity;
    private javax.swing.JLabel jlb_quantity1;
    private javax.swing.JLabel jlb_quantity2;
    private javax.swing.JLabel jlb_rowCount;
    private javax.swing.JLabel jlb_subTotal;
    private javax.swing.JLabel jlb_totalQuantity;
    private javax.swing.JTable tbl_Inventorybilldetail;
    private javax.swing.JTextField txt_sProductID;
    private javax.swing.JTextField txt_sQuantity;
    // End of variables declaration//GEN-END:variables
}