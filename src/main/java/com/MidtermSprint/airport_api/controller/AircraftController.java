package com.MidtermSprint.airport_api.controller;

import com.MidtermSprint.airport_api.model.Aircraft;
import com.MidtermSprint.airport_api.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        return aircraftRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft updatedAircraft) {
        return aircraftRepository.findById(id).map(aircraft -> {
            aircraft.setType(updatedAircraft.getType());
            aircraft.setAirlineName(updatedAircraft.getAirlineName());
            aircraft.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());
            aircraft.setPassengers(updatedAircraft.getPassengers());
            aircraft.setAirports(updatedAircraft.getAirports());
            return ResponseEntity.ok(aircraftRepository.save(aircraft));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        return aircraftRepository.findById(id).map(aircraft -> {
            aircraftRepository.delete(aircraft);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}