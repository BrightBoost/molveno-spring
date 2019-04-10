package com.molveno.molveno.boats;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoatRepository  extends CrudRepository<Boat,Long> {
    List<Boat> findAll();
    Boat findById(long id);

}
