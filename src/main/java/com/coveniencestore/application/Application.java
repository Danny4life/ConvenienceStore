package com.coveniencestore.application;

import com.coveniencestore.model.Applicant;
import com.coveniencestore.model.Store;

public interface Application {
    void apply(Applicant applicant, Store store);
}
