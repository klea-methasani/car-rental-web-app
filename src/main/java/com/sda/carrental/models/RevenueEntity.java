package com.sda.carrental.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name="revenues")
@NoArgsConstructor
@AllArgsConstructor
@Data
@jakarta.persistence.Entity
public class RevenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="revenue_id")
    private Integer revenue_id;

    @Column(name="return_date")
    private Date return_date;

    @Column(name="revenue_amount")
    private Integer revenue_amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="branch_id", nullable = false)
    private BranchEntity branchEntity;
}
