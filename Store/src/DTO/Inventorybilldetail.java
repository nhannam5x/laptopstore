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
    private int inventorybillID, productID, quantity, status;

    public Inventorybilldetail(int inventorybillID, int productID, int quantity, int status) {
        this.inventorybillID = inventorybillID;
        this.productID = productID;
        this.quantity = quantity;
        this.status = status;
    }

    public int getInventorybillID() {
        return inventorybillID;
    }

    public int getProductID(){
        return productID;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setInventorybillID(int billID) {
        this.inventorybillID = inventorybillID;
    }
    
    public void setProductID(int productID){
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(int status) {
        this.status = status;
    }

  
        
}
