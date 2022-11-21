/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Staff;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StaffDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public StaffDAO() {
    }
    public ArrayList<Staff> list() throws ClassNotFoundException
    {
        ArrayList<Staff> Staff = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM staff ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int staffID= rs.getInt("staffID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                int authority = rs.getInt("authority");
                int status = rs.getInt("status");
                Staff s = new Staff(staffID, firstName, lastName, email, phone, authority, status);
                Staff.add(s);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Staff;
    }

    public void set(Staff s) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE staff SET ";
            sql += "staffID='"+s.getStaffID()+"', ";
            sql += "firstName='"+s.getFirstName()+"', ";
            sql += "lastName='"+s.getLastName()+"', ";
            sql += "email='"+s.getEmail()+"',";
            sql += "phone='"+s.getPhone()+"',";
            sql += "authority='"+s.getAuthority()+"',";
            sql += "status='"+s.getStatus()+"'";
            sql += "WHERE staffID="+s.getStaffID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Staff s) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO staff VALUES (";
                sql += "'"+s.getStaffID()+"',";
                sql += "'"+s.getFirstName()+"',";
                sql += "'"+s.getLastName()+"',";
                sql += "'"+s.getEmail()+"',";
                sql += "'"+s.getPhone()+"',";
                sql += "'"+s.getAuthority()+"',";
                sql += "'"+s.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
