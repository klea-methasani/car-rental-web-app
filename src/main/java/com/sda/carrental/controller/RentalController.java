package com.sda.carrental.controller;

import com.sda.carrental.models.RentalEntity;
import com.sda.carrental.service.serviceImpl.RentalServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalController {

    @Autowired
    private RentalServiceImpl rentalService;

    @PostMapping("/createRentals")
    public ResponseEntity<RentalEntity> createRentals(@RequestBody RentalEntity rental){
        RentalEntity createRental = rentalService.createRental(rental);
        return new ResponseEntity<>(createRental, HttpStatus.CREATED);
    }

    @GetMapping("/getRentalById/{id}")
    public ResponseEntity<Optional<RentalEntity>> getRentalsById(@PathVariable Integer rentalId){
        Optional<RentalEntity> getRental = rentalService.getRental(rentalId);
        return new ResponseEntity<>(getRental, HttpStatus.OK);
    }

    @PutMapping("/updateRentals/{id}")
    public ResponseEntity<RentalEntity> updateRentals(@RequestBody RentalEntity rental, @PathVariable Integer rentalId){
        RentalEntity updateRental = rentalService.updateRental(rental,rentalId);
        return new ResponseEntity<>(updateRental, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRentals/{id}")
    public ResponseEntity<Void> deleteRentals(Integer branchId){
        rentalService.deleteRental(branchId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
