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
public class Supplier {
    private int supplierID;
    private String supplierName, address;
    private int status;

    public Supplier(int supplierID, String supplierName, String address, int status) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address = address;
        this.status = status;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getAddress() {
        return address;
    }

    public int getStatus() {
        return status;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
