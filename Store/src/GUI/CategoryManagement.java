/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Category;
import BUS.CategoryBUS;
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
public class CategoryManagement extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    CategoryBUS categoryBUS = new CategoryBUS();
    ArrayList<Category> categoryls = categoryBUS.getList();
    int staffID;
    
    public CategoryManagement(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        categoryBUS.listCategory();

        showTable(categoryls);
    }
    
    private void showTable(ArrayList<Category> categoryls)
    {   
        tbl_Category.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Category.getModel();
        defaultModel.setRowCount(0);
        for(Category c : categoryls)
        {
            if(c.getStatus() == 1){
                int categoryID = c.getCategoryID();
                String categoryName = c.getCategoryName();
                defaultModel.addRow(new Object[]{categoryID, categoryName});
            }
        }
    }
    
    private void showCategoryValue(ArrayList<Category> categoryls)
    {
        
        int row = tbl_Category.getSelectedRow();
        jlb_categoryID.setText(tbl_Category.getModel().getValueAt(row, 0).toString());
        txt_categoryName.setText(tbl_Category.getModel().getValueAt(row, 1).toString());
    }
    
     private void editCategory()
    {
        int categoryID;
        int row = tbl_Category.getSelectedRow();    
        String categoryName;
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn loại cần sửa", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           
           categoryID = Integer.parseInt(jlb_categoryID.getText());
           if(txt_categoryName.getText().equals("") || txt_categoryName.getText().equals("CategoryName")){
                JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập tên loại ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }categoryName = txt_categoryName.getText();
           
           int status =1; 
         
           Category c = new Category(categoryID, categoryName, status);
            
           int response = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa loại "+ categoryID +" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
           if(response == JOptionPane.YES_OPTION){
               categoryBUS.SetCategory(c);
               refresh();
               resetText();
               JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
               return;
           }
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void delCategory(){
        int row = tbl_Category.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn loại cần xoá", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           int categoryID = (int)tbl_Category.getModel().getValueAt(row, 0);
           String categoryName = tbl_Category.getModel().getValueAt(row, 1).toString();
           int status = 0;
           Category c = new Category(categoryID, categoryName, status);
           int response = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa loại "+ categoryID +" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
           if(response == JOptionPane.YES_OPTION){
               categoryBUS.SetCategory(c);
               refresh();
               resetText();
               JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
               return;
           }
           
           resetText();
           row = -1;
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetText(){
        jlb_categoryID.setText("");
        txt_categoryName.setText("");
        
    }
    
    private void refresh(){
        try {
            categoryBUS.listCategory();
            categoryls = categoryBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(categoryls);
    }    
    
    private void search(){
        String categoryID = txt_sCategoryID.getText();
        String categoryName = txt_sCategoryName.getText();
        showTable(categoryBUS.search(categoryID, categoryName));
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
        tbl_Category = new javax.swing.JTable();
        btn_restore = new javax.swing.JToggleButton();
        btn_del = new javax.swing.JToggleButton();
        btn_Update = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txt_sCategoryID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txt_sCategoryName = new javax.swing.JTextField();
        jlb_categoryID = new javax.swing.JLabel();
        jlb_categoryName = new javax.swing.JLabel();
        txt_categoryName = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btn_add1 = new javax.swing.JToggleButton();
        jlb_category = new javax.swing.JLabel();
        btn_exportExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Category Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 290, 77));

        tbl_Category.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Category.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Category.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "categoryID", "categoryName"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Category.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Category.setRowHeight(40);
    tbl_Category.setRowMargin(2);
    tbl_Category.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Category.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Category.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_CategoryMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Category);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1280, 157));

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
    jLabel3.setText("Search:");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 146, 50));

    txt_sCategoryID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sCategoryID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sCategoryID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sCategoryIDActionPerformed(evt);
        }
    });
    txt_sCategoryID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sCategoryIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sCategoryID, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 230, 52));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("CategoryID:");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 138, 52));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1340, 10));

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 51));
    jLabel9.setText("CategoryName:");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 150, 52));

    txt_sCategoryName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sCategoryName.setForeground(new java.awt.Color(255, 153, 51));
    txt_sCategoryName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sCategoryNameActionPerformed(evt);
        }
    });
    txt_sCategoryName.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sCategoryNameKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sCategoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, 320, 52));

    jlb_categoryID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_categoryID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_categoryID.setText("...");
    jPanel1.add(jlb_categoryID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 138, 52));

    jlb_categoryName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_categoryName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_categoryName.setText("CategoryName:");
    jPanel1.add(jlb_categoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 170, 52));

    txt_categoryName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_categoryName.setForeground(new java.awt.Color(255, 153, 51));
    txt_categoryName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_categoryNameActionPerformed(evt);
        }
    });
    jPanel1.add(txt_categoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, 320, 52));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1350, 10));

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

    jlb_category.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_category.setForeground(new java.awt.Color(255, 153, 51));
    jlb_category.setText("CategoryID:");
    jPanel1.add(jlb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 138, 52));

    btn_exportExcel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/a1.png"))); // NOI18N
    btn_exportExcel.setText("XUẤT EXCEL");
    btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_exportExcelActionPerformed(evt);
        }
    });
    jPanel1.add(btn_exportExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 60));

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

    private void tbl_CategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CategoryMouseClicked
        showCategoryValue(categoryls);
    }//GEN-LAST:event_tbl_CategoryMouseClicked

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        CategoryRecovery c = new CategoryRecovery();
        c.setVisible(true);

    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        delCategory();

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        editCategory();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
//        showTable();

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
            refresh();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_sCategoryIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sCategoryIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sCategoryIDActionPerformed

    private void txt_sCategoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sCategoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sCategoryNameActionPerformed

    private void txt_categoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryNameActionPerformed

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        try {
           AddCategory c = new AddCategory();
           c.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupplierManagement.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_sCategoryIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sCategoryIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sCategoryIDKeyReleased

    private void txt_sCategoryNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sCategoryNameKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sCategoryNameKeyReleased

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
//            java.util.logging.Logger.getLogger(CategoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CategoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CategoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CategoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new CategoryManagement().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(CategoryManagement.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_category;
    private javax.swing.JLabel jlb_categoryID;
    private javax.swing.JLabel jlb_categoryName;
    private javax.swing.JTable tbl_Category;
    private javax.swing.JTextField txt_categoryName;
    private javax.swing.JTextField txt_sCategoryID;
    private javax.swing.JTextField txt_sCategoryName;
    // End of variables declaration//GEN-END:variables
}
