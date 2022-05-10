package com.example.forcastle_app;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.forcastle_app.DatabaseTeam.BusJourney;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
Code implemented by Eugenia Vuong & Harry Smith
 */

public class FilterPage extends AppCompatActivity {
    Button back, dateButton, bookTripButton;
    ImageView minus2, childMinus2, add1;
    TextView value1, value2, timer;
    int count1 = 1, count2 = 0, tHour, tMinute;
    DatePickerDialog datePickerDialog;
    String confirmedDate;
    String confirmedAdultTickets;
    String confirmedChildTickets;
    Boolean timerClicked = false;
    Boolean dateClicked = false;
    static String anchor = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_page);
        initDatePicker();

        setViews();

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerClicked = true;
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        FilterPage.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                                //initialise hour and minutes
                                tHour = hourOfDay;
                                tMinute = minute;
                                String time = tHour + ":" + tMinute;
                                SimpleDateFormat f24hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24hours.parse(time);
                                    //initialise 12 hour time format
              /*              SimpleDateFormat f24hours = new SimpleDateFormat(
                                    "hh:mm"
                            );*/
                                    timer.setText(f24hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 24, 0, true
                );
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(tHour, tMinute);
                timePickerDialog.show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        /* NEED TO ALTER PAGE NAME
        when user confirms the filter page details, the location, date, time and number of tickets should be
        presented on the confirmation page.
        */
        bookTripButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerClicked && dateClicked) {

                    //check all fields are complete
                    BusJourney.setNoAdultTickets(count1);
                    BusJourney.setNoChildTickets(count2);
                    Intent intent1 = new Intent(FilterPage.this, BoundPage.class);
                    confirmedDate = timer.getText().toString();
                    intent1.putExtra("confirmedDate", confirmedDate);
                    confirmedAdultTickets = value1.getText().toString();
                    intent1.putExtra("confirmedAdultTickets", confirmedAdultTickets);
                    confirmedChildTickets = value2.getText().toString();
                    intent1.putExtra("confirmedChildTickets", confirmedChildTickets);
                    intent1.putExtra("anchor", anchor);
                    startActivity(intent1);
                } else {
                    Toast.makeText(FilterPage.this, "Please confirm a date & time", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    /*
    The methods below are a series of method to provide functionality to the date picker
     */

    //this sets the initial date that is shown on the page to the current date that is it being used
    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    //this methods allows users to select the date and override the date to the new date that the user selects
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1; // so January is equal to 01
                dateClicked = true;
                //assigns busJourney as weekDay or weekend, needed when query database as different timetables for weekdays vs weekend
                BusJourney.setPartOfWeek(day + "/" + month + "/" + year);
                BusJourney.setTravelDate(day, month, year);
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
                dateClicked = true;
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    //prints the date in the format of DAY MONTH YEAR
    private String makeDateString(int day, int month, int year) {
        return day + " " + getMonthFormat(month) + " " + year;
    }

    //changes the month format to the first three letters of the month instead of numbers
    private String getMonthFormat(int month) {
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

    public void openDatePicker(View v) {
        datePickerDialog.show();
    }


    /*
    method for the back button --> once the back button is clicked,
    this takes the user to the next page.
     */
    public void openActivity2() {
        Intent intent = new Intent(this, FacilitiesPage.class);
        startActivity(intent);
    }

    //Increments adult ticket number
    public void increment1(View v) {
        if (count1 + count2 < 5) { //5 = capacity
            count1++;
            minus2.setImageResource(R.drawable.ic_minus_1);
            value1.setText("" + count1);
        } else {
            value1.setText("" + count1);
        }
    }

    //decrements ticket number
    public void decrement1(View v) {
        if (count1 <= 2) {
            minus2.setImageResource(R.drawable.ic_minus_2);
            count1 = 1;
        } else count1--;
        value1.setText("" + count1);
    }

    //Increments child ticket number
    public void increment2(View v) {
        if (count1 + count2 < 5) { //5 = capacity
            count2++;
            childMinus2.setImageResource(R.drawable.ic_minus_1);
            value2.setText("" + count2);
        } else {
            value2.setText("" + count2);
        }
    }

    //decrements child ticket number
    public void decrement2(View v) {
        if (count2 <= 1) {
            count2 = 0;
            childMinus2.setImageResource(R.drawable.ic_minus_2);
        } else count2--;
        value2.setText("" + count2);
    }

    public void setViews() {
        back = findViewById(R.id.back_button);
        dateButton = findViewById(R.id.datePickerButton);
        bookTripButton = findViewById(R.id.bookTripButton);
        dateButton.setText(getTodaysDate());
        value1 = findViewById(R.id.adultTickets);
        value2 = findViewById(R.id.childTickets);
        minus2 = findViewById(R.id.minus2);
        add1 = findViewById(R.id.add1);
        childMinus2 = findViewById(R.id.childMinus2);
        timer = findViewById(R.id.timer);

        //displays the departure station and destination castle in the "From" & "To" on the filter page
        ((TextView) findViewById(R.id.insertBusStop)).setText(BusJourney.getDepartureStationOut1());
        ((TextView) findViewById(R.id.insertCastle)).setText(BusJourney.getArrivalStationOut1());
    }

}