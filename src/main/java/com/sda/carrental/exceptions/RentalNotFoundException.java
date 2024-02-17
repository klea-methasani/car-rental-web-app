package com.sda.carrental.exceptions;

public class RentalNotFoundException extends RuntimeException{
    public RentalNotFoundException(String message){
        super(message);
    }
}
