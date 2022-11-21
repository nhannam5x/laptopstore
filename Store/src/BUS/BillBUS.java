/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-bifault.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.BillDAO;
import DTO.Bill;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class BillBUS {
    private ArrayList<Bill> bil ;
    public BillBUS(int i) throws ClassNotFoundException
    {
        listBill();
    }
     
    
    public BillBUS() 
    {
        try {
            listBill();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Bill getBillID(int bill_id)
    {
        for(Bill bi : bil )
        {
            if(bi.getBillID() == bill_id)
            {
                return bi;
            }
        }
        return null;
    }
    
    public void listBill() throws ClassNotFoundException
    {
        BillDAO bilDAO = new BillDAO();
        bil = new ArrayList<>();
        bil = bilDAO.list();
    }
    public void AddBill(Bill bi) throws ClassNotFoundException
    {
        bil.add(bi);
        BillDAO bilDAO = new BillDAO();
        bilDAO.add(bi);
    }

    public void SetBill(Bill bi) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < bil.size() ; i++)
        {
            if(bil.get(i).getBillID() == bi.getBillID())
            {
                bil.set(i, bi);
                BillDAO bilDAO = new BillDAO();
                bilDAO.set(bi);
                return;
            }
        }
    }
    
    public boolean CheckBillID(int billID)
    {
        for(Bill bi : bil)
        {
            if(bi.getBillID() == billID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Bill> getList() throws ClassNotFoundException {
        
        return bil;
    }
}

