package com.sda.carrental.service;

import com.sda.carrental.models.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerServiceInterface {

    public CustomerEntity createCustomer(CustomerEntity customer, Long branchId);

    Optional<CustomerEntity> getCustomer(Integer customerId);

    CustomerEntity updateCustomer(CustomerEntity customer, Integer customerId);

    void deleteCustomer(Integer customerId);

    List<CustomerEntity> getCustomersByBranchId(Integer branchId);

    List<CustomerEntity> getAllCustomersByRentalId(Integer rentalId);

}
