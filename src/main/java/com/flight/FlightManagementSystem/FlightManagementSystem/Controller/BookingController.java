package com.flight.FlightManagementSystem.FlightManagementSystem.Controller;

import com.flight.FlightManagementSystem.FlightManagementSystem.Model.AirlineModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Model.BookingModel;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.BookingService;
import com.flight.FlightManagementSystem.FlightManagementSystem.Service.ClientBookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @Autowired
    private ClientBookingsService clientBookingsService;
    @GetMapping("/booking")
    public String booking(Model model) {
        model.addAttribute("bookingModel", new BookingModel());
        return "booking";
    }

    @PostMapping("createBooking")
    public String createBooking(@ModelAttribute("bookingModel") BookingModel bookingModel) {
        bookingService.addNewBookingModel(bookingModel);
        return "redirect:/clientBookings";
    }

    @PostMapping("/saveBooking")
    public ResponseEntity<String> saveBooking(@RequestParam String flightId) {
        // Logic to save the booking
        // ...

        return ResponseEntity.ok("Booking saved successfully");
    }

    @PostMapping("/saveClientBooking")
    public ResponseEntity<String> saveClientBooking(@RequestParam String flightId) {
        // Logic to save the client booking
        // ...

        // For example:
        clientBookingsService.saveClientBooking(flightId);

        return ResponseEntity.ok("Client booking saved successfully");
    }





    /*@GetMapping(value = "/bookingList")
    public List<BookingModel> getAll() {
        return bookingService.getAll();
    }

    @PostMapping(value = "/addBooking")
    public BookingModel addNewBookingModel(@RequestBody BookingModel bookingModel) {
        return bookingService.addNewBookingModel(bookingModel);
    }

    @PutMapping(value = "/updateBooking")
    public BookingModel updateBookingModel(@PathVariable Integer id, @RequestBody BookingModel bookingModel) {
        return bookingService.updateBookingModel(bookingModel, id);
    }

    @DeleteMapping(value = "/deleteBooking")
    public void deleteBookingModel(@PathVariable Integer id) {
        bookingService.deleteBookingModel(id);
    }

    @GetMapping(value = "/bookingListById")
    public BookingModel listById(@PathVariable Integer id) {
        return bookingService.listById(id);
    }
*/
}
