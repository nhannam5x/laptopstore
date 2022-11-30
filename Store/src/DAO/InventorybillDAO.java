/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Inventorybill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class InventorybillDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public InventorybillDAO() {
    }
    public ArrayList<Inventorybill> list() throws ClassNotFoundException
    {
        ArrayList<Inventorybill> Inventorybill = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM inventorybill ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int inventorybillID= rs.getInt("inventorybillID");
                int staffID = rs.getInt("staffID");
                float totalPrice = rs.getFloat("totalPrice");
                String date = rs.getString("date");
                int status = rs.getInt("status");
                Inventorybill b = new Inventorybill(inventorybillID, staffID, totalPrice, date,status);
                Inventorybill.add(b);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(InventorybillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Inventorybill;
    }

    public void set(Inventorybill b) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE inventorybill SET ";
            sql += "inventorybillID='"+b.getInventorybillID()+"', ";
            sql += "staffID='"+b.getStaffID()+"', ";
            sql += "totalPrice='"+b.getTotalPrice()+"', ";
            sql += "date='"+b.getDate()+"', ";
            sql += "status='"+b.getStatus()+"'";
            sql += "WHERE inventorybillID="+b.getInventorybillID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Inventorybill b) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO inventorybill VALUES (";
                sql += "'"+b.getInventorybillID()+"',";
                sql += "'"+b.getStaffID()+"',";
                sql += "'"+b.getTotalPrice()+"',";
                sql += "'"+b.getDate()+"',";
                sql += "'"+b.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
