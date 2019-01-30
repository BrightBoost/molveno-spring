package com.molveno.molveno.hotel.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @RequestMapping(value = "/get-guest", method =  RequestMethod.GET)
    public List<Guest> getGuest(){
        return guestRepository.findAll();
    }

    @RequestMapping(value = "/get-guestByID", method =  RequestMethod.GET)
    public Guest getGuestByID(@RequestParam long id){
        return guestRepository.findById(id);
    }

    @RequestMapping(value = "/add-guest", method = RequestMethod.POST, consumes="application/json")
    public void saveGuest(@RequestBody Guest guest){
        guestRepository.save(guest);
    }

    @RequestMapping(value = "/edit-guest", method = RequestMethod.POST, consumes = "application/json")
    public void editGuest(@RequestBody Guest guest){
        Guest guest1 = guestRepository.findById(guest.getId());
        guest1.setFirstname(guest.getFirstname());
        guest1.setLastname(guest.getLastname());
        guest1.setEmail(guest.getEmail());
        guest1.setPhone(guest.getPhone());
        guest1.setPassword(guest.getPassword());
        guest1.setStreet(guest.getStreet());
        guest1.setHousenumber(guest.getHousenumber());
        guest1.setPostcode(guest.getPostcode());
        guest1.setCountry(guest.getCountry());
        guestRepository.save(guest1);
    }

    @RequestMapping(value = "/delete-guest", method = RequestMethod.POST, consumes = "application/json")
    public void deleteGuest(@RequestBody Guest guest){
        guestRepository.deleteById(guest.getId());
    }
    // sign up  or sign in
}
