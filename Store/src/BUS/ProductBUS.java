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
    
    public ArrayList<Product> search(String productID, String productName, String categoryID, String supplierID) {
        ArrayList<Product> search = new ArrayList<>();
        productID = productID.isEmpty()?productID = "": productID;
        productName = productName.isEmpty()?productName = "": productName;
        categoryID = categoryID.isEmpty()?categoryID = "": categoryID;
        supplierID = supplierID.isEmpty()?supplierID = "": supplierID;
        for(Product p : pro)
        {
            if((String.valueOf(p.getProductID())).toLowerCase().contains(productID.toLowerCase()) && 
               (String.valueOf(p.getProductName())).toLowerCase().contains(productName.toLowerCase()) &&
               (String.valueOf(p.getCategoryID())).toLowerCase().contains(categoryID.toLowerCase()) &&
               (String.valueOf(p.getSupplierID())).toLowerCase().contains(supplierID.toLowerCase())
                )
                    
                    
            {
                search.add(p);
            }
        }
        return search;
    }
}

