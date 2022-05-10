package com.example.forcastle_app.DatabaseTeam;

/*
Code implemented by Harry Smith
 */
public class TimeDateFormatters {

    /*
    This class is a collection of formatting methods used to convert integers to time formats (e.g. HH:MM, HHh MMm) and vice versa
     */

    // takes a total number of minutes and converts it into a string of format hh:mm
    public static String timeFormat(int totalTime) {
        int minute = totalTime % 60;

        int hour = (totalTime - minute) / 60;

        String minuteString = String.valueOf(minute);

        if (minute < 10) minuteString = "0" + minute;

        return hour + ":" + minuteString;
    }

    // takes a String of format hh:mm and converts it into a total number of minutes as an int
    public static int reverseTimeFormat(String timeFormat) {

        String[] parts = timeFormat.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour * 60 + minute;
    }

    // takes a total number of minutes and formats it to the duration of the journey (00h 00m)
    public static String durationFormat(int totalTime) {
        int minute = totalTime % 60;

        int hour = (totalTime - minute) / 60;

        String minuteString = String.valueOf(minute);

        if (hour > 0 && minute < 10) minuteString = "0" + minute;

        String finalString;

        if (hour <= 0) {
            finalString = minuteString + "m";
        } else {
            finalString = hour + "h " + minuteString + "m";
        }

        return finalString;
    }

    // converts number of month to text of month
    public static String getMonthFormat(int month) {
        if (month == 1)
            return "Jan";
        if (month == 2)
            return "Feb";
        if (month == 3)
            return "Mar";
        if (month == 4)
            return "Apr";
        if (month == 5)
            return "May";
        if (month == 6)
            return "Jun";
        if (month == 7)
            return "Jul";
        if (month == 8)
            return "Aug";
        if (month == 9)
            return "Sep";
        if (month == 10)
            return "Oct";
        if (month == 11)
            return "Nov";
        if (month == 12)
            return "Dec";

        //DEFAULT
        return "Jan";
    }

    // converts a castle price stored as a string into a double. Used as the facilities pages stores castle entry prices as strings
    public static double getCastlePrice(String castlePrice) {
        String[] parts = castlePrice.split("£");

        return Double.parseDouble(parts[1]);
    }

}
