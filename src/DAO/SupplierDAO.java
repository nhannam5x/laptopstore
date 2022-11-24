/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Supplier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SupplierDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public SupplierDAO() {
    }
    public ArrayList<Supplier> list() throws ClassNotFoundException
    {
        ArrayList<Supplier> supplier = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM supplier ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int supplierID= rs.getInt("supplierID");
                String supplierName = rs.getString("supplierName");
                String address = rs.getString("address");
                int status = rs.getInt("status");
                Supplier s = new Supplier(supplierID, supplierName, address, status);
                supplier.add(s);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return supplier;
    }

    public void set(Supplier s) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE supplier SET ";
            sql += "supplierID='"+s.getSupplierID()+"', ";
            sql += "supplierName='"+s.getSupplierName()+"', ";
            sql += "address='"+s.getAddress()+"', ";
            sql += "status='"+s.getStatus()+"'";
            sql += "WHERE supplierID="+s.getSupplierID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Supplier s) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO supplier VALUES (";
                sql += "'"+s.getSupplierID()+"',";
                sql += "'"+s.getSupplierName()+"',";
                sql += "'"+s.getAddress()+"',";
                sql += "'"+s.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
