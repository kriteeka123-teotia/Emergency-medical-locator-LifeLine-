package com.emergency.emergency_locator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "emergency_requests")
public class EmergencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private Long userId;

    private Long providerId;

    private String emergencyType;

    private String status;

    private Double latitude;

    private Double longitude;

    private LocalDateTime requestTime;

    public EmergencyRequest() {}

}