package com.molveno.molveno.boats;

import com.molveno.molveno.restaurant.guest.Guest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Bootreservation")
public class BoatReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;
    @Column(name = "startdate")
    private LocalDateTime startDate;
    @Column(name="enddate")
    private LocalDateTime endDate;
    @Column(name="tripstatus")
    private  String tripStatus;
    @Column(name="numberofperson")
    private int numberOfPerson;
    @JoinColumn(name = "guestid", referencedColumnName = "id")
    @OneToOne
    private Guest guest;
    @JoinColumn(name = "boatid", referencedColumnName = "id")
    @OneToOne
    private Boat boat;

    @Column(name = "price")
    private  double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
