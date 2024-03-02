package com.sda.carrental.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Table(name="branches")
@NoArgsConstructor
@AllArgsConstructor
@Data
@jakarta.persistence.Entity
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="branch_id")
    private Integer branch_id;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="rental_id")

    private RentalEntity rentalEntity;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy = "branchEntity")
    private RevenueEntity revenueEntities;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy = "branchEntity")
    private List<CarEntity> carEntities;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy = "branchEntity")
    private List<CustomerEntity> customerEntities;
}
