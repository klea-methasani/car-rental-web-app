package com.sda.carrental.models;
import com.sda.carrental.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name="car")
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="car_id")
    private Integer car_id;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="year")
    private Integer year;

    @Column(name="color")
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;

    @Column(name="rental_per_day")
    private Integer rental_per_day;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy = "carEntity")
    private List<ReservationEntity> reservationEntities;
}
