/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.DiscountDAO;
import DTO.Discount;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DiscountBUS {
    private ArrayList<Discount> dis ;
    public DiscountBUS(int i) throws ClassNotFoundException
    {
        listDiscount();
    }
     
    public DiscountBUS() 
    {
        try {
            listDiscount();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiscountBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Discount getDiscountID(int discount_id)
    {
        for(Discount di : dis )
        {
            if(di.getDiscountID()== discount_id)
            {
                return di;
            }
        }
        return null;
    }
    
    public void listDiscount() throws ClassNotFoundException
    {
        DiscountDAO disDAO = new DiscountDAO();
        dis = new ArrayList<>();
        dis = disDAO.list();
    }
    public void AddDiscount(Discount di) throws ClassNotFoundException
    {
        dis.add(di);
        DiscountDAO disDAO = new DiscountDAO();
        disDAO.add(di);
    }

    public void SetDiscount(Discount di) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < dis.size() ; i++)
        {
            if(dis.get(i).getDiscountID()== di.getDiscountID())
            {
                dis.set(i, di);
                DiscountDAO disDAO = new DiscountDAO();
                disDAO.set(di);
                return;
            }
        }
    }
    
    public boolean CheckDiscountID(int DiscountID)
    {
        for(Discount di : dis)
        {
            if(di.getDiscountID()== DiscountID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Discount> getList() throws ClassNotFoundException {
        
        return dis;
    }
    
    public ArrayList<Discount> search(String discountID, String dateStart, String dateEnd)
    {
        ArrayList<Discount> search = new ArrayList<>();
        discountID = discountID.isEmpty()?discountID = "": discountID;
        dateStart = dateStart.isEmpty()?dateStart = "": dateStart;
        dateEnd = dateEnd.isEmpty()?dateEnd = "": dateEnd;
        for(Discount d : dis)
        {
            if((String.valueOf(d.getDiscountID())).toLowerCase().contains(discountID.toLowerCase()) && 
               (String.valueOf(d.getDateStart())).toLowerCase().contains(dateStart.toLowerCase()) &&
               (String.valueOf(d.getDateEnd())).toLowerCase().contains(dateEnd.toLowerCase())
                )
                    
                    
            {
                search.add(d);
            }
        }
        return search;
    }
}

