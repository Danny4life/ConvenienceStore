package com.coveniencestore.model;

import com.coveniencestore.enums.Gender;

public class Staff extends Person{
    public Staff(String firstName, String lastName, String address, Gender gender) {
        super(firstName, lastName, address, gender);
    }
}
