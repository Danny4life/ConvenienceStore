package com.coveniencestore.storeoperation;

import com.coveniencestore.model.*;

public interface StoreOperation {
    void hireCashier(Applicant applicant, Staff staff, Store store);

    String sellProducts(Store store, Customer customer, Staff staff);

    Product[] viewProductByCategory(Store store, String productCategory);
}
