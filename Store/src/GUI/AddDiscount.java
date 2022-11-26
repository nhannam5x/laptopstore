package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
//import DTO.Customer;
//import BUS.CustomerBUS;

import BUS.DiscountBUS;
import DTO.Discount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static org.apache.logging.log4j.util.Strings.isEmpty;


/**
 *
 * @author LacKhaiMinh
 */
public class AddDiscount extends javax.swing.JFrame {

    DiscountBUS discountBUS = new DiscountBUS() ;
   
    public AddDiscount() throws ClassNotFoundException {
        initComponents();
        discountBUS.listDiscount();

        
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

    
    public void refeshText(){
        txt_discountID.setText("DiscountID");
        txt_discountValue.setText("DiscountValue");
        txt_dateStart.setText("DateStart");
        txt_dateEnd.setText("DateEnd");
        txt_quantity.setText("Quantity");
    }

    
    
    public void addDiscount(){
        int discountID, discountValue, quantity;
        String dateStart, dateEnd;
        System.out.println(isValidDate(txt_dateStart.getText()));
        try {
            if(!isNumeric(txt_discountID.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Mã khuyến mãi không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else discountID = Integer.parseInt(txt_discountID.getText());
            
            if(!isNumeric(txt_discountValue.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Giá trị khuyến mãi không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else discountValue = Integer.parseInt(txt_discountValue.getText());
            
            if(!isNumeric(txt_quantity.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Số lượng không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else quantity = Integer.parseInt(txt_quantity.getText());            
                        
            if(!isValidDate(txt_dateStart.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Ngày bắt đầu không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else dateStart = txt_dateStart.getText();            
            
            if(!isValidDate(txt_dateEnd.getText())){
                JOptionPane.showMessageDialog(new JFrame(), "Ngày kết thúc không hợp lệ ", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            else dateEnd = txt_dateEnd.getText();
         
            int status = 1;
            Discount d = new Discount(discountID, discountValue, dateStart, dateEnd, quantity, status);
            
            if(!discountBUS.CheckDiscountID(discountID)) {
                        discountBUS.AddDiscount(d);
                        this.refeshText();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Mã khuyến mãi bị trùng", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
                    }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddDiscount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_discountID = new javax.swing.JTextField();
        txt_dateStart = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_discountValue = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_dateEnd = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txt_quantity = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD DISCOUNT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD DISCOUNT");

        txt_discountID.setBackground(new java.awt.Color(255, 153, 51));
        txt_discountID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_discountID.setForeground(new java.awt.Color(255, 255, 255));
        txt_discountID.setText("DiscountID");
        txt_discountID.setBorder(null);
        txt_discountID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_discountIDFocusGained(evt);
            }
        });
        txt_discountID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_discountIDActionPerformed(evt);
            }
        });

        txt_dateStart.setBackground(new java.awt.Color(255, 153, 51));
        txt_dateStart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_dateStart.setForeground(new java.awt.Color(255, 255, 255));
        txt_dateStart.setText("DateStart");
        txt_dateStart.setBorder(null);
        txt_dateStart.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dateStartFocusGained(evt);
            }
        });
        txt_dateStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateStartActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_user_50px_4.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
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

        txt_discountValue.setBackground(new java.awt.Color(255, 153, 51));
        txt_discountValue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_discountValue.setForeground(new java.awt.Color(255, 255, 255));
        txt_discountValue.setText("DiscountValue");
        txt_discountValue.setBorder(null);
        txt_discountValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_discountValueFocusGained(evt);
            }
        });
        txt_discountValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_discountValueActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        txt_dateEnd.setBackground(new java.awt.Color(255, 153, 51));
        txt_dateEnd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_dateEnd.setForeground(new java.awt.Color(255, 255, 255));
        txt_dateEnd.setText("DateEnd");
        txt_dateEnd.setBorder(null);
        txt_dateEnd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_dateEndFocusGained(evt);
            }
        });
        txt_dateEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateEndActionPerformed(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        txt_quantity.setBackground(new java.awt.Color(255, 153, 51));
        txt_quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_quantity.setForeground(new java.awt.Color(255, 255, 255));
        txt_quantity.setText("Quantity");
        txt_quantity.setBorder(null);
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_quantityFocusGained(evt);
            }
        });
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });

        jSeparator6.setBackground(new java.awt.Color(255, 153, 51));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_dateStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_discountID, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2))
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dateEnd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3)
                            .addComponent(txt_discountValue)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_discountID, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_discountValue, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_discountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_discountIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_discountIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        String Phone = customerPhoneTxt.getText();
//        String Name = customerNameTxt.getText();
//          
//        if(CustomerBUS.check(Phone)){
//            JOptionPane.showMessageDialog(null, "Số điện thoại bạn nhập đã tồn tại");
//        }else{
//            if(Name.equals("")){
//                JOptionPane.showMessageDialog(null, "Vui lòng nhập tên khách");
//            }else if(Phone.equals("")){
//                JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại khách");
//            }else{
//                JOptionPane.showMessageDialog(null, "Khách hàng đã được thêm");
//                Customer a = new Customer(Phone,Name);
//                CustomerBUS.addCustomer(a);
//                this.dispose();
//        }
//        }
        addDiscount();
//        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_discountIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_discountIDFocusGained
        // TODO add your handling code here:
        txt_discountID.setText("");
    }//GEN-LAST:event_txt_discountIDFocusGained

    private void txt_dateStartFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dateStartFocusGained
        // TODO add your handling code here:
        txt_dateStart.setText("");
    }//GEN-LAST:event_txt_dateStartFocusGained

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.refeshText();
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void txt_discountValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_discountValueFocusGained
        // TODO add your handling code here:
        txt_discountValue.setText("");
    }//GEN-LAST:event_txt_discountValueFocusGained

    private void txt_discountValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_discountValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_discountValueActionPerformed

    private void txt_dateEndFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_dateEndFocusGained
        // TODO add your handling code here:
        txt_dateEnd.setText("");
    }//GEN-LAST:event_txt_dateEndFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_dateStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateStartActionPerformed

    private void txt_dateEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateEndActionPerformed

    private void txt_quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusGained
        // TODO add your handling code here:
        txt_quantity.setText("");
    }//GEN-LAST:event_txt_quantityFocusGained

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField txt_dateEnd;
    private javax.swing.JTextField txt_dateStart;
    private javax.swing.JTextField txt_discountID;
    private javax.swing.JTextField txt_discountValue;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
