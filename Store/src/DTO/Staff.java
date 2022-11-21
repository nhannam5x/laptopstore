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
public class Staff {
    private int staffID;
    private String firstName, lastName, email;
    private int phone, authority, status;

    public Staff(int staffID, String firstName, String lastName, String email, int phone, int authority, int status) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.authority = authority;
        this.status = status;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public int getAuthority() {
        return authority;
    }

    public int getStatus() {
        return status;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
