package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.AirlineModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.AirlineService;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.FlightsService;
import jakarta.servlet.http.HttpSession;
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
    public String airline(Model model, HttpSession session) {
        Integer id2 = (Integer) session.getAttribute("userModel2");
        if(id2!= null){
            model.addAttribute("airlineModel", new AirlineModel());
            model.addAttribute("airlines", airlineService.getAll());
            return "airline";
        }else {
            return "redirect:/login";
        }

    }

    @GetMapping("/editAirline/{id}")
    public String editAirline(@PathVariable Integer id, Model model, HttpSession session) {
        Integer id2 = (Integer) session.getAttribute("userModel2");
        if(id2!= null){
            AirlineModel airline = airlineService.listById(id);
            model.addAttribute("airlineModel", airline);
            model.addAttribute("airlines", airlineService.getAll());
            return "airline";
        }else {
            return "redirect:/login";
        }

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
    public String createAirline(@ModelAttribute("airlineModel") AirlineModel airlineModel, Model model, HttpSession session) {
        Integer id2 = (Integer) session.getAttribute("userModel2");
        if(id2!= null) {
            airlineService.addNewAirlineModel(airlineModel);
            model.addAttribute("airlines", airlineService.getAll());
            return "redirect:/airline";
        }else {
            return "redirect:/login";
        }
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
