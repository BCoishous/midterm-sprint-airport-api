package com.MidtermSprint.airport_api.controller;

import com.MidtermSprint.airport_api.model.Airport;
import com.MidtermSprint.airport_api.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        return airportRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport updatedAirport) {
        return airportRepository.findById(id).map(airport -> {
            airport.setName(updatedAirport.getName());
            airport.setCode(updatedAirport.getCode());
            airport.setCity(updatedAirport.getCity());
            return ResponseEntity.ok(airportRepository.save(airport));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
    return airportRepository.findById(id).map(airport -> {
        airportRepository.delete(airport);
        return ResponseEntity.noContent().<Void>build();
    }).orElse(ResponseEntity.notFound().build());
}
}