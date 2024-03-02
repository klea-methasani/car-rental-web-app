package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.ReservationNotFoundException;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.models.CustomerEntity;
import com.sda.carrental.models.ReservationEntity;
import com.sda.carrental.models.enums.CarStatus;
import com.sda.carrental.repository.CarRepository;
import com.sda.carrental.repository.CustomerRepository;
import com.sda.carrental.repository.ReservationRepository;
import com.sda.carrental.service.CarServiceInterface;
import com.sda.carrental.service.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationServiceInterface {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CarServiceImpl carService;

    @Override
    public ReservationEntity createReservation(ReservationEntity reservation,Long carId,Long userId) {
        Optional<CarEntity> carEntityOptional = carRepository.findById(Math.toIntExact(carId));
        if (carEntityOptional.isEmpty()) {
            throw new RuntimeException("Car with provided ID does not exist");
        }

        Optional<CustomerEntity> userEntity = customerRepository.findById(Math.toIntExact(userId));
        if (userEntity.isEmpty()) {
            throw new RuntimeException("User with provided ID does not exist");
        }

        CarEntity carEntity = carEntityOptional.get();
        if (carEntity.getStatus().equals(CarStatus.AVAILABLE)) {
            carEntity.setStatus(CarStatus.BOOKED); // Update the status of the car
            reservation.setReservedBy(userEntity.get().getFirstName());
            reservation.setCarEntity(carEntity);

            reservation.setBooking_date(new Date()); // Assuming this sets the current date as booking date
            Integer daysOfBooking = (int)((reservation.getEnd_date().getTime() - reservation.getStart_date().getTime()) / (1000 * 60 * 60 * 24));
            Integer overallPrice = carEntity.getRental_per_day() * daysOfBooking;
            reservation.setAmount(overallPrice);

            carRepository.save(carEntity);
            return reservationRepository.save(reservation);
        } else {
            throw new RuntimeException("This car is unavailable");
        }
    }

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

    @Override
    public List<ReservationEntity> getAllReservation() {return reservationRepository.findAll();    }
}
