package com.molveno.molveno.restaurant.guest;

import com.molveno.molveno.restaurant.reservation.Reservation;
import com.molveno.molveno.restaurant.reservation.ReservationRepository;
import com.molveno.molveno.restaurant.table.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestController {
    @Autowired
    private GuestRepository guestRepository;

    @RequestMapping(value = "/get-guest", method = RequestMethod.GET)
    public List<Guest> getAll() {
        return guestRepository.findAll();
    }

    @RequestMapping(value = "/save-guest", method = RequestMethod.POST, consumes = "application/json")
    public Guest saveGuest(@RequestBody Guest guest) {

        guestRepository.save(guest);
return guest;
    }

    @RequestMapping(value = "/delete-guest", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteReservation(@RequestBody Guest guest) {
        guestRepository.deleteById(guest.getId());

    }

    @RequestMapping(value = "/edit-guest", method = RequestMethod.POST, consumes = "application/json")
    public void editPerson(@RequestBody Guest guest) {


        Guest g = guestRepository.findById(guest.getId());


        if (!guest.getEmail().equals("")) {
            g.setEmail(guest.getEmail());
        }
        if (!guest.getMobileNumber().equals("")) {
            g.setMobileNumber(guest.getMobileNumber());
        }
        if (!guest.getFirstName().equals("")) {
            g.setFirstName(guest.getFirstName());
        }
        if (!guest.getLastName().equals("")) {
            g.setLastName(guest.getLastName());
        }

        guestRepository.save(g);

    }


}
