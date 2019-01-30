package com.molveno.molveno.hotel.room;

import javax.persistence.*;

@Entity
@Table(name = "Room")

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    //RoomType roomType;

    @Column
    private long roomTypeID;

    @Column
    private String roomName;

    @Column
    private boolean roomAvailability;

    public long getRoomTypeID() {
        return roomTypeID;
    }

    public void setRoomTypeID(long roomTypeID) {
        this.roomTypeID = roomTypeID;
    }

    public boolean isRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(boolean roomAvailability) {
        this.roomAvailability = roomAvailability;
    }


    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




}
