package com.MidtermSprint.airport_api;

import com.MidtermSprint.airport_api.model.*;
import com.MidtermSprint.airport_api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedData(
            CityRepository cityRepository,
            AirportRepository airportRepository,
            PassengerRepository passengerRepository,
            AircraftRepository aircraftRepository) {

        return args -> {
            if (cityRepository.count() > 0) return;

            // Cities
            City stJohns = cityRepository.save(new City("St. John's", "Newfoundland", 110000));
            City toronto = cityRepository.save(new City("Toronto", "Ontario", 2800000));
            City vancouver = cityRepository.save(new City("Vancouver", "British Columbia", 675000));
            City calgary = cityRepository.save(new City("Calgary", "Alberta", 1336000));

            // Airports
            Airport yyt = airportRepository.save(new Airport("St. John's International Airport", "YYT", stJohns));
            Airport yyz = airportRepository.save(new Airport("Toronto Pearson International Airport", "YYZ", toronto));
            Airport yvr = airportRepository.save(new Airport("Vancouver International Airport", "YVR", vancouver));
            Airport yyc = airportRepository.save(new Airport("Calgary International Airport", "YYC", calgary));

            // Passengers
            Passenger p1 = passengerRepository.save(new Passenger("Brandon", "Coish", "709-555-0101", stJohns));
            Passenger p2 = passengerRepository.save(new Passenger("Sarah", "Murphy", "416-555-0102", toronto));
            Passenger p3 = passengerRepository.save(new Passenger("James", "Walsh", "604-555-0103", vancouver));
            Passenger p4 = passengerRepository.save(new Passenger("Emily", "Chen", "403-555-0104", calgary));
            Passenger p5 = passengerRepository.save(new Passenger("Michael", "Power", "709-555-0105", stJohns));

            // Aircraft
            Aircraft ac1 = aircraftRepository.save(new Aircraft("Boeing 737", "Air Canada", 180));
            ac1.setPassengers(List.of(p1, p2));
            ac1.setAirports(List.of(yyt, yyz));
            aircraftRepository.save(ac1);

            Aircraft ac2 = aircraftRepository.save(new Aircraft("Airbus A320", "WestJet", 150));
            ac2.setPassengers(List.of(p3, p4));
            ac2.setAirports(List.of(yvr, yyc));
            aircraftRepository.save(ac2);

            Aircraft ac3 = aircraftRepository.save(new Aircraft("Bombardier Q400", "PAL Airlines", 70));
            ac3.setPassengers(List.of(p1, p5));
            ac3.setAirports(List.of(yyt, yyc));
            aircraftRepository.save(ac3);

            Aircraft ac4 = aircraftRepository.save(new Aircraft("Boeing 787", "Air Transat", 300));
            ac4.setPassengers(List.of(p2, p3, p4));
            ac4.setAirports(List.of(yyz, yvr));
            aircraftRepository.save(ac4);

            System.out.println("Database seeded successfully!");
        };
    }
}