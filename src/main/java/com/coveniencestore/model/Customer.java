package com.coveniencestore.model;

import com.coveniencestore.enums.Gender;

public class Customer extends Person{

    private final Cart cart;
    private final Wallet wallet;

    public Customer(String firstName, String lastName, String address, Gender gender) {
        super(firstName, lastName, address, gender);
        this.cart = new Cart();
        this.wallet = new Wallet();
    }

    public Cart getCart() {
        return cart;
    }

    public Wallet getWallet() {
        return wallet;
    }
}
