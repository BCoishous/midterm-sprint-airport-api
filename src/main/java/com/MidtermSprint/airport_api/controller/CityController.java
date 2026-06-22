package com.MidtermSprint.airport_api.controller;

import com.MidtermSprint.airport_api.model.City;
import com.MidtermSprint.airport_api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        return cityRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityRepository.save(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City updatedCity) {
        return cityRepository.findById(id).map(city -> {
            city.setName(updatedCity.getName());
            city.setState(updatedCity.getState());
            city.setPopulation(updatedCity.getPopulation());
            return ResponseEntity.ok(cityRepository.save(city));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
    return cityRepository.findById(id).map(city -> {
        cityRepository.delete(city);
        return ResponseEntity.noContent().<Void>build();
    }).orElse(ResponseEntity.notFound().build());
}
}