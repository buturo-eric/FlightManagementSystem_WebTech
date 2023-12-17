package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.ClientBookingsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.FlightsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.ClientBookingsService;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CheckFlightsController {

    @Autowired
    private FlightsService flightsService;

    @Autowired
    private ClientBookingsService clientBookingsService;

    @GetMapping("/checkFlights")
    public String checkFlights(Model model) {
        model.addAttribute("flights", flightsService.getAll());
        return "checkFlights";
    }

    @GetMapping("/bookNow/{flightId}")
    public String bookNow(@PathVariable String flightId, Model model) {
        // Get the flight details
        FlightsModel flight = flightsService.listById(flightId);

        // Create a new booking
        ClientBookingsModel booking = new ClientBookingsModel(
                flight.getFlightId(),
                flight.getAirlineId().getId(),
                flight.getOrigin(),
                flight.getDestination(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getTicketPrice()
        );

        // Save the booking
        clientBookingsService.addClientBookingsModel(booking);

        // Redirect to the bookings page
        return "redirect:/clientBookings";
    }
}

