package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import BUS.SupplierBUS;
import DTO.Supplier;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LacKhaiMinh
 */
public class SupplierRecovery extends javax.swing.JFrame {
    
    SupplierBUS supplierBUS = new SupplierBUS();
    /**
     * Creates new form Customer
     */
    
    public SupplierRecovery() {
            initComponents();
            
            
            
            tbl_Supplier.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 12));
            tbl_Supplier.getTableHeader().setOpaque(false);
            tbl_Supplier.getTableHeader().setBackground(Color.orange);
            showTable();
            
            
                
     

    }
    
    private void showTable()
    {
        try {
            supplierBUS.listSupplier();
            tbl_Supplier.removeAll();
            DefaultTableModel defaultModel = (DefaultTableModel) tbl_Supplier.getModel();
            defaultModel.setRowCount(0);
            
            ArrayList<Supplier> supplierls = supplierBUS.getList();
            
            for(Supplier p : supplierls)
            {
                if(p.getStatus()==0){
                int supplierID = p.getSupplierID();
                String supplierName = p.getSupplierName();
                String address = p.getAddress();
                
                
                defaultModel.addRow(new Object[]{supplierID, supplierName, address});
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupplierRecovery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void restoreSupplier(){
        
        int row = tbl_Supplier.getSelectedRow();
        
        try {    
          if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn sản phẩm cần khôi phục", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           
           int supplierID = (int)tbl_Supplier.getModel().getValueAt(row, 0);
           String supplierName = tbl_Supplier.getModel().getValueAt(row, 1).toString();
           String address = tbl_Supplier.getModel().getValueAt(row, 2).toString();
           int status = 1;
           Supplier p = new Supplier(supplierID, supplierName, address, status);
                        
        if(supplierBUS.CheckSupplierID(supplierID)) supplierBUS.SetSupplier(p);
        else {
           JOptionPane.showMessageDialog(new JFrame(), "Mã sản phẩm không có trong dữ liêu", "Dialog",
           JOptionPane.ERROR_MESSAGE);
        }
                showTable();
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(SupplierRecovery.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        tbl_Supplier = new javax.swing.JTable();
        btn_restore = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1300, 650));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1290, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Supplier Recovery");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 261, 77));

        tbl_Supplier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Supplier.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "supplierID", "supplierName", "address"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Supplier.setRowHeight(40);
    tbl_Supplier.setRowMargin(2);
    tbl_Supplier.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Supplier.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Supplier.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_SupplierMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Supplier);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1270, 157));

    btn_restore.setBackground(new java.awt.Color(102, 255, 102));
    btn_restore.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_restore.setForeground(new java.awt.Color(255, 255, 255));
    btn_restore.setText("Restore");
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
    jPanel1.add(btn_restore, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 230, 90));

    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_50px_5.png"))); // NOI18N
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 60));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 1270, 10));

    jButton2.setBackground(new java.awt.Color(255, 255, 255));
    jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jButton2.setForeground(new java.awt.Color(255, 153, 51));
    jButton2.setText("X");
    jButton2.setBorder(null);
    jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton2MouseClicked(evt);
        }
    });
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, -1, -1));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 720));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        
        restoreSupplier();
        
        
    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_restoreMouseClicked

    private void tbl_SupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SupplierMouseClicked
        

    }//GEN-LAST:event_tbl_SupplierMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_restore;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_Supplier;
    // End of variables declaration//GEN-END:variables
}
