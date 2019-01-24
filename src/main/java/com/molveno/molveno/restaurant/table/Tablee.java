package com.molveno.molveno.restaurant.table;

import javax.persistence.*;

@Entity
@Table(name = "Tablee")
public class Tablee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "numberofchairs")
    private int numberofchairs;

    @Column(name = "nameoftable")
    private String nameoftable;

    public int getNumberofchairs() {
        return numberofchairs;
    }

    public void setNumberofchairs(int numberofchairs) {
        this.numberofchairs = numberofchairs;
    }

    public String getNameoftable() {
        return nameoftable;
    }

    public void setNameoftable(String nameoftable) {
        this.nameoftable = nameoftable;
    }

    public int getNumberOfChairs() {
        return numberofchairs;
    }

    public void setNumberOfChairs(int numberOfChairs) {
        this.numberofchairs = numberOfChairs;
    }





}

