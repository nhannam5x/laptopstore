/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Discount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DiscountDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public DiscountDAO() {
    }
    public ArrayList<Discount> list() throws ClassNotFoundException
    {
        ArrayList<Discount> Discount = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM discount ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int discountID= rs.getInt("discountID");
                int discountValue = rs.getInt("discountValue");
                String dateStart = rs.getString("dateStart");
                String dateEnd = rs.getString("dateEnd");
                int quantity = rs.getInt("quantity");
                int status = rs.getInt("status");
                Discount d = new Discount(discountID, discountValue, dateStart, dateEnd, quantity, status);
                Discount.add(d);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(DiscountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Discount;
    }

    public void set(Discount d) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE discount SET ";
            sql += "discountID='"+d.getDiscountID()+"', ";
            sql += "discountValue='"+d.getDiscountValue()+"', ";
            sql += "dateStart='"+d.getDateStart()+"', ";
            sql += "dateEnd='"+d.getDateEnd()+"', ";
            sql += "quantity='"+d.getQuantity()+"',";
            sql += "status='"+d.getStatus()+"'";
            sql += "WHERE discountID="+d.getDiscountID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Discount d) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO discount VALUES (";
                sql += "'"+d.getDiscountID()+"',";
                sql += "'"+d.getDiscountValue()+"',";
                sql += "'"+d.getDateStart()+"',";
                sql += "'"+d.getDateEnd()+"',";
                sql += "'"+d.getQuantity()+"',";
                sql += "'"+d.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
