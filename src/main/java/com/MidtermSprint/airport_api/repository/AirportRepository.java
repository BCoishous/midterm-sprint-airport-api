package com.MidtermSprint.airport_api.repository;

import com.MidtermSprint.airport_api.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}