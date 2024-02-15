package com.sda.carrental.exceptions;

public class BranchNotFoundException extends RuntimeException{

    public BranchNotFoundException(String message){
        super(message);
    }
}
