/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Discount;
import BUS.DiscountBUS;
import DTO.Category;
import DTO.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.apache.logging.log4j.util.Strings.isEmpty;
/**
 *
 * @author donha
 */
public class DiscountManagement extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    DiscountBUS discountBUS = new DiscountBUS();
    ArrayList<Discount> discountls = discountBUS.getList();
    
    public DiscountManagement() throws ClassNotFoundException {
        initComponents();
        discountBUS.listDiscount();
        showTable(discountls);
    }
    
    private void showTable(ArrayList<Discount> discountls)
    {   
        tbl_Discount.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Discount.getModel();
        defaultModel.setRowCount(0);
        for(Discount d : discountls)
        {
            if(d.getStatus() == 1){
                int discountID = d.getDiscountID();
                int discountValue = d.getDiscountValue();
                String dateStart = d.getDateStart();
                String dateEnd = d.getDateEnd();
                int quantity = d.getQuantity();
                defaultModel.addRow(new Object[]{discountID, discountValue, dateStart, dateEnd, quantity});
            }
        }
    }
    
    private void showDiscountValue(ArrayList<Discount> discountls)
    {
        
        int row = tbl_Discount.getSelectedRow();
        jlb_discountID.setText(tbl_Discount.getModel().getValueAt(row, 0).toString());
        txt_discountValue.setText(tbl_Discount.getModel().getValueAt(row, 1).toString());
        txt_dateStart.setText(tbl_Discount.getModel().getValueAt(row, 2).toString());
        txt_dateEnd.setText(tbl_Discount.getModel().getValueAt(row, 3).toString());
        txt_quantity.setText(tbl_Discount.getModel().getValueAt(row, 4).toString());
    } 
    
        private boolean isNumeric(CharSequence cs) {
        if (isEmpty(cs)) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
     private void editDiscount()
    {
        int discountID, discountValue, quantity;
        String dateStart, dateEnd;
        int row = tbl_Discount.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Ch???n khuy???n m??i c???n s???a", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           
           discountID = Integer.parseInt(jlb_discountID.getText());
           if(!isNumeric(txt_discountValue.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Gi?? tr??? khuy???n m??i kh??ng h???p l??? ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else discountValue = Integer.parseInt(txt_discountValue.getText());
            
            if(!isNumeric(txt_quantity.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "S??? l?????ng kh??ng h???p l??? ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else quantity = Integer.parseInt(txt_quantity.getText());            
                        
            if(!isValidDate(txt_dateStart.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Ng??y b???t ?????u kh??ng h???p l??? ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else dateStart = txt_dateStart.getText();            
            
            if(!isValidDate(txt_dateEnd.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Ng??y k???t th??c kh??ng h???p l??? ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else dateEnd = txt_dateEnd.getText();
           int status =1; 
         
           Discount d = new Discount(discountID, discountValue, dateStart, dateEnd, quantity, status);
                        
            discountBUS.SetDiscount(d);
            refresh();
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(DiscountManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void delDiscount(){
    int row = tbl_Discount.getSelectedRow();    
    try {    
      if(row < 0)
      {
        JOptionPane.showMessageDialog(new JFrame(), "Ch???n s???n ph???m c???n xo??", "Dialog",
        JOptionPane.ERROR_MESSAGE);
        return; 
      }
         
      int discountID = (int)tbl_Discount.getModel().getValueAt(row, 0);
      int discountValue = (int)tbl_Discount.getModel().getValueAt(row, 1);
      String dateStart = tbl_Discount.getModel().getValueAt(row, 2).toString();
      String dateEnd = tbl_Discount.getModel().getValueAt(row, 3).toString();
      int quantity = (int)tbl_Discount.getModel().getValueAt(row, 5);
      int status = 0;
      Discount d = new Discount(discountID, discountValue, dateStart, dateEnd, quantity, status);
      discountBUS.SetDiscount(d);
      refresh();
      resetText();
      row = -1;
            
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void resetText(){
        jlb_discountID.setText("...");
        txt_discountValue.setText("");
        txt_dateStart.setText("");
        txt_dateEnd.setText("");
        txt_quantity.setText("");
    }
    
    private void refresh(){
        try {
            discountBUS.listDiscount();
            discountls = discountBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(discountls);
    }
    
    private void search(){
        String discountID = txt_sDiscountID.getText();
        String dateStart = txt_sDateStart.getText();
        String dateEnd = txt_sDateEnd.getText();
        showTable(discountBUS.search(discountID, dateStart, dateEnd));
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
        tbl_Discount = new javax.swing.JTable();
        btn_restore = new javax.swing.JToggleButton();
        btn_del = new javax.swing.JToggleButton();
        btn_Update = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txt_sDiscountID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txt_sDateStart = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_sDateEnd = new javax.swing.JTextField();
        jlb_discountID = new javax.swing.JLabel();
        jlb_discountValue = new javax.swing.JLabel();
        txt_discountValue = new javax.swing.JTextField();
        jlb_dateStart = new javax.swing.JLabel();
        txt_dateStart = new javax.swing.JTextField();
        jlb_dateEnd = new javax.swing.JLabel();
        txt_dateEnd = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btn_add1 = new javax.swing.JToggleButton();
        jlb_quantity = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        jlb_discount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Discount Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 300, 77));

        tbl_Discount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Discount.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Discount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "discountID", "discountValue", "dateStart", "dateEnd", "quantity"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Discount.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Discount.setRowHeight(40);
    tbl_Discount.setRowMargin(2);
    tbl_Discount.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Discount.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Discount.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_DiscountMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Discount);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1270, 157));

    btn_restore.setBackground(new java.awt.Color(102, 255, 102));
    btn_restore.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_restore.setForeground(new java.awt.Color(255, 255, 255));
    btn_restore.setText("Kh??i ph???c");
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
    btn_del.setText("X??a");
    btn_del.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_delActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 230, 90));

    btn_Update.setBackground(new java.awt.Color(102, 255, 102));
    btn_Update.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Update.setForeground(new java.awt.Color(255, 255, 255));
    btn_Update.setText("S???a");
    btn_Update.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_UpdateActionPerformed(evt);
        }
    });
    jPanel1.add(btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 230, 90));

    btn_Refresh.setBackground(new java.awt.Color(102, 255, 255));
    btn_Refresh.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Refresh.setForeground(new java.awt.Color(255, 255, 255));
    btn_Refresh.setText("L??m M???i");
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
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 146, 50));

    txt_sDiscountID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sDiscountID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sDiscountID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sDiscountIDActionPerformed(evt);
        }
    });
    txt_sDiscountID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sDiscountIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sDiscountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 120, 52));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("DiscountID:");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 138, 52));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 1270, 10));

    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 51));
    jLabel9.setText("DateStart:");
    jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 110, 52));

    txt_sDateStart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sDateStart.setForeground(new java.awt.Color(255, 153, 51));
    txt_sDateStart.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sDateStartActionPerformed(evt);
        }
    });
    txt_sDateStart.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sDateStartKeyReleased(evt);
        }
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txt_sDateStartKeyTyped(evt);
        }
    });
    jPanel1.add(txt_sDateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 260, 52));

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 153, 51));
    jLabel10.setText("DateEnd:");
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 100, 52));

    txt_sDateEnd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sDateEnd.setForeground(new java.awt.Color(255, 153, 51));
    txt_sDateEnd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sDateEndActionPerformed(evt);
        }
    });
    txt_sDateEnd.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sDateEndKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sDateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 460, 270, 52));

    jlb_discountID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_discountID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_discountID.setText("...");
    jPanel1.add(jlb_discountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 138, 52));

    jlb_discountValue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_discountValue.setForeground(new java.awt.Color(255, 153, 51));
    jlb_discountValue.setText("DiscountValue:");
    jPanel1.add(jlb_discountValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 150, 52));

    txt_discountValue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_discountValue.setForeground(new java.awt.Color(255, 153, 51));
    txt_discountValue.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_discountValueActionPerformed(evt);
        }
    });
    jPanel1.add(txt_discountValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 200, 52));

    jlb_dateStart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_dateStart.setForeground(new java.awt.Color(255, 153, 51));
    jlb_dateStart.setText("DateStart:");
    jPanel1.add(jlb_dateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 110, 52));

    txt_dateStart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_dateStart.setForeground(new java.awt.Color(255, 153, 51));
    txt_dateStart.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_dateStartActionPerformed(evt);
        }
    });
    jPanel1.add(txt_dateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 270, 52));

    jlb_dateEnd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_dateEnd.setForeground(new java.awt.Color(255, 153, 51));
    jlb_dateEnd.setText("DateEnd:");
    jPanel1.add(jlb_dateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, 140, 52));

    txt_dateEnd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_dateEnd.setForeground(new java.awt.Color(255, 153, 51));
    txt_dateEnd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_dateEndActionPerformed(evt);
        }
    });
    jPanel1.add(txt_dateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, 290, 52));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1270, 10));

    btn_add1.setBackground(new java.awt.Color(102, 255, 102));
    btn_add1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_add1.setForeground(new java.awt.Color(255, 255, 255));
    btn_add1.setText("Th??m");
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

    jlb_quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_quantity.setForeground(new java.awt.Color(255, 153, 51));
    jlb_quantity.setText("Quantity:");
    jPanel1.add(jlb_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 138, 52));

    txt_quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_quantity.setForeground(new java.awt.Color(255, 153, 51));
    txt_quantity.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_quantityActionPerformed(evt);
        }
    });
    jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 270, 190, 52));

    jlb_discount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_discount.setForeground(new java.awt.Color(255, 153, 51));
    jlb_discount.setText("DiscountID:");
    jPanel1.add(jlb_discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 138, 52));

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

    private void tbl_DiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DiscountMouseClicked
        showDiscountValue(discountls);
    }//GEN-LAST:event_tbl_DiscountMouseClicked

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
//        CourseRecovery a = new CourseRecovery();
//        a.setVisible(true);

    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        delDiscount();

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        editDiscount();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
//        showTable();

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
//        showTable();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_sDiscountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sDiscountIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sDiscountIDActionPerformed

    private void txt_sDateStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sDateStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sDateStartActionPerformed

    private void txt_sDateEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sDateEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sDateEndActionPerformed

    private void txt_discountValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_discountValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_discountValueActionPerformed

    private void txt_dateStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateStartActionPerformed

    private void txt_dateEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateEndActionPerformed

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
//        AddCourse a = new AddCourse();
//        a.setVisible(true);
    try {
           AddDiscount d = new AddDiscount();
            d.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StaffManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void txt_sDiscountIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sDiscountIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sDiscountIDKeyReleased

    private void txt_sDateStartKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sDateStartKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sDateStartKeyReleased

    private void txt_sDateEndKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sDateEndKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sDateEndKeyReleased

    private void txt_sDateStartKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sDateStartKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sDateStartKeyTyped

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
            java.util.logging.Logger.getLogger(DiscountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiscountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiscountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiscountManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DiscountManagement().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DiscountManagement.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_dateEnd;
    private javax.swing.JLabel jlb_dateStart;
    private javax.swing.JLabel jlb_discount;
    private javax.swing.JLabel jlb_discountID;
    private javax.swing.JLabel jlb_discountValue;
    private javax.swing.JLabel jlb_quantity;
    private javax.swing.JTable tbl_Discount;
    private javax.swing.JTextField txt_dateEnd;
    private javax.swing.JTextField txt_dateStart;
    private javax.swing.JTextField txt_discountValue;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_sDateEnd;
    private javax.swing.JTextField txt_sDateStart;
    private javax.swing.JTextField txt_sDiscountID;
    // End of variables declaration//GEN-END:variables
}
