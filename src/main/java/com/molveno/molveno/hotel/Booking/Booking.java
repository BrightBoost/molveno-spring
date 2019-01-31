package com.molveno.molveno.hotel.Booking;

import com.molveno.molveno.hotel.Guest.Guest;
import com.molveno.molveno.hotel.room.Room;
import com.molveno.molveno.hotel.room.RoomType;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@Entity
@Table (name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;


    @ManyToMany
    @JoinTable(name = "roombooking",
            joinColumns = {@JoinColumn(name = "bookingid")},
            inverseJoinColumns = {@JoinColumn(name = "roomid")})
    private List<Room> rooms;

    @JoinColumn(name = "guestid",referencedColumnName = "id")
    @OneToOne
    private Guest guest;

    @Column(name = "checkin")
    private LocalDate checkIn;
    @Column(name = "checkout")
    private LocalDate checkOut;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDate getCheckIn() {
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
