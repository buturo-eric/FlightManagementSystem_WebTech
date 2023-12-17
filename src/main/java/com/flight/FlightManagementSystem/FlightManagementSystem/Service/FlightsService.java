package com.flight.FlightManagementSystem.FlightManagementSystem.Service;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.FlightsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Repository.FlightsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightsService {
    @Autowired
    private FlightsRepo flightsRepo;

    public List<FlightsModel> getAll(){
        return flightsRepo.findAll();
    }

    public FlightsModel addFlightsModel(FlightsModel flightsModel){
        return flightsRepo.save(flightsModel);
    }

    public FlightsModel updateFlightsModel(FlightsModel flightsModel, String id){
        Optional<FlightsModel> listFlightsModel = flightsRepo.findById(id);
        if(listFlightsModel.isPresent()){
            FlightsModel present = listFlightsModel.get();
            present.setOrigin(flightsModel.getOrigin());
            present.setDestination(flightsModel.getDestination());
            present.setDepartureTime(flightsModel.getDepartureTime());
            present.setArrivalTime(flightsModel.getArrivalTime());
            present.setAvailableSeats(flightsModel.getAvailableSeats());
            present.setTicketPrice(flightsModel.getTicketPrice());
            return flightsRepo.save(present);
        }else {
            throw new RuntimeException("Id not Found");
        }
    }

    public void deleteFlightsModel(String id){
        Optional<FlightsModel> listFlightsModel = flightsRepo.findById(id);
        if(listFlightsModel.isPresent()){
            FlightsModel present = listFlightsModel.get();
            flightsRepo.delete(present);
        }else{
            throw new RuntimeException("Id not found");
        }
    }

    public FlightsModel listById(String id){
        return flightsRepo.findById(id).orElse(null);
    }

    public Page<FlightsModel> getAllPageable(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return flightsRepo.findAll(pageable);
    }

    public FlightsModel findFlightById(String flightId){
        return flightsRepo.findFlightByFlightId(flightId);
    }


    public FlightsModel findFlightByOriginAndDestination(String origin, String destination) {
        return flightsRepo.findFlightByOriginAndDestination(origin, destination);
    }


}
