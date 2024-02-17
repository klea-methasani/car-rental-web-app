package com.sda.carrental.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Table(name="costumers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@jakarta.persistence.Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="costumer_id")
    private Integer costumer_id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy = "costumerEntity")
    private List<ReservationEntity> reservationEntities;

}
