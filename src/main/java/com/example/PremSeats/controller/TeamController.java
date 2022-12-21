package com.example.PremSeats.controller;

import com.example.PremSeats.model.Team;
import com.example.PremSeats.repo.TeamRepo;
import com.example.PremSeats.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    //Get all teams
    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeams(){
        List<Team> teams = teamService.findAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }


    //Find specific team by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long id){
        Team team = teamService.findTeamById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }


    //Add new team to the database
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Team> addTeam(@RequestBody Team team){
        Team newTeam = teamService.addTeam(team);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }


    //Update existing team
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Team> updateTeam(@RequestBody Team GivenInfoTeam, @PathVariable Long id) {
       Team updatedTeam = teamService.updateTeam(id,GivenInfoTeam);
       return new ResponseEntity<>(updatedTeam, HttpStatus.CREATED);
    }

    //Delete specific team
    @Transactional
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable("id") Long id){
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
