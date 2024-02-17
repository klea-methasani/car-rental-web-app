package com.sda.carrental.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Table(name="rental")
@NoArgsConstructor
@AllArgsConstructor
@Data
@jakarta.persistence.Entity  // librari e cila ben lidhjen me SQL

public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="rental_id")  //eshte kompania qe do te kete deget e ndryshme
    private Integer rental_id;
    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="owner")
    private String owner;

    //po behet lidhja one to many(nje rental company ka disa branche)
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy = "rentalEntity")
    private List<BranchEntity> branchEntities;



}
