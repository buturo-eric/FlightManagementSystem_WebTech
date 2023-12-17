package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.ClientBookingsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.ClientBookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientBookingsController {
    @Autowired
    ClientBookingsService clientBookingsService;
    @GetMapping("/clientBookings")
    public String viewBookings(Model model) {
        List<ClientBookingsModel> clientBookings = clientBookingsService.getAll();
        model.addAttribute("clientBookings", clientBookings);
        return "clientBookings";
    }

    @GetMapping("/clientBookingsList")
    public List<ClientBookingsModel> getAll() {
        return clientBookingsService.getAll();
    }

    @DeleteMapping("/deleteClientBookings")
    public void deleteClientBookingsModel(@PathVariable String id) {
        clientBookingsService.deleteClientBookingsModel(id);
    }

}
