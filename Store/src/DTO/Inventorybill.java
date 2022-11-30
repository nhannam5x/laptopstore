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
public class Inventorybill {
    private int inventorybillID, staffID;
    private float totalPrice;
    private String date;
    private int status;

    public Inventorybill(int inventorybillID, int staffID, float totalPrice, String date, int status) {
        this.inventorybillID = inventorybillID;
        this.staffID = staffID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.status = status;
    }

    public int getInventorybillID() {
        return inventorybillID;
    }


    public int getStaffID() {
        return staffID;
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

    public void setInventorybillID(int inventorybillID) {
        this.inventorybillID = inventorybillID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
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
