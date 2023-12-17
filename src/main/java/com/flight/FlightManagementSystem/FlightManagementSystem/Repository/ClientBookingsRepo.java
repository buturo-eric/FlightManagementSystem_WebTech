package com.flight.FlightManagementSystem.FlightManagementSystem.Repository;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.ClientBookingsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientBookingsRepo extends JpaRepository <ClientBookingsModel, String> {
}
