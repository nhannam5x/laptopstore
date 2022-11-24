/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL XPS 15
 */
public class Account {
    private int accountID;
    private String accountName, password;
    private int staffID, status;

    public Account(int accountID, String accountName, String password, int staffID, int status) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.password = password;
        this.staffID = staffID;
        this.status = status;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public int getStaffID() {
        return staffID;
    }

    public int getStatus() {
        return status;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
