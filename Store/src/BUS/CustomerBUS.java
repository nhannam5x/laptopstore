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

    
    
    public ArrayList<Customer> getList() {
        
        return cus;
    }
    
    public ArrayList<Customer> search(String customerID, String firstName, String lastName, String email, String phone)
    {
        ArrayList<Customer> search = new ArrayList<>();
        customerID = customerID.isEmpty()?customerID = "": customerID;
        firstName = firstName.isEmpty()?firstName = "": firstName;
        lastName = lastName.isEmpty()?lastName = "": lastName;
        email = email.isEmpty()?email = "": email;
        phone = phone.isEmpty()?phone = "": phone;
        for(Customer cu : cus)
        {
            if((String.valueOf(cu.getCustomerID())).toLowerCase().contains(customerID.toLowerCase()) && 
               (String.valueOf(cu.getFirstName())).toLowerCase().contains(firstName.toLowerCase()) &&
               (String.valueOf(cu.getLastName())).toLowerCase().contains(lastName.toLowerCase()) &&
               (String.valueOf(cu.getEmail())).toLowerCase().contains(email.toLowerCase()) &&
               (String.valueOf(cu.getPhone())).toLowerCase().contains(phone.toLowerCase())
                )
                    
                    
            {
                search.add(cu);
            }
        }
        return search;
    }
}

