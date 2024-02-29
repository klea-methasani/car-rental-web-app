package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.BranchNotFoundException;
import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.RentalEntity;
import com.sda.carrental.repository.BranchRepository;
import com.sda.carrental.repository.RentalRepository;
import com.sda.carrental.service.BranchServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchServiceInterface {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    RentalRepository rentalRepository;


    @Override
    public BranchEntity createBranch(BranchEntity branch) {
        branch.setCustomerEntities(branch.getCustomerEntities());
        branch.setRentalEntity(branch.getRentalEntity());
        return branchRepository.save(branch);
    }

    @Override
    public Optional<BranchEntity> getBranch(Integer branchId) {
        return Optional.ofNullable(branchRepository.findById(branchId)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found with this: " + branchId)));
    }

    @Override
    public BranchEntity updateBranch(BranchEntity branch, Integer branchId) {
        if (!branchRepository.existsById(branchId)) {
            throw new BranchNotFoundException("You can not update  this branch because it does not exist");
        }
        Optional<BranchEntity> branchEntity = branchRepository.findById(branchId);
        branchEntity.get().setCity(branch.getCity());
        branchEntity.get().setAddress(branch.getAddress());
        return branchRepository.save(branchEntity.get());
    }

    @Override
    public void deleteBranch(Integer branchId) {
        branchRepository.deleteById(branchId);
    }

    @Override
    public List<BranchEntity> getBranchByRentalId(Integer rentalId) {
        return rentalRepository.findById(rentalId).map(RentalEntity::getBranchEntities)
                .orElseThrow(() -> new EntityNotFoundException("Branch not found"));
    }

}
