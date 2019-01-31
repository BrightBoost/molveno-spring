package com.molveno.molveno.hotel.room;

import javax.persistence.*;

@Entity
@Table(name = "Room")

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    @JoinColumn(name = "roomtypeid",referencedColumnName = "id")
    @OneToOne
    private RoomType roomType;

    @Column(name = "roomname")
    private String roomName;

    @Column(name = "roomava")
    private boolean roomBooked;


    public boolean isRoomBooked() {
        return roomBooked;
    }

    public void setRoomBooked(boolean roomBooked) {
        this.roomBooked = roomBooked;
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

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
