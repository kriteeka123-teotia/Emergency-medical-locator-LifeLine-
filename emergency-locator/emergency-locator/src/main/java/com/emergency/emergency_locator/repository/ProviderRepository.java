package com.emergency.emergency_locator.repository;

import com.emergency.emergency_locator.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    List<Provider> findByAvailability(String availability);
    List<Provider> findByVerificationStatus(String status);

}