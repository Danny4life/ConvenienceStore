package com.coveniencestore.customer;

import com.coveniencestore.exception.OutOfStockException;
import com.coveniencestore.exception.QuantityExceededException;
import com.coveniencestore.model.Customer;
import com.coveniencestore.model.Product;
import com.coveniencestore.model.Store;

import static com.coveniencestore.enums.ProductAvailability.AVAILABLE;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public void addProductsToCart(Customer customer, Store store, String productName, int quantity) {
        for(Product product : store.getListOfProductsInStore() ){
            if(product.getName().equalsIgnoreCase(productName)){
                if(product.getProductAvailability().equals(AVAILABLE)){
                    if(product.getQuantity() >= quantity){
                        customer.getCart().getProductsInCart().merge(product, quantity, Integer::sum );
                        System.out.println(product.getName() + "has been added to " + customer.getFirstName() + " 's cart.");
                        break;
                    }else
                        throw new QuantityExceededException("We do not have up to " + quantity +
                                "available, " + "only " + product.getQuantity() + "is/are left");
                    }
                        else throw new OutOfStockException("This product is out of stock");
                }
            }
        System.out.println(customer.getCart().getProductsInCart());

    }

    @Override
    public String fundWallet(Customer customer, double amount) {
        double newBalance = customer.getWallet().getBalance() + amount;
        customer.getWallet().setBalance(newBalance);
        return "Successfully added " + amount + " to wallet. Your new balance is " + customer.getWallet().getBalance();
    }
}
