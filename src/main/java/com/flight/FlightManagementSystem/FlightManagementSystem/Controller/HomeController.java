package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.AirlineModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
