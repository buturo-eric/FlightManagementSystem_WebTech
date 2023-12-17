package com.flight.FlightManagementSystem.FlightManagementSystem.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class FlightsModel {
    @Id
    public String flightId;
    @JoinColumn(name = "airline_id")
    @ManyToOne
    public AirlineModel airlineId;
    public String origin;
    public String destination;
    public LocalDateTime departureTime;
    public LocalDateTime arrivalTime;
    public int availableSeats;
    public float ticketPrice;
    @OneToOne(mappedBy = "flightId")
    public UsersViewModel userView;

    public FlightsModel() {
    }

    public FlightsModel(String flightId, AirlineModel airlineId, String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, int availableSeats, float ticketPrice, UsersViewModel userView) {
        this.flightId = flightId;
        this.airlineId = airlineId;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
        this.userView = userView;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public AirlineModel getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(AirlineModel airlineId) {
        this.airlineId = airlineId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public UsersViewModel getUserView() {
        return userView;
    }

    public void setUserView(UsersViewModel userView) {
        this.userView = userView;
    }
}
