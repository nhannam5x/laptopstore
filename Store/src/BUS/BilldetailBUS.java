/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-bifault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.BilldetailDAO;
import DTO.Billdetail;
import static java.lang.Character.toUpperCase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BilldetailBUS {
    private ArrayList<Billdetail> bdt ;
    public BilldetailBUS(int i) throws ClassNotFoundException
    {
        listBilldetail();
    }
     
    
    public BilldetailBUS() 
    {
        try {
            listBilldetail();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BilldetailBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Billdetail getBillID(int bill_id)
    {
        for(Billdetail bd : bdt )
        {
            if(bd.getBillID() == bill_id)
            {
                return bd;
            }
        }
        return null;
    }
    
    public void listBilldetail() throws ClassNotFoundException
    {
        BilldetailDAO bdtDAO = new BilldetailDAO();
        bdt = new ArrayList<>();
        bdt = bdtDAO.list();
    }
    public void AddBilldetail(Billdetail bd) throws ClassNotFoundException
    {
        bdt.add(bd);
        BilldetailDAO bdtDAO = new BilldetailDAO();
        bdtDAO.add(bd);
    }

    public void SetBilldetail(Billdetail bd) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < bdt.size() ; i++)
        {
            if(bdt.get(i).getBillID() == bd.getBillID())
            {
                bdt.set(i, bd);
                BilldetailDAO bdtDAO = new BilldetailDAO();
                bdtDAO.set(bd);
                return;
            }
        }
    }
    
    
    
    public boolean CheckBilldetailID(int billID)
    {
        for(Billdetail bd : bdt)
        {
            if(bd.getBillID() == billID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Billdetail> getList() {
        
        return bdt;
    }
    
     public ArrayList<Billdetail> search(String productID, String quantity)
    {
        ArrayList<Billdetail> search = new ArrayList<>();
        productID = productID.isEmpty()?productID = "": productID;
        quantity = quantity.isEmpty()?quantity = "": quantity;
        for(Billdetail b : bdt)
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

