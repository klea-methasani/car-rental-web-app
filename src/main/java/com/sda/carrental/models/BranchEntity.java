package com.sda.carrental.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name="branch")
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity

public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="branch_id")  //
    private Integer branch_id;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rental_id", nullable = false)
    private RentalEntity rentalEntity; // e deklarojme si obj

}
