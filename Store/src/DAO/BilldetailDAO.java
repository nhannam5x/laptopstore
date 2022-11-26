/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Billdetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BilldetailDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public BilldetailDAO() {
    }
    public ArrayList<Billdetail> list() throws ClassNotFoundException
    {
        ArrayList<Billdetail> Billdetail = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM billdetail ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int billID= rs.getInt("billID");
                int productID = rs.getInt("productID");
                int quantity= rs.getInt("quantity");
                int status = rs.getInt("status");
                Billdetail bd = new Billdetail(billID, productID, quantity, status);
                Billdetail.add(bd);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(BilldetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Billdetail;
    }

    public void set(Billdetail bd) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE billdetail SET ";
            sql += "billID='"+bd.getBillID()+"', ";
            sql += "productID='"+bd.getProductID()+"', ";
            sql += "quantity='"+bd.getQuantity()+"', ";
            sql += "status='"+bd.getStatus()+"'";
            sql += "WHERE billID="+bd.getBillID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Billdetail bd) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO billdetail VALUES (";
                sql += "'"+bd.getBillID()+"',";
                sql += "'"+bd.getProductID()+"',";
                sql += "'"+bd.getQuantity()+"',";
                sql += "'"+bd.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
