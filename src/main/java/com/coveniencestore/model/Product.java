package com.coveniencestore.model;

import com.coveniencestore.enums.ProductAvailability;
import com.coveniencestore.enums.ProductCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.coveniencestore.enums.ProductAvailability.AVAILABLE;
import static com.coveniencestore.enums.ProductAvailability.OUT_OF_STOCK;

@Data
@NoArgsConstructor
public class Product {
    private String name;
    private double price;
    private int quantity;
    private ProductAvailability productAvailability;
    private ProductCategory productCategory;

    public Product(String name, double price, int quantity, ProductCategory productCategory) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.productCategory = productCategory;
    }

    public void checkProductAvailability() {
        if (this.getQuantity() <= 0) {
            this.setProductAvailability(OUT_OF_STOCK);
        } else {
            this.setProductAvailability(AVAILABLE);
        }
    }

    public void checkAndSetAvailability() {
        if (this.getQuantity() == 0)
            this.setProductAvailability(OUT_OF_STOCK);
            else this.setProductAvailability(AVAILABLE);

    }

}

