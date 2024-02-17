package com.sda.carrental.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Table(name="reservations")
@NoArgsConstructor
@AllArgsConstructor
@Data
@jakarta.persistence.Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="reservation_id")
    private Integer reservation_id;

    private Date booking_date;

    private Date start_date;

    private Date end_date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="costumer_id", nullable = false)
    private CustomerEntity costumerEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="car_id", nullable = false)
    private CarEntity carEntity;

    private Integer pickup_branch_id;  // mos harro FK per pickup & return

    private Integer return_branch_id; // mos harro lidhja e Branch me Reservation

}
