/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DTO.Product;
import BUS.ProductBUS;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class SaleGUI extends javax.swing.JFrame {
    ProductBUS productBUS = new ProductBUS();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    /**
     * Creates new form SaleGUI
     */
    ArrayList<Product> arrProduct = new ArrayList<>();
    ArrayList<Product> arrCart = new ArrayList<>();
    
    public SaleGUI() throws ClassNotFoundException {
        initComponents();
        productBUS.listProduct();
        showTableProduct();
    }

    private void showTableProduct()
    {        
        tbl_product.removeAll();
        arrProduct = productBUS.getList();
        DefaultTableModel ModelProduct = (DefaultTableModel) tbl_product.getModel();
        ModelProduct.setRowCount(0);
        Vector data;
        for(Product pro : arrProduct)
        {       
                if(pro.getStatus() == 1){
                    data = new Vector();
                    data.add(pro.getProductID());
                    data.add(pro.getProductName());
                    data.add(pro.getCategoryID());
                    data.add(pro.getSupplierID());
                    data.add(pro.getPrice());
                    data.add(pro.getQuantity());
                    ModelProduct.addRow(data);
                }
            }        
        tbl_product.setModel(ModelProduct);
    }
    
    private void showTableCart()
    {        
        tbl_cart.removeAll();
        DefaultTableModel ModelCart = (DefaultTableModel) tbl_cart.getModel();
        ModelCart.setRowCount(0);
        Vector data;
        for(Product cart : arrCart)
        {       
                if(cart.getStatus() == 1){
                    data = new Vector();
                    data.add(cart.getProductID());
                    data.add(cart.getProductName());
                    data.add(cart.getCategoryID());
                    data.add(cart.getSupplierID());
                    data.add(cart.getPrice());
                    data.add(cart.getQuantity());
                    ModelCart.addRow(data);
                }
            }        
        tbl_cart.setModel(ModelCart);
    }
    
    private void addCart(){
        int row = tbl_product.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Hãy chọn sản phẩm", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int productID = (int) tbl_product.getValueAt(row, 0);
        Product itemCart = productBUS.getProductByID(productID);
        arrCart.add(itemCart);
        showTableCart();
    }

//    private boolean checkItemCart(ArrayList<Product> cart,int id){
//        for(Product c : arrCart){
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
        tbl_product = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        categoryCBB = new javax.swing.JComboBox<>();
        btn_del1 = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_del2 = new javax.swing.JToggleButton();
        btn_del3 = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_cart = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_add1 = new javax.swing.JToggleButton();
        btn_del4 = new javax.swing.JToggleButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_restore1 = new javax.swing.JToggleButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_cart2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        categoryCBB2 = new javax.swing.JComboBox<>();
        txt_productID1 = new javax.swing.JTextField();
        btn_del5 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        btn_Refresh1 = new javax.swing.JToggleButton();
        jLabel21 = new javax.swing.JLabel();
        lb_total1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        categoryCBB3 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        btn_del6 = new javax.swing.JToggleButton();
        btn_del7 = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_cart3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        categoryCBB1 = new javax.swing.JComboBox<>();
        categoryCBB5 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txt_Qty = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_productID2 = new javax.swing.JTextField();
        categoryCBB4 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();

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
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, 330, 60));

        btn_del.setBackground(new java.awt.Color(255, 0, 0));
        btn_del.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_del.setForeground(new java.awt.Color(255, 255, 255));
        btn_del.setText("Giảm");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });
        jPanel1.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 430, 160, 60));
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

        tbl_product.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_product.setForeground(new java.awt.Color(255, 153, 51));
        tbl_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productID", "productName", "categoryID", "supplierID", "price", "quantity"
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
    tbl_product.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_product.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_productMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tbl_product);

    jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 940, 300));

    jLabel3.setBackground(new java.awt.Color(255, 255, 255));
    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 153, 51));
    jLabel3.setText("Sản phẩm");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 90, 40));

    jLabel5.setBackground(new java.awt.Color(255, 255, 255));
    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("VNĐ");
    jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 560, 50, 50));

    categoryCBB.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryCBBActionPerformed(evt);
        }
    });
    jPanel1.add(categoryCBB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, 180, 40));

    btn_del1.setBackground(new java.awt.Color(102, 255, 102));
    btn_del1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del1.setForeground(new java.awt.Color(255, 255, 255));
    btn_del1.setText("Tăng");
    btn_del1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del1ActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 430, 170, 60));

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
    jPanel1.add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 490, 330, 70));

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
    jLabel12.setText("Nhân viên:");
    jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 100, 30));

    jButton2.setText("...");
    jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 40, 40, 40));

    btn_del2.setBackground(new java.awt.Color(255, 0, 0));
    btn_del2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del2.setForeground(new java.awt.Color(255, 255, 255));
    btn_del2.setText("Xóa");
    btn_del2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del2ActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, 170, 60));

    btn_del3.setBackground(new java.awt.Color(255, 0, 0));
    btn_del3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del3.setForeground(new java.awt.Color(255, 255, 255));
    btn_del3.setText("Hủy giỏ hàng");
    btn_del3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del3ActionPerformed(evt);
        }
    });
    jPanel1.add(btn_del3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 370, 160, 60));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 950, 10));

    jLabel6.setBackground(new java.awt.Color(255, 255, 255));
    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 153, 51));
    jLabel6.setText("Giỏ hàng");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 90, 40));

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
    jScrollPane3.setViewportView(tbl_cart);

    jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 940, 320));

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setMinimumSize(new java.awt.Dimension(1300, 720));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    btn_add1.setBackground(new java.awt.Color(102, 255, 102));
    btn_add1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_add1.setForeground(new java.awt.Color(255, 255, 255));
    btn_add1.setText("Thêm sản phẩm");
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
    jPanel2.add(btn_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, 330, 60));

    btn_del4.setBackground(new java.awt.Color(255, 0, 0));
    btn_del4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del4.setForeground(new java.awt.Color(255, 255, 255));
    btn_del4.setText("Giảm");
    btn_del4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del4ActionPerformed(evt);
        }
    });
    jPanel2.add(btn_del4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 430, 160, 60));
    jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 60));
    jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 352, -1, -1));

    btn_restore1.setBackground(new java.awt.Color(102, 255, 102));
    btn_restore1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_restore1.setForeground(new java.awt.Color(255, 255, 255));
    btn_restore1.setText("Thanh Toán");
    btn_restore1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_restore1MouseClicked(evt);
        }
    });
    btn_restore1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_restore1ActionPerformed(evt);
        }
    });
    jPanel2.add(btn_restore1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 620, 330, 90));

    tbl_cart2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    tbl_cart2.setForeground(new java.awt.Color(255, 153, 51));
    tbl_cart2.setModel(new javax.swing.table.DefaultTableModel(
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
    tbl_cart2.setRowHeight(40);
    tbl_cart2.setRowMargin(2);
    tbl_cart2.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_cart2.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_cart2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_cart2MouseClicked(evt);
        }
    });
    jScrollPane4.setViewportView(tbl_cart2);

    jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 940, 300));

    jLabel15.setBackground(new java.awt.Color(255, 255, 255));
    jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(255, 153, 51));
    jLabel15.setText("Sản phẩm");
    jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 90, 40));

    jLabel16.setBackground(new java.awt.Color(255, 255, 255));
    jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(255, 153, 51));
    jLabel16.setText("VNĐ");
    jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 560, 50, 50));

    jLabel17.setBackground(new java.awt.Color(255, 255, 255));
    jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel17.setForeground(new java.awt.Color(255, 153, 51));
    jLabel17.setText("Số lượng:");
    jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 100, 30));

    jLabel18.setBackground(new java.awt.Color(255, 255, 255));
    jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel18.setForeground(new java.awt.Color(255, 153, 51));
    jLabel18.setText("ID SP:");
    jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, 100, 30));

    categoryCBB2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryCBB2ActionPerformed(evt);
        }
    });
    jPanel2.add(categoryCBB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, 180, 40));

    txt_productID1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_productID1ActionPerformed(evt);
        }
    });
    jPanel2.add(txt_productID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 220, 40));

    btn_del5.setBackground(new java.awt.Color(102, 255, 102));
    btn_del5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del5.setForeground(new java.awt.Color(255, 255, 255));
    btn_del5.setText("Tăng");
    btn_del5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del5ActionPerformed(evt);
        }
    });
    jPanel2.add(btn_del5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 430, 170, 60));

    jButton3.setText("...");
    jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 200, 40, 40));

    btn_Refresh1.setBackground(new java.awt.Color(102, 255, 255));
    btn_Refresh1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Refresh1.setForeground(new java.awt.Color(255, 255, 255));
    btn_Refresh1.setText("Cập nhật số lượng");
    btn_Refresh1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_Refresh1MouseClicked(evt);
        }
    });
    btn_Refresh1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_Refresh1ActionPerformed(evt);
        }
    });
    jPanel2.add(btn_Refresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 490, 330, 70));

    jLabel21.setBackground(new java.awt.Color(255, 255, 255));
    jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel21.setForeground(new java.awt.Color(255, 153, 51));
    jLabel21.setText("Thành tiền:");
    jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 560, 130, 50));

    lb_total1.setBackground(new java.awt.Color(255, 255, 255));
    lb_total1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    lb_total1.setForeground(new java.awt.Color(255, 153, 51));
    lb_total1.setText("...");
    jPanel2.add(lb_total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 560, 170, 50));

    jLabel22.setBackground(new java.awt.Color(255, 255, 255));
    jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel22.setForeground(new java.awt.Color(255, 153, 51));
    jLabel22.setText("Nhân viên:");
    jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 100, 30));

    categoryCBB3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryCBB3ActionPerformed(evt);
        }
    });
    jPanel2.add(categoryCBB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 200, 180, 40));

    jButton4.setText("...");
    jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 40, 40, 40));

    btn_del6.setBackground(new java.awt.Color(255, 0, 0));
    btn_del6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del6.setForeground(new java.awt.Color(255, 255, 255));
    btn_del6.setText("Xóa");
    btn_del6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del6ActionPerformed(evt);
        }
    });
    jPanel2.add(btn_del6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 370, 170, 60));

    btn_del7.setBackground(new java.awt.Color(255, 0, 0));
    btn_del7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_del7.setForeground(new java.awt.Color(255, 255, 255));
    btn_del7.setText("Hủy giỏ hàng");
    btn_del7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_del7ActionPerformed(evt);
        }
    });
    jPanel2.add(btn_del7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 370, 160, 60));

    jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator3.setForeground(new java.awt.Color(255, 153, 51));
    jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 950, 10));

    jLabel23.setBackground(new java.awt.Color(255, 255, 255));
    jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel23.setForeground(new java.awt.Color(255, 153, 51));
    jLabel23.setText("Giỏ hàng");
    jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 90, 40));

    tbl_cart3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    tbl_cart3.setForeground(new java.awt.Color(255, 153, 51));
    tbl_cart3.setModel(new javax.swing.table.DefaultTableModel(
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
    tbl_cart3.setRowHeight(40);
    tbl_cart3.setRowMargin(2);
    tbl_cart3.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_cart3.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_cart3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_cart3MouseClicked(evt);
        }
    });
    jScrollPane5.setViewportView(tbl_cart3);

    jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 940, 320));

    jLabel8.setBackground(new java.awt.Color(255, 255, 255));
    jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 153, 51));
    jLabel8.setText("Nhà CC:");
    jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 210, 100, 30));

    categoryCBB1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryCBB1ActionPerformed(evt);
        }
    });
    jPanel2.add(categoryCBB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, 180, 40));

    categoryCBB5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryCBB5ActionPerformed(evt);
        }
    });
    jPanel2.add(categoryCBB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 180, 40));

    jButton1.setText("...");
    jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 160, 40, 40));

    jButton6.setText("...");
    jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 40, 40));
    jPanel2.add(txt_Qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 240, 220, 40));

    jLabel24.setBackground(new java.awt.Color(255, 255, 255));
    jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel24.setForeground(new java.awt.Color(255, 153, 51));
    jLabel24.setText("Loại SP:");
    jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 170, 100, 30));

    jLabel9.setBackground(new java.awt.Color(255, 255, 255));
    jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 153, 51));
    jLabel9.setText("Mã KM:");
    jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 80, 30));

    jLabel10.setBackground(new java.awt.Color(255, 255, 255));
    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 153, 51));
    jLabel10.setText("Mã KH:");
    jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 80, 30));

    jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    jPanel1.add(txt_productID2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 220, 40));

    categoryCBB4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            categoryCBB4ActionPerformed(evt);
        }
    });
    jPanel1.add(categoryCBB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 180, 40));

    jButton5.setText("...");
    jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 40, 40));

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
        addCart();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed

    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restoreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restoreMouseClicked

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed

    }//GEN-LAST:event_btn_restoreActionPerformed

    private void tbl_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_productMouseClicked

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

    private void tbl_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cartMouseClicked

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void btn_del4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_del4ActionPerformed

    private void btn_restore1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restore1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restore1MouseClicked

    private void btn_restore1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restore1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restore1ActionPerformed

    private void tbl_cart2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cart2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cart2MouseClicked

    private void categoryCBB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBB2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryCBB2ActionPerformed

    private void btn_del5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_del5ActionPerformed

    private void btn_Refresh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_Refresh1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Refresh1MouseClicked

    private void btn_Refresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Refresh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Refresh1ActionPerformed

    private void categoryCBB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBB3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryCBB3ActionPerformed

    private void btn_del6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_del6ActionPerformed

    private void btn_del7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_del7ActionPerformed

    private void tbl_cart3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cart3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cart3MouseClicked

    private void categoryCBB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBB4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryCBB4ActionPerformed

    private void categoryCBB5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBB5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryCBB5ActionPerformed

    private void txt_productID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productID1ActionPerformed

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
                try {
                    new SaleGUI().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JToggleButton btn_Refresh1;
    private javax.swing.JToggleButton btn_add;
    private javax.swing.JToggleButton btn_add1;
    private javax.swing.JToggleButton btn_del;
    private javax.swing.JToggleButton btn_del1;
    private javax.swing.JToggleButton btn_del2;
    private javax.swing.JToggleButton btn_del3;
    private javax.swing.JToggleButton btn_del4;
    private javax.swing.JToggleButton btn_del5;
    private javax.swing.JToggleButton btn_del6;
    private javax.swing.JToggleButton btn_del7;
    private javax.swing.JToggleButton btn_restore;
    private javax.swing.JToggleButton btn_restore1;
    private javax.swing.JComboBox<String> categoryCBB;
    private javax.swing.JComboBox<String> categoryCBB1;
    private javax.swing.JComboBox<String> categoryCBB2;
    private javax.swing.JComboBox<String> categoryCBB3;
    private javax.swing.JComboBox<String> categoryCBB4;
    private javax.swing.JComboBox<String> categoryCBB5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lb_total;
    private javax.swing.JLabel lb_total1;
    private javax.swing.JTable tbl_cart;
    private javax.swing.JTable tbl_cart2;
    private javax.swing.JTable tbl_cart3;
    private javax.swing.JTable tbl_product;
    private javax.swing.JTextField txt_Qty;
    private javax.swing.JTextField txt_productID1;
    private javax.swing.JTextField txt_productID2;
    // End of variables declaration//GEN-END:variables
}
