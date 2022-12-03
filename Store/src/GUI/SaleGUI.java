/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BUS.BillBUS;
import BUS.BilldetailBUS;
import BUS.CategoryBUS;
import BUS.CustomerBUS;
import BUS.DiscountBUS;
import DTO.Product;
import DTO.Discount;
import BUS.ProductBUS;
import BUS.SupplierBUS;
import DTO.Product;
import DTO.Supplier;
import DTO.Bill;
import DTO.Billdetail;
import DTO.Category;
import DTO.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.apache.logging.log4j.util.Strings.isEmpty;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author Admin
 */
public class SaleGUI extends javax.swing.JFrame {
    ProductBUS productBUS = new ProductBUS();
    CustomerBUS customerBUS = new CustomerBUS();
    DiscountBUS discountBUS = new DiscountBUS();
    CategoryBUS categoryBUS = new CategoryBUS();
    SupplierBUS supplierBUS = new SupplierBUS();
    BillBUS billBUS = new BillBUS();
    BilldetailBUS billdetailBUS = new BilldetailBUS();
    ArrayList<Customer> customer = customerBUS.getList();
    ArrayList<Discount> discount = discountBUS.getList();
    ArrayList<Category> category = categoryBUS.getList();
    ArrayList<Supplier> supplier = supplierBUS.getList();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    /**
     * Creates new form SaleGUI
     */
    ArrayList<Product> arrProduct = new ArrayList<>();
    int staffID;
    
    public SaleGUI(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        AutoCompleteDecorator.decorate(customerJComboBox);
        AutoCompleteDecorator.decorate(discountJComboBox);
        customerBUS.listCustomer();
        discountBUS.listDiscount();
        setValueDiscountJcombo(discount);
        setValueCustomerJcombo(customer);
        customerJComboBox.setSelectedItem("Khách Hàng");
        discountJComboBox.setSelectedItem("Không");
        productBUS.listProduct();
        arrProduct = productBUS.getList();
        showTableProduct(arrProduct);
    }

    public void setValueCustomerJcombo(ArrayList<Customer> customer){
        customerJComboBox.removeAllItems();
        for(Customer c: customer){
            customerJComboBox.addItem(String.valueOf(c.getCustomerID()));
        }
        customerJComboBox.setSelectedItem("Khách Hàng");
    }
    
    public void setValueDiscountJcombo(ArrayList<Discount> discount){
        discountJComboBox.removeAllItems();
        for(Discount d: discount){
            if(d.getQuantity() > 0){
                try { 
                    Date start = new SimpleDateFormat("dd-MM-yyyy").parse(d.getDateStart());
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(java.time.LocalDate.now().toString());
                    Date end = new SimpleDateFormat("dd-MM-yyyy").parse(d.getDateEnd());
                    if(start.before(date) && end.after(date)){
                         discountJComboBox.addItem(String.valueOf(d.getDiscountID()));
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(SaleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        discountJComboBox.setSelectedItem("Không");
    }
    
    private boolean isNumeric(CharSequence cs) {
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void showTableProduct(ArrayList<Product> arrProduct)
    {        
        tbl_product.removeAll();
        DefaultTableModel ModelProduct = (DefaultTableModel) tbl_product.getModel();
        ModelProduct.setRowCount(0);
        Vector data;
        for(Product pro : arrProduct)
        {       
                if(pro.getStatus() == 1 && pro.getQuantity() > 0){
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
    
    private void addCart(){
        boolean flag = false;
        DefaultTableModel ModelCart = (DefaultTableModel) tbl_cart.getModel();
        int row = tbl_product.getSelectedRow();
        
        int productID = 0;          //lấy id sản phẩm
        if(txt_productID.getText().equals("")){
            if(row < 0)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Hãy chọn sản phẩm", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            productID = (int) tbl_product.getValueAt(row, 0);
        }else{
            productID = Integer.parseInt(txt_productID.getText());
        }
        
        if(productBUS.getProductByID(productID) == null){
            JOptionPane.showMessageDialog(new JFrame(), "ID sản phẩm không hợp lệ", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!isNumeric(txt_Qty.getText())){
            JOptionPane.showMessageDialog(new JFrame(), "Số lượng không hợp lệ", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        Product itemCart = productBUS.getProductByID(productID);
        
        for(int i = 0; i< tbl_cart.getRowCount(); i++){
            if(Integer.parseInt(tbl_cart.getModel().getValueAt(i, 0).toString()) == productID){
                flag = true;
                int quantity = Integer.parseInt(tbl_cart.getModel().getValueAt(i, 3).toString()) + getQty();
                if(quantity > itemCart.getQuantity()){
                    JOptionPane.showMessageDialog(new JFrame(), "Sản phẩm không đủ số lượng", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                tbl_cart.getModel().setValueAt(quantity, i, 3);
//                resetText();
                    refesh();
                }
            }
        if(!flag){
            int quantity = getQty();
            if(quantity > itemCart.getQuantity()){
                JOptionPane.showMessageDialog(new JFrame(), "Sản phẩm không đủ số lượng", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            ModelCart.addRow(new Object[]{productID, itemCart.getProductName(),itemCart.getPrice(),quantity});
//            resetText();
                refesh();
        }
        
        getTotal();
    }
    
    private int getQty(){
        if(txt_Qty.getText().equals("")){
            return 1;
        }
        return Integer.parseInt(txt_Qty.getText());
    }
    
    private void editQty(){
        int row = tbl_cart.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Hãy chọn sản phẩm", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!isNumeric(txt_Qty.getText()) || Integer.parseInt(txt_Qty.getText()) <= 0){
            JOptionPane.showMessageDialog(new JFrame(), "Số lượng không hợp lệ", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        int productID = (int) tbl_cart.getValueAt(row, 0);
        Product itemCart = productBUS.getProductByID(productID);
        int quantity = getQty();
        if(quantity > itemCart.getQuantity()){
            JOptionPane.showMessageDialog(new JFrame(), "Sản phẩm không đủ số lượng", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        tbl_cart.getModel().setValueAt(quantity, row, 3);
        getTotal();
    }

    private void del(String type){
        DefaultTableModel ModelCart = (DefaultTableModel) tbl_cart.getModel();
        if(type.equals("Item")){
            int row = tbl_cart.getSelectedRow();
            if(row < 0)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Hãy chọn sản phẩm", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int response = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa sản phẩm không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
            if(response == JOptionPane.YES_OPTION){
              ModelCart.removeRow(row);
              row = -1;
              JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
               getTotal();
              return;
            }
        }
        
        if(type.equals("All")){
            int response = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa giỏ hàng không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
            if(response == JOptionPane.YES_OPTION){
              for (int row = tbl_cart.getRowCount() -1; row >=0 ; row--) {
                ModelCart.removeRow(row);
              }
              getTotal();
              JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
              return;
            }
        }
       
    }
    
    private float getTotal(){
        System.out.println("GUI.SaleGUI.getTotal()");
        float total = 0;
        for (int row = tbl_cart.getRowCount() -1; row >=0 ; row--) {
            total += (float) tbl_cart.getValueAt(row,2) * (int) tbl_cart.getValueAt(row,3);
        }
            if(!discountJComboBox.getSelectedItem().toString().equals("Không")){
                lb_km.setText("% KM: " + String.valueOf(discountBUS.getDiscountID(Integer.parseInt(discountJComboBox.getSelectedItem().toString())).getDiscountValue())+"%");
                lb_total.setText(String.valueOf(total - total * discountBUS.getDiscountID(Integer.parseInt(discountJComboBox.getSelectedItem().toString())).getDiscountValue()/100));
                return total - total * discountBUS.getDiscountID(Integer.parseInt(discountJComboBox.getSelectedItem().toString())).getDiscountValue()/100;
            }
            lb_km.setText("% KM: " + 0 +"%");
            lb_total.setText(String.valueOf(total));
            return total;
    }
        
    private boolean checkCart()
    {
        if(tbl_cart.getRowCount() == 0){
            return false;
        }
        return true;
    }
    
    private void search(){
        String productName = txt_productName.getText();
        String category = txt_category.getText();
        String supplier = txt_supplier.getText();
        showTableProduct(productBUS.search("", productName,category,supplier));
    }
    

    
    private void addBill(){
       
        int billID = 0;
        int staffID = this.staffID;
        int customerID = 0;
        if (!customerJComboBox.getSelectedItem().toString().equals("Khách Hàng")){
            customerID = Integer.parseInt(customerJComboBox.getSelectedItem().toString());
        }
        int discountID = 0;
        
        if (!discountJComboBox.getSelectedItem().toString().equals("Không")){
            discountID = Integer.parseInt(discountJComboBox.getSelectedItem().toString());
        }
        float totalPrice = getTotal();
        if(!(discountID == 0)){
            totalPrice = totalPrice - (totalPrice*discountBUS.getDiscountID(discountID).getDiscountValue()/100);
        }
        String date = java.time.LocalDate.now().toString();
        int status = 1;
        Bill b = new Bill(billID,staffID,customerID,discountID,totalPrice, date, status);
        try {
            billBUS.AddBill(b);
            billBUS.listBill();
            if(!(discountID == 0)){
                Discount d = discountBUS.getDiscountID(discountID);
                d.setQuantity(d.getQuantity() - 1);
                discountBUS.SetDiscount(d);
                discountBUS.listDiscount();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void pay(){
        int customerID = 0;
        if (!customerJComboBox.getSelectedItem().toString().equals("Khách Hàng")){
            customerID = Integer.parseInt(customerJComboBox.getSelectedItem().toString());
        }
        
        DefaultTableModel ModelCart = (DefaultTableModel) tbl_cart.getModel();
        if(!checkCart()){
            JOptionPane.showMessageDialog(new JFrame(), "Chưa có hàng trong giỏ", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        addBill();
        for (int i = 0 ; i < tbl_cart.getRowCount();i++){
                int quantity = (int) tbl_cart.getValueAt(i, 3);
                addBilletail(i);
                updateProduct(i, quantity);
        }
        
        PDF pdf = new PDF();
        pdf.export(getBillID(), this.staffID, customerID);
        for (int row = tbl_cart.getRowCount() -1; row >=0 ; row--) {
            ModelCart.removeRow(row);
        }
        refesh();
        refeshData();
        customerJComboBox.setSelectedItem("Khách Hàng");
        discountJComboBox.setSelectedItem("Không");
        JOptionPane.showMessageDialog(new JFrame(), "Thanh toán thành công", "Dialog",
        JOptionPane.ERROR_MESSAGE);
    }
    
    private void updateProduct(int row, int quantity){
        try{
            int productID = Integer.parseInt(tbl_cart.getModel().getValueAt(row, 0).toString());
            Product p = productBUS.getProductByID(productID);
            p.setQuantity(p.getQuantity() - quantity);
            productBUS.SetProduct(p);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int getBillID(){
        int billID = billBUS.getList().size();
        return billID;
    }
    
    private void addBilletail(int row){
        try{
            int billID = getBillID();
            int productID = Integer.parseInt(tbl_cart.getModel().getValueAt(row, 0).toString());
            int quantity = Integer.parseInt(tbl_cart.getModel().getValueAt(row, 3).toString());
            int status = 1;
            Billdetail bd = new Billdetail(billID, productID, quantity, status);
            
            billdetailBUS.AddBilldetail(bd);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Thêm thất bại", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void refesh(){
        txt_productID.setText("");
        txt_Qty.setText("");
        txt_productName.setText("");
        txt_category.setText("");
        txt_supplier.setText("");
        getTotal();
    }
    
    private void refeshData() {
        try {
            productBUS.listProduct();
            customerBUS.listCustomer();
            discountBUS.listDiscount();
            setValueDiscountJcombo(discount);
            setValueCustomerJcombo(customer);
            showTableProduct(arrProduct);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaleGUI.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_product = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        customerJComboBox = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_cart = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_restore1 = new javax.swing.JToggleButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_cart2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        lb_km = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        categoryCBB2 = new javax.swing.JComboBox<>();
        txt_productID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btn_del6 = new javax.swing.JToggleButton();
        btn_delAll = new javax.swing.JToggleButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_cart3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        discountJComboBox = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        txt_Qty = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_Refresh = new javax.swing.JToggleButton();
        btn_add = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        txt_supplier = new javax.swing.JTextField();
        txt_productName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txt_category = new javax.swing.JTextField();
        lb_total = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        txt_productID2 = new javax.swing.JTextField();
        categoryCBB4 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 60));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 352, -1, -1));

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
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 100, 40));

    customerJComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            customerJComboBoxActionPerformed(evt);
        }
    });
    jPanel1.add(customerJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 40, 180, 40));

    jButton2.setText("...");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 40, 40, 40));

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
            "productID", "productName", "price", "quantity"
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
    jPanel2.add(btn_restore1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, 330, 80));

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

    lb_km.setBackground(new java.awt.Color(255, 255, 255));
    lb_km.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    lb_km.setForeground(new java.awt.Color(255, 153, 51));
    lb_km.setText("% KM:");
    jPanel2.add(lb_km, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 210, 160, 30));

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

    txt_productID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_productIDActionPerformed(evt);
        }
    });
    jPanel2.add(txt_productID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 220, 40));

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
    jPanel2.add(btn_del6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 450, 170, 60));

    btn_delAll.setBackground(new java.awt.Color(255, 0, 0));
    btn_delAll.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_delAll.setForeground(new java.awt.Color(255, 255, 255));
    btn_delAll.setText("Hủy giỏ hàng");
    btn_delAll.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_delAllActionPerformed(evt);
        }
    });
    jPanel2.add(btn_delAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 450, 160, 60));

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
    jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 350, 100, 30));

    discountJComboBox.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            discountJComboBoxItemStateChanged(evt);
        }
    });
    discountJComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            discountJComboBoxMouseClicked(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            discountJComboBoxMouseExited(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            discountJComboBoxMousePressed(evt);
        }
    });
    discountJComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            discountJComboBoxActionPerformed(evt);
        }
    });
    jPanel2.add(discountJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 180, 40));

    jButton6.setText("...");
    jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 40, 40));
    jPanel2.add(txt_Qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, 220, 40));

    jLabel24.setBackground(new java.awt.Color(255, 255, 255));
    jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel24.setForeground(new java.awt.Color(255, 153, 51));
    jLabel24.setText("Tên SP:");
    jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 270, 100, 30));

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
    jPanel2.add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 510, 330, 60));

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
    jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 390, 330, 60));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 330, 10));

    jButton7.setBackground(new java.awt.Color(0, 51, 204));
    jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jButton7.setForeground(new java.awt.Color(255, 255, 255));
    jButton7.setText("Làm Mới");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });
    jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 200, 110, 40));

    txt_supplier.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_supplierKeyReleased(evt);
        }
    });
    jPanel2.add(txt_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 340, 160, 40));

    txt_productName.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_productNameKeyReleased(evt);
        }
    });
    jPanel2.add(txt_productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 260, 160, 40));

    jSeparator3.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator3.setForeground(new java.awt.Color(255, 153, 51));
    jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 940, 10));

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_search_50px.png"))); // NOI18N
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, -1, -1));

    txt_category.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_categoryKeyReleased(evt);
        }
    });
    jPanel2.add(txt_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 300, 160, 40));

    lb_total.setBackground(new java.awt.Color(255, 255, 255));
    lb_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    lb_total.setForeground(new java.awt.Color(255, 153, 51));
    lb_total.setText("...");
    jPanel2.add(lb_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 580, 170, 50));

    jLabel5.setBackground(new java.awt.Color(255, 255, 255));
    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 153, 51));
    jLabel5.setText("VNĐ");
    jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 580, 50, 50));

    jLabel11.setBackground(new java.awt.Color(255, 255, 255));
    jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(255, 153, 51));
    jLabel11.setText("Thành tiền:");
    jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, 130, 50));

    jLabel25.setBackground(new java.awt.Color(255, 255, 255));
    jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel25.setForeground(new java.awt.Color(255, 153, 51));
    jLabel25.setText("Loại SP:");
    jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 310, 100, 30));

    jLabel19.setBackground(new java.awt.Color(255, 255, 255));
    jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel19.setForeground(new java.awt.Color(255, 153, 51));
    jLabel19.setText("Số lượng:");
    jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 170, 100, 30));

    jButton8.setBackground(new java.awt.Color(0, 51, 204));
    jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jButton8.setForeground(new java.awt.Color(255, 255, 255));
    jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8_available_updates_30px.png"))); // NOI18N
    jButton8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton8ActionPerformed(evt);
        }
    });
    jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 200, 110, 40));

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

    private void tbl_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_productMouseClicked

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
        //        showTable(category);
    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        editQty();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void customerJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerJComboBoxActionPerformed

    }//GEN-LAST:event_customerJComboBoxActionPerformed

    private void tbl_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cartMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cartMouseClicked

    private void btn_restore1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_restore1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_restore1MouseClicked

    private void btn_restore1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restore1ActionPerformed
        // TODO add your handling code here:
        pay();
    }//GEN-LAST:event_btn_restore1ActionPerformed

    private void tbl_cart2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cart2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cart2MouseClicked

    private void categoryCBB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBB2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryCBB2ActionPerformed

    private void btn_del6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_del6ActionPerformed
        // TODO add your handling code here:
       del("Item");
    }//GEN-LAST:event_btn_del6ActionPerformed

    private void btn_delAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delAllActionPerformed
       del("All");
    }//GEN-LAST:event_btn_delAllActionPerformed

    private void tbl_cart3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cart3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_cart3MouseClicked

    private void categoryCBB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCBB4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryCBB4ActionPerformed

    private void discountJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountJComboBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_discountJComboBoxActionPerformed

    private void txt_productIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productIDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            CustomerManagement customerManagement = new CustomerManagement(staffID);
            customerManagement.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaleGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_productNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_productNameKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_productNameKeyReleased

    private void txt_categoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_categoryKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_categoryKeyReleased

    private void txt_supplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_supplierKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_supplierKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        refeshData();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void discountJComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discountJComboBoxMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_discountJComboBoxMouseClicked

    private void discountJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_discountJComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_discountJComboBoxItemStateChanged

    private void discountJComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discountJComboBoxMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_discountJComboBoxMousePressed

    private void discountJComboBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discountJComboBoxMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_discountJComboBoxMouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        getTotal();
    }//GEN-LAST:event_jButton8ActionPerformed

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
//            java.util.logging.Logger.getLogger(SaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SaleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new SaleGUI().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(SaleGUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JToggleButton btn_add;
    private javax.swing.JToggleButton btn_del6;
    private javax.swing.JToggleButton btn_delAll;
    private javax.swing.JToggleButton btn_restore1;
    private javax.swing.JComboBox<String> categoryCBB2;
    private javax.swing.JComboBox<String> categoryCBB4;
    private javax.swing.JComboBox<String> customerJComboBox;
    private javax.swing.JComboBox<String> discountJComboBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JLabel lb_km;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTable tbl_cart;
    private javax.swing.JTable tbl_cart2;
    private javax.swing.JTable tbl_cart3;
    private javax.swing.JTable tbl_product;
    private javax.swing.JTextField txt_Qty;
    private javax.swing.JTextField txt_category;
    private javax.swing.JTextField txt_productID;
    private javax.swing.JTextField txt_productID2;
    private javax.swing.JTextField txt_productName;
    private javax.swing.JTextField txt_supplier;
    // End of variables declaration//GEN-END:variables
}
