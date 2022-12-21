package com.example.PremSeats.repo;

import com.example.PremSeats.model.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FixtureRepo extends JpaRepository<Fixture, Long> {

}
