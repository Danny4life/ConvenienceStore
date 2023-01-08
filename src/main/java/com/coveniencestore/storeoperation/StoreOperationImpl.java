package com.coveniencestore.storeoperation;

import com.coveniencestore.model.*;

public class StoreOperationImpl implements StoreOperation{
    @Override
    public void hireCashier(Applicant applicant, Staff staff, Store store) {

    }

    @Override
    public String sellProducts(Store store, Customer customer, Staff staff) {
        return null;
    }

    @Override
    public Product[] viewProductByCategory(Store store, String productCategory) {
        return new Product[0];
    }
}
