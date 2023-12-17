package com.flight.FlightManagementSystem.FlightManagementSystem.Repository;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersViewRepo extends JpaRepository <UsersViewModel,Integer> {
}
