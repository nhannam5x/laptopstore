/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CustomerDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public CustomerDAO() {
    }
    public ArrayList<Customer> list() throws ClassNotFoundException
    {
        ArrayList<Customer> Customer = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM customer ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int customerID= rs.getInt("customerID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                int status = rs.getInt("status");
                Customer cu = new Customer(customerID, firstName, lastName, email, phone,status);
                Customer.add(cu);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Customer;
    }

    public void set(Customer cu) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE customer SET ";
            sql += "customerID='"+cu.getCustomerID()+"', ";
            sql += "firstName='"+cu.getFirstName()+"', ";
            sql += "lastName='"+cu.getLastName()+"', ";
            sql += "email='"+cu.getEmail()+"',";
            sql += "phone='"+cu.getPhone()+"',";
            sql += "status='"+cu.getStatus()+"'";
            sql += "WHERE customerID="+cu.getCustomerID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Customer cu) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO customer VALUES (";
                sql += "'"+cu.getCustomerID()+"',";
                sql += "'"+cu.getFirstName()+"',";
                sql += "'"+cu.getLastName()+"',";
                sql += "'"+cu.getEmail()+"',";
                sql += "'"+cu.getPhone()+"',";
                sql += "'"+cu.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
