package com.molveno.molveno.restaurant.reservation;

import com.molveno.molveno.restaurant.table.Tablee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository  extends CrudRepository <Reservation, Long> {

    List<Reservation> findAll();

}
