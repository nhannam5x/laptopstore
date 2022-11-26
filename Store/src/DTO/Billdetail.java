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
public class Billdetail {
    private int billID, productID, quantity, status;

    public Billdetail(int billID, int productID, int quantity, int status) {
        this.billID = billID;
        this.productID = productID;
        this.quantity = quantity;
        this.status = status;
    }

    public int getBillID() {
        return billID;
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

    public void setBillID(int billID) {
        this.billID = billID;
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
