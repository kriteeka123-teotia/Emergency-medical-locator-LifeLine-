package com.emergency.emergency_locator.controller;

import com.emergency.emergency_locator.model.Provider;
import com.emergency.emergency_locator.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")

public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/providers")

    public List<Provider> getAllProviders(){

        return adminService.getAllProviders();

    }

    @PutMapping("/verify/{providerId}")

    public Provider verifyProvider(@PathVariable Long providerId){

        return adminService.verifyProvider(providerId);

    }

}