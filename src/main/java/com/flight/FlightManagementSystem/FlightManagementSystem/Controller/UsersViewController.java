package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.AirlineModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.FlightsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersViewModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Repository.UsersViewRepo;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.AirlineService;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.FlightsService;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.UserViewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersViewController {
    @Autowired
    UserViewsService userViewsService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    FlightsService flightsService;

    @Autowired
    private UsersViewRepo usersViewRepo;

    @GetMapping("/passenger")
    public String passenger(Model model) {
        model.addAttribute("usersViewModel", new UsersViewModel());
        model.addAttribute("passengers", userViewsService.getAll());
        model.addAttribute("airlines", airlineService.getAll());
        model.addAttribute("flights", flightsService.getAll());
        return "userView";
    }



    @GetMapping("/editPassenger/{id}")
    public String editPassenger(@PathVariable String id, Model model) {
        Integer pId = Integer.parseInt(id);
        UsersViewModel passengers = userViewsService.listById(pId);
        model.addAttribute("flights", flightsService.getAll());
        model.addAttribute("airlines", airlineService.getAll());
        model.addAttribute("usersViewModel", passengers);
        model.addAttribute("passengers", userViewsService.getAll());
        return "editUserView";
    }



    @GetMapping("/deletePassenger/{id}")
    public String deletePassenger(@PathVariable("id") Integer id){
        userViewsService.deleteUsersViewModel(id);
        return "redirect:/passenger";
    }
    @PostMapping("/createPassenger")
    public String createPassenger(@ModelAttribute("usersViewModel") UsersViewModel usersViewModel,
                                  Model model,
                                  @RequestParam("flightId") String flightId, @RequestParam("airline") Integer id) {
        FlightsModel flight = flightsService.listById(flightId);
        AirlineModel airlineModel = airlineService.listById(id);
        usersViewModel.setFlightId(flight);
        usersViewModel.setAirline(airlineModel);
        userViewsService.addUsersViewModel(usersViewModel);
        model.addAttribute("passengers", userViewsService.getAll());
        return "userView";
    }

    @PostMapping("/updatePassenger")
    public String updatePassenger(@ModelAttribute("usersViewModel") UsersViewModel usersViewModel,
                                  Model model){
        userViewsService.addUsersViewModel(usersViewModel);
        model.addAttribute("usersViewModel", userViewsService.getAll());
        return "userView";
    }

    @PostMapping("/updatePassenger/{id}")
    public String updatePassenger(@PathVariable Integer id, @ModelAttribute("usersViewModel") UsersViewModel usersViewModel, Model model) {
        userViewsService.updateUsersViewModel(usersViewModel, id);
        model.addAttribute("passengers", userViewsService.getAll());
        return "redirect:/userView";
    }

}
