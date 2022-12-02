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
public class Discount {
    private int discountID, discountValue;
    private String dateStart, dateEnd;
    private int quantity, status;

    public Discount(int discountID, int discountValue, String dateStart, String dateEnd, int quantity, int status) {
        this.discountID = discountID;
        this.discountValue = discountValue;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.quantity = quantity;
        this.status = status;
    }

    public int getDiscountID() {
        return discountID;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
