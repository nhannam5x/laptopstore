/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL XPS 15
 */
public class Inventorybilldetail {
    private int inventorybillID, productID, categoryID, supplierID, quantity, status;

    public Inventorybilldetail(int inventorybillID, int productID, int categoryID, int supplierID,int quantity, int status) {
        this.inventorybillID = inventorybillID;
        this.productID = productID;
        this.categoryID = categoryID;
        this.supplierID = supplierID;
        this.quantity = quantity;
        this.status = status;
    }

    public int getInventorybillID() {
        return inventorybillID;
    }

    public int getProductID() {
        return productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setInventorybillID(int inventorybillID) {
        this.inventorybillID = inventorybillID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
        
}
