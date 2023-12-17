package com.flight.FlightManagementSystem.FlightManagementSystem.Service;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.BookingModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.ClientBookingsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.FlightsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Repository.ClientBookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientBookingsService {
    @Autowired
    private ClientBookingsRepo clientBookingsRepo;

    @Autowired
    private FlightsService flightsService;


    public List<ClientBookingsModel> getAll(){
        return clientBookingsRepo.findAll();
    }

    public void deleteClientBookingsModel (String id){
        Optional<ClientBookingsModel> listClientBookingsModel = clientBookingsRepo.findById(id);
        if(listClientBookingsModel.isPresent()){
            ClientBookingsModel present = listClientBookingsModel.get();
            clientBookingsRepo.delete(present);
        }else{
            throw new RuntimeException("Id not Found");
        }
    }

    public ClientBookingsModel addClientBookingsModel(ClientBookingsModel clientBookingsModel){
        return clientBookingsRepo.save(clientBookingsModel);
    }

    public void saveClientBooking(String flightId) {
        // Fetch flight details based on the flightId
        FlightsModel flight = flightsService.findFlightById(flightId);

        if (flight != null) {
            // Create a new ClientBookingsModel and set properties using flight details
            ClientBookingsModel clientBooking = new ClientBookingsModel();
            clientBooking.setFlightId(flight.getFlightId());
            clientBooking.setAirlineId(flight.getAirlineId().getId()); // Assuming AirlineModel has an 'id' property
            clientBooking.setOrigin(flight.getOrigin());
            clientBooking.setDestination(flight.getDestination());
            clientBooking.setDepartureTime(flight.getDepartureTime());
            clientBooking.setArrivalTime(flight.getArrivalTime());
            clientBooking.setTicketPrice(flight.getTicketPrice());

            // Save the client booking
            clientBookingsRepo.save(clientBooking);
        } else {
            throw new RuntimeException("Flight not found with id: " + flightId);
        }
    }
}
