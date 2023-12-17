package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.AirlineModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.AirlineService;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AirlineController {
    @Autowired
    AirlineService airlineService;
    @GetMapping("/airline")
    public String airline(Model model) {
        model.addAttribute("airlineModel", new AirlineModel());
        model.addAttribute("airlines", airlineService.getAll());
        return "airline";
    }

    @GetMapping("/editAirline/{id}")
    public String editAirline(@PathVariable Integer id, Model model) {
        AirlineModel airline = airlineService.listById(id);
        model.addAttribute("airlineModel", airline);
        model.addAttribute("airlines", airlineService.getAll());
        return "airline";
    }

    @GetMapping("/deleteAirline/{id}")
    public String deleteAirline(@PathVariable("id") Integer id, Model model){
        try{
        airlineService.deleteAirlineModel(id);
        return "redirect:/airline";
    } catch (DataIntegrityViolationException e) {
        // Log the exception if needed
        e.printStackTrace();

        // Add custom error message to the model
        model.addAttribute("errorMessage", "Can't delete flight due to existing relationships.");

        // Return the error view
        return "error"; // Create an "error.html" Thymeleaf template for displaying error messages
    }
    }
    @PostMapping("createAirline")
    public String createAirline(@ModelAttribute("airlineModel") AirlineModel airlineModel, Model model) {
        airlineService.addNewAirlineModel(airlineModel);
        model.addAttribute("airlines", airlineService.getAll());
        return "redirect:/airline";
    }

    @PostMapping("/updateAirline/{id}")
    public String updateAirline(@PathVariable Integer id, @ModelAttribute("airlineModel") AirlineModel airlineModel, Model model) {
        // Update the existing airline with the new data
        airlineService.updateAirlineModel(airlineModel, id);
        // Refresh the list of airlines
        model.addAttribute("airlines", airlineService.getAll());
        return "redirect:/airline";
    }
}
