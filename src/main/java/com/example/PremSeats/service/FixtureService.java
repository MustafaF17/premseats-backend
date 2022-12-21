package com.example.PremSeats.service;

import com.example.PremSeats.model.Fixture;
import com.example.PremSeats.model.Team;
import com.example.PremSeats.repo.FixtureRepo;
import com.example.PremSeats.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixtureService {
    private final FixtureRepo fixtureRepo;


    @Autowired
    public FixtureService(FixtureRepo fixtureRepo) {
        this.fixtureRepo = fixtureRepo;
    }

    public Fixture addFixture(Fixture fixture){
        return fixtureRepo.save(fixture);
    }

    public List<Fixture> findAllFixtures(){
        return fixtureRepo.findAll();
    }

    public void deleteFixture(Long id){
        fixtureRepo.deleteById(id);
    }




}
