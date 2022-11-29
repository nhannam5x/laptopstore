/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-bifault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.InventorybilldetailDAO;
import DTO.Inventorybilldetail;
import static java.lang.Character.toUpperCase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class InventorybilldetailBUS {
    private ArrayList<Inventorybilldetail> bdt ;
    public InventorybilldetailBUS(int i) throws ClassNotFoundException
    {
        listInventorybilldetail();
    }
     
    
    public InventorybilldetailBUS() 
    {
        try {
            listInventorybilldetail();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventorybilldetailBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Inventorybilldetail getInventorybillID(int inventorybill_id)
    {
        for(Inventorybilldetail bd : bdt )
        {
            if(bd.getInventorybillID() == inventorybill_id)
            {
                return bd;
            }
        }
        return null;
    }
    
    public void listInventorybilldetail() throws ClassNotFoundException
    {
        InventorybilldetailDAO bdtDAO = new InventorybilldetailDAO();
        bdt = new ArrayList<>();
        bdt = bdtDAO.list();
    }
    public void AddBilldetail(Inventorybilldetail bd) throws ClassNotFoundException
    {
        bdt.add(bd);
        InventorybilldetailDAO bdtDAO = new InventorybilldetailDAO();
        bdtDAO.add(bd);
    }

    public void SetInventorybilldetail(Inventorybilldetail bd) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < bdt.size() ; i++)
        {
            if(bdt.get(i).getInventorybillID() == bd.getInventorybillID())
            {
                bdt.set(i, bd);
                InventorybilldetailDAO bdtDAO = new InventorybilldetailDAO();
                bdtDAO.set(bd);
                return;
            }
        }
    }
    
    
    
    public boolean CheckInventorybilldetailID(int inventorybillID)
    {
        for(Inventorybilldetail bd : bdt)
        {
            if(bd.getInventorybillID() == inventorybillID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Inventorybilldetail> getList() throws ClassNotFoundException {
        
        return bdt;
    }
    
     public ArrayList<Inventorybilldetail> search(String productID, String quantity)
    {
        ArrayList<Inventorybilldetail> search = new ArrayList<>();
        productID = productID.isEmpty()?productID = "": productID;
        quantity = quantity.isEmpty()?quantity = "": quantity;
        for(Inventorybilldetail b : bdt)
        {
            if((String.valueOf(b.getProductID())).toLowerCase().contains(productID.toLowerCase()) && 
                (String.valueOf(b.getQuantity())).toLowerCase().contains(quantity.toLowerCase()))
            {
                search.add(b);
            }
        }
        return search;
    }


}

