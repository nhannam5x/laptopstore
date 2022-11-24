/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LacKhaiMinh
 */
public class TeacherManegement extends javax.swing.JFrame {
    AddTeacher addCustomer = new AddTeacher();
    /**
     * Creates new form Customer
     */
    
    public TeacherManegement() {
        initComponents();
        
        
        
        customerTbl.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 12));
        customerTbl.getTableHeader().setOpaque(false);
        customerTbl.getTableHeader().setBackground(Color.orange);

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
        customerTbl = new javax.swing.JTable();
        addBtn = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sdtJbl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tenkhachJlb = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        tenkhachJlb1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tenkhachJlb2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        sdtJbl1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tenkhachJlb3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tenkhachJlb4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tenkhachJlb5 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Quản Lý Khách Hàng");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 261, 77));

        customerTbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customerTbl.setForeground(new java.awt.Color(255, 153, 51));
        customerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TeacherID", "Lastname", "Firstname", "HireDate"
            }
        ));
        customerTbl.setRowHeight(40);
        customerTbl.setRowMargin(2);
        customerTbl.setSelectionBackground(new java.awt.Color(153, 255, 153));
        customerTbl.setSelectionForeground(new java.awt.Color(0, 0, 0));
        customerTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerTbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1270, 157));

        addBtn.setBackground(new java.awt.Color(102, 255, 102));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Thêm");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 230, 90));

        jToggleButton2.setBackground(new java.awt.Color(255, 0, 0));
        jToggleButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("Xóa");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 230, 90));

        jToggleButton3.setBackground(new java.awt.Color(102, 255, 102));
        jToggleButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton3.setText("Sửa");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 230, 90));

        jToggleButton4.setBackground(new java.awt.Color(102, 255, 255));
        jToggleButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jToggleButton4.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton4.setText("Làm Mới");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 610, 230, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_50px_5.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 60));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setText("Search:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 352, 146, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_50px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 352, -1, -1));

        sdtJbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sdtJbl.setForeground(new java.awt.Color(255, 153, 51));
        sdtJbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtJblActionPerformed(evt);
            }
        });
        jPanel1.add(sdtJbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 190, 52));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 51));
        jLabel5.setText("TeacherID:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 138, 52));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText("HireDate:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 410, 110, 52));

        tenkhachJlb.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tenkhachJlb.setForeground(new java.awt.Color(255, 153, 51));
        tenkhachJlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhachJlbActionPerformed(evt);
            }
        });
        jPanel1.add(tenkhachJlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 410, 250, 52));

        jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 1270, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 51));
        jLabel9.setText("Lastname:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 110, 52));

        tenkhachJlb1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tenkhachJlb1.setForeground(new java.awt.Color(255, 153, 51));
        tenkhachJlb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhachJlb1ActionPerformed(evt);
            }
        });
        jPanel1.add(tenkhachJlb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 200, 52));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 51));
        jLabel10.setText("Firstname:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 110, 52));

        tenkhachJlb2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tenkhachJlb2.setForeground(new java.awt.Color(255, 153, 51));
        tenkhachJlb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhachJlb2ActionPerformed(evt);
            }
        });
        jPanel1.add(tenkhachJlb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 200, 52));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 51));
        jLabel11.setText("TeacherID:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 138, 52));

        sdtJbl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sdtJbl1.setForeground(new java.awt.Color(255, 153, 51));
        sdtJbl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtJbl1ActionPerformed(evt);
            }
        });
        jPanel1.add(sdtJbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 190, 52));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 51));
        jLabel12.setText("Lastname:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 110, 52));

        tenkhachJlb3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tenkhachJlb3.setForeground(new java.awt.Color(255, 153, 51));
        tenkhachJlb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhachJlb3ActionPerformed(evt);
            }
        });
        jPanel1.add(tenkhachJlb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 200, 52));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 51));
        jLabel13.setText("Firstname:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 110, 52));

        tenkhachJlb4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tenkhachJlb4.setForeground(new java.awt.Color(255, 153, 51));
        tenkhachJlb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhachJlb4ActionPerformed(evt);
            }
        });
        jPanel1.add(tenkhachJlb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 200, 52));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 51));
        jLabel14.setText("HireDate:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, 110, 52));

        tenkhachJlb5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tenkhachJlb5.setForeground(new java.awt.Color(255, 153, 51));
        tenkhachJlb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenkhachJlb5ActionPerformed(evt);
            }
        });
        jPanel1.add(tenkhachJlb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 270, 250, 52));

        jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 334, 1270, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        addCustomer.setVisible(true);
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_addBtnMouseClicked

    private void customerTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTblMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_customerTblMouseClicked

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void tenkhachJlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlbActionPerformed

    private void sdtJblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtJblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtJblActionPerformed

    private void tenkhachJlb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlb1ActionPerformed

    private void tenkhachJlb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlb2ActionPerformed

    private void sdtJbl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtJbl1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtJbl1ActionPerformed

    private void tenkhachJlb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlb3ActionPerformed

    private void tenkhachJlb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlb4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlb4ActionPerformed

    private void tenkhachJlb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenkhachJlb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenkhachJlb5ActionPerformed

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
                if ("Windows Vista".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TeacherManegement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherManegement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherManegement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherManegement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherManegement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addBtn;
    private javax.swing.JTable customerTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JTextField sdtJbl;
    private javax.swing.JTextField sdtJbl1;
    private javax.swing.JTextField tenkhachJlb;
    private javax.swing.JTextField tenkhachJlb1;
    private javax.swing.JTextField tenkhachJlb2;
    private javax.swing.JTextField tenkhachJlb3;
    private javax.swing.JTextField tenkhachJlb4;
    private javax.swing.JTextField tenkhachJlb5;
    // End of variables declaration//GEN-END:variables
}
