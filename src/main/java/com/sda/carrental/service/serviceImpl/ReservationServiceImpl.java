package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.ReservationNotFoundException;
import com.sda.carrental.models.ReservationEntity;
import com.sda.carrental.repository.ReservationRepository;
import com.sda.carrental.service.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationServiceInterface {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public ReservationEntity createReservation(ReservationEntity reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Optional<ReservationEntity> getReservation(Integer reservationId) {
        return Optional.ofNullable(reservationRepository.findById(reservationId)
                .orElseThrow(()->new ReservationNotFoundException("Reservation not found with this id:" + reservationId)));
    }

    @Override
    public ReservationEntity updateReservation(ReservationEntity reservation, Integer reservationId) {
        if (!reservationRepository.existsById(reservationId)){
            throw new ReservationNotFoundException("You can not update  this reservation because it does not exist");
        }
        Optional<ReservationEntity> reservationEntity = reservationRepository.findById(reservationId);
        reservationEntity.get().setStart_date(reservation.getStart_date());
        reservationEntity.get().setBooking_date(reservation.getBooking_date());
        reservationEntity.get().setEnd_date(reservation.getEnd_date());
        return reservationRepository.save(reservationEntity.get());
    }

    @Override
    public void deleteReservation(Integer reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
