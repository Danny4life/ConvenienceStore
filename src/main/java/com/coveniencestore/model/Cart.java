package com.coveniencestore.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> productsInCart;
    private double totalCostOfProductInCart;

    public Cart() {
        this.productsInCart = new HashMap<>();
    }

    public Map<Product, Integer> getProductsInCart() {
        return productsInCart;
    }

    public double getTotalCostOfProductInCart() {
        return totalCostOfProductInCart;
    }

    public void setTotalCostOfProductInCart(double totalCostOfProductInCart) {
        this.totalCostOfProductInCart = totalCostOfProductInCart;
    }
}
