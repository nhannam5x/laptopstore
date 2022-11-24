/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author donha
 */
public class Product {
    private int productID;
    private String productName;
    private int categoryID, supplierID;
    private float price;
    private int quantity, status;

    public Product(int productID, String productName, int categoryID, int supplierID, float price, int quantity, int status) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.supplierID = supplierID;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
}
