package com.molveno.molveno.hotel.room;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository <Room,Long>{

    List<Room> findAll();
    Room findById(long id);
}
