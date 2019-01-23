package com.molveno.molveno.hotel.room;


import javax.persistence.*;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;
    private RoomType roomType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
