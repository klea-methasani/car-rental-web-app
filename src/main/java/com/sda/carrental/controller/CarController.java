package com.sda.carrental.controller;

import com.sda.carrental.models.CarEntity;
import com.sda.carrental.models.enums.CarStatus;
import com.sda.carrental.service.serviceImpl.CarServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @PostMapping("/addCar/{branchId}")
    public ResponseEntity<CarEntity> addCar(@RequestBody CarEntity car,@PathVariable Integer branchId) {
        CarEntity createCar = carService.createCar(car,branchId);
        return new ResponseEntity<>(createCar, HttpStatus.CREATED);
    }

    @GetMapping("/getCarById/{carId}")
    public ResponseEntity<Optional<CarEntity>> getCarById(@PathVariable Integer carId) {
        Optional<CarEntity> getCar= carService.getCar(carId);
        return new ResponseEntity<>(getCar, HttpStatus.OK);
    }

    @PutMapping("/updateCar/{carId}")
    public ResponseEntity<CarEntity> getCar(@RequestBody CarEntity car, @PathVariable Integer carId) {
        CarEntity updateBranch = carService.updateCar(car, carId);
        return new ResponseEntity<>(updateBranch, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<Void> deletCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getCarByBranchId/{branchId}")
    public ResponseEntity<List<CarEntity>> getCarByBranchId(@PathVariable Integer branchId) {
        List<CarEntity> getCostumerByBranchId = carService.getCarsByBranchId(branchId);
        return new ResponseEntity<>(getCostumerByBranchId, HttpStatus.OK);
    }

}
