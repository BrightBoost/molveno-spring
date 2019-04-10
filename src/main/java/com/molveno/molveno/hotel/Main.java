package com.molveno.molveno.hotel;


import com.molveno.molveno.hotel.Guest.Guest;
import com.molveno.molveno.hotel.room.Room;
import com.molveno.molveno.hotel.Booking.Booking;


import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {

    public static void main(String[] args) {



        System.out.println("Welcome to the Molveno Hotel Portal!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Check-In Date:  (yyyy-MM-dd)");

        String checkIn = scanner.nextLine();

        LocalDate date2 = null;

        //Parsing the String
        date2 = LocalDate.parse(checkIn);//dateFormat.parse(checkIn);

        while (date2.compareTo(LocalDate.now()) < 0) {
            System.out.println("Enter the Correct Check-In Date: (yyyy-MM-dd) ");
            checkIn = scanner.nextLine();
            date2 = LocalDate.parse(checkIn);
        }
        Booking booking = new Booking();
        booking.setCheckIn(date2);

        System.out.println("Enter the Check-Out Date: (yyyy-MM-dd) ");

        String checkOut = scanner.nextLine();

        LocalDate date3 = null;

        date3 = LocalDate.parse(checkOut);

        while (date3.isEqual(date2) || date3.isBefore(date2)) {
            System.out.println("Enter the Correct Check-Out Date: (yyyy-MM-dd) ");
            checkOut = scanner.nextLine();
            date3 = LocalDate.parse(checkOut);
        }

        booking.setCheckOut(date3);

        System.out.println("Guest Count: ");
        int guestCount = scanner.nextInt();
        scanner.nextLine();


        LocalDate BookingRequest = LocalDate.of(2018, Month.DECEMBER, 12);

        System.out.println("Reservation Request is at the date: " + BookingRequest);


        LocalDate checkInDate = LocalDate.of(2018, Month.DECEMBER, 12);
        //LocalDate Booking1 = LocalDate.of(checkInDate);

        LocalDate checkOutDate = LocalDate.of(2018, Month.DECEMBER, 16);

        //LocalDate Booking2 = LocalDate.of(checkOutDate);

//        List<LocalDate> current = new ArrayList<>();
        //current.add(Booking1);
        //current.add(Booking2);

//        System.out.println("current is  " + current);

        //System.out.println(BoatReservationLogic.checkDateTime(ReservationRequest, current));

        Room room1 = new Room();
        room1.setId(1);

        Room room2 = new Room();
        room2.setId(2);

        Room room3 = new Room();
        room3.setId(3);

        Room room4 = new Room();
        room4.setId(4);

        //boolean timeAvailable = BoatReservationLogic.checkDateTime(ReservationRequest, current);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);


        Map<String, Integer> proMap = new HashMap<>();
        proMap.put(" * Budget ", 80);
        proMap.put(" * Standard  ", 100);
        proMap.put(" * Luxury  ", 140);

        List<Integer> professionalList = new ArrayList<>();
        Iterator it = proMap.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            professionalList.add((Integer) pair.getValue());
        }

        for (Map.Entry entry : proMap.entrySet()) {
            System.out.println("Rooms are available: \n" + rooms.size() + entry);
        }

        System.out.println("Enter your Choice: ");
        String roomChoice = scanner.nextLine();
        System.out.println("You choose this room: " + roomChoice);

        String decision;

        boolean yn = true;
        while (yn) {
            System.out.println("Would you like to register and create a profile? (yes or no)");

            decision = scanner.nextLine();

            switch (decision) {
                case "yes":
                    yn = true;
                    break;

                case "no":
                    yn = false;
                    break;

                default:
                    System.out.println("please enter again ");
                    boolean repeat = true;

                    while (repeat) {
                        System.out.println("enter another answer : yes or no");
                        decision = scanner.nextLine();

                        switch (decision) {
                            case "yes":
                                yn = repeat = true;
                                break;

                            case "no":
                                yn = repeat = false;
                                break;
                        }
                    }
                    break;
            }

            System.out.println("Enter your full name: ");
            String name = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            System.out.println("Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.println("Address: ");
            String address = scanner.nextLine();

            System.out.println("Country: ");
            String country = scanner.nextLine();

            System.out.println("Nationality: ");
            String nationality = scanner.nextLine();


            Guest guestInfo = new Guest();
            guestInfo.setName(name);
            guestInfo.setEmail(email);
            guestInfo.setPhone(phoneNumber);
            guestInfo.setAddress(address);
            guestInfo.setCountry(country);
            guestInfo.setNationality(nationality);

            Date date = new Date();
            // display time and date using toString()
            System.out.println(date.toString());

            Booking rese1 = new Booking();
            rese1.setRoom(room1);
            // rese1.setCheckIn(Booking1);

            Booking rese2 = new Booking();
            rese2.setRoom(room2);
            //rese2.setCheckIn(Booking2);
            List<Booking> listBookings = new ArrayList<>();

            listBookings.add(rese1);
            listBookings.add(rese2);

            break;
        }
    }

}