package com.sda.carrental.controller;

import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.service.serviceImpl.BranchServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/branches")
@AllArgsConstructor
public class BranchController {

    @Autowired
    private BranchServiceImpl branchService;

    @PostMapping("/createBranches/{rental_id}")
    public ResponseEntity<BranchEntity> createBranches(@RequestBody BranchEntity branch,@PathVariable Long rental_id) {
        BranchEntity createBranch = branchService.createBranch(branch,rental_id);
        return new ResponseEntity<>(createBranch, HttpStatus.CREATED);
    }

    @GetMapping("/getBranchById/{branchId}")
    public ResponseEntity<Optional<BranchEntity>> getBranchesById(@PathVariable Integer branchId) {
        Optional<BranchEntity> getBranch = branchService.getBranch(branchId);
        return new ResponseEntity<>(getBranch, HttpStatus.OK);
    }

    @PutMapping("/updateBranches/{branchId}")
    public ResponseEntity<BranchEntity> updateBranches(@RequestBody BranchEntity branch, @PathVariable Integer branchId) {
        BranchEntity updateBranch = branchService.updateBranch(branch, branchId);
        return new ResponseEntity<>(updateBranch, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBranches/{id}")
    public ResponseEntity<Void> deleteBranches(@PathVariable Integer id) {
        branchService.deleteBranch(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getBranchByRentalId/{rentalId}")
    public ResponseEntity<List<BranchEntity>> getBranchByRentalId(@PathVariable Integer rentalId) {
        List<BranchEntity> getCostumerByBranchId = branchService.getBranchByRentalId(rentalId);
        return new ResponseEntity<>(getCostumerByBranchId, HttpStatus.OK);
    }

}