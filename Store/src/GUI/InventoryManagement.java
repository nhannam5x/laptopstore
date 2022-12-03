/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.InventorybillBUS;
import BUS.InventorybilldetailBUS;
import DTO.Product;
import BUS.ProductBUS;
import DTO.Category;
import BUS.CategoryBUS;
import DTO.Supplier;
import BUS.SupplierBUS;
import DTO.Inventorybill;
import DTO.Inventorybilldetail;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import static org.apache.logging.log4j.util.Strings.isEmpty;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author donha
 */
public class InventoryManagement extends javax.swing.JFrame {

    ProductBUS productBUS = new ProductBUS();
    CategoryBUS categoryBUS = new CategoryBUS();
    SupplierBUS supplierBUS = new SupplierBUS();
    InventorybillBUS inventorybillBUS = new InventorybillBUS();
    InventorybilldetailBUS inventorybilldetailBUS = new InventorybilldetailBUS();
    ArrayList<Product> productls = new ArrayList();
    ArrayList<Category> categoryls = categoryBUS.getList();
    ArrayList<Supplier> supplierls = supplierBUS.getList();
    int staffID;
    
    public InventoryManagement(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        categoryBUS.listCategory();
        supplierBUS.listSupplier();
        ArrayList<Integer> categoryCombo = new ArrayList();
        ArrayList<Integer> supplierCombo = new ArrayList();
            for(Category c: categoryls ){
                categoryCombo.add(c.getCategoryID());
            }
            for(int i=0; i<categoryCombo.size(); i++){
                jComboCategory.addItem(String.valueOf(categoryCombo.get(i)));
            }
        
            for(Supplier s: supplierls ){
                supplierCombo.add(s.getSupplierID());
            }
            for(int i=0; i<supplierCombo.size(); i++){
                jComboSupplier.addItem(String.valueOf(supplierCombo.get(i)));
            }
    }
    
    private void showProductValue(ArrayList<Product> productls)
    {
        
        int row = tbl_Product.getSelectedRow();
        txt_productID.setText(tbl_Product.getModel().getValueAt(row, 0).toString());
        txt_productName.setText(tbl_Product.getModel().getValueAt(row, 1).toString());
        jComboCategory.setSelectedItem(tbl_Product.getModel().getValueAt(row, 2).toString());
        jComboSupplier.setSelectedItem(tbl_Product.getModel().getValueAt(row, 3).toString());
        txt_price.setText(tbl_Product.getModel().getValueAt(row, 4).toString());
        txt_quantity.setText(tbl_Product.getModel().getValueAt(row, 5).toString());
    }   
    
    private boolean CheckAlphabets(String s)
    {
        for (int i = 0; i < s.length(); i++) {
        char charAt2 = s.charAt(i);
        if (Character.isLetter(charAt2)) {
            return true;
            }
        }
        return false;
    }
    
     private void editProduct()
    {
        int row = tbl_Product.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng chọn dòng để sửa", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            return;
        }
        tbl_Product.getModel().setValueAt(txt_productName.getText().toString(), row, 1);
        tbl_Product.getModel().setValueAt(jComboCategory.getSelectedItem(), row, 2);
        tbl_Product.getModel().setValueAt(jComboSupplier.getSelectedItem(), row, 3);
        jComboSupplier.getSelectedItem().toString();
        if(!CheckAlphabets(txt_price.getText())){
            tbl_Product.getModel().setValueAt(txt_price.getText().toString(), row, 4);
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập giá là số", "Dialog",
            JOptionPane.ERROR_MESSAGE);
        }
        if(!CheckAlphabets(txt_quantity.getText())){
            tbl_Product.getModel().setValueAt(txt_quantity.getText().toString(), row, 5);
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng nhập số lượng là số", "Dialog",
            JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void delProduct(){
          int row = tbl_Product.getSelectedRow();
          if(row < 0)
          {
              JOptionPane.showMessageDialog(new JFrame(), "Chọn dữ liệu cần xoá", "Dialog",
                      JOptionPane.ERROR_MESSAGE);
              return;
          }
          ((DefaultTableModel)tbl_Product.getModel()).removeRow(row);
          JOptionPane.showMessageDialog(new JFrame(), "Xóa thành công", "Dialog",
                  JOptionPane.ERROR_MESSAGE);
    }
    
    private void resetText(){
        txt_productID.setText("");
        txt_productName.setText("");
        jComboCategory.setSelectedIndex(0);
        jComboSupplier.setSelectedIndex(0);
        txt_price.setText("");
        txt_quantity.setText("");
    }
    
    private void refresh(){
        
    }
    
    
    public void importExcelToJtableJava() {
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Product.getModel();
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "C/Users/admin/Desktop";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Select Excel File");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
                System.out.println(excelSheet.getLastRowNum());
                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);

                    XSSFCell excelProductID = excelRow.getCell(0);
                    XSSFCell excelProductName = excelRow.getCell(1);
                    XSSFCell excelCategoryID = excelRow.getCell(2);
                    XSSFCell excelSupplierID = excelRow.getCell(3);
                    XSSFCell excelPrice = excelRow.getCell(4);
                    XSSFCell excelQuantity = excelRow.getCell(5);
                    int productID = Math.round(Float.parseFloat(excelProductID.toString()));
                    int categoryID = Math.round(Float.parseFloat(excelCategoryID.toString()));
                    int supplierID = Math.round(Float.parseFloat(excelSupplierID.toString()));
                    int quantity = Math.round(Float.parseFloat(excelQuantity.toString()));
                    defaultModel.addRow(new Object[]{productID, excelProductName, categoryID,supplierID,excelPrice,quantity});
                    
                }
                JOptionPane.showMessageDialog(null, "Imported Successfully !!.....");
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }
    }
    
     private boolean checkInventory()
    {
        
        if(tbl_Product.getRowCount() == 0){
            return false;
        }
        
        return true;
    }
    
    private void addInventory(int row){
        try{
            int productID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 0).toString());
            String productName = tbl_Product.getModel().getValueAt(row, 1).toString();
            int categoryID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 2).toString());
            int supplierID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 3).toString());
            float price = Float.parseFloat(tbl_Product.getModel().getValueAt(row, 4).toString());
            int quantity = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 5).toString());
            int status = 1;
            Product p = new Product(productID,productName,categoryID, supplierID, price, quantity, status);
            
            productBUS.AddProduct(p);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Thêm thất bại", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateInventory(int row, int quantity){
        try{
            int productID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 0).toString());
            String productName = tbl_Product.getModel().getValueAt(row, 1).toString();
            int categoryID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 2).toString());
            int supplierID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 3).toString());
            float price = Float.parseFloat(tbl_Product.getModel().getValueAt(row, 4).toString());
           
            int status = 1;
            Product p = new Product(productID,productName,categoryID, supplierID, price, quantity, status);
            
            productBUS.SetProduct(p);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Thêm thất bại", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private float getTotalPrice(){
        float total = 0;
        for(int i = 0; i < tbl_Product.getRowCount(); i++){
            total += Float.parseFloat(tbl_Product.getModel().getValueAt(i, 4).toString()) * Integer.parseInt(tbl_Product.getModel().getValueAt(i, 5).toString());
            
        }
        return total;
    }
    
    private void addBill(){
       
        int billID = 0;
        int staffID = 1;
        float totalPrice = getTotalPrice();
        String date = java.time.LocalDate.now().toString();
        int status = 1;
        Inventorybill b = new Inventorybill(billID,staffID,totalPrice, date, status);
        try {
           
            inventorybillBUS.AddBill(b);
            inventorybillBUS.listInventorybill();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int getBillID(){
        int billID = 0;
        try {
            billID = inventorybillBUS.getList().size();
            System.out.print(billID);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return billID;
    }
    
    private void addInventorybilldetail(int row){
        try{
            int billID = getBillID();
            int productID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 0).toString());
            int categoryID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 2).toString());
            int supplierID = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 3).toString());
            int quantity = Integer.parseInt(tbl_Product.getModel().getValueAt(row, 5).toString());
            int status = 1;
            Inventorybilldetail ibd = new Inventorybilldetail(billID, productID,categoryID, supplierID, quantity, status);
            
            inventorybilldetailBUS.AddBilldetail(ibd);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Thêm thất bại", "Dialog",
            JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void importProduct(){
        
         if(!checkInventory()){
                JOptionPane.showMessageDialog(new JFrame(), "Chưa có hàng để nhập", "Dialog",
                JOptionPane.ERROR_MESSAGE);
                return;
            }
            addBill();
            for (int i = 0 ; i < tbl_Product.getRowCount();i++){
                int productID = Integer.parseInt(tbl_Product.getModel().getValueAt(i, 0).toString());
                int inventoryQuantity = Integer.parseInt(tbl_Product.getModel().getValueAt(i, 5).toString());
                if(productBUS.getProductByID(productID) != null){
                    int quantity = productBUS.getProductByID(productID).getQuantity() + inventoryQuantity;
                    addInventorybilldetail(i);
                    updateInventory(i, quantity);
                    
                } else {
                    addInventory(i);
                    addInventorybilldetail(i);
                }
            }
            JOptionPane.showMessageDialog(new JFrame(), "Thêm thành công", "Dialog",
            JOptionPane.ERROR_MESSAGE);
    }
    
    private void addItem(){
        if(txt_productID.getText().isEmpty() || txt_productName.getText().isEmpty() || txt_quantity.getText().isEmpty() || txt_price.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Vui lòng điền thông tin đầy đủ", "Dialog",JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean flag = false;
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Product.getModel();
        int productID = Integer.parseInt(txt_productID.getText());
        String productName = txt_productName.getText();
        int categoryID = Integer.parseInt(jComboCategory.getSelectedItem().toString());
        int supplierID = Integer.parseInt(jComboSupplier.getSelectedItem().toString());     
        float price = Float.parseFloat(txt_price.getText());
            
        for(int i = 0; i< tbl_Product.getRowCount(); i++){
            if(Integer.parseInt(tbl_Product.getModel().getValueAt(i, 0).toString()) == productID){
                flag = true;
                int quantity = Integer.parseInt(tbl_Product.getModel().getValueAt(i, 5).toString()) + Integer.parseInt(txt_quantity.getText());
                tbl_Product.getModel().setValueAt(quantity, i, 5);
                resetText();
                
            }
        }
        if(!flag){
            int quantity = Integer.parseInt(txt_quantity.getText());
            defaultModel.addRow(new Object[]{productID, productName, categoryID,supplierID,price,quantity});
            resetText();
        }
        
        
        
    }
    
    private void delItem(){
        int row = tbl_Product.getSelectedRow();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Product.getModel();
        if(row < 0){
           JOptionPane.showMessageDialog(new JFrame(), "Chọn sản phẩm cần xoá", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
        }
        int id = (int) tbl_Product.getModel().getValueAt(row, 0);
        int response = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa sản phẩm "+id+" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if(response == JOptionPane.YES_OPTION){
            defaultModel.removeRow(row);
            return;
        }
        resetText();
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
    
    private boolean checkValueInputProduct(){
        boolean flag = true;
        if(!isNumeric(txt_productID.getText())){
            flag = false;
        }
        if(!isNumeric(txt_quantity.getText())){
            flag = false;
        }
        try{ 
           Float.parseFloat(txt_price.getText());
        } catch(Exception e) {
            flag = false;
        }
        return flag;
    }
    
    private void editItem(){
        int row = tbl_Product.getSelectedRow();
        
        if(row < 0){
           JOptionPane.showMessageDialog(new JFrame(), "Chọn sản phẩm cần sửa", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
        }
        
        if(!checkValueInputProduct()){
            JOptionPane.showMessageDialog(new JFrame(), "Thông tin sản phẩm không hợp lệ", "Dialog",
            JOptionPane.ERROR_MESSAGE);
           return;
        }
        int productID = Integer.parseInt(txt_productID.getText());
        String productName = txt_productName.getText();
        int categoryID = Integer.parseInt(jComboCategory.getSelectedItem().toString());
        int supplierID = Integer.parseInt(jComboSupplier.getSelectedItem().toString());     
        float price = Float.parseFloat(txt_price.getText());
        int quantity = Integer.parseInt(txt_quantity.getText());
        int id = (int) tbl_Product.getModel().getValueAt(row, 0);
        int response = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa sản phẩm "+id+" không?", "confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if(response == JOptionPane.YES_OPTION){
            tbl_Product.getModel().setValueAt(productID, row, 0);
            tbl_Product.getModel().setValueAt(productName, row, 1);
            tbl_Product.getModel().setValueAt(productName, row, 1);
            tbl_Product.getModel().setValueAt(categoryID, row, 2);
            tbl_Product.getModel().setValueAt(supplierID, row, 3);
            tbl_Product.getModel().setValueAt(price, row, 4);
            tbl_Product.getModel().setValueAt(quantity, row, 5);
            return;
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
        tbl_Product = new javax.swing.JTable();
        btn_del = new javax.swing.JToggleButton();
        btn_Update = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jlb_productName = new javax.swing.JLabel();
        txt_productName = new javax.swing.JTextField();
        btn_add1 = new javax.swing.JToggleButton();
        jlb_price = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jlb_quantity = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        jlb_productID1 = new javax.swing.JLabel();
        jlb_category = new javax.swing.JLabel();
        jlb_supplier = new javax.swing.JLabel();
        jComboCategory = new javax.swing.JComboBox<>();
        jComboSupplier = new javax.swing.JComboBox<>();
        jlb_price1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_add2 = new javax.swing.JToggleButton();
        txt_productID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Inventory Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 300, 77));

        tbl_Product.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Product.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Product.setModel(new javax.swing.table.DefaultTableModel(
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
    tbl_Product.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Product.setRowHeight(40);
    tbl_Product.setRowMargin(2);
    tbl_Product.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Product.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Product.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_ProductMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Product);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1270, 310));

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

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1330, 10));

    jlb_productName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_productName.setForeground(new java.awt.Color(255, 153, 51));
    jlb_productName.setText("Product Name:");
    jPanel1.add(jlb_productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 140, 52));

    txt_productName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_productName.setForeground(new java.awt.Color(255, 153, 51));
    txt_productName.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_productNameActionPerformed(evt);
        }
    });
    jPanel1.add(txt_productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 320, 52));

    btn_add1.setBackground(new java.awt.Color(0, 204, 0));
    btn_add1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_add1.setForeground(new java.awt.Color(255, 255, 255));
    btn_add1.setText("Nhập hàng");
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
    jPanel1.add(btn_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 230, 90));

    jlb_price.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_price.setForeground(new java.awt.Color(255, 153, 51));
    jlb_price.setText("VNĐ");
    jPanel1.add(jlb_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 50, 52));

    txt_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_price.setForeground(new java.awt.Color(255, 153, 51));
    txt_price.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_priceActionPerformed(evt);
        }
    });
    jPanel1.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 300, 52));

    jlb_quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_quantity.setForeground(new java.awt.Color(255, 153, 51));
    jlb_quantity.setText("Quantity:");
    jPanel1.add(jlb_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 510, 110, 52));

    txt_quantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_quantity.setForeground(new java.awt.Color(255, 153, 51));
    txt_quantity.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_quantityActionPerformed(evt);
        }
    });
    jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 510, 160, 52));

    jlb_productID1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_productID1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_productID1.setText("Product ID:");
    jPanel1.add(jlb_productID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 138, 52));

    jlb_category.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_category.setForeground(new java.awt.Color(255, 153, 51));
    jlb_category.setText("CategoryID:");
    jPanel1.add(jlb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 120, 52));

    jlb_supplier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_supplier.setForeground(new java.awt.Color(255, 153, 51));
    jlb_supplier.setText("SupplierID:");
    jPanel1.add(jlb_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 440, 110, 52));

    jPanel1.add(jComboCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 170, 50));

    jPanel1.add(jComboSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 440, 160, 50));

    jlb_price1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_price1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_price1.setText("Price:");
    jPanel1.add(jlb_price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 60, 52));

    jButton1.setBackground(new java.awt.Color(102, 204, 0));
    jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/a1.png"))); // NOI18N
    jButton1.setText("Nhập Excel");
    jButton1.setBorderPainted(false);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });
    jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 30, 200, 60));

    btn_add2.setBackground(new java.awt.Color(102, 255, 102));
    btn_add2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_add2.setForeground(new java.awt.Color(255, 255, 255));
    btn_add2.setText("Thêm");
    btn_add2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btn_add2MouseClicked(evt);
        }
    });
    btn_add2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_add2ActionPerformed(evt);
        }
    });
    jPanel1.add(btn_add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 230, 90));

    txt_productID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_productID.setForeground(new java.awt.Color(255, 153, 51));
    txt_productID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_productIDActionPerformed(evt);
        }
    });
    jPanel1.add(txt_productID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 200, 52));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProductMouseClicked
        showProductValue(productls);
    }//GEN-LAST:event_tbl_ProductMouseClicked

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        delItem();
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        editItem();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
        
      

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Product.getModel();
        defaultModel.setRowCount(0);
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_productNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productNameActionPerformed

    private void btn_add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add1MouseClicked

    private void btn_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add1ActionPerformed
        importProduct();
    }//GEN-LAST:event_btn_add1ActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        importExcelToJtableJava();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_add2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add2MouseClicked

    private void btn_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add2ActionPerformed
        // TODO add your handling code here:
         addItem();
    }//GEN-LAST:event_btn_add2ActionPerformed

    private void txt_productIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productIDActionPerformed

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
//            java.util.logging.Logger.getLogger(InventoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InventoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InventoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InventoryManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new InventoryManagement().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(InventoryManagement.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JToggleButton btn_Update;
    private javax.swing.JToggleButton btn_add1;
    private javax.swing.JToggleButton btn_add2;
    private javax.swing.JToggleButton btn_del;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboCategory;
    private javax.swing.JComboBox<String> jComboSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlb_category;
    private javax.swing.JLabel jlb_price;
    private javax.swing.JLabel jlb_price1;
    private javax.swing.JLabel jlb_productID1;
    private javax.swing.JLabel jlb_productName;
    private javax.swing.JLabel jlb_quantity;
    private javax.swing.JLabel jlb_supplier;
    private javax.swing.JTable tbl_Product;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_productID;
    private javax.swing.JTextField txt_productName;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
