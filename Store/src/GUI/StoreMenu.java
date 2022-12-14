/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
public class StoreMenu extends javax.swing.JFrame {


    
    public StoreMenu() {
        initComponents();

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
        btn_categoryManegement = new javax.swing.JToggleButton();
        btn_customerManagement = new javax.swing.JToggleButton();
        btn_Logout = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_billManagement = new javax.swing.JToggleButton();
        btn_discountManagement = new javax.swing.JToggleButton();
        btn_productManagement = new javax.swing.JToggleButton();
        btn_supplierManagement = new javax.swing.JToggleButton();
        btn_staffManagement = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        btn_categoryManegement1 = new javax.swing.JToggleButton();
        btn_discountManagement1 = new javax.swing.JToggleButton();
        btn_staffManagement1 = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Store Menu");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 140, 77));

        btn_categoryManegement.setBackground(new java.awt.Color(255, 153, 51));
        btn_categoryManegement.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_categoryManegement.setForeground(new java.awt.Color(255, 255, 255));
        btn_categoryManegement.setText("Lo???i s???n ph???m");
        btn_categoryManegement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_categoryManegementMouseClicked(evt);
            }
        });
        btn_categoryManegement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoryManegementActionPerformed(evt);
            }
        });
        jPanel1.add(btn_categoryManegement, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, 90));

        btn_customerManagement.setBackground(new java.awt.Color(255, 153, 51));
        btn_customerManagement.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_customerManagement.setForeground(new java.awt.Color(255, 255, 255));
        btn_customerManagement.setText("Kh??ch h??ng");
        btn_customerManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_customerManagementMouseClicked(evt);
            }
        });
        btn_customerManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customerManagementActionPerformed(evt);
            }
        });
        jPanel1.add(btn_customerManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 200, 90));

        btn_Logout.setBackground(new java.awt.Color(255, 51, 51));
        btn_Logout.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_Logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_Logout.setText("????ng xu???t");
        btn_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LogoutMouseClicked(evt);
            }
        });
        btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 610, 220, 90));

        jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1280, 10));

        btn_billManagement.setBackground(new java.awt.Color(255, 153, 51));
        btn_billManagement.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_billManagement.setForeground(new java.awt.Color(255, 255, 255));
        btn_billManagement.setText("H??a ????n");
        btn_billManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_billManagementMouseClicked(evt);
            }
        });
        btn_billManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_billManagementActionPerformed(evt);
            }
        });
        jPanel1.add(btn_billManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 200, 90));

        btn_discountManagement.setBackground(new java.awt.Color(255, 153, 51));
        btn_discountManagement.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_discountManagement.setForeground(new java.awt.Color(255, 255, 255));
        btn_discountManagement.setText("Khuy???n m??i");
        btn_discountManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_discountManagementMouseClicked(evt);
            }
        });
        btn_discountManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_discountManagementActionPerformed(evt);
            }
        });
        jPanel1.add(btn_discountManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 200, 90));

        btn_productManagement.setBackground(new java.awt.Color(255, 153, 51));
        btn_productManagement.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_productManagement.setForeground(new java.awt.Color(255, 255, 255));
        btn_productManagement.setText("S???n ph???m");
        btn_productManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_productManagementMouseClicked(evt);
            }
        });
        btn_productManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productManagementActionPerformed(evt);
            }
        });
        jPanel1.add(btn_productManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 200, 90));

        btn_supplierManagement.setBackground(new java.awt.Color(255, 153, 51));
        btn_supplierManagement.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_supplierManagement.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplierManagement.setText("Nh?? cung c???p");
        btn_supplierManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_supplierManagementMouseClicked(evt);
            }
        });
        btn_supplierManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierManagementActionPerformed(evt);
            }
        });
        jPanel1.add(btn_supplierManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 90, 200, 90));

        btn_staffManagement.setBackground(new java.awt.Color(255, 153, 51));
        btn_staffManagement.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_staffManagement.setForeground(new java.awt.Color(255, 255, 255));
        btn_staffManagement.setText("Nh??n vi??n");
        btn_staffManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_staffManagementMouseClicked(evt);
            }
        });
        btn_staffManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_staffManagementActionPerformed(evt);
            }
        });
        jPanel1.add(btn_staffManagement, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 200, 90));

        jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 1280, 10));

        btn_categoryManegement1.setBackground(new java.awt.Color(255, 153, 51));
        btn_categoryManegement1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_categoryManegement1.setForeground(new java.awt.Color(255, 255, 255));
        btn_categoryManegement1.setText("Th???ng k??");
        btn_categoryManegement1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_categoryManegement1MouseClicked(evt);
            }
        });
        btn_categoryManegement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoryManegement1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_categoryManegement1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 200, 90));

        btn_discountManagement1.setBackground(new java.awt.Color(255, 153, 51));
        btn_discountManagement1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_discountManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btn_discountManagement1.setText("Th???ng k??");
        btn_discountManagement1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_discountManagement1MouseClicked(evt);
            }
        });
        btn_discountManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_discountManagement1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_discountManagement1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 200, 90));

        btn_staffManagement1.setBackground(new java.awt.Color(255, 153, 51));
        btn_staffManagement1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_staffManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btn_staffManagement1.setText("Th???ng k??");
        btn_staffManagement1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_staffManagement1MouseClicked(evt);
            }
        });
        btn_staffManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_staffManagement1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_staffManagement1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 200, 90));

        jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 153, 51));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 1280, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_categoryManegementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_categoryManegementMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            CategoryManagement sm = new CategoryManagement();
            sm.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_categoryManegementMouseClicked

    private void btn_categoryManegementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoryManegementActionPerformed
//        CourseRecovery a = new CourseRecovery();
//        a.setVisible(true);

    }//GEN-LAST:event_btn_categoryManegementActionPerformed

    private void btn_customerManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customerManagementActionPerformed

    }//GEN-LAST:event_btn_customerManagementActionPerformed

    private void btn_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LogoutMouseClicked
        Login l = new Login();
        l.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_LogoutMouseClicked

    private void btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LogoutActionPerformed

    private void btn_billManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_billManagementMouseClicked
        try {
           BillManagement b = new BillManagement();
            b.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_billManagementMouseClicked

    private void btn_billManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_billManagementActionPerformed

    }//GEN-LAST:event_btn_billManagementActionPerformed

    private void btn_discountManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_discountManagementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_discountManagementActionPerformed

    private void btn_productManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_productManagementMouseClicked
        // TODO add your handling code here:
        try {
            ProductManagement pm = new ProductManagement();
            pm.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_productManagementMouseClicked

    private void btn_productManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productManagementActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_productManagementActionPerformed

    private void btn_supplierManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierManagementActionPerformed

    }//GEN-LAST:event_btn_supplierManagementActionPerformed

    private void btn_staffManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_staffManagementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_staffManagementActionPerformed

    private void btn_discountManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_discountManagementMouseClicked
        // TODO add your handling code here:
        try {
           DiscountManagement d = new DiscountManagement();
            d.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_discountManagementMouseClicked

    private void btn_customerManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customerManagementMouseClicked
        try {
           CustomerManagement cu = new CustomerManagement();
            cu.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_customerManagementMouseClicked

    private void btn_staffManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_staffManagementMouseClicked
        try {
           StaffManagement s = new StaffManagement();
            s.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_staffManagementMouseClicked

    private void btn_supplierManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_supplierManagementMouseClicked
        // TODO add your handling code here:
        try {
           SupplierManagement su = new SupplierManagement();
            su.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoreMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_supplierManagementMouseClicked

    private void btn_categoryManegement1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_categoryManegement1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_categoryManegement1MouseClicked

    private void btn_categoryManegement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoryManegement1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_categoryManegement1ActionPerformed

    private void btn_discountManagement1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_discountManagement1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_discountManagement1MouseClicked

    private void btn_discountManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_discountManagement1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_discountManagement1ActionPerformed

    private void btn_staffManagement1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_staffManagement1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_staffManagement1MouseClicked

    private void btn_staffManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_staffManagement1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_staffManagement1ActionPerformed

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
            java.util.logging.Logger.getLogger(StoreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoreMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Logout;
    private javax.swing.JToggleButton btn_billManagement;
    private javax.swing.JToggleButton btn_categoryManegement;
    private javax.swing.JToggleButton btn_categoryManegement1;
    private javax.swing.JToggleButton btn_customerManagement;
    private javax.swing.JToggleButton btn_discountManagement;
    private javax.swing.JToggleButton btn_discountManagement1;
    private javax.swing.JToggleButton btn_productManagement;
    private javax.swing.JToggleButton btn_staffManagement;
    private javax.swing.JToggleButton btn_staffManagement1;
    private javax.swing.JToggleButton btn_supplierManagement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
