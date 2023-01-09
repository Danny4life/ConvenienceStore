package com.coveniencestore.storeoperation;

import com.coveniencestore.enums.Qualification;
import com.coveniencestore.enums.Role;
import com.coveniencestore.exception.AlreadyAppliedException;
import com.coveniencestore.exception.ApplicantNotAppliedException;
import com.coveniencestore.exception.ApplicantNotQualifiedException;
import com.coveniencestore.exception.StaffNotAuthorizedException;
import com.coveniencestore.model.*;

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
        return null;
    }

    @Override
    public Product[] viewProductByCategory(Store store, String productCategory) {
        return new Product[0];
    }
}
