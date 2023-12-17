package com.flight.FlightManagementSystem.FlightManagementSystem.Service;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.UsersModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepo usersRepo;

    public List<UsersModel> getAll(){
        return usersRepo.findAll();
    }

    public UsersModel addUsersModel(UsersModel usersModel){
        return usersRepo.save(usersModel);
    }

    public UsersModel updateUsersModel(UsersModel usersModel, Integer id){
        Optional<UsersModel> listUsersModel = usersRepo.findById(id);
        if(listUsersModel.isPresent()){
            UsersModel present = listUsersModel.get();
            present.setName(usersModel.getName());
            present.setEmail(usersModel.getEmail());
            present.setRole(usersModel.getRole());
            return usersRepo.save(present);
        }else {
            throw new RuntimeException("Id not Found");
        }
    }

    public void deleteUsersModel(Integer id){
        Optional<UsersModel> listUsersModel = usersRepo.findById(id);
        if(listUsersModel.isPresent()){
            UsersModel present = listUsersModel.get();
            usersRepo.delete(present);
        }else{
            throw new RuntimeException("Id not found");
        }
    }

    public UsersModel listById(Integer id){
        return usersRepo.findById(id).orElse(null);
    }

    public UsersModel userLogin(UsersModel usersModel){
        return usersRepo.findUsersModelByEmailAndPassword(usersModel.getEmail(), usersModel.password);
    }
}
