/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.CustomerDAO;
import DTO.Customer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CustomerBUS {
    private ArrayList<Customer> cus ;
    public CustomerBUS(int i) throws ClassNotFoundException
    {
        listCustomer();
    }
     
    
    public CustomerBUS() 
    {
        try {
            listCustomer();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Customer getCustomerID(int customer_id)
    {
        for(Customer cu : cus )
        {
            if(cu.getCustomerID() == customer_id)
            {
                return cu;
            }
        }
        return null;
    }
    
    public void listCustomer() throws ClassNotFoundException
    {
        CustomerDAO cusDAO = new CustomerDAO();
        cus = new ArrayList<>();
        cus = cusDAO.list();
    }
    public void AddCustomer(Customer cu) throws ClassNotFoundException
    {
        cus.add(cu);
        CustomerDAO cusDAO = new CustomerDAO();
        cusDAO.add(cu);
    }

    public void SetCustomer(Customer cu) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < cus.size() ; i++)
        {
            if(cus.get(i).getCustomerID() == cu.getCustomerID())
            {
                cus.set(i, cu);
                CustomerDAO cusDAO = new CustomerDAO();
                cusDAO.set(cu);
                return;
            }
        }
    }
    
    public boolean CheckCustomerID(int CustomerID)
    {
        for(Customer cu : cus)
        {
            if(cu.getCustomerID() == CustomerID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Customer> getList() throws ClassNotFoundException {
        
        return cus;
    }
}

