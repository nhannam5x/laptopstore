/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Inventorybill;
import BUS.InventorybillBUS;
import DTO.Product;
import BUS.ProductBUS;
import DTO.Staff;
import BUS.StaffBUS;
import DTO.Supplier;
import BUS.SupplierBUS;
import DTO.Bill;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author donha
 */
public class InventorybillManagement extends javax.swing.JFrame {

    /**
     * Creates new form BillManagement
     */
    InventorybillBUS inventorybillBUS = new InventorybillBUS();
    ProductBUS productBUS = new ProductBUS();
    StaffBUS staffBUS = new StaffBUS();
    SupplierBUS supplierBUS = new SupplierBUS();
    ArrayList<Inventorybill> inventorybillls = inventorybillBUS.getList();
    ArrayList<Product> product = productBUS.getList();
    ArrayList<Staff> staff = staffBUS.getList();
    ArrayList<Supplier> supplier = supplierBUS.getList();
    int staffID;
    public static final int COLUMN_INDEX_billID     = 0;
    public static final int COLUMN_INDEX_staffID     = 1;
    public static final int COLUMN_INDEX_staffName     = 2;
    public static final int COLUMN_INDEX_totalPrice      = 3;
    public static final int COLUMN_INDEX_date      = 4;
    private static CellStyle cellStyleFormatNumber = null;
    
    public InventorybillManagement(int staffID) throws ClassNotFoundException {
        initComponents();
        this.staffID = staffID;
        jlb_staffIDT.setText("Staff ID: " +staffID);
        inventorybillBUS.listInventorybill();
        productBUS.listProduct();
        staffBUS.listStaff();
        supplierBUS.listSupplier();
        showTable(inventorybillls);
    }
    
    private void showTable(ArrayList<Inventorybill> inventorybillls)
    {   
        tbl_Inventorybill.removeAll();
        DefaultTableModel defaultModel = (DefaultTableModel) tbl_Inventorybill.getModel();
        defaultModel.setRowCount(0);
        for(Inventorybill b : inventorybillls)
        {
            if(b.getStatus() == 1){
                int inventorybillID = b.getInventorybillID();
                int staffID = staffBUS.getStaffID(b.getStaffID()).getStaffID();
                String staffName = staffBUS.getStaffID(b.getStaffID()).getFirstName()+ " "+staffBUS.getStaffID(b.getStaffID()).getLastName();
                float totalPrice = b.getTotalPrice();
                String date = b.getDate();
                
                defaultModel.addRow(new Object[]{inventorybillID, staffID, staffName, totalPrice, date});
            }
        }
    }
    
    private void showBillValue(ArrayList<Inventorybill> inventorybillls)
    {
        
        int row = tbl_Inventorybill.getSelectedRow();
        jlb_billID.setText(tbl_Inventorybill.getModel().getValueAt(row, 0).toString());
        jlb_staffID.setText(tbl_Inventorybill.getModel().getValueAt(row, 1).toString());
        jlb_totalPrice.setText(tbl_Inventorybill.getModel().getValueAt(row, 2).toString());
        jlb_date.setText(tbl_Inventorybill.getModel().getValueAt(row, 3).toString());
                
    }   
    
    
    private void resetText(){
        jlb_billID.setText("...");
        jlb_staffID.setText("");
        jlb_totalPrice.setText("");
        jlb_date.setText("");
    }
    
    private void refresh(){
        try {
            inventorybillBUS.listInventorybill();
            inventorybillls = inventorybillBUS.getList(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventorybillManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTable(inventorybillls);
    }
    
    private void search(){
        String inventorybillID = txt_sInventorybillID.getText();
        String staffID = txt_sStaffID.getText();
        String date = txt_sDate.getText();
        showTable(inventorybillBUS.search(inventorybillID, staffID, date));
    }
    
    public void writeExcel(List<Inventorybill> inventorybill, String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
 
        // Create sheet
        Sheet sheet = workbook.createSheet("Inventory Bill"); // Create sheet with sheet name
 
        int rowIndex = 0;
         
        // Write header
        writeHeader(sheet, rowIndex);
 
        // Write data
        rowIndex++;
        for (Inventorybill sgl : inventorybill) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(sgl, row);
            rowIndex++;
        }
         
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }

    // Create workbook
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
 
    // Write header with format
    private static void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_billID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Bill ID");
        
        cell = row.createCell(COLUMN_INDEX_staffID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Staff ID");
        
        cell = row.createCell(COLUMN_INDEX_staffName);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Staff Name");
        
        cell = row.createCell(COLUMN_INDEX_totalPrice);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Total Price");
        
        cell = row.createCell(COLUMN_INDEX_date);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Date");
    }
 
    // Write data
    private void writeBook(Inventorybill inventorybill, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
             
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
         
        Cell cell = row.createCell(COLUMN_INDEX_billID);
        cell.setCellValue(inventorybill.getInventorybillID());
        
        cell = row.createCell(COLUMN_INDEX_staffID);
        cell.setCellValue(inventorybill.getStaffID());
        
        cell = row.createCell(COLUMN_INDEX_staffName);
        cell.setCellValue(staffBUS.getStaffID(inventorybill.getStaffID()).getFirstName());

        cell = row.createCell(COLUMN_INDEX_totalPrice);
        cell.setCellValue(inventorybill.getTotalPrice());
        
        cell = row.createCell(COLUMN_INDEX_date);
        cell.setCellValue(inventorybill.getDate());
       
    }
 
    // Create CellStyle for header
    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        org.apache.poi.ss.usermodel.Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.BLACK.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
     
    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
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
        tbl_Inventorybill = new javax.swing.JTable();
        btn_Check = new javax.swing.JToggleButton();
        btn_Refresh = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txt_sInventorybillID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_sDate = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txt_sStaffID = new javax.swing.JTextField();
        jlb_billID = new javax.swing.JLabel();
        jlb_staff = new javax.swing.JLabel();
        jlb_date = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jlb_totalPrice1 = new javax.swing.JLabel();
        jlb_date1 = new javax.swing.JLabel();
        jlb_bill = new javax.swing.JLabel();
        jlb_staffID = new javax.swing.JLabel();
        jlb_totalPrice = new javax.swing.JLabel();
        jlb_bill1 = new javax.swing.JLabel();
        btn_exportExcel = new javax.swing.JButton();
        jlb_staffIDT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Inventory bill Management");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 340, 77));

        tbl_Inventorybill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_Inventorybill.setForeground(new java.awt.Color(255, 153, 51));
        tbl_Inventorybill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill ID", "Staff ID", "Staff Name", "Total Price", "Date"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_Inventorybill.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    tbl_Inventorybill.setRowHeight(40);
    tbl_Inventorybill.setRowMargin(2);
    tbl_Inventorybill.setSelectionBackground(new java.awt.Color(153, 255, 153));
    tbl_Inventorybill.setSelectionForeground(new java.awt.Color(0, 0, 0));
    tbl_Inventorybill.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_InventorybillMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_Inventorybill);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 101, 1290, 157));

    btn_Check.setBackground(new java.awt.Color(102, 255, 102));
    btn_Check.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    btn_Check.setForeground(new java.awt.Color(255, 255, 255));
    btn_Check.setText("Xem");
    btn_Check.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_CheckActionPerformed(evt);
        }
    });
    jPanel1.add(btn_Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 230, 90));

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
    jLabel3.setText("SEARCH");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 90, 50));

    txt_sInventorybillID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    txt_sInventorybillID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sInventorybillID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sInventorybillIDActionPerformed(evt);
        }
    });
    txt_sInventorybillID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sInventorybillIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sInventorybillID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 200, 52));

    jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 153, 51));
    jLabel6.setText("Date:");
    jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 60, 52));

    txt_sDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sDate.setForeground(new java.awt.Color(255, 153, 51));
    txt_sDate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sDateActionPerformed(evt);
        }
    });
    txt_sDate.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sDateKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 320, 52));

    jSeparator1.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator1.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 1350, 10));

    jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(255, 153, 51));
    jLabel10.setText("StaffID:");
    jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 80, 52));

    txt_sStaffID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    txt_sStaffID.setForeground(new java.awt.Color(255, 153, 51));
    txt_sStaffID.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_sStaffIDActionPerformed(evt);
        }
    });
    txt_sStaffID.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_sStaffIDKeyReleased(evt);
        }
    });
    jPanel1.add(txt_sStaffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, 200, 52));

    jlb_billID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_billID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_billID.setText("...");
    jPanel1.add(jlb_billID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 140, 52));

    jlb_staff.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_staff.setForeground(new java.awt.Color(255, 153, 51));
    jlb_staff.setText("Staff:");
    jPanel1.add(jlb_staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 60, 52));

    jlb_date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_date.setForeground(new java.awt.Color(255, 153, 51));
    jlb_date.setText("...");
    jPanel1.add(jlb_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 310, 320, 52));

    jSeparator2.setBackground(new java.awt.Color(255, 153, 51));
    jSeparator2.setForeground(new java.awt.Color(255, 153, 51));
    jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1350, 10));

    jlb_totalPrice1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_totalPrice1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_totalPrice1.setText("TotalPrice:");
    jPanel1.add(jlb_totalPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 110, 52));

    jlb_date1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_date1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_date1.setText("Date:");
    jPanel1.add(jlb_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, 60, 52));

    jlb_bill.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_bill.setForeground(new java.awt.Color(255, 153, 51));
    jlb_bill.setText("Inventory Bill ID:");
    jPanel1.add(jlb_bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 170, 52));

    jlb_staffID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_staffID.setForeground(new java.awt.Color(255, 153, 51));
    jlb_staffID.setText("...");
    jPanel1.add(jlb_staffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 270, 52));

    jlb_totalPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_totalPrice.setForeground(new java.awt.Color(255, 153, 51));
    jlb_totalPrice.setText("...");
    jPanel1.add(jlb_totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 90, 52));

    jlb_bill1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jlb_bill1.setForeground(new java.awt.Color(255, 153, 51));
    jlb_bill1.setText("Inventory Bill ID:");
    jPanel1.add(jlb_bill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 170, 52));

    btn_exportExcel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    btn_exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/a1.png"))); // NOI18N
    btn_exportExcel.setText("XUẤT EXCEL");
    btn_exportExcel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_exportExcelActionPerformed(evt);
        }
    });
    jPanel1.add(btn_exportExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 210, 60));

    jlb_staffIDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jlb_staffIDT.setForeground(new java.awt.Color(255, 102, 0));
    jlb_staffIDT.setText("Staff ID:");
    jPanel1.add(jlb_staffIDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 40, 190, -1));

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

    private void tbl_InventorybillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_InventorybillMouseClicked
        showBillValue(inventorybillls);
    }//GEN-LAST:event_tbl_InventorybillMouseClicked

    private void btn_CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CheckActionPerformed
        int inventorybillID;
        int row = tbl_Inventorybill.getSelectedRow();    
        try {    
         if(row < 0)
         {
           JOptionPane.showMessageDialog(new JFrame(), "Chọn hóa đơn cần xem", "Dialog",
           JOptionPane.ERROR_MESSAGE);
           return; 
         }
           
           inventorybillID = Integer.parseInt(jlb_billID.getText());    
           InventorybilldetailManagement bd = new InventorybilldetailManagement(inventorybillID);
            bd.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventorybillManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_CheckActionPerformed

    private void btn_RefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RefreshMouseClicked
//        showTable();

    }//GEN-LAST:event_btn_RefreshMouseClicked

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_sInventorybillIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sInventorybillIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sInventorybillIDActionPerformed

    private void txt_sDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sDateActionPerformed

    private void txt_sStaffIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sStaffIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sStaffIDActionPerformed

    private void txt_sInventorybillIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sInventorybillIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sInventorybillIDKeyReleased

    private void txt_sStaffIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sStaffIDKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sStaffIDKeyReleased

    private void txt_sDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sDateKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_txt_sDateKeyReleased

    private void btn_exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportExcelActionPerformed
        // TODO add your handling code here:
        try {
        // TODO add your handling code here:
            String date = java.time.LocalDate.now().toString();
            final String excelFilePath = "C:/Users/donha/Desktop/Inventory_Bill_Excel_"+date+".xlsx";
            writeExcel(this.inventorybillls,excelFilePath);
            JOptionPane.showMessageDialog(rootPane, "Xuất thành công");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Không xuất do Excel đang hiện diện", "Dialog",JOptionPane.ERROR_MESSAGE);
            return;
        }
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
//            java.util.logging.Logger.getLogger(InventorybillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InventorybillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InventorybillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InventorybillManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//                    new InventorybillManagement().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(InventorybillManagement.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Check;
    private javax.swing.JToggleButton btn_Refresh;
    private javax.swing.JButton btn_exportExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlb_bill;
    private javax.swing.JLabel jlb_bill1;
    private javax.swing.JLabel jlb_billID;
    private javax.swing.JLabel jlb_date;
    private javax.swing.JLabel jlb_date1;
    private javax.swing.JLabel jlb_staff;
    private javax.swing.JLabel jlb_staffID;
    private javax.swing.JLabel jlb_staffIDT;
    private javax.swing.JLabel jlb_totalPrice;
    private javax.swing.JLabel jlb_totalPrice1;
    private javax.swing.JTable tbl_Inventorybill;
    private javax.swing.JTextField txt_sDate;
    private javax.swing.JTextField txt_sInventorybillID;
    private javax.swing.JTextField txt_sStaffID;
    // End of variables declaration//GEN-END:variables
}
