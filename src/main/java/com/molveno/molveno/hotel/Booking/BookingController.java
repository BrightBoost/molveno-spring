package com.molveno.molveno.hotel.Booking;


import com.molveno.molveno.hotel.Guest.Guest;
import com.molveno.molveno.hotel.room.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@RestController
public class BookingController {


    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/get-booking", method = RequestMethod.GET)
    public List<Booking> getAll(){
        //response entity
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/find-one", method = RequestMethod.GET)
    public Booking getOne(@RequestParam long id){
        return bookingRepository.findById(id);
    }

    @RequestMapping(value = "/save-booking", method = RequestMethod.POST, produces="application/json", consumes="application/json")
    public void saveBooking(@RequestBody Booking booking){
        Booking booked = new Booking();
        booked.setCheckOut(booked.getCheckIn());
        bookingRepository.save(booked);

        //demoRepository.save(demo);
    }

    @RequestMapping(value= "/delete-booking", method = RequestMethod.POST)
    public void deleteBooking(@RequestParam Booking booking){bookingRepository.deleteById(booking.getId());
    }


    public static boolean checkDate(LocalDate checkinRequest, LocalDate checkoutRequest, List<Booking> currentBookings, Room room) {
        long roomId = room.getId();


        for (Booking current : currentBookings) {
            if (current.getRoom().getId() != roomId) {
                continue;
            }
            if (current.getCheckIn().isAfter(checkinRequest) && current.getCheckIn().isBefore(checkoutRequest)) {
                return false;
            }
            if (current.getCheckOut().isAfter(checkinRequest) && current.getCheckOut().isBefore(checkoutRequest)) {
                return false;
            }
        }
        return true;
    }

    public static List<Room> getAvailableRooms(LocalDate checkinRequest, LocalDate checkoutRequest, List<Room> rooms, List<Booking> bookings) {

        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (checkDate(checkinRequest, checkoutRequest, bookings, room)) {
                availableRooms.add(room);
                System.out.println(room.getId());
            }
        }
        return availableRooms;
    }
}