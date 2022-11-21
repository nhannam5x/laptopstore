/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.SupplierDAO;
import DTO.Supplier;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SupplierBUS {
    private ArrayList<Supplier> sup ;
    public SupplierBUS(int i) throws ClassNotFoundException
    {
        listSupplier();
    }
     
    
    public SupplierBUS() 
    {
        try {
            listSupplier();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SupplierBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Supplier getSupplierID(int supplier_id)
    {
        for(Supplier su : sup )
        {
            if(su.getSupplierID() == supplier_id)
            {
                return su;
            }
        }
        return null;
    }
    
    public void listSupplier() throws ClassNotFoundException
    {
        SupplierDAO supDAO = new SupplierDAO();
        sup = new ArrayList<>();
        sup = supDAO.list();
    }
    public void AddSupplier(Supplier su) throws ClassNotFoundException
    {
        sup.add(su);
        SupplierDAO supDAO = new SupplierDAO();
        supDAO.add(su);
    }

    public void SetSupplier(Supplier su) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < sup.size() ; i++)
        {
            if(sup.get(i).getSupplierID() == su.getSupplierID())
            {
                sup.set(i, su);
                SupplierDAO supDAO = new SupplierDAO();
                supDAO.set(su);
                return;
            }
        }
    }
    
    public boolean CheckSupplierID(int supplierID)
    {
        for(Supplier su : sup)
        {
            if(su.getSupplierID() == supplierID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Supplier> getList() throws ClassNotFoundException {
        
        return sup;
    }
}

