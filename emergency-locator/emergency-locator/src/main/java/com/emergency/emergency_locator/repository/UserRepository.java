package com.emergency.emergency_locator.repository;

import com.emergency.emergency_locator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}