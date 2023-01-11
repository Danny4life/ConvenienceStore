package com.coveniencestore.storeoperation;

import com.coveniencestore.enums.ProductCategory;
import com.coveniencestore.enums.Qualification;
import com.coveniencestore.enums.Role;
import com.coveniencestore.exception.*;
import com.coveniencestore.model.*;

import java.util.Map;

import static com.coveniencestore.enums.Qualification.OND;

public class StoreOperationImpl implements StoreOperation{
    @Override
    public void hireCashier(Applicant applicant, Staff staff, Store store){
        if(staff.getRole().equals(Role.MANAGER)){
            if(store.getApplicants().contains(applicant)){
                if(applicant.getQualification().equals(OND)) {
                    Staff newStaff = new Staff(
                            applicant.getFirstName(),
                            applicant.getLastName(),
                            applicant.getAddress(),
                            applicant.getGender(),
                            Role.CASHIER
                    );

                    store.getStaffs().add(newStaff);
                    store.getApplicants().remove(applicant);
                    System.out.println("Congratulations, " + applicant.getFirstName() + " you have been hired!");
                }else {
                    throw new ApplicantNotQualifiedException("You must have an " + OND + " to be eligible for this position");
                }
            }else {
                throw new ApplicantNotAppliedException(applicant.getFirstName() + " did not apply for this role");
            }
        } else {
            throw new StaffNotAuthorizedException("You are not authorized to hire an applicant");
        }
    }

    @Override
    public String sellProducts(Store store, Customer customer, Staff staff) {
        if(staff.getRole().equals(Role.CASHIER)){
            double totalCostOfProductsInCart = customer.getCart().getTotalCostOfProductInCart();
            Map<Product, Integer> productsInCart = customer.getCart().getProductsInCart();
            for(Map.Entry<Product, Integer> products : productsInCart.entrySet()){
                Product product = products.getKey();
                Integer quantity = products.getValue();
                totalCostOfProductsInCart += getTotalCostOfProductInCart(product, quantity);
            }
            return checkIfCustomerHasEnoughFunds(store, customer, staff, totalCostOfProductsInCart);

        }else {
            throw new InsufficientFundException("Your balance is not enough to perform this transaction");
        }

    }

    private String checkIfCustomerHasEnoughFunds(Store store, Customer customer, Staff staff, double totalCostOfProductsInCart) {

        if(customer.getWallet().getBalance() >= totalCostOfProductsInCart){
            double newWalletBalance = customer.getWallet().getBalance() - totalCostOfProductsInCart;
            customer.getWallet().setBalance(newWalletBalance);
            String receipt = generateReceipt(store, customer, totalCostOfProductsInCart, staff);
            customer.getCart().setTotalCostOfProductInCart(0);
            customer.getCart().getProductsInCart().clear();

            return receipt;
        }else {
            throw new InsufficientFundException("Your balance is not enough to perform this transaction");
        }

    }

    @Override
    public Product[] viewProductByCategory(Store store, String productCategory) {
        System.out.printf("Viewing products in %s category...\\n\", productCategory");
        Product[] productsByCategory;
        int index = 0;
        ProductCategory category = ProductCategory.valueOf(productCategory.toUpperCase());

        for(Product product : store.getListOfProductsInStore()){
            if(product.getProductCategory().equals(category)) index++;
        }

        productsByCategory = new Product[index];
        int counter = 0;

        for(Product product : store.getListOfProductsInStore()){
            if(product.getProductCategory().equals(category)){
                productsByCategory[counter++] = product;
            }
        }
       if(productsByCategory.length == 0){
           System.out.println("There are no products in this category yet");
       }

       return productsByCategory;
    }

    private String generateReceipt(Store store, Customer customer, double totalCostOfProductsInCart, Staff staff) {

        StringBuilder productsBought = new StringBuilder();

        for(Map.Entry<Product, Integer> product : customer.getCart().getProductsInCart().entrySet()){
            productsBought.append(product.getKey().getName())
                    .append(", ")
                    .append("price ")
                    .append(product.getKey().getPrice())
                    .append(", ")
                    .append(" quantity bought ")
                    .append(product.getValue())
                    .append("\n");
        }

        return "\n" +
                "Payment Successful! \n" +
                "Receipt For : " + customer.getFirstName() + "\n" +
                "======================\n" +
                "Products bought : " + productsBought + "\n" +
                "======================\n" +
                "Total cost of Products bought : " + totalCostOfProductsInCart + "\n" +
                "======================\n" +
                "Processed by " + staff.getFirstName() + "\n" +
                "======================\n" +
                "Thank you for shopping with us at " + store.getName() + "!" + "\n";
    }

    private double getTotalCostOfProductInCart(Product product, Integer quantity) {

        return 0;
    }


}
