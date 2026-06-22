package com.MidtermSprint.airport_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;
    private int population;

    public City() {}

    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getState() { return state; }
    public int getPopulation() { return population; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setState(String state) { this.state = state; }
    public void setPopulation(int population) { this.population = population; }
}