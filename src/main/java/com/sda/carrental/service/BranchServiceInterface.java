package com.sda.carrental.service;

import com.sda.carrental.models.BranchEntity;

import java.util.List;
import java.util.Optional;

public interface BranchServiceInterface {

    public BranchEntity createBranch(BranchEntity branch, Long rentalId);
    Optional<BranchEntity> getBranch(Integer branchId);

    BranchEntity updateBranch(BranchEntity branch, Integer branchId);

    void deleteBranch(Integer branchId);

    public List<BranchEntity> getBranchByRentalId(Integer rentalId);
}
