package com.molveno.molveno.hotel.Booking;

import com.molveno.molveno.hotel.Guest.Guest;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking,Long> {
    List<Booking> findAll();
    Booking findById(long id);
}
