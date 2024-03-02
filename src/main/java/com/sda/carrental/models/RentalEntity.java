package com.sda.carrental.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "rentals")
@NoArgsConstructor
@AllArgsConstructor
@Data
@jakarta.persistence.Entity
public class RentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name = "rental_id")
    private Integer rental_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @Email(message = "This email is not valid")
    private String email;

    @Column(name = "owner")
    private String owner;

    //po behet lidhja one to many(nje rental company ka disa branche)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rentalEntity")
    private List<BranchEntity> branchEntities;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rentalEntity")
    private List<CustomerEntity> customerEntities;

}
