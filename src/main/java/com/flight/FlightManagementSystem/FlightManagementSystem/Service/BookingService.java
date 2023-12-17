package com.flight.FlightManagementSystem.FlightManagementSystem.Service;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.BookingModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    public List<BookingModel> getAll() {
        return bookingRepo.findAll();
    }
    public BookingModel addNewBookingModel(BookingModel bookingModel){
        return bookingRepo.save(bookingModel);
    }

    public BookingModel updateBookingModel(BookingModel bookingModel, Integer id){
        Optional<BookingModel> listBooking = bookingRepo.findById(id);
        if(listBooking.isPresent()){
            BookingModel present = listBooking.get();
            present.setFirstName(bookingModel.getFirstName());
            present.setLastName(bookingModel.getLastName());
            present.setNumber(bookingModel.getNumber());
            present.setTotal(bookingModel.getTotal());
            present.setPaymentMethod(bookingModel.getPaymentMethod());
            return bookingRepo.save(present);
        }else {
            throw new RuntimeException("Id not Found");
        }
    }

    public void deleteBookingModel(Integer id){
        Optional<BookingModel> listBooking = bookingRepo.findById(id);
        if(listBooking.isPresent()){
            BookingModel present = listBooking.get();
            bookingRepo.delete(present);
        }else{
            throw new RuntimeException("Id not Found");
        }
    }

    public BookingModel listById(Integer id){
        return bookingRepo.findById(id).orElse(null);
    }
}
