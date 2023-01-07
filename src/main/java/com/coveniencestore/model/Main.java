package com.coveniencestore.model;

import com.coveniencestore.enums.Gender;
import com.coveniencestore.enums.Role;

import static com.coveniencestore.enums.Gender.MALE;
import static com.coveniencestore.enums.ProductAvailability.AVAILABLE;
import static com.coveniencestore.enums.ProductCategory.SHOES;

public class Main {


    public static void main(String[] args) {
       Staff staff1 = new Staff("joe", "doe", "sapele road", Gender.MALE, 001, Role.CASHIER);

        System.out.println(staff1.getRole());
    }


}
