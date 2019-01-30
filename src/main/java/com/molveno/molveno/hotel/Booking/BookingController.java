//package com.molveno.molveno.hotel.Booking;
//
//
//
//import com.molveno.molveno.hotel.room.Room;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookingController {
//
//    public static boolean checkDate(LocalDate checkingRequest, LocalDate checkoutRequest, List<Booking> currentBookings, Room room) {
//        long roomId = room.getId();
//
//
//        for (Booking current : currentBookings) {
//            if (current.getRoom().getId() != roomId) {
//                continue;
//            }
//            if (current.getCheckIn().isAfter(checkingRequest) && current.getCheckIn().isBefore(checkoutRequest)) {
//                return false;
//            }
//            if (current.getCheckOut().isAfter(checkingRequest) && current.getCheckOut().isBefore(checkoutRequest)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static List<Room> getAvailableRooms(LocalDate checkinRequest, LocalDate checkoutRequest, List<Room> rooms, List<Booking> bookings) {
//
//        List<Room> availableRooms = new ArrayList<>();
//        for (Room room : rooms) {
//            if (checkDate(checkinRequest, checkoutRequest, bookings, room)) {
//                availableRooms.add(room);
//                System.out.println(room.getId());
//            }
//        }
//        return availableRooms;
//    }
//
//}
