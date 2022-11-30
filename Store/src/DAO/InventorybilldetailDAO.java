/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Inventorybilldetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class InventorybilldetailDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public InventorybilldetailDAO() {
    }
    public ArrayList<Inventorybilldetail> list() throws ClassNotFoundException
    {
        ArrayList<Inventorybilldetail> Inventorybilldetail = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM inventorybilldetail ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int inventorybillID= rs.getInt("inventorybillID");
                int productID = rs.getInt("productID");
                int categoryID = rs.getInt("categoryID");
                int supplierID = rs.getInt("supplierID");
                int quantity= rs.getInt("quantity");
                int status = rs.getInt("status");
                Inventorybilldetail bd = new Inventorybilldetail(inventorybillID, productID, categoryID, supplierID,  quantity, status);
                Inventorybilldetail.add(bd);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(InventorybilldetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Inventorybilldetail;
    }

    public void set(Inventorybilldetail bd) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE inventorybilldetail SET ";
            sql += "inventorybillID='"+bd.getInventorybillID()+"', ";
            sql += "productID='"+bd.getProductID()+"', ";
            sql += "categoryID='"+bd.getCategoryID()+"', ";
            sql += "supplierID='"+bd.getSupplierID()+"', ";
            sql += "quantity='"+bd.getQuantity()+"', ";
            sql += "status='"+bd.getStatus()+"'";
            sql += "WHERE inventorybillID="+bd.getInventorybillID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Inventorybilldetail bd) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO inventorybilldetail VALUES (";
                sql += "'"+bd.getInventorybillID()+"',";
                sql += "'"+bd.getProductID()+"',";
                sql += "'"+bd.getCategoryID()+"',";
                sql += "'"+bd.getSupplierID()+"',";
                sql += "'"+bd.getQuantity()+"',";
                sql += "'"+bd.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
