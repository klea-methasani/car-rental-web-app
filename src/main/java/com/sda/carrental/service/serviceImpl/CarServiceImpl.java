package com.sda.carrental.service.serviceImpl;


import com.sda.carrental.exceptions.BranchNotFoundException;
import com.sda.carrental.exceptions.CarNotFoundException;
import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.repository.BranchRepository;
import com.sda.carrental.repository.CarRepository;
import com.sda.carrental.service.BranchServiceInterface;
import com.sda.carrental.service.CarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarServiceInterface {

    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntity createCar(CarEntity car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<CarEntity> getCar(Integer carId) {
        return Optional.ofNullable(carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found with this: " + carId)));
    }

    @Override
    public CarEntity updateCar(CarEntity car, Integer carId) {
        if (!carRepository.existsById(carId)) {
            throw new CarNotFoundException("You can not update  this car because it does not exist");
        }
        Optional<CarEntity> carEntity = carRepository.findById(carId);
        carEntity.get().setModel(car.getModel());
        carEntity.get().setBrand(car.getBrand());
        carEntity.get().setYear(car.getYear());
        carEntity.get().setColor(car.getColor());
        carEntity.get().setStatus(car.getStatus());
        carEntity.get().setRental_per_day(car.getRental_per_day());

        return carRepository.save(carEntity.get());
    }
    @Override
    public void deleteCar(Integer carId) {
        carRepository.deleteById(carId);
    }
}
