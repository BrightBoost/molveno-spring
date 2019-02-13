package com.molveno.molveno.hotel.payment;


import com.molveno.molveno.hotel.guest.Guest;
import com.molveno.molveno.hotel.room.RoomType;

public class Bill {

    private String dateBill;
    private String referenceNumber;
    private double total;
    private int days;
    private RoomType roomType;
    private Guest guest;

    Bill() {

    }

    public String getDateBill() {
        return dateBill;
    }

    public void setDateBill(String dateBill) {
        this.dateBill = dateBill;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

//    public double calculateTotal(){
//        return total = days*roomType.getPrice();

}
