package com.coveniencestore.model;


import com.coveniencestore.customer.CustomerService;
import com.coveniencestore.customer.CustomerServiceImpl;
import com.coveniencestore.enums.Gender;
import com.coveniencestore.enums.Role;
import com.coveniencestore.storeoperation.StoreOperation;
import com.coveniencestore.storeoperation.StoreOperationImpl;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        Store store1 = new Store("Tarex Store");
        Staff staff1 = new Staff("Sola", "Osiki", "Sapele Road", Gender.FEMALE, Role.MANAGER);
        Staff staff2 = new Staff("Jane", "Doe", "Airport road", Gender.FEMALE, Role.CASHIER);

        System.out.println(Arrays.toString(store1.getListOfProductsInStore()));

        StoreOperation storeOperation = new StoreOperationImpl();
        System.out.println(Arrays.toString(storeOperation.viewProductByCategory(store1, "Shoes")));

        Customer samuel = new Customer("Samuel", "Adjei", "brooks street uyo", Gender.MALE);
        CustomerService customerMenu = new CustomerServiceImpl();
        customerMenu.addProductsToCart(samuel, store1, "Lewis", 4);
        customerMenu.addProductsToCart(samuel, store1, "Lewis", 3);
        customerMenu.addProductsToCart(samuel, store1, "Vans", 5);
        customerMenu.fundWallet(samuel, 1000000.00);

        System.out.println(storeOperation.sellProducts(store1,samuel,staff2));
    }

}
