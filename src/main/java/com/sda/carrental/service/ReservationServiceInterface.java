package com.sda.carrental.service;

import com.sda.carrental.models.ReservationEntity;

import java.util.Optional;

public interface ReservationServiceInterface {

    ReservationEntity createReservation(ReservationEntity reservation);

    Optional<ReservationEntity> getReservation(Integer reservationId);

    ReservationEntity updateReservation(ReservationEntity reservation, Integer reservationId);

    void deleteReservation(Integer reservationId);
}
