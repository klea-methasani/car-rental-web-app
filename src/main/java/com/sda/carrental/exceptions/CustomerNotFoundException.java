package com.sda.carrental.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message)
    {super(message);}
}
