package com.example.forcastle_app.DatabaseTeam;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BusJourney {

    private static String journey1, journey2,
            return1, return2,
            partOfWeek,
            operator1, operator2,
            busNo1, busNo2,
            outboundTime1, outboundTime2,
            inboundTime1, inboundTime2,
            departureStationOut, departureStationIn,
            arrivalStationOut, arrivalStationIn,
            travelDate,
            travelTime1, travelTime2,
            directChange;
    private static String dateTest;
    private static int hour = 0, minute = 0, totalTime, arrivalTime, returnTime;
    private static Integer journeyTime1, journeyTime2;

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
        setTravelTime(journeyTime1);
        directChange = hashMaps.getDirectChange().get(journey1);
        departureStationOut = hashMaps.getStation().get(journey1);
        arrivalStationOut = hashMaps.getStation().get(return1);
        departureStationIn = hashMaps.getStation().get(return1);
        arrivalStationIn = hashMaps.getStation().get(journey1);
    }

    public BusJourney() {
    }

    public static int getReturnTime() {
        return returnTime;
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

    public static String getDepartureStationIn() {
        return departureStationIn;
    }

    public static void setDepartureStationIn(String departureStationIn) {
        BusJourney.departureStationIn = departureStationIn;
    }

    public static String getArrivalStationIn() {
        return arrivalStationIn;
    }

    public static void setArrivalStationIn(String arrivalStationIn) {
        BusJourney.arrivalStationIn = arrivalStationIn;
    }

    public static String getDepartureStationOut() {
        return departureStationOut;
    }

    public static void setDepartureStationOut(String departureStationOut) {
        BusJourney.departureStationOut = departureStationOut;
    }

    public static String getArrivalStationOut() {
        return arrivalStationOut;
    }

    public static void setArrivalStationOut(String arrivalStationOut) {
        BusJourney.arrivalStationOut = arrivalStationOut;
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

    public static void setDirectChange(String directChange) {
        BusJourney.directChange = directChange;
    }

    public static String getTravelTime1() {
        return travelTime1;
    }

    public static void setTravelTime(int journeyTime) {

        int minute = journeyTime % 60;

        String minuteString = String.valueOf(minute);
        if (journeyTime < 10) minuteString = "0" + minute;

        int arrivalHour = (journeyTime - minute) / 60;

        BusJourney.travelTime1 = arrivalHour + "h " + minuteString + "m";
    }

    public static void setTravelTime2(int journeyTime1, int journeyTime2) {

        int journeyTime = journeyTime1 + journeyTime2;

        int minute = journeyTime % 60;

        String minuteString = String.valueOf(minute);
        if (journeyTime < 10) minuteString = "0" + minute;

        int arrivalHour = (journeyTime - minute) / 60;

        BusJourney.travelTime1 = arrivalHour + "h " + minuteString + "m";
    }


    public static void setJourneyTime1(Integer journeyTime1) {
        BusJourney.journeyTime1 = journeyTime1;
    }

    public static void setJourneyTime2(Integer journeyTime2) {
        BusJourney.journeyTime2 = journeyTime2;
    }

    public static String getTravelDate() {
        return travelDate;
    }

    public static void setTravelDate(int day, int month, int year) {

        String date = day + "/" + month + "/" + year;

        String monthName = getMonthFormat(month);

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

    public static String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        //DEFAULT
        return "JAN";
    }

    public static String getDateTest() {
        return dateTest;
    }

    public static void setDateTest(String dateTest) {
        BusJourney.dateTest = dateTest;
    }

    @NonNull
    @Override
    public String toString() {
        return "BusJourney{" +
                "journey1='" + journey1 + '\'' +
                ", journey2='" + journey2 + '\'' +
                ", return1='" + return1 + '\'' +
                ", return2='" + return2 + '\'' +
                ", dayOfWeek='" + partOfWeek + '\'' +
                ", operator1='" + operator1 + '\'' +
                ", operator2='" + operator2 + '\'' +
                ", busNo1='" + busNo1 + '\'' +
                ", busNo2='" + busNo2 + '\'' +
                ", hour=" + hour +
                ", minute=" + minute +
                '}';
    }

    public static String getJourney1() {
        return journey1;
    }

    public static void setJourney1(String journey1) {
        BusJourney.journey1 = journey1;
    }

    public static String getJourney2() {
        return journey2;
    }

    public static void setJourney2(String journey2) {
        BusJourney.journey2 = journey2;
    }

    public static String getReturn1() {
        return return1;
    }

    public static void setReturn1(String return1) {
        BusJourney.return1 = return1;
    }

    public static String getReturn2() {
        return return2;
    }

    public static void setReturn2(String return2) {
        BusJourney.return2 = return2;
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

        if (dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday")) {
            partOfWeek = "weekEnd";
        } else {
            partOfWeek = "weekDay";
        }
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

    public static String getOperator1() {
        return operator1;
    }

    public static void setOperator1(String operator1) {
        BusJourney.operator1 = operator1;
    }

    public static String getOperator2() {
        return operator2;
    }

    public static void setOperator2(String operator2) {
        BusJourney.operator2 = operator2;
    }

    public static String getBusNo1() {
        return busNo1;
    }

    public static void setBusNo1(String busNo1) {
        BusJourney.busNo1 = busNo1;
    }

    public static String getBusNo2() {
        return busNo2;
    }

    public static void setBusNo2(String busNo2) {
        BusJourney.busNo2 = busNo2;
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

    public static int getJourneyTime1() {
        return journeyTime1;
    }

    public static void setJourneyTime1(int journeyTime1) {
        BusJourney.journeyTime1 = journeyTime1;
    }

    public static int getJourneyTime2() {
        return journeyTime2;
    }

    public static void setJourneyTime2(int journeyTime2) {
        BusJourney.journeyTime2 = journeyTime2;
    }
}
