package com.coveniencestore.customer;

import com.coveniencestore.model.Customer;
import com.coveniencestore.model.Store;

public interface CustomerService {

    void addProductsToCart(Customer customer, Store store, String productName, int quantity);

    String fundWallet(Customer customer, double amount);
}
