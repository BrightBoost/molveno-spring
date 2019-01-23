package com.molveno.molveno.hotel.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getAll(){
        return roomRepository.findAll();
    }
}
