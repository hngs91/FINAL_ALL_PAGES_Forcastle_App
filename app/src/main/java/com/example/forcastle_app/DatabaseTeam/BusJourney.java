package com.example.forcastle_app.DatabaseTeam;

import static com.example.forcastle_app.DatabaseTeam.HashMaps.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
Code implemented by Harry Smith
 */
public class BusJourney {

    /*
    This class has been designed to be a singleton class, i.e., only one BusJourney object can exist.
    As a user goes through the app, the object is built with relevant data being updated and retrieved as necessary throughout the app
     */

    private static String journeyCode1, journeyCode2,
            returnCode1, returnCode2,
            partOfWeek,
            operator1, operator2,
            busNo1, busNo2,
            outboundTime1, outboundTime2,
            inboundTime1, inboundTime2,
            departureStationOut1, departureStationOut2, arrivalStationOut1, arrivalStationOut2,
            departureStationIn1, departureStationIn2, arrivalStationIn1, arrivalStationIn2,
            travelDate,
            travelTime1, travelTime2,
            directChange,
            changeWaitOut, changeWaitIn,
            castleName;

    private static int hour, minute, totalTime,
            arrivalTimeOut, arrivalTimeIn,
            noAdultTickets, noChildTickets;

    private static double adultBusPrice, childBusPrice,
            adultCastlePrice, childCastlePrice;

    private static Integer journeyDurationTotalMinutes1, journeyDurationTotalMinutes2;

    // private empty constructor to ensure additional instances of the class cannot be created
    private BusJourney() {
    }


    // method sets data dictated by the journey chosen by the user via HashMaps
    public static void buildBusJourney(String journey1, String journey2) {
        BusJourney.journeyCode1 = journey1;
        BusJourney.journeyCode2 = journey2;

        buildAllHashMaps();

        returnCode1 = getReturnJourney().get(journey1);
        returnCode2 = getReturnJourney().get(journey2);

        operator1 = getOperators().get(journey1);
        operator2 = getOperators().get(journey2);

        busNo1 = getBusNo().get(journey1);
        busNo2 = getBusNo().get(journey2);

        journeyDurationTotalMinutes1 = getJourneyTimes().get(journey1);

        if (getJourneyTimes().containsKey(journey2)) {
            journeyDurationTotalMinutes2 = getJourneyTimes().get(journey2);
        } else {
            journeyDurationTotalMinutes2 = 0;
        }

        directChange = HashMaps.getDirectChange().get(journey1);

        departureStationOut1 = getStation().get(journey1);
        departureStationOut2 = getStation().get(journey2);

        arrivalStationOut1 = getStation().get(returnCode1);
        arrivalStationOut2 = getStation().get(returnCode2);

        departureStationIn1 = getStation().get(returnCode1);
        departureStationIn2 = getStation().get(returnCode2);

        arrivalStationIn1 = getStation().get(journey1);
        arrivalStationIn2 = getStation().get(journey2);

        adultBusPrice = getAdultPrice().get(journey1);
        childBusPrice = getChildPrice().get(journey1);

        castleName = HashMaps.getCastleName().get(journey1);
    }

    /****************** GETTERS & SETTERS **************************/
    public static String getJourneyCode1() {
        return journeyCode1;
    }

    public static String getJourneyCode2() {
        return journeyCode2;
    }

    public static String getReturnCode1() {
        return returnCode1;
    }

    public static String getReturnCode2() {
        return returnCode2;
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

    // reformats dd/mm/yyyy date and finds out if the date is a weekday, Saturday, or Sunday
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

        if (dayOfWeek.equals("Saturday")) partOfWeek = "Sat";

        else if (dayOfWeek.equals("Sunday")) partOfWeek = "Sun";

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

    public static String getTravelTime2() {
        return travelTime2;
    }

    public static void setTravelTime2(String travelTime2) {
        BusJourney.travelTime2 = travelTime2;
    }

    public static int getArrivalTimeOut() {
        return arrivalTimeOut;
    }

    public static void setArrivalTimeOut(int arrivalTimeOut) {
        BusJourney.arrivalTimeOut = arrivalTimeOut;
    }

    public static int getArrivalTimeIn() {
        return arrivalTimeIn;
    }

    public static void setArrivalTimeIn(int arrivalTimeIn) {
        BusJourney.arrivalTimeIn = arrivalTimeIn;
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

    public static int getJourneyDurationTotalMinutes1() {
        return journeyDurationTotalMinutes1;
    }

    public static int getJourneyDurationTotalMinutes2() {
        return journeyDurationTotalMinutes2;
    }

    public static void setHour(int hour) {
        BusJourney.hour = hour;
    }

    public static void setMinute(int minute) {
        BusJourney.minute = minute;
        setTotalTime(minute + hour * 60);
    }

    public static void setTotalTime(int totalTime) {
        BusJourney.totalTime = totalTime;
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

    public static String getChangeWaitOut() {
        return changeWaitOut;
    }

    public static void setChangeWaitOut(String changeWaitOut) {
        BusJourney.changeWaitOut = changeWaitOut;
    }

    public static String getChangeWaitIn() {
        return changeWaitIn;
    }

    public static void setChangeWaitIn(String changeWaitIn) {
        BusJourney.changeWaitIn = changeWaitIn;
    }

    public static int getTotalTime() {
        return totalTime;
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

    public static int getNoAdultTickets() {
        return noAdultTickets;
    }

    public static void setNoAdultTickets(int noAdultTickets) {
        BusJourney.noAdultTickets = noAdultTickets;
    }

    public static int getNoChildTickets() {
        return noChildTickets;
    }

    public static void setNoChildTickets(int noChildTickets) {
        BusJourney.noChildTickets = noChildTickets;
    }

    public static double getAdultBusPrice() {
        return adultBusPrice;
    }

    public static double getChildBusPrice() {
        return childBusPrice;
    }

    public static double getAdultCastlePrice() {
        return adultCastlePrice;
    }

    public static void setAdultCastlePrice(double adultCastlePrice) {
        BusJourney.adultCastlePrice = adultCastlePrice;
    }

    public static double getChildCastlePrice() {
        return childCastlePrice;
    }

    public static void setChildCastlePrice(double childCastlePrice) {
        BusJourney.childCastlePrice = childCastlePrice;
    }

    public static String getCastleName() {
        return castleName;
    }

    public static int getMinute() {
        return minute;
    }
}
