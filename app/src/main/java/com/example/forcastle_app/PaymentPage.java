package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;
/*
Code implemented by Eugenia Vuong, Zheng Yang, & Harry Smith
 */
public class PaymentPage extends AppCompatActivity {

    TextView details1, details2;
    Button backPayment, payButton;
    static String anchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        String tickets = "Adult: " + BusJourney.getNoAdultTickets() + "\nChildren: " + BusJourney.getNoChildTickets();

        Toast.makeText(this, tickets, Toast.LENGTH_LONG).show();

        setViews();

        if (BusJourney.getDirectChange().equals("Direct")) {
            ((TextView) findViewById(R.id.time1)).setText(TimeDateFormatters.durationFormat((BusJourney.getJourneyDurationTotalMinutes1())));
        } else {
            ((TextView) findViewById(R.id.time1)).setText((BusJourney.getTravelTime1()));
        }

        if (BusJourney.getDirectChange().equals("Direct")) {
            ((TextView) findViewById(R.id.time2)).setText(TimeDateFormatters.durationFormat((BusJourney.getJourneyDurationTotalMinutes1())));
        } else {
            ((TextView) findViewById(R.id.time2)).setText((BusJourney.getTravelTime2()));
        }


        // add in if statement to send it to correct details page if journey is direct or 1 change
        details1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anchor = "1";
                Intent intent = new Intent(PaymentPage.this, BoundDetails.class);
                startActivity(intent);
            }
        });

        details2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anchor = "2";
                Intent intent = new Intent(PaymentPage.this, BoundDetails.class);
                startActivity(intent);
            }
        });

        /*
        The method below should be uncommented once this code has been integrated with all the pages.
        the ClickListener will allow the backToTimeSelection() method to run (commented method below)
         */
        backPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentPage.this, BoundPage.class);
                startActivity(intent);
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentPage.this, ConfirmationPage.class);
                startActivity(intent);
            }
        });
    }
    public void setViews() {
        details1 = findViewById(R.id.details1);
        details2 = findViewById(R.id.details2);
        backPayment = findViewById(R.id.back_payment);
        payButton = (Button) findViewById(R.id.payButton);

        //setting TextViews to user chosen journey data
        ((TextView) findViewById(R.id.JourneyFrom1)).setText(BusJourney.getDepartureStationOut1());
        ((TextView) findViewById(R.id.JourneyTo1)).setText(BusJourney.getArrivalStationOut1());
        ((TextView) findViewById(R.id.JourneyFrom2)).setText(BusJourney.getDepartureStationIn1());
        ((TextView) findViewById(R.id.JourneyTo2)).setText(BusJourney.getArrivalStationIn1());
        ((TextView) findViewById(R.id.journeyType1)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.journeyType2)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.confirmedDate)).setText(BusJourney.getTravelDate());
        ((TextView) findViewById(R.id.confirmDate2)).setText(BusJourney.getTravelDate());
    }
}