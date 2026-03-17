package com.emergency.emergency_locator.controller;

import com.emergency.emergency_locator.model.Provider;
import com.emergency.emergency_locator.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provider")
@CrossOrigin(origins = "*")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping("/register")
    public Provider registerProvider(@RequestBody Provider provider){
        return providerService.registerProvider(provider);
    }

    @GetMapping("/nearby")
    public List<Provider> getAvailableProviders(){
        return providerService.getAvailableProviders();
    }

    @GetMapping("/nearest")
    public List<Provider> getNearestProviders(
            @RequestParam double latitude,
            @RequestParam double longitude){

        return providerService.findNearestProviders(latitude, longitude);
    }

    @PutMapping("/availability/{providerId}")
    public Provider updateAvailability(
            @PathVariable Long providerId,
            @RequestParam String availability){

        return providerService.updateAvailability(providerId, availability);
    }

    @PutMapping("/rating/{providerId}")
    public Provider updateProviderRating(
            @PathVariable Long providerId,
            @RequestParam Double rating){

        return providerService.updateRating(providerId, rating);
    }

}