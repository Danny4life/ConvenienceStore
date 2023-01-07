package com.coveniencestore.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Store {
    private String name;
    private List<Applicant> applicants;
    private List<Staff> staffs;
    private List<Transaction> transactions;
    private Product[] listOfProductsInStore;

    public Store(String name) {
        this.name = name;
        this.applicants = new ArrayList<>();
        this.staffs = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.listOfProductsInStore = listOfProductsInStore;
    }
}
