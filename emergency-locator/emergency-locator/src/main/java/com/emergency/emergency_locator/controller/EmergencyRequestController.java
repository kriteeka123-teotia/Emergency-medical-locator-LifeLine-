package com.emergency.emergency_locator.controller;

import com.emergency.emergency_locator.model.EmergencyRequest;
import com.emergency.emergency_locator.service.EmergencyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request")
@CrossOrigin(origins = "*")
public class EmergencyRequestController {

    @Autowired
    private EmergencyRequestService service;

    @PostMapping("/create")
    public EmergencyRequest createRequest(@RequestBody EmergencyRequest request){
        return service.createRequest(request);
    }

    @PostMapping("/accept/{id}")
    public EmergencyRequest acceptRequest(@PathVariable Long id){
        return service.acceptRequest(id);
    }

    @PostMapping("/complete/{id}")
    public EmergencyRequest completeRequest(@PathVariable Long id) {
        return service.completeRequest(id);
    }

    @GetMapping("/pending")
    public List<EmergencyRequest> getPendingRequests(){
        return service.getPendingRequests();
    }

    @GetMapping("/history/{userId}")
    public List<EmergencyRequest> getUserHistory(@PathVariable Long userId){
        return service.getUserRequests(userId);
    }

    @GetMapping("/provider/{providerId}")
    public List<EmergencyRequest> getProviderRequests(@PathVariable Long providerId){
        return service.getProviderRequests(providerId);
    }

}