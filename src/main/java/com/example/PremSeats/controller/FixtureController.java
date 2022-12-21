package com.example.PremSeats.controller;


import com.example.PremSeats.model.Fixture;
import com.example.PremSeats.model.User;
import com.example.PremSeats.repo.FixtureRepo;
import com.example.PremSeats.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/fixture")
public class FixtureController {
    private final FixtureService fixtureService;

    @Autowired
    private FixtureRepo repository;

    public FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService;
    }

    //Get all fixtures
    @GetMapping("/all")
    public ResponseEntity<List<Fixture>> getAllFixtures() {
        List<Fixture> fixtures = fixtureService.findAllFixtures();
        return new ResponseEntity<>(fixtures, HttpStatus.OK);
    }

    //Add new fixture to the database
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Fixture> addFixture(@RequestBody Fixture fixture){
        Fixture newFixture = fixtureService.addFixture(fixture);
        return new ResponseEntity<>(newFixture, HttpStatus.CREATED);
    }

    //Delete specific fixture
    @Transactional
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFixture(@PathVariable("id") Long id){
        fixtureService.deleteFixture(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Lower available count
    @PutMapping("/loweravailable/{userId}")
    public ResponseEntity<User> LowerAvailability(@PathVariable Long userId) {
        Fixture fixture = repository.findById(userId).get();
        int currentavailability = fixture.getAvailable();
        int newavailability = currentavailability - 1;
        fixture.setAvailable(newavailability);
        repository.save(fixture);
        return new ResponseEntity(fixture, HttpStatus.OK);
    }




}
