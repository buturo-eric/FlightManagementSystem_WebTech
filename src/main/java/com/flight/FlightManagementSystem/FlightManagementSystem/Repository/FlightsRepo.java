package com.flight.FlightManagementSystem.FlightManagementSystem.Repository;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.FlightsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FlightsRepo extends JpaRepository<FlightsModel, String> {
    FlightsModel findFlightByFlightId(String flightId);

    FlightsModel findFlightByOriginAndDestination(String origin, String destination);
}

