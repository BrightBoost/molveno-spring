package com.molveno.molveno.hotel.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "/get-room",method = RequestMethod.GET)
    public List<Room> getRoom(){
        return roomRepository.findAll();
    }

//    @RequestMapping(value = "/add-room",method = RequestMethod.POST)
//    public void saveRoom




}

