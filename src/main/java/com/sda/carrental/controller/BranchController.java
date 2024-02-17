package com.sda.carrental.controller;

import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.service.serviceImpl.BranchServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/branches")
@AllArgsConstructor
public class BranchController {

    @Autowired
    private BranchServiceImpl branchService;

    @PostMapping("/createBranches")
    public ResponseEntity<BranchEntity> createBranches(@RequestBody BranchEntity branch){
        BranchEntity createBranch = branchService.createBranch(branch);
        return new ResponseEntity<>(createBranch, HttpStatus.CREATED);
    }

    @GetMapping("/getBranchById/{id}")
    public ResponseEntity<Optional<BranchEntity>> getBranchesById(@PathVariable Integer branchId){
        Optional<BranchEntity> getBranch = branchService.getBranch(branchId);
        return new ResponseEntity<>(getBranch, HttpStatus.OK);
    }

    @PutMapping("/updateBranches/{id}")
    public ResponseEntity<BranchEntity> updateBranches(@RequestBody BranchEntity branch, @PathVariable Integer branchId){
        BranchEntity updateBranch = branchService.updateBranch(branch,branchId);
        return new ResponseEntity<>(updateBranch, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBranches/{id}")
    public ResponseEntity<Void> deleteBranches(@PathVariable Integer branchId){
        branchService.deleteBranch(branchId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}