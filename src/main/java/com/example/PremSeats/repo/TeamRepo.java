package com.example.PremSeats.repo;

import com.example.PremSeats.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {


    void deleteTeamById(Long id);

    Optional<Team> findTeamById(Long id);
}
