package com.sda.carrental.service;

import com.sda.carrental.models.CarEntity;

import java.util.List;
import java.util.Optional;

public interface CarServiceInterface {

    CarEntity createCar(CarEntity customer, Long branchId);

    Optional<CarEntity> getCar(Integer customerId);

    CarEntity updateCar(CarEntity customer, Integer customerId);

    void deleteCar(Integer customerId);

    List<CarEntity> getCarsByBranchId(Integer branchId);

}
