package com.sda.carrental.service;


import com.sda.carrental.models.CarEntity;
import java.util.Optional;

public interface CarServiceInterface {

    CarEntity createCar(CarEntity car);

    Optional<CarEntity> getCar(Integer carId);

    CarEntity updateCar(CarEntity car, Integer carId);

    void deleteCar(Integer carId);

}
