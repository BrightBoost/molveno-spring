package com.molveno.molveno.hotel.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookingController2 {

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping(value = "/get-booking" , method = RequestMethod.GET)
    public List<Booking> getBooking(){
        return bookingRepository.findAll();

    }

    @RequestMapping(value = "/get-booking-by-id",method = RequestMethod.GET)
    public Booking getBookingById(@RequestParam long id){
        return bookingRepository.findById(id);
    }

    @RequestMapping(value = "add-booking",method = RequestMethod.POST , consumes = "application/json")
    public void saveBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
    }

    @RequestMapping (value = "/delete-booking" , method = RequestMethod.POST , consumes = "application/json")
    public void deleteBooking(@RequestBody Booking booking){
        bookingRepository.deleteById(booking.getId());
    }

    @RequestMapping(value = "edit-booking",method = RequestMethod.POST , consumes = "application/json")
    public void editBooking(@RequestBody Booking booking){
        Booking booking1 = new Booking();
        booking1.setCheckIn(booking.getCheckIn());
        booking1.setCheckOut(booking.getCheckOut());

    }


}
