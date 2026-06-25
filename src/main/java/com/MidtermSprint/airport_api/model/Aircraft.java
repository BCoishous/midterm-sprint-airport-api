package com.MidtermSprint.airport_api.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String airlineName;
    private int numberOfPassengers;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "aircraft_passengers",
        joinColumns = @JoinColumn(name = "aircraft_id"),
        inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private List<Passenger> passengers;

    @ManyToMany
    @JoinTable(
        name = "aircraft_airports",
        joinColumns = @JoinColumn(name = "aircraft_id"),
        inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airports;

    public Aircraft() {}

    public Aircraft(String type, String airlineName, int numberOfPassengers) {
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Long getId() { return id; }
    public String getType() { return type; }
    public String getAirlineName() { return airlineName; }
    public int getNumberOfPassengers() { return numberOfPassengers; }
    public List<Passenger> getPassengers() { return passengers; }
    public List<Airport> getAirports() { return airports; }

    public void setId(Long id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }
}