/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.AccountDAO;
import DTO.Account;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AccountBUS {
    private ArrayList<Account> acc ;
    public AccountBUS(int i) throws ClassNotFoundException
    {
        listAccount();
    }
     
    
    public AccountBUS() 
    {
        try {
            listAccount();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Account getAccountID(int account_id)
    {
        for(Account ac : acc )
        {
            if(ac.getAccountID() == account_id)
            {
                return ac;
            }
        }
        return null;
    }
    
    public  Account getByAccountName(String account_name)
    {
        for(Account ac : acc )
        {
            if(ac.getAccountName().equals(account_name))
            {
                return ac;
            }
        }
        return null;
    }
    
    public void listAccount() throws ClassNotFoundException
    {
        AccountDAO accDAO = new AccountDAO();
        acc = new ArrayList<>();
        acc = accDAO.list();
    }
    public void AddAccount(Account ac) throws ClassNotFoundException
    {
        acc.add(ac);
        AccountDAO accDAO = new AccountDAO();
        accDAO.add(ac);
    }

    public void SetAccount(Account ac) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < acc.size() ; i++)
        {
            if(acc.get(i).getAccountID() == ac.getAccountID())
            {
                acc.set(i, ac);
                AccountDAO accDAO = new AccountDAO();
                accDAO.set(ac);
                return;
            }
        }
    }
    
    public boolean CheckAccountID(int accountID)
    {
        for(Account ac : acc)
        {
            if(ac.getAccountID() == accountID)
            {
                return true;
            }
        }
        return false;
    }

    public boolean CheckStaff(int staffID)
    {
        for(Account ac : acc)
        {
            if(ac.getStaffID() == staffID)
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Account> getList() {
        
        return acc;
    }
    
     public ArrayList<Account> search(String accountID, String accountName, String staffID)
    {
        ArrayList<Account> search = new ArrayList<>();
        accountID = accountID.isEmpty()?accountID = "": accountID;
        accountName = accountName.isEmpty()?accountName = "": accountName;
        staffID = staffID.isEmpty()?staffID = "": staffID;
        for(Account a : acc)
        {
            if((String.valueOf(a.getAccountID())).toLowerCase().contains(accountID.toLowerCase()) && 
               (String.valueOf(a.getAccountName())).toLowerCase().contains(accountName.toLowerCase()) &&
               (String.valueOf(a.getStaffID())).toLowerCase().contains(staffID.toLowerCase()))
            {
                search.add(a);
            }
        }
        return search;
    }
}

