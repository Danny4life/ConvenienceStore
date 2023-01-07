package com.coveniencestore.model;

import com.coveniencestore.enums.Gender;
import com.coveniencestore.enums.Qualification;

public class Applicant extends Person{

    private Qualification qualification;

    public Applicant(String firstName, String lastName, String address, Gender gender, Qualification qualification) {
        super(firstName, lastName, address, gender);
        this.qualification = qualification;
    }

    public Qualification getQualification() {
        return qualification;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "firstName='" + super.getFirstName() + '\'' +
                "lastName='" + super.getLastName() + '\'' +
                "address='" + super.getAddress()+ '\'' +
                "gender=" + super.getGender() +
                "qualification=" + qualification +
                '}';
    }
}
