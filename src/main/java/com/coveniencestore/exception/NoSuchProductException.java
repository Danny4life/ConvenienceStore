package com.coveniencestore.exception;

public class NoSuchProductException extends RuntimeException{
    public NoSuchProductException(String message){
        super(message);
    }
}
