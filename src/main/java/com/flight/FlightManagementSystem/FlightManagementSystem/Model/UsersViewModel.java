package com.flight.FlightManagementSystem.FlightManagementSystem.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "userView")
public class UsersViewModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @OneToOne
    @JoinColumn(name = "flight_Id")
    public FlightsModel flightId;
    public String firstName;
    public String lastName;
    @JoinColumn(name = "airlineId")
    @ManyToOne
    public AirlineModel airline;
    public String origin;
    public String destination;
    public String seatType;
    public int seatNumber;
    public LocalDateTime bookingDate;

    public UsersViewModel() {
    }

    public UsersViewModel(int id, FlightsModel flightId, String firstName, String lastName, AirlineModel airline, String origin, String destination, String seatType, int seatNumber, LocalDateTime bookingDate) {
        this.id = id;
        this.flightId = flightId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FlightsModel getFlightId() {
        return flightId;
    }

    public void setFlightId(FlightsModel flightId) {
        this.flightId = flightId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AirlineModel getAirline() {
        return airline;
    }

    public void setAirline(AirlineModel airline) {
        this.airline = airline;
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

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }
}
