package com.molveno.molveno.hotel.booking;

import com.molveno.molveno.hotel.guest.Guest;
import com.molveno.molveno.hotel.room.Room;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @Column
    private LocalDate checkIn;
    @Column
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
