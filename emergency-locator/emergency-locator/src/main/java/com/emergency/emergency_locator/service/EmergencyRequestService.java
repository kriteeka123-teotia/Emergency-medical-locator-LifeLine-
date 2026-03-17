package com.emergency.emergency_locator.service;

import com.emergency.emergency_locator.model.EmergencyRequest;
import com.emergency.emergency_locator.repository.EmergencyRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmergencyRequestService {

    @Autowired
    private EmergencyRequestRepository repository;

    public EmergencyRequest createRequest(EmergencyRequest request) {

        request.setStatus("PENDING");
        request.setRequestTime(LocalDateTime.now());

        return repository.save(request);
    }

    public EmergencyRequest acceptRequest(Long requestId){

        EmergencyRequest request = repository.findById(requestId).orElse(null);

        if(request != null){
            request.setStatus("ACCEPTED");
            return repository.save(request);
        }

        return null;
    }

    public EmergencyRequest completeRequest(Long requestId) {

        EmergencyRequest request = repository.findById(requestId).orElse(null);

        if (request != null) {
            request.setStatus("COMPLETED");
            return repository.save(request);
        }

        return null;
    }

    public List<EmergencyRequest> getPendingRequests() {
        return repository.findByStatus("PENDING");
    }

    public List<EmergencyRequest> getUserRequests(Long userId){
        return repository.findByUserId(userId);
    }

    public List<EmergencyRequest> getProviderRequests(Long providerId){
        return repository.findByStatusAndProviderId("ACCEPTED", providerId);
    }

}