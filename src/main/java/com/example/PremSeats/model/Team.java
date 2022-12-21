package com.example.PremSeats.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String location;
    private String imageUrl;
    private int nrSeats;

    public Team() {
    }

    public Team(Long id, String name, String location, String imageUrl, int nrSeats) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.imageUrl = imageUrl;
        this.nrSeats = nrSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getNrSeats() {
        return nrSeats;
    }

    public void setNrSeats(int nrSeats) {
        this.nrSeats = nrSeats;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


