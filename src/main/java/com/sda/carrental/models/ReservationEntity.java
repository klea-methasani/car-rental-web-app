package com.sda.carrental.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer amount;

    private String reservedBy;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="costumer_id")
    private CustomerEntity customerEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="car_id", nullable = true)
    @JsonIgnore
    private CarEntity carEntity;

    private Integer pickup_branch_id;  // mos harro FK per pickup & return

    private Integer return_branch_id; // mos harro lidhja e Branch me Reservation

}
