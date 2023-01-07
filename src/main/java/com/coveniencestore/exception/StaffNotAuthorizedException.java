package com.coveniencestore.exception;

public class StaffNotAuthorizedException extends RuntimeException{
    public StaffNotAuthorizedException(String message){
        super(message);
    }
}
