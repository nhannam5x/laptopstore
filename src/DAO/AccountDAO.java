/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectMysql.MySQLConnect;
import DTO.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AccountDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public AccountDAO() {
    }
    public ArrayList<Account> list() throws ClassNotFoundException
    {
        ArrayList<Account> Account = new ArrayList<>();
        try {
           
            String sql = "SELECT * FROM account ";
            ResultSet rs = mySQL.executeQuery(sql);
            while(rs.next())
            {
                int accountID= rs.getInt("accountID");
                String accountName = rs.getString("accountName");
                String password = rs.getString("password");
                int staffID = rs.getInt("staffID");
                int status = rs.getInt("status");
                Account a = new Account(accountID, accountName, password, staffID, status);
                Account.add(a);
            }
            rs.close();
            mySQL.disConnect();
            
        } catch (SQLException ex) { 
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Account;
    }

    public void set(Account a) throws ClassNotFoundException {
            MySQLConnect mySQL = new MySQLConnect();
            String sql = "UPDATE account SET ";
            sql += "accountID='"+a.getAccountID()+"', ";
            sql += "accountName='"+a.getAccountName()+"', ";
            sql += "password='"+a.getPassword()+"', ";
            sql += "staffID='"+a.getStaffID()+"',";
            sql += "status='"+a.getStatus()+"'";
            sql += "WHERE accountID="+a.getAccountID();
            System.out.println(sql);
            mySQL.executeUpdate(sql);
    }

    public void add(Account a) throws ClassNotFoundException {
        MySQLConnect mySQL = new MySQLConnect();
         String sql = "INSERT INTO account VALUES (";
                sql += "'"+a.getAccountID()+"',";
                sql += "'"+a.getAccountName()+"',";
                sql += "'"+a.getPassword()+"',";
                sql += "'"+a.getStaffID()+"',";
                sql += "'"+a.getStatus()+"')";
         System.out.println(sql);
         mySQL.executeUpdate(sql);
    }
}
