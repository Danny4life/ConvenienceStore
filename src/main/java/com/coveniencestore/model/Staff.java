package com.coveniencestore.model;

import com.coveniencestore.enums.Gender;
import com.coveniencestore.enums.Role;

public class Staff extends Person{

    private int staffID;
    private Role role;

    public Staff(String firstName, String lastName, String address, Gender gender, Role role) {
        super(firstName, lastName, address, gender);
        this.staffID = staffID + staffID;
        this.role = role;
    }


    public Role getRole() {
        return role;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "firstName='" + getFirstName() + '\'' +
                "lastName='" + getLastName() + '\'' +
                "address='" + getAddress()+ '\'' +
                "gender=" + getGender() +
                "staffID=" + staffID +
                ", role=" + role +
                '}';
    }
}
