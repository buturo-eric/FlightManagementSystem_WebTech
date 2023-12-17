package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.AirlineModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.FlightsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Repository.AirlineRepo;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.AirlineService;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.FlightsService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlightsController {
    @Autowired
    FlightsService flightsService;

    @Autowired
    AirlineService airlineService;
    @Autowired
    AirlineRepo airlineRepo;

    @GetMapping("/flights")
    public String flights(@RequestParam(name = "page", defaultValue = "0") int currentPage,
                          @RequestParam(name = "size", defaultValue = "2") int size, Model model){
        model.addAttribute("flightsModel", new FlightsModel());
       // model.addAttribute("flights", flightsService.getAll());
        model.addAttribute("airlines", airlineService.getAll());
        Page<FlightsModel> flightsPage = flightsService.getAllPageable(currentPage, size);
        model.addAttribute("allFlights",flightsPage.getContent());
        model.addAttribute("currentPageFlights", currentPage);
        model.addAttribute("totalPageFlights",flightsPage.getTotalPages());
        model.addAttribute("totalItemFlights",flightsPage.getTotalElements());

        return "flights";
    }

    @GetMapping("/editFlight/{id}")
    public String editFlight(@PathVariable String id, Model model) {
        FlightsModel flights = flightsService.listById(id);
        model.addAttribute("flightsModel", flights);
        model.addAttribute("airlines", airlineService.getAll());
        return "editFlight";
    }

    @GetMapping("/deleteFlight/{id}")
    public String deleteFlight(@PathVariable("id") String id){
        flightsService.deleteFlightsModel(id);
        return "redirect:/flights";
    }

    @PostMapping("/createFlight")
    public String createFlight(@ModelAttribute("flightsModel") FlightsModel flightsModel,
                               Model model,
                               @RequestParam("airlineId") Integer airlineId) {
        AirlineModel airline = airlineService.listById(airlineId);
        flightsModel.setAirlineId(airline);
        flightsService.addFlightsModel(flightsModel);
        model.addAttribute("flights", flightsService.getAll());
        return "redirect:/flights";
    }


    @PostMapping("/updateFlight/{id}")
    public String updateFlight(@PathVariable String id, @ModelAttribute("flightsModel") FlightsModel flightsModel, Model model) {
        flightsService.updateFlightsModel(flightsModel, id);
        model.addAttribute("flights", flightsService.getAll());
        return "redirect:/flights";
    }

    @GetMapping("/search")
    public String searchFlights(@RequestParam(name = "searchType", defaultValue = "flightId") String searchType,
                                @RequestParam(name = "flightId", required = false) String flightId,
                                @RequestParam(name = "origin", required = false) String origin,
                                @RequestParam(name = "destination", required = false) String destination,
                                Model model) {
        if ("flightId".equals(searchType) && flightId != null) {
            FlightsModel flight = flightsService.findFlightById(flightId);
            if (flight != null) {
                model.addAttribute("flightFound", true);
                model.addAttribute("flight", flight);
            } else {
                model.addAttribute("flightFound", false);
            }
        } else if ("originDest".equals(searchType) && origin != null && destination != null) {
            FlightsModel flight = flightsService.findFlightByOriginAndDestination(origin, destination);
            if (flight != null) {
                model.addAttribute("flightFound", true);
                model.addAttribute("flight", flight);
            } else {
                model.addAttribute("flightFound", false);
            }
        }

        return "search";
    }


}
