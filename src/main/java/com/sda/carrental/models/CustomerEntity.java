package com.sda.carrental.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name="customer")
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="customer_id")  //
    private Integer costumer_id;
    @Column(name="first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy = "customerEntity")
    private List<ReservationEntity> reservationEntities;

}
