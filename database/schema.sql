CREATE DATABASE emergency_locator;
USE emergency_locator;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    password VARCHAR(255),
    role VARCHAR(20),
    latitude DOUBLE,
    longitude DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE providers (
    provider_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    resource_type VARCHAR(50),
    availability VARCHAR(20),
    verification_status VARCHAR(20),
    rating DOUBLE DEFAULT 0,
    
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE emergency_requests (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    resource_type VARCHAR(50),
    priority VARCHAR(20),
    status VARCHAR(20),
    latitude DOUBLE,
    longitude DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    accepted_provider INT,
    
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE request_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    request_id INT,
    provider_id INT,
    response_time INT,
    status VARCHAR(20)
);
ALTER TABLE providers
ADD COLUMN phone VARCHAR(15);
ALTER TABLE emergency_requests
ADD provider_id INT;
