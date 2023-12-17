package com.flight.FlightManagementSystem.FlightManagementSystem.Service;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.FlightsModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersViewModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Repository.UsersViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserViewsService {
    @Autowired
    private UsersViewRepo usersViewRepo;

    public List<UsersViewModel> getAll(){
        return usersViewRepo.findAll();
    }

    public UsersViewModel addUsersViewModel(UsersViewModel usersViewModel){
        return usersViewRepo.save(usersViewModel);
    }

    public UsersViewModel updateUsersViewModel(UsersViewModel usersViewModel, Integer id){
        Optional<UsersViewModel> listUsersViewModel = usersViewRepo.findById(id);
        if(listUsersViewModel.isPresent()){
            UsersViewModel present = listUsersViewModel.get();
            present.setFirstName(usersViewModel.getFirstName());
            present.setLastName(usersViewModel.getLastName());
            present.setOrigin(usersViewModel.getOrigin());
            present.setDestination(usersViewModel.getDestination());
            present.setSeatType(usersViewModel.getSeatType());
            present.setSeatNumber(usersViewModel.getSeatNumber());
            return usersViewRepo.save(present);
        }else {
            throw new RuntimeException("Id not Found");
        }
    }

    public void deleteUsersViewModel(Integer id){
        Optional<UsersViewModel> listUsersViewModel = usersViewRepo.findById(id);
        if(listUsersViewModel.isPresent()){
            UsersViewModel present = listUsersViewModel.get();
            usersViewRepo.delete(present);
        }else{
            throw new RuntimeException("Id not Found");
        }
    }

    public UsersViewModel listById(Integer id){
        return usersViewRepo.findById(id).orElse(null);
    }
}
