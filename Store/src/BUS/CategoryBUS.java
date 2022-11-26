/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.CategoryDAO;
import DTO.Category;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CategoryBUS {
    private ArrayList<Category> cat ;
    public CategoryBUS(int i) throws ClassNotFoundException
    {
        listCategory();
    }
     
    
    public CategoryBUS() 
    {
        try {
            listCategory();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Category getCategoryID(int Category_id)
    {
        for(Category ca : cat )
        {
            if(ca.getCategoryID()== Category_id)
            {
                return ca;
            }
        }
        return null;
    }
    
    public void listCategory() throws ClassNotFoundException
    {
        CategoryDAO catDAO = new CategoryDAO();
        cat = new ArrayList<>();
        cat = catDAO.list();
    }
    public void AddCategory(Category ca) throws ClassNotFoundException
    {
        cat.add(ca);
        CategoryDAO catDAO = new CategoryDAO();
        catDAO.add(ca);
    }

    public void SetCategory(Category ca) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < cat.size() ; i++)
        {
            if(cat.get(i).getCategoryID()== ca.getCategoryID())
            {
                cat.set(i, ca);
                CategoryDAO catDAO = new CategoryDAO();
                catDAO.set(ca);
                return;
            }
        }
    }
    
    public boolean CheckCategoryID(int categoryID)
    {
        for(Category ca : cat)
        {
            if(ca.getCategoryID()== categoryID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Category> getList() throws ClassNotFoundException {
        
        return cat;
    }
    
    public ArrayList<Category> search(String categoryID, String categoryName)
    {
        ArrayList<Category> search = new ArrayList<>();
        categoryID = categoryID.isEmpty()?categoryID = "": categoryID;
        categoryName = categoryName.isEmpty()?categoryName = "": categoryName;
        for(Category c : cat)
        {
            if((String.valueOf(c.getCategoryID())).toLowerCase().contains(categoryID.toLowerCase()) && 
               (String.valueOf(c.getCategoryName())).toLowerCase().contains(categoryName.toLowerCase()))
            {
                search.add(c);
            }
        }
        return search;
    }
}

