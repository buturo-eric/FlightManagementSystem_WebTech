package com.flight.FlightManagementSystem.FlightManagementSystem.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="airline")
public class AirlineModel {
    @Id
    public int  id;
    public String name;
    public int contact;
    @OneToMany(mappedBy = "airlineId")
    public List<FlightsModel> flightId;
    @OneToMany(mappedBy = "airline")
    public List<UsersViewModel> userView;

    public AirlineModel() {
    }

    public AirlineModel(int id, String name, int contact, List<FlightsModel> flightId, List<UsersViewModel> userView) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.flightId = flightId;
        this.userView = userView;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public List<FlightsModel> getFlightId() {
        return flightId;
    }

    public void setFlightId(List<FlightsModel> flightId) {
        this.flightId = flightId;
    }

    public List<UsersViewModel> getUserView() {
        return userView;
    }

    public void setUserView(List<UsersViewModel> userView) {
        this.userView = userView;
    }
}
