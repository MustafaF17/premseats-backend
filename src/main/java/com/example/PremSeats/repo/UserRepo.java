package com.example.PremSeats.repo;

import com.example.PremSeats.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long > {

    Optional<User> findByUserName(String username);
}
