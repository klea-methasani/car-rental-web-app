package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.BranchNotFoundException;
import com.sda.carrental.exceptions.CustomerNotFoundException;
import com.sda.carrental.exceptions.RentalNotFoundException;
import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.models.CustomerEntity;
import com.sda.carrental.models.RentalEntity;
import com.sda.carrental.repository.BranchRepository;
import com.sda.carrental.repository.CustomerRepository;
import com.sda.carrental.repository.RentalRepository;
import com.sda.carrental.service.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerServiceImpl implements CustomerServiceInterface {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    RentalRepository rentalRepository;


    @Override
    public CustomerEntity createCustomer(CustomerEntity customer,Long branchId) {
        Optional<BranchEntity> branchEntity = branchRepository.findById(Math.toIntExact(branchId));
        if (branchEntity.isEmpty()) {
            throw new RuntimeException("Branch with provided ID does not exist");
        }
        customer.setBranchEntity(branchEntity.get());
        return customerRepository.save(customer);
    }

    @Override
    public Optional<CustomerEntity> getCustomer(Integer customerId) {
        return Optional.of(customerRepository.findById(customerId)).orElseThrow(() -> new CustomerNotFoundException("customer not found with this :" + customerId));

    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }


    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer, Integer customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException("You are not able to update  this customer because it does not exist");
        }
        Optional<CustomerEntity> customerEntity = customerRepository.findById(customerId);

        customerEntity.get().setAddress(customer.getAddress());
        customerEntity.get().setEmail(customer.getEmail());
        customerEntity.get().setFirstName(customer.getFirstName());
        customerEntity.get().setLastName(customer.getLastName());

        return customerRepository.save(customerEntity.get());
    }

    @Override
    public List<CustomerEntity> getCustomersByBranchId(Integer branchId) {
        return branchRepository.findById(branchId).map(BranchEntity::getCustomerEntities)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found"));
    }
    @Override
    public List<CustomerEntity> getAllCustomersByRentalId(Integer rentalId) {
        return rentalRepository.findById(rentalId).map(RentalEntity::getCustomerEntities)
                .orElseThrow(() -> new RentalNotFoundException("Rental not found"));
    }

}
