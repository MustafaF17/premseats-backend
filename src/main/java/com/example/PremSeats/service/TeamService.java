package com.example.PremSeats.service;

import com.example.PremSeats.exception.UserNotFoundException;
import com.example.PremSeats.model.Team;
import com.example.PremSeats.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
public class TeamService {
    private final TeamRepo teamRepo;

    @Autowired
    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }


    public Team addTeam(Team team){
        return teamRepo.save(team);
    }

    public List<Team> findAllTeams(){
        return teamRepo.findAll();
    }

    public Team updateTeam(Long id, Team team){

        if (teamRepo.findById(id).isPresent())
        {
            Team existingTeam = teamRepo.findTeamById(id).get();
            existingTeam.setName(team.getName());
            existingTeam.setNrSeats(team.getNrSeats());
            existingTeam.setImageUrl(team.getImageUrl());
            existingTeam.setLocation(team.getLocation());

            Team updatedTeam = teamRepo.save(existingTeam);

            return updatedTeam;
        }

        else return null;
    }

    public Team findTeamById(Long id) {
       return teamRepo.findTeamById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found"));
    }

    public void deleteTeam(Long id){
        teamRepo.deleteTeamById(id);
    }



}
