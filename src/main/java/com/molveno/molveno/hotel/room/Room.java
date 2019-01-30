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
    @JoinColumn(name = "roomtypeid",referencedColumnName = "id")
    @OneToOne

   private RoomType roomType;

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Column(name = "roomname")
    private String roomName;

    @Column(name = "roomava")
    private boolean roomAvailability;


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
