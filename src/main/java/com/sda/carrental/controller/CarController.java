package com.sda.carrental.controller;

import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.service.serviceImpl.BranchServiceImpl;
import com.sda.carrental.service.serviceImpl.CarServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @PostMapping("/createCars")
    public ResponseEntity<CarEntity> createCars(@RequestBody CarEntity car){
        CarEntity createCar = carService.createCar(car);
        return new ResponseEntity<>(createCar, HttpStatus.CREATED);
    }

    @GetMapping("/getCarById/{id}")
    public ResponseEntity<Optional<CarEntity>> getCarsById(@PathVariable Integer carId){
        Optional<CarEntity> getCar = carService.getCar(carId);
        return new ResponseEntity<>(getCar, HttpStatus.OK);
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<CarEntity> updateCars(@RequestBody CarEntity car, @PathVariable Integer carId){
        CarEntity updateCar = carService.updateCar(car,carId);
        return new ResponseEntity<>(updateCar, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCars/{id}")
    public ResponseEntity<Void> deleteCars(@PathVariable Integer carId){
        carService.deleteCar(carId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
