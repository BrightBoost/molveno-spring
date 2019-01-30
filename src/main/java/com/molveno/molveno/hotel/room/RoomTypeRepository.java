package com.molveno.molveno.hotel.room;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomTypeRepository extends CrudRepository <RoomType,Long> {

        List<RoomType> findAll();
        RoomType findById(long id);



}
