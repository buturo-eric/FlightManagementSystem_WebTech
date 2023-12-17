package com.flight.FlightManagementSystem.FlightManagementSystem.Repository;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<UsersModel, Integer> {
    public UsersModel findUsersModelByEmailAndPassword(String email, String password);
}
