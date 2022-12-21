package com.example.PremSeats;
import static org.junit.jupiter.api.Assertions.*;
import com.example.PremSeats.model.Team;
import org.junit.jupiter.api.Test;

public class TeamTest {
    @Test
    void TestGetSetId() {
        Team team = new Team();
        team.setId(1L);
        assertEquals(1, team.getId());
    }

    @Test
    void TestSetId() {
        Team team = new Team();
        team.setName("Arsenal");
        assertEquals("Arsenal", team.getName());
    }

    @Test
    void TestSetLocation() {
        Team team = new Team();
        team.setLocation("London");
        assertEquals("London", team.getLocation());
    }

    @Test
    void TestSetNumberOfSeats() {
        Team team = new Team();
        team.setNrSeats(6);
        assertEquals(6, team.getNrSeats());
    }

    @Test
    void TestSetImageUrl() {
        Team team = new Team();
        team.setImageUrl("Image");
        assertEquals("Image", team.getImageUrl());
    }








}
