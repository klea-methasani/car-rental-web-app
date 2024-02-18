package com.sda.carrental.controller;

import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CustomerEntity;
import com.sda.carrental.service.serviceImpl.BranchServiceImpl;
import com.sda.carrental.service.serviceImpl.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerEntity> createCustomers(@RequestBody CustomerEntity customer){
        CustomerEntity createCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createCustomer, HttpStatus.CREATED);}

    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Optional<CustomerEntity>> getCustomerById(@PathVariable Integer customerId){
        Optional<CustomerEntity> getCostumer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(getCostumer, HttpStatus.OK);}

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody CustomerEntity customer, @PathVariable Integer customerId){
        CustomerEntity updateCustomer = customerService.updateCustomer(customer,customerId);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
