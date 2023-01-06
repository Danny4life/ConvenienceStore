package com.coveniencestore.model;

import static com.coveniencestore.enums.ProductAvailability.AVAILABLE;
import static com.coveniencestore.enums.ProductCategory.SHOES;

public class Main {


    public static void main(String[] args) {
        Product shoe = new Product("lofas", 300.00, 50, SHOES);



        System.out.println("we have a total of " +  "" + shoe.getQuantity() + " " + shoe.getName()
                + " " + "which will be sold at " + "" + shoe.getPrice() + "" +
                "$" + " " + "per " + "" + shoe.getName());

        System.out.println(shoe.getQuantity());
        System.out.println(shoe.getProductCategory());
        System.out.println(shoe.getProductAvailability());

    }


}
