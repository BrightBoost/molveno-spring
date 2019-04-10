package com.molveno.molveno.boats;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BoatReservationLogic {
    public static boolean checkDateTime(LocalDateTime startTime, LocalDateTime endTime, List<BoatReservation> currentReservations, Boat boat) {
        long boatId = boat.getId();
        startTime = startTime.minusHours(1);


        for (BoatReservation current : currentReservations) {
            if (current.getBoat().getId() != boatId) {

                continue;
            }


            if (startTime.isBefore(current.getEndDate()) && current.getStartDate().isBefore(endTime)) {
                return false;
            }


        }

        return true;
    }


    public static List<Boat> getAvailableBoats(LocalDateTime startTime, LocalDateTime endTime, List<Boat> boats, List<BoatReservation> boatReservations) {
        List<Boat> availableBoats
                = new ArrayList<>();
        for (Boat boat : boats) {
            if (checkDateTime(startTime, endTime, boatReservations, boat)) {
                availableBoats.add(boat);
                availableBoats.sort(Comparator.comparing(Boat::getCounter));

            }

        }

        return availableBoats;


    }

    public static void calPrice(BoatReservation boatReservation) {
        long counter = boatReservation.getBoat().getCounter();
        boatReservation.setTripStatus("Not active");
        boatReservation.getBoat().setCounter(counter + 1);
        LocalDateTime a = boatReservation.getStartDate();
        LocalDateTime b = boatReservation.getEndDate();

        Duration duration = Duration.between(a, b);
        long x = duration.getSeconds();

        long hours = (x) / 3600;
        boatReservation.setPrice(boatReservation.getBoat().getPricePerHour() * hours);

    }

    public static void changeTripStatus(BoatReservation boatReservation) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = boatReservation.getEndDate();
        LocalDateTime start = boatReservation.getStartDate();


        if (!boatReservation.getTripStatus().equals("ended")) {
            if (now.isAfter(start) && now.isBefore(end)) {
                boatReservation.setTripStatus("in progress");

            } else if (now.isAfter(end)) {
                boatReservation.setTripStatus("ended");


            } else {
                boatReservation.setTripStatus("not Active");
            }

        }
    }

    public static List<BoatReservation> getActiveRes(List<BoatReservation> boatReservations, String date) {
        List<BoatReservation> boatReservations1 = new ArrayList<>();
       LocalDateTime startDate = LocalDateTime.parse(date);

        for (BoatReservation b : boatReservations) {
            if ((b.getEndDate().getDayOfYear() == startDate.getDayOfYear()) & (startDate.getYear() == b.getEndDate().getYear())) {
                if (b.getTripStatus().equals("not Active")) {
                    continue;
                }
                boatReservations1.add(b);
            }
        }

        return boatReservations1;

    }


    public static List<Integer> oneBoatOverView(List<BoatReservation> boatReservations, String date, Boat boat) {
        int inProgressCounter = 0;
        int endedCounter = 0;
        int incomeCounter = 0;
        int avreageDurationCounter = 0;
        List<Integer> counters = new ArrayList<>();
        List<BoatReservation> a = getActiveRes(boatReservations, date);
        List<BoatReservation> c = new ArrayList<>();

        for (BoatReservation b : a) {
            if (b.getBoat().getBootNumber() == boat.getBootNumber()) {

                c.add(b);

            }

        }
        for (BoatReservation k : c) {
            if (k.getTripStatus().equals("in progress")) {
                inProgressCounter = inProgressCounter + 1;
            } else {
                Duration d = Duration.between(k.getStartDate(), k.getEndDate());
                endedCounter = endedCounter + 1;
                avreageDurationCounter = (int) (d.getSeconds() + avreageDurationCounter);

            }

            incomeCounter = (int) (k.getPrice() + incomeCounter);

        }
        avreageDurationCounter = avreageDurationCounter / 3600;


        counters.add(boat.getBootNumber());
        counters.add(inProgressCounter);
        counters.add(endedCounter);
        counters.add(incomeCounter);
        counters.add(avreageDurationCounter);


        return counters;

    }

    public static List<List<Integer>> allBoatsOverView(List<BoatReservation> boatReservations, String date, List<Boat> boats) {
        List<List<Integer>> counters = new ArrayList<>();
        List<Integer> counter1 = new ArrayList<>();
        int totalTime = 0;
        int totalIncome = 0;

        for (Boat b : boats) {

            List<Integer> a = oneBoatOverView(boatReservations, date, b);
            totalIncome = a.get(3) + totalIncome;
            totalTime = a.get(4) + totalTime;
            counters.add(a);
        }
        counter1.add(totalIncome);
        counter1.add(totalTime);

        counters.add(counter1);
        return counters;
    }


    public static List<Integer> tripOverView(List<BoatReservation> boatReservations, String date) {

        List<Integer> counters = new ArrayList<>();
        List<Integer> boatNumbers = new ArrayList<>();
        List<BoatReservation> boatReservationList = getActiveRes(boatReservations, date);
        int inProgressCounter = 0;
        int endedCounter = 0;
        int incomeCounter = 0;
        int avreageDurationCounter = 0;
        for (BoatReservation b : boatReservationList) {


            if (b.getTripStatus().equals("in progress")) {
                inProgressCounter = inProgressCounter + 1;
            } else {
                Duration d = Duration.between(b.getStartDate(), b.getEndDate());
                endedCounter = endedCounter + 1;
                avreageDurationCounter = (int) (d.getSeconds() + avreageDurationCounter);

            }
            if (!boatNumbers.contains(b.getBoat().getBootNumber())) {
                boatNumbers.add(b.getBoat().getBootNumber());
            }
            incomeCounter = (int) (b.getPrice() + incomeCounter);

        }
        avreageDurationCounter = avreageDurationCounter / 3600;
        if (endedCounter != 0) {
            avreageDurationCounter = avreageDurationCounter / endedCounter;
        }

        counters.add(inProgressCounter);
        counters.add(endedCounter);
        counters.add(incomeCounter);
        counters.add(avreageDurationCounter);
        counters.addAll(boatNumbers);
        return counters;
    }


}
