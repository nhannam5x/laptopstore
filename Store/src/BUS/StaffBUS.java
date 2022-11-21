/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.StaffDAO;
import DTO.Staff;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StaffBUS {
    private ArrayList<Staff> sta ;
    public StaffBUS(int i) throws ClassNotFoundException
    {
        listStaff();
    }
     
    
    public StaffBUS() 
    {
        try {
            listStaff();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StaffBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Staff getStaffID(int staff_id)
    {
        for(Staff st : sta )
        {
            if(st.getStaffID() == staff_id)
            {
                return st;
            }
        }
        return null;
    }
    
    public void listStaff() throws ClassNotFoundException
    {
        StaffDAO staDAO = new StaffDAO();
        sta = new ArrayList<>();
        sta = staDAO.list();
    }
    public void AddStaff(Staff st) throws ClassNotFoundException
    {
        sta.add(st);
        StaffDAO staDAO = new StaffDAO();
        staDAO.add(st);
    }

    public void SetStaff(Staff st) throws ClassNotFoundException
    {
       
        for(int i = 0 ; i < sta.size() ; i++)
        {
            if(sta.get(i).getStaffID() == st.getStaffID())
            {
                sta.set(i, st);
                StaffDAO staDAO = new StaffDAO();
                staDAO.set(st);
                return;
            }
        }
    }
    
    public boolean CheckStaffID(int StaffID)
    {
        for(Staff st : sta)
        {
            if(st.getStaffID() == StaffID)
            {
                return true;
            }
        }
        return false;
    }

    
    
    public ArrayList<Staff> getList() throws ClassNotFoundException {
        
        return sta;
    }
}

