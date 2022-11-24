/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public ProductDAO() {
    }
    public ArrayList<Product> list() throws ClassNotFoundException
    {
        ArrayList<Product> Product = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM product ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int productID= rs.getInt("productID");
                String productName = rs.getString("productName");
                int categoryID = rs.getInt("categoryID");
                int supplierID = rs.getInt("supplierID");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                int status = rs.getInt("status");
                Product p = new Product(productID, productName, categoryID, supplierID, price, quantity, status);
                Product.add(p);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Product;
    }

    public void set(Product p) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE product SET ";
            sql += "productID='"+p.getProductID()+"', ";
            sql += "productName='"+p.getProductName()+"', ";
            sql += "categoryID='"+p.getCategoryID()+"', ";
            sql += "supplierID='"+p.getSupplierID()+"', ";
            sql += "price='"+p.getPrice()+"', ";
            sql += "quantity='"+p.getQuantity()+"',";
            sql += "status='"+p.getStatus()+"'";
            sql += "WHERE productID="+p.getProductID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Product p) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO product VALUES (";
                sql += "'"+p.getProductID()+"',";
                sql += "'"+p.getProductName()+"',";
                sql += "'"+p.getCategoryID()+"',";
                sql += "'"+p.getSupplierID()+"',";
                sql += "'"+p.getPrice()+"',";
                sql += "'"+p.getQuantity()+"',";
                sql += "'"+p.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
