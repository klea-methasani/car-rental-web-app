package com.sda.carrental.service;

import com.sda.carrental.models.RentalEntity;
import com.sda.carrental.models.ReservationEntity;

import java.util.List;
import java.util.Optional;

public interface ReservationServiceInterface {

    public ReservationEntity createReservation(ReservationEntity reservation, Long carId, Long userId);

    Optional<ReservationEntity> getReservation(Integer reservationId);

    ReservationEntity updateReservation(ReservationEntity reservation, Integer reservationId);

    void deleteReservation(Integer reservationId);
    List<ReservationEntity> getAllReservation();
}
