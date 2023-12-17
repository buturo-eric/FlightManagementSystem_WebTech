package com.flight.FlightManagementSystem.FlightManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String firstName;
    public String lastName;
    public int number;
    public int total;
    public String paymentMethod;

    public BookingModel() {
    }

    public BookingModel(int id, String firstName, String lastName, int number, int total, String paymentMethod) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
