package com.sda.carrental.repository;

import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Integer> {
}
