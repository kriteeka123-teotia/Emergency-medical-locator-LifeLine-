package com.emergency.emergency_locator.repository;

import com.emergency.emergency_locator.model.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmergencyRequestRepository extends JpaRepository<EmergencyRequest, Long> {
    List<EmergencyRequest> findByStatus(String status);
    List<EmergencyRequest> findByUserId(Long userId);
    List<EmergencyRequest> findByStatusAndProviderId(String status, Long providerId);
}