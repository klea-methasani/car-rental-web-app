package com.sda.carrental.service;

import com.sda.carrental.models.CustomerEntity;

import java.util.Optional;

public interface CustomerServiceInterface {

    CustomerEntity createCustomer(CustomerEntity customer);

    Optional<CustomerEntity> getCustomer(Integer customerId);

    CustomerEntity updateCustomer(CustomerEntity customer, Integer customerId);

    void deleteCustomer(Integer customerId);
}
