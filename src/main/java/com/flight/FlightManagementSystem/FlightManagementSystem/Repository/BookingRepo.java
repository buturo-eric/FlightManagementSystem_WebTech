package com.flight.FlightManagementSystem.FlightManagementSystem.Repository;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository <BookingModel, Integer> {
}
