package com.molveno.molveno.hotel.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RoomController {
@Autowired
RoomTypeRepository roomTypeRepository;
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "/get-room", method =  RequestMethod.GET)
    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    @RequestMapping(value = "/add-room" ,method = RequestMethod.POST,consumes = "application/json")
    public Room saveRoom(@RequestBody Room room){
        roomRepository.save(room);
        return room;
    }

    @RequestMapping(value = "/edit-room",method = RequestMethod.POST ,consumes = "application/json")
    public void editRoom(@RequestBody Room room){
        Room room1 = roomRepository.findById(room.getId());
        room1.setRoomName(room.getRoomName());
        room1.setId(room.getId());
        room1.setRoomType(room.getRoomType());
        long s=room.getRoomType().getId();
        RoomType a = room.getRoomType();
        a.setId(s);
        room1.setRoomType(a);
        roomRepository.save(room1);

    }
    @RequestMapping(value = "/delete-room", method = RequestMethod.POST, consumes = "application/json")
    public void deleteRoom(@RequestBody Room room){
        roomRepository.deleteById(room.getId());
    }




}
