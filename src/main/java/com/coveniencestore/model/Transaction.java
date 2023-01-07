package com.coveniencestore.model;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private double transactionAmount;
    private List<Product> productBoughtByCustomer;
    private Staff processedBy;
    private Customer customer;

    public Transaction(double transactionAmount, Staff processedBy, Customer customer) {
        this.transactionAmount = transactionAmount;
        this.productBoughtByCustomer = new ArrayList<>();
        this.processedBy = processedBy;
        this.customer = customer;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Staff getProcessedBy() {
        return processedBy;
    }

    public List<Product> getProductBoughtByCustomer() {
        return productBoughtByCustomer;
    }

    public void setProcessedBy(Staff processedBy) {
        this.processedBy = processedBy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionAmount=" + transactionAmount +
                ", productBoughtByCustomer=" + productBoughtByCustomer +
                ", processedBy=" + processedBy +
                ", customer=" + customer +
                '}';
    }
}
