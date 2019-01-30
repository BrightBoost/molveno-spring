package com.molveno.molveno.hotel.Booking;

import com.molveno.molveno.hotel.Guest.Guest;
import com.molveno.molveno.hotel.room.Room;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    private LocalDate checkIn;
    private LocalDate checkOut;
    private Room room;
    private Guest guest;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getCheckIn(LocalDate date2) {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }


}
