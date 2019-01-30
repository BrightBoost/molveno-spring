package com.molveno.molveno.hotel.Booking;

import com.molveno.molveno.hotel.Guest.Guest;
import com.molveno.molveno.hotel.room.Room;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

@Entity
@Table (name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    //Room room;
    //Guest guest;


    @Column
    private LocalDate checkIn;
    @Column
    private LocalDate checkOut;

    @Column
    private long roomId;

    @Column
    private long guestId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
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

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }
}
