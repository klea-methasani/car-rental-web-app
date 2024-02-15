package com.sda.carrental.repository;

import com.sda.carrental.models.CostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CostumerEntity, Integer> {
}
