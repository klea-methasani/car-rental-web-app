package com.sda.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BranchNotFoundException.class})
    public ResponseEntity<String> handleBranchNotFound(BranchNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  
    @ExceptionHandler(value = {CustomerNotFoundException.class})
    public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  
  @ExceptionHandler(value = {RentalNotFoundException.class})
    public ResponseEntity<String> handleRentalNotFound(RentalNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
