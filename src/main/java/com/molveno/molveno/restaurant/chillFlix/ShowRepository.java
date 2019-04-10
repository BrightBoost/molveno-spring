package com.molveno.molveno.restaurant.chillFlix;

import com.molveno.molveno.restaurant.guest.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowRepository extends CrudRepository<Show, Long> {
    List<Show> findAll();


    Show findById(long id);


}
