package com.MidtermSprint.airport_api.repository;

import com.MidtermSprint.airport_api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}