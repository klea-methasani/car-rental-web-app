package com.sda.carrental.controller;


import com.sda.carrental.models.ReservationEntity;
import com.sda.carrental.service.serviceImpl.ReservationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
@AllArgsConstructor
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping("/createReservation")
    public ResponseEntity<ReservationEntity> createReservations(@RequestBody ReservationEntity reservation){
        ReservationEntity createReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(createReservation, HttpStatus.CREATED);
    }

    @GetMapping("/getReservation/{reservationId}")
    public ResponseEntity<Optional<ReservationEntity>> getReservationsById(@PathVariable Integer reservationId){
        Optional<ReservationEntity> getReservation= reservationService.getReservation(reservationId);
        return new ResponseEntity<>(getReservation,HttpStatus.OK);
    }

    @PutMapping("/updateReservation/{reservationId}")
    public ResponseEntity<ReservationEntity> updateReservations(@RequestBody ReservationEntity reservation, @PathVariable Integer reservationId){
        ReservationEntity updateReservation = reservationService.updateReservation(reservation,reservationId);
        return new ResponseEntity<>(updateReservation,HttpStatus.OK);
    }

    @DeleteMapping("/deleteReservation/{reservationId}")
    public ResponseEntity<ReservationEntity> deleteReservations(@PathVariable Integer reservationId){
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}