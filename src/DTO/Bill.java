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
public class Bill {
    private int billID, productID, staffID, customerID, discountID;
    private float totalPrice;
    private String date;
    private int status;

    public Bill(int billID, int productID, int staffID, int customerID, int discountID, float totalPrice, String date, int status) {
        this.billID = billID;
        this.productID = productID;
        this.staffID = staffID;
        this.customerID = customerID;
        this.discountID = discountID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.status = status;
    }

    public int getBillID() {
        return billID;
    }

    public int getProductID() {
        return productID;
    }

    public int getStaffID() {
        return staffID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getDiscountID() {
        return discountID;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public String getDate() {
        return date;
    }

    public int getStatus() {
        return status;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
    
}
