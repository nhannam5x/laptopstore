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
    
}
