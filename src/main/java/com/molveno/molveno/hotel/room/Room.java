package com.molveno.molveno.hotel.room;

import javax.persistence.*;

@Entity
@Table (name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private int id;

    @Column
    private String name;

    @JoinColumn(name = "roomtype", referencedColumnName = "id")
    @ManyToOne
    private RoomType roomtype;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public RoomType getRoomType() {
        return roomtype;
    }

    public void setRoomType(RoomType roomType) {
        this.roomtype = roomType;
    }




}
