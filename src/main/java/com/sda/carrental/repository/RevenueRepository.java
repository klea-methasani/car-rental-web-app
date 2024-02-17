package com.sda.carrental.repository;

import com.sda.carrental.models.RevenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<RevenueEntity, Integer> {
}
