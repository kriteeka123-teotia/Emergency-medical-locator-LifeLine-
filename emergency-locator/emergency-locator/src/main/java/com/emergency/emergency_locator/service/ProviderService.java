package com.emergency.emergency_locator.service;

import com.emergency.emergency_locator.model.Provider;
import com.emergency.emergency_locator.repository.ProviderRepository;
import com.emergency.emergency_locator.util.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public Provider registerProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public List<Provider> getAvailableProviders() {
        return providerRepository.findByAvailability("AVAILABLE");
    }

    public List<Provider> findNearestProviders(double userLat, double userLon) {

        List<Provider> providers = providerRepository.findByAvailability("AVAILABLE");

        providers.sort((p1, p2) -> {
            double d1 = DistanceCalculator.calculateDistance(
                    userLat, userLon, p1.getLatitude(), p1.getLongitude());

            double d2 = DistanceCalculator.calculateDistance(
                    userLat, userLon, p2.getLatitude(), p2.getLongitude());

            return Double.compare(d1, d2);
        });

        return providers;
    }

    public Provider updateRating(Long providerId, Double rating){

        Provider provider = providerRepository.findById(providerId).orElse(null);

        if(provider != null){
            provider.setRating(rating);
            return providerRepository.save(provider);
        }

        return null;
    }

    public Provider updateAvailability(Long providerId, String availability){

        Provider provider = providerRepository.findById(providerId).orElse(null);

        if(provider != null){
            provider.setAvailability(availability);
            return providerRepository.save(provider);
        }

        return null;
    }
}