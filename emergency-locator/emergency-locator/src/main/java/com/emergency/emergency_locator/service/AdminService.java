package com.emergency.emergency_locator.service;

import com.emergency.emergency_locator.model.Provider;
import com.emergency.emergency_locator.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    ProviderRepository providerRepository;

    public List<Provider> getAllProviders(){

        return providerRepository.findAll();

    }

    public Provider verifyProvider(Long providerId){

        Provider p = providerRepository.findById(providerId).orElse(null);

        if(p!=null){

            p.setVerificationStatus("VERIFIED");

            return providerRepository.save(p);

        }

        return null;

    }

}