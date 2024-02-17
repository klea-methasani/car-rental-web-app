package com.sda.carrental.service;

import com.sda.carrental.models.BranchEntity;
import java.util.Optional;

public interface BranchServiceInterface {

    BranchEntity createBranch(BranchEntity branch);

    Optional<BranchEntity> getBranch(Integer branchId);

    BranchEntity updateBranch(BranchEntity branch, Integer branchId);

    void deleteBranch(Integer branchId);
}
