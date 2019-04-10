package com.molveno.molveno.boats;

import com.molveno.molveno.restaurant.guest.GuestRepository;
import com.molveno.molveno.restaurant.reservation.ReservationLogic;
import com.molveno.molveno.restaurant.table.Tablee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class BoatReservationController {
    @Autowired
    private BoatReservationRepository boatReservationRepository;
    @Autowired
    private BoatRepository boatRepository;
    @Autowired
    private GuestRepository guestRepository;

    @RequestMapping(value = "/get-boat-reservation", method = RequestMethod.GET)
    public List<BoatReservation> getAll() {
        List<BoatReservation> boatReservations = boatReservationRepository.findAll();
        for (BoatReservation b : boatReservations) {
            BoatReservationLogic.changeTripStatus(b);
            boatReservationRepository.save(b);

        }

        return boatReservationRepository.findAll();
    }

    @RequestMapping(value = "/save-boat-reservation", method = RequestMethod.POST, consumes = "application/json")
    public void saveBoat(@RequestBody BoatReservation boatReservation) {
        BoatReservationLogic.calPrice(boatReservation);

        boatReservationRepository.save(boatReservation);

    }

    @RequestMapping(value = "/delete-boat-reservation", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteBoat(@RequestBody BoatReservation boatReservation) {
        boatReservationRepository.deleteById(boatReservation.getId());

    }

    @RequestMapping(value = "/edit-boat-reservation", method = RequestMethod.POST, consumes = "application/json")
    public void editBoat(@RequestBody BoatReservation boatReservation) {


    }

    @RequestMapping(value = "/get-ava-boats", method = RequestMethod.GET)
    public List<Boat> checkAva(@RequestParam String a, @RequestParam String b) {

        LocalDateTime startDate = LocalDateTime.parse(a);
        LocalDateTime endDate = LocalDateTime.parse(b);

        List<BoatReservation> boatReservations = boatReservationRepository.findAll();
        for (BoatReservation boatReservation : boatReservations) {
            BoatReservationLogic.changeTripStatus(boatReservation);
            boatReservationRepository.save(boatReservation);

        }


        List<Boat> boats = BoatReservationLogic.getAvailableBoats(startDate, endDate, boatRepository.findAll(), boatReservationRepository.findAll());

        return boats;

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/get-trip-overview/{date}", method = RequestMethod.GET)
    public List<Integer> getTripOverview(@PathVariable String date) {

        List<Integer> a = BoatReservationLogic.tripOverView(boatReservationRepository.findAll(), date);


        return a;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/reserve-boat", method = RequestMethod.POST, consumes = "application/json")
    public void reserveBoat(@RequestBody BoatReservation b) {
        List<Boat> a = BoatReservationLogic.getAvailableBoats(b.getStartDate(), b.getEndDate(), boatRepository.findAll(), boatReservationRepository.findAll());
        b.setBoat(a.get(0));
        guestRepository.save(b.getGuest());
        BoatReservationLogic.calPrice(b);
        System.out.println(b.getPrice());
        boatReservationRepository.save(b);

    }

    @RequestMapping(value = "/get-boats-overview", method = RequestMethod.GET)
    public List<List<Integer>> boatsOverView(@RequestParam String date) {

        List<List<Integer>> a = BoatReservationLogic.allBoatsOverView(boatReservationRepository.findAll(), date, boatRepository.findAll());

        return a;
    }


}
