package com.molveno.molveno.hotel.room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    List<Room> findAll();
    Room findById(long id);
    Room findByName(String name);
}