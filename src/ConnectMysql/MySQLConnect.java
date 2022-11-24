/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Minion
 */
public class MySQLConnect {
    private String user = "root";
    private String password="";
    private String url="jdbc:mysql://localhost/store";
    private Connection conn = null;
    private Statement st = null;
    
    public void Connect() throws ClassNotFoundException, SQLException
    {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

    }
    public void disConnect()
    { 
        try{
            st.close();
            conn.close();
        }catch (SQLException E){}
    }
    
    public ResultSet executeQuery(String sql) throws ClassNotFoundException
    {
        ResultSet rs = null;
        try {
            Connect();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void executeUpdate(String sql) throws ClassNotFoundException
    {
        try {
            Connect();
            st = conn.createStatement();
            st.executeUpdate(sql);
            disConnect();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Connect();
        return conn;
    }
    public boolean isConnect()
    {
        return conn!=null?true:false;
    }
    
    public static void main (String[] args) throws ClassNotFoundException
    {
        try {
            MySQLConnect sql = new MySQLConnect();
            sql.Connect();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}