package com.example.forcastle_app.DatabaseTeam;

public class TimeFormatters {

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

        if (minute < 10 && minute > 0) minuteString = "0" + minute;

        return hour + "h " + minuteString + "m";
    }

}
