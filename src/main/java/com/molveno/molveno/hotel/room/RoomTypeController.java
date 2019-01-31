package com.molveno.molveno.hotel.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomTypeController {
    @Autowired
    RoomTypeRepository roomTypeRepository;
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "/get-roomType", method =  RequestMethod.GET)
    public List<RoomType> getRoomsType(){
        return roomTypeRepository.findAll();
    }

    @RequestMapping(value = "/add-roomType" ,method = RequestMethod.POST ,consumes="application/json")
    public void saveRoomType(@RequestBody RoomType roomType){
        roomTypeRepository.save(roomType);
    }

    @RequestMapping(value = "/edit-roomType",method = RequestMethod.POST ,consumes = "application/json")
    public void editRoomType(@RequestBody RoomType roomType){
        RoomType roomType1 =roomTypeRepository.findById(roomType.getId());
        roomType1.setRoomType(roomType.getRoomType());
        roomType1.setRoomPrice(roomType.getRoomPrice());
        roomTypeRepository.save(roomType1);
    }
    @RequestMapping(value = "/delete-roomType", method = RequestMethod.DELETE, consumes = "application/json")
    public void deleteRoomType(@RequestBody RoomType roomType){
        roomTypeRepository.deleteById(roomType.getId());
    }


}
