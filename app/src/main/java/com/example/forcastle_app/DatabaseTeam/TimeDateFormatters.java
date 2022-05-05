package com.example.forcastle_app.DatabaseTeam;

/*
Code implemented by Harry Smith
 */
public class TimeDateFormatters {

    public static String timeFormat(int totalTime) {
        int minute = totalTime % 60;

        int hour = (totalTime - minute) / 60;

        String minuteString = String.valueOf(minute);

        if (minute < 10) minuteString = "0" + minute;

        return hour + ":" + minuteString;
    }

    public static int reverseTimeFormat(String timeFormat) {

        String[] parts = timeFormat.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour * 60 + minute;
    }

    //used to format the duration of the journey to 00h 00m
    public static String durationFormat(int totalTime) {
        int minute = totalTime % 60;

        int hour = (totalTime - minute) / 60;

        String minuteString = String.valueOf(minute);

        if (hour > 0 && minute < 10) minuteString = "0" + minute;

        String finalString = "";

        if (hour <= 0) {
            finalString = minuteString + "m";
        } else {
            finalString = hour + "h " + minuteString + "m";
        }

        return finalString;
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

    public static double getCastlePrice(String castlePrice) {
        String[] parts = castlePrice.split("£");

        return Double.parseDouble(parts[1]);
    }

}
