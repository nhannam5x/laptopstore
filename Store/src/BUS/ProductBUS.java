/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.ProductDAO;
import DTO.Product;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ProductBUS {
    private ArrayList<Product> pro ;
    public ProductBUS(int i) throws ClassNotFoundException
    {
        listProduct();
    }
     
    
    public ProductBUS() 
    {
        try {
            listProduct();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Product getProductID(int product_id)
    {
        for(Product pr : pro )
        {
            if(pr.getProductID()== product_id)
            {
                return pr;
            }
        }
        return null;
    }
    
    public void listProduct() throws ClassNotFoundException
    {
        ProductDAO proDAO = new ProductDAO();
        pro = new ArrayList<>();
        pro = proDAO.list();
    }
    public void AddProduct(Product pr) throws ClassNotFoundException
    {
        pro.add(pr);
        ProductDAO proDAO = new ProductDAO();
        proDAO.add(pr);
    }

    public void SetProduct(Product pr) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < pro.size() ; i++)
        {
            if(pro.get(i).getProductID()== pr.getProductID())
            {
                pro.set(i, pr);
                ProductDAO proDAO = new ProductDAO();
                proDAO.set(pr);
                return;
            }
        }
    }
    
    public boolean CheckProductID(int productID)
    {
        for(Product pr : pro)
        {
            if(pr.getProductID() == productID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Product> getList() {
        
        return pro;
    }
}

