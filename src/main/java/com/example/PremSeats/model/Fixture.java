package com.example.PremSeats.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fixture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String home;
    private String away;
    private Double price;
    private String date;
    private int available;

    public Fixture() {

    }


    public Fixture(Long id, String home, String away, Double price, String date, int available) {
        this.id = id;
        this.home = home;
        this.away = away;
        this.price = price;
        this.date = date;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
