package com.molveno.molveno.boats;

import com.molveno.molveno.restaurant.guest.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BoatController {
    @Autowired
private  BoatRepository boatRepository;
    @RequestMapping(value = "/get-allboats", method = RequestMethod.GET)
    public List<Boat> getAll() {
        return boatRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/save-boat", method = RequestMethod.POST, consumes = "application/json")
    public Boat saveBoat(@RequestBody Boat boat) {

        boatRepository.save(boat);
        return boat;
    }

    @RequestMapping(value = "/delete-boat", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteBoat(@RequestBody Boat boat) {
        boatRepository.deleteById(boat.getId());

    }

    @RequestMapping(value = "/edit-boat", method = RequestMethod.POST, consumes = "application/json")
    public void editBoat(@RequestBody Boat boat) {



    }



}
