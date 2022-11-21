/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CategoryDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public CategoryDAO() {
    }
    public ArrayList<Category> list() throws ClassNotFoundException
    {
        ArrayList<Category> Category = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM category ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int categoryID= rs.getInt("categoryID");
                String categoryName = rs.getString("categoryName");
                int status = rs.getInt("status");
                Category c = new Category(categoryID, categoryName, status);
                Category.add(c);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Category;
    }

    public void set(Category c) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE category SET ";
            sql += "categoryID='"+c.getCategoryID()+"', ";
            sql += "categoryName='"+c.getCategoryName()+"', ";
            sql += "status='"+c.getStatus()+"'";
            sql += "WHERE categoryID="+c.getCategoryID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Category c) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO category VALUES (";
                sql += "'"+c.getCategoryID()+"',";
                sql += "'"+c.getCategoryName()+"',";
                sql += "'"+c.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
