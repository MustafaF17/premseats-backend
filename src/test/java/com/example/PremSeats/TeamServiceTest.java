package com.example.PremSeats;

import com.example.PremSeats.model.Team;
import com.example.PremSeats.repo.TeamRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamServiceTest {


    @Autowired
    TeamRepo teamRepo;


    @Test
    public void testReadAll()
    {
        Team team1 = new Team(600L,"Arsenal","London","",500);
        Team team2 = new Team(601L,"Ajax","Amsterdam","",600);

        List<Team> list = teamRepo.findAll();
        assertNotNull(list);

        teamRepo.deleteTeamById(600L);
        teamRepo.deleteTeamById(601L);
    }

    @Test
    public void testSingleTeam()
    {
        Team team1 = new Team(600L,"Arsenal","London","",500);
        assertEquals("London", team1.getLocation());
        teamRepo.deleteTeamById(600L);
    }

    @Test
    public void testUpdateTeam()
    {
        //Create a team with id 600 and save to database
        Team team  = new Team(600L,"Arsenal","London","",500);

        //Set number of seats to 50
        team.setNrSeats(5);
        teamRepo.save(team);


        //Check if it is not the old value
        assertNotEquals(500, team.getNrSeats());
    }

    @Test
    public void testDeleteteam()
    {
        //Create a team with id 600 and save to database
        Team team  = new Team(600L,"Arsenal","London","",500);

        teamRepo.save(team);
        teamRepo.deleteTeamById(600L);

        //Check if it is not the old value
        assertNotEquals(java.util.Optional.of(600L), team.getId());
    }





}
