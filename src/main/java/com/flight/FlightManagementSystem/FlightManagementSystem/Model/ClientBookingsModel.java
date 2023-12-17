package com.flight.FlightManagementSystem.FlightManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
    @Entity
    @Table(name = "clientBookings")
    public class ClientBookingsModel {
        @Id
        public String flightId;
        public int airlineId;
        public String origin;
        public String destination;
        public LocalDateTime departureTime;
        public LocalDateTime arrivalTime;
        public float ticketPrice;

        public ClientBookingsModel() {
        }

        public ClientBookingsModel(String flightId, int airlineId, String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, float ticketPrice) {
            this.flightId = flightId;
            this.airlineId = airlineId;
            this.origin = origin;
            this.destination = destination;
            this.departureTime = departureTime;
            this.arrivalTime = arrivalTime;
            this.ticketPrice = ticketPrice;
        }

        public String getFlightId() {
            return flightId;
        }

        public void setFlightId(String flightId) {
            this.flightId = flightId;
        }

        public int getAirlineId() {
            return airlineId;
        }

        public void setAirlineId(int airlineId) {
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

        public float getTicketPrice() {
            return ticketPrice;
        }

        public void setTicketPrice(float ticketPrice) {
            this.ticketPrice = ticketPrice;
        }
    }