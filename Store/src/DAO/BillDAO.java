/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Bill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BillDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public BillDAO() {
    }
    public ArrayList<Bill> list() throws ClassNotFoundException
    {
        ArrayList<Bill> Bill = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM bill ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int billID= rs.getInt("billID");
                int productID= rs.getInt("productID");
                int staffID = rs.getInt("staffID");
                int customerID = rs.getInt("customerID");
                int discountID = rs.getInt("disctountID");
                float totalPrice = rs.getFloat("totalPrice");
                String date = rs.getString("date");
                int status = rs.getInt("status");
                Bill b = new Bill(billID, productID, staffID, customerID, discountID, totalPrice, date,status);
                Bill.add(b);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Bill;
    }

    public void set(Bill b) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE bill SET ";
            sql += "billID='"+b.getBillID()+"', ";
            sql += "productID='"+b.getProductID()+"', ";
            sql += "staffID='"+b.getStaffID()+"', ";
            sql += "customerID='"+b.getCustomerID()+"', ";
            sql += "discountID='"+b.getDiscountID()+"', ";
            sql += "totalPrice='"+b.getTotalPrice()+"', ";
            sql += "date='"+b.getDate()+"', ";
            sql += "status='"+b.getStatus()+"'";
            sql += "WHERE billID="+b.getBillID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Bill b) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO bill VALUES (";
                sql += "'"+b.getBillID()+"',";
                sql += "'"+b.getProductID()+"',";
                sql += "'"+b.getStaffID()+"',";
                sql += "'"+b.getStaffID()+"',";
                sql += "'"+b.getCustomerID()+"',";
                sql += "'"+b.getDiscountID()+"',";
                sql += "'"+b.getTotalPrice()+"',";
                sql += "'"+b.getDate()+"',";
                sql += "'"+b.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
