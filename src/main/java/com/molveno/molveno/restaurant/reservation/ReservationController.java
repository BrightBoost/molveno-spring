package com.molveno.molveno.restaurant.reservation;


import com.molveno.molveno.restaurant.table.TableRepository;
import com.molveno.molveno.restaurant.table.Tablee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ReservationController {


    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping(value = "/get-reservation", method = RequestMethod.GET)
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @RequestMapping(value = "/save-reservation", method = RequestMethod.POST , consumes="application/json")
    public void saveReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @RequestMapping(value = "/delete-reservation", method = RequestMethod.DELETE , consumes="application/json")
    public void deleteReservation(@RequestBody Reservation reservation){
        reservationRepository.deleteById(reservation.getId());

    }
}
