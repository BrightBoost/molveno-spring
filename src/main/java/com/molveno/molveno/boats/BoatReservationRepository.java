package com.molveno.molveno.boats;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoatReservationRepository extends CrudRepository<BoatReservation,Long> {
    List<BoatReservation> findAll();
    BoatReservation findById(long id);
}
