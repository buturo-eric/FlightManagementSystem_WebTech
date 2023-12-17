package com.flight.FlightManagementSystem.FlightManagementSystem.Service;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.AirlineModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Repository.AirlineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepo airlineRepo;

    public List<AirlineModel> getAll(){
        return airlineRepo.findAll();
    }
    public AirlineModel addNewAirlineModel(AirlineModel airlineModel){
        return airlineRepo.save(airlineModel);
    }

    public AirlineModel updateAirlineModel(AirlineModel airlineModel, Integer id){
        Optional<AirlineModel> listAirline = airlineRepo.findById(id);
        if(listAirline.isPresent()){
            AirlineModel present = listAirline.get();
            present.setName(airlineModel.getName());
            present.setContact(airlineModel.getContact());
            return airlineRepo.save(present);
        }else {
            throw new RuntimeException("Id Not Found");
        }
    }

    public void deleteAirlineModel(Integer id){
        Optional<AirlineModel> listAirline = airlineRepo.findById(id);
        if(listAirline.isPresent()){
            AirlineModel present = listAirline.get();
            airlineRepo.delete(present);
        }else {
            throw new RuntimeException("Id not Found");
        }
    }

    public AirlineModel listById(Integer id){
            return airlineRepo.findById(id).orElse(null);
    }
}