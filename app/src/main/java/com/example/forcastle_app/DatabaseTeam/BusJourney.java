package com.example.forcastle_app.DatabaseTeam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BusJourney {

    //variables are static so that only one BusJourney object needs to be made with all variables of the one object being accessible from all other classes
    //removes the need to create a BusJourney object on every page of the app
    private static String journey1, journey2,
            return1, return2,
            partOfWeek,
            operator1, operator2,
            busNo1, busNo2,
            outboundTime1, outboundTime2,
            inboundTime1, inboundTime2,
            departureStationOut1, departureStationOut2, departureStationIn1, departureStationIn2,
            arrivalStationOut1, arrivalStationOut2, arrivalStationIn1, arrivalStationIn2,
            travelDate,
            travelTime1, travelTime2,
            directChange,
            changeWait;
    private static int hour = 0, minute = 0, totalTime, arrivalTime, returnTime;
    private static Integer journeyTime1, journeyTime2;

    //constructor sets data dictated by the journey chosen by the user via HashMaps
    public BusJourney(String journey1, String journey2) {
        BusJourney.journey1 = journey1;
        BusJourney.journey2 = journey2;

        HashMaps hashMaps = new HashMaps();

        return1 = hashMaps.getReturnJourney().get(journey1);
        return2 = hashMaps.getReturnJourney().get(journey2);
        operator1 = hashMaps.getOperators().get(journey1);
        operator2 = hashMaps.getOperators().get(journey2);
        busNo1 = hashMaps.getBusNo().get(journey1);
        busNo2 = hashMaps.getBusNo().get(journey2);
        journeyTime1 = hashMaps.getJourneyTimes().get(journey1);
        journeyTime2 = hashMaps.getJourneyTimes().get(journey2);
        TimeDateFormatters.durationFormat(journeyTime1);
        directChange = hashMaps.getDirectChange().get(journey1);
        departureStationOut1 = hashMaps.getStation().get(journey1);
        arrivalStationOut1 = hashMaps.getStation().get(return1);
        departureStationOut2 = hashMaps.getStation().get(journey2);
        arrivalStationOut2 = hashMaps.getStation().get(return2);
        departureStationIn1 = hashMaps.getStation().get(return1);
        departureStationIn2 = hashMaps.getStation().get(return2);
        arrivalStationIn1 = hashMaps.getStation().get(journey1);
        arrivalStationIn2 = hashMaps.getStation().get(journey2);
    }

    /****************** GETTERS & SETTERS **************************/
    public static String getJourney1() {
        return journey1;
    }

    public static String getJourney2() {
        return journey2;
    }

    public static String getReturn1() {
        return return1;
    }

    public static String getReturn2() {
        return return2;
    }

    public static String getOperator1() {
        return operator1;
    }

    public static String getOperator2() {
        return operator2;
    }

    public static String getBusNo1() {
        return busNo1;
    }

    public static String getBusNo2() {
        return busNo2;
    }

    public static String getPartOfWeek() {
        return partOfWeek;
    }

    public static void setPartOfWeek(String date) {

        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
        Date dt1 = null;
        try {
            dt1 = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("EEEE", Locale.UK);
        String dayOfWeek = format2.format(dt1);

        if (dayOfWeek.equals("Saturday")) partOfWeek = "Saturday";

        else if (dayOfWeek.equals("Sunday")) partOfWeek = "Sunday";

        else partOfWeek = "weekDay";
    }

    public static String getDepartureStationOut1() {
        return departureStationOut1;
    }

    public static String getDepartureStationOut2() {
        return departureStationOut2;
    }

    public static String getDepartureStationIn2() {
        return departureStationIn2;
    }

    public static String getArrivalStationOut2() {
        return arrivalStationOut2;
    }

    public static String getArrivalStationIn2() {
        return arrivalStationIn2;
    }

    public static String getArrivalStationOut1() {
        return arrivalStationOut1;
    }

    public static String getDepartureStationIn1() {
        return departureStationIn1;
    }

    public static String getArrivalStationIn1() {
        return arrivalStationIn1;
    }

    public static void setReturnTime(int returnTime) {
        BusJourney.returnTime = returnTime;
    }

    public static String getTravelTime2() {
        return travelTime2;
    }

    public static void setTravelTime2(String travelTime2) {
        BusJourney.travelTime2 = travelTime2;
    }

    public static int getArrivalTime() {
        return arrivalTime;
    }

    public static void setArrivalTime(int arrivalTime) {
        BusJourney.arrivalTime = arrivalTime;
    }

    public static void setTravelTime1(String travelTime1) {
        BusJourney.travelTime1 = travelTime1;
    }

    public static String getDirectChange() {
        return directChange;
    }

    public static String getTravelTime1() {
        return travelTime1;
    }

    public static int getJourneyTime1() {
        return journeyTime1;
    }

    public static int getJourneyTime2() {
        return journeyTime2;
    }

    public static int getHour() {
        return hour;
    }

    public static void setHour(int hour) {
        BusJourney.hour = hour;
    }

    public static int getMinute() {
        return minute;
    }

    public static void setMinute(int minute) {
        BusJourney.minute = minute;
        totalTime = minute + hour * 60;
    }

    public static String getTravelDate() {
        return travelDate;
    }

    public static void setTravelDate(int day, int month, int year) {

        String date = day + "/" + month + "/" + year;

        String monthName = TimeDateFormatters.getMonthFormat(month);

        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
        Date dt1 = null;
        try {
            dt1 = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("EEEE", Locale.UK);
        String dayOfWeek = format2.format(dt1);

        travelDate = dayOfWeek + " " + day + " " + monthName;

    }

    public static String getChangeWait() {
        return changeWait;
    }

    public static void setChangeWait(String changeWait) {
        BusJourney.changeWait = changeWait;
    }

    public static int getTotalTime() {
        return totalTime;
    }

    public static void setTotalTime(int totalTime) {
        BusJourney.totalTime = totalTime;
    }

    public static String getOutboundTime1() {
        return outboundTime1;
    }

    public static void setOutboundTime1(String outboundTime1) {
        BusJourney.outboundTime1 = outboundTime1;
    }

    public static String getOutboundTime2() {
        return outboundTime2;
    }

    public static void setOutboundTime2(String outboundTime2) {
        BusJourney.outboundTime2 = outboundTime2;
    }

    public static String getInboundTime1() {
        return inboundTime1;
    }

    public static void setInboundTime1(String inboundTime1) {
        BusJourney.inboundTime1 = inboundTime1;
    }

    public static String getInboundTime2() {
        return inboundTime2;
    }

    public static void setInboundTime2(String inboundTime2) {
        BusJourney.inboundTime2 = inboundTime2;
    }

    public static void setTravelDate(String travelDate) {
        BusJourney.travelDate = travelDate;
    }

}
