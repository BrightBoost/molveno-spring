package com.molveno.molveno.hotel.booking;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking,Long> {
    List<Booking> findAll();
    Booking findById(long id);
}
