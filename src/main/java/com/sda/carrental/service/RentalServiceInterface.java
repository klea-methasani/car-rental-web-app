package com.sda.carrental.service;

import com.sda.carrental.models.RentalEntity;

import java.util.Optional;

public interface RentalServiceInterface {

    RentalEntity createRental(RentalEntity rental);

    Optional<RentalEntity> getRental(Integer rentalId);

    RentalEntity updateRental(RentalEntity rental, Integer rentalId);

    void deleteRental(Integer rentalId);
}
