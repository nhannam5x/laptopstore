/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-bifault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.InventorybillDAO;
import DTO.Inventorybill;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class InventorybillBUS {
    private ArrayList<Inventorybill> ivb ;
    public InventorybillBUS(int i) throws ClassNotFoundException
    {
        listInventorybill();
    }
     
    
    public InventorybillBUS() 
    {
        try {
            listInventorybill();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventorybillBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Inventorybill getInventorybillID(int inventorybill_id)
    {
        for(Inventorybill iv : ivb )
        {
            if(iv.getInventorybillID() == inventorybill_id)
            {
                return iv;
            }
        }
        return null;
    }
    
    public void listInventorybill() throws ClassNotFoundException
    {
        InventorybillDAO inventorybilDAO = new InventorybillDAO();
        ivb = new ArrayList<>();
        ivb = inventorybilDAO.list();
    }
    public void AddBill(Inventorybill iv) throws ClassNotFoundException
    {
        ivb.add(iv);
        InventorybillDAO inventorybilDAO = new InventorybillDAO();
        inventorybilDAO.add(iv);
    }

    public void SetInventorybill(Inventorybill iv) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < ivb.size() ; i++)
        {
            if(ivb.get(i).getInventorybillID() == iv.getInventorybillID())
            {
                ivb.set(i, iv);
                InventorybillDAO inventorybilDAO = new InventorybillDAO();
                inventorybilDAO.set(iv);
                return;
            }
        }
    }
    
    public boolean CheckInventorybillID(int inventorybillID)
    {
        for(Inventorybill iv : ivb)
        {
            if(iv.getInventorybillID() == inventorybillID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Inventorybill> getList() throws ClassNotFoundException {
        
        return ivb;
    }
    
     public ArrayList<Inventorybill> search(String inventorybillID, String staffID, String supplierID, String date)
    {
        ArrayList<Inventorybill> search = new ArrayList<>();
        inventorybillID = inventorybillID.isEmpty()?inventorybillID = "": inventorybillID;
        staffID = staffID.isEmpty()?staffID = "": staffID;
        supplierID = supplierID.isEmpty()?supplierID = "": supplierID;
        date = date.isEmpty()?date = "": date;
        for(Inventorybill b : ivb)
        {
            if((String.valueOf(b.getInventorybillID())).toLowerCase().contains(inventorybillID.toLowerCase()) && 
               (String.valueOf(b.getStaffID())).toLowerCase().contains(staffID.toLowerCase()) &&
               (String.valueOf(b.getSupplierID())).toLowerCase().contains(supplierID.toLowerCase()) &&
               (String.valueOf(b.getDate())).toLowerCase().contains(date.toLowerCase()))
            {
                search.add(b);
            }
        }
        return search;
    }
}

