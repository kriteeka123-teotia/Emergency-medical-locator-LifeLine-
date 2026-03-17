package com.emergency.emergency_locator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private Long providerId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "availability")
    private String availability;

    @Column(name = "verification_status")
    private String verificationStatus;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "phone")
    private String phone;

    private Double latitude;
    private Double longitude;

    public Provider() {}

    public String getVerificationStatus() {
        return verificationStatus;
    }

}