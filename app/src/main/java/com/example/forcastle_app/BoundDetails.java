package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;

/*
Code implemented by Zheng Yang & Harry Smith
 */
public class BoundDetails extends AppCompatActivity {

    ImageView cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_details);

        setViews();

        // PaymentPage.anchor controls if details for the outbound journey or inbound journey will be shown to the user
        if ("1".equals(PaymentPage.anchor)) {
            populatingOutboundDetails();
        } else {
            populatingInboundDetails();
        }

        cross.setOnClickListener(view -> {
            Intent i = new Intent(BoundDetails.this, PaymentPage.class);
            startActivity(i);
        });
    }

    // pulls all outbound journey details from the BusJourney object and displays to the user
    public void populatingOutboundDetails() {
        // To and from stations set
        ((TextView) findViewById(R.id.departureStationDetails)).setText(BusJourney.getDepartureStationOut1());
        ((TextView) findViewById(R.id.arrivalStationDetails)).setText(BusJourney.getArrivalStationOut1());
        ((TextView) findViewById(R.id.changeOrDirectDetails)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.firstJourneyDepartureStation)).setText(BusJourney.getDepartureStationOut1());
        ((TextView) findViewById(R.id.firstJourneyDepartureTime)).setText(BusJourney.getOutboundTime1());
        ((TextView) findViewById(R.id.overallJourneyTime)).setText(BusJourney.getTravelTime1());

        if (BusJourney.getDirectChange().equals("Direct")) {
            ((TextView) findViewById(R.id.firstJourneyArrivalStation)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.firstJourneyArrivalTime)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeOut()));
            ((TextView) findViewById(R.id.firstJourneyDurationDetails)).setText(BusJourney.getTravelTime1());

            // makes second journey layout not visible for direct journeys
            ((LinearLayout) findViewById(R.id.secondJourneyLayout)).setVisibility(View.INVISIBLE);
        } else {
            ((TextView) findViewById(R.id.firstJourneyArrivalStation)).setText(BusJourney.getArrivalStationIn2());
            String firstJourneyArrivalTime = TimeDateFormatters.timeFormat((TimeDateFormatters.reverseTimeFormat(BusJourney.getOutboundTime1())) + BusJourney.getJourneyDurationTotalMinutes1());
            ((TextView) findViewById(R.id.firstJourneyArrivalTime)).setText(firstJourneyArrivalTime);
            ((TextView) findViewById(R.id.firstJourneyDurationDetails)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes1()));
            String howLongWait = BusJourney.getChangeWaitOut() + " wait";
            ((TextView) findViewById(R.id.waitingTimeBetweenLegs)).setText(howLongWait);
            ((TextView) findViewById(R.id.secondJourneyDepartureStation)).setText(BusJourney.getDepartureStationIn2());
            ((TextView) findViewById(R.id.secondJourneyArrivalStation)).setText(BusJourney.getDepartureStationIn1());
            ((TextView) findViewById(R.id.secondJourneyDepartureTime)).setText(BusJourney.getOutboundTime2());
            ((TextView) findViewById(R.id.secondJourneyArrivalTime)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeOut()));
            ((TextView) findViewById(R.id.secondJourneyDurationDetails)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes2()));
        }
    }

    // pulls all inbound journey details from the BusJourney object and displays to the user
    public void populatingInboundDetails() {
        ((TextView) findViewById(R.id.firstJourneyDepartureTime)).setText(BusJourney.getInboundTime1());
        ((TextView) findViewById(R.id.departureStationDetails)).setText(BusJourney.getDepartureStationIn1());
        ((TextView) findViewById(R.id.arrivalStationDetails)).setText(BusJourney.getArrivalStationIn1());
        ((TextView) findViewById(R.id.changeOrDirectDetails)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.overallJourneyTime)).setText((BusJourney.getTravelTime2()));
        ((TextView) findViewById(R.id.firstJourneyDepartureStation)).setText(BusJourney.getDepartureStationIn1());

        if (BusJourney.getDirectChange().equals("Direct")) {
            ((TextView) findViewById(R.id.firstJourneyArrivalStation)).setText(BusJourney.getArrivalStationIn1());
            ((TextView) findViewById(R.id.firstJourneyArrivalTime)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeIn()));
            ((TextView) findViewById(R.id.firstJourneyDurationDetails)).setText(BusJourney.getTravelTime1());

            // makes second journey layout not visible for direct journeys
            ((LinearLayout) findViewById(R.id.secondJourneyLayout)).setVisibility(View.INVISIBLE);

        } else {
            ((TextView) findViewById(R.id.firstJourneyArrivalStation)).setText(BusJourney.getDepartureStationIn2());
            String firstJourneyArrivalTime = TimeDateFormatters.timeFormat((TimeDateFormatters.reverseTimeFormat(BusJourney.getInboundTime1())) + BusJourney.getJourneyDurationTotalMinutes2());
            ((TextView) findViewById(R.id.firstJourneyArrivalTime)).setText(firstJourneyArrivalTime);
            ((TextView) findViewById(R.id.firstJourneyDurationDetails)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes2()));
            String howLongWait = BusJourney.getChangeWaitIn() + " wait";
            ((TextView) findViewById(R.id.waitingTimeBetweenLegs)).setText(howLongWait);
            ((TextView) findViewById(R.id.secondJourneyDepartureStation)).setText(BusJourney.getArrivalStationIn2());
            ((TextView) findViewById(R.id.secondJourneyArrivalStation)).setText(BusJourney.getArrivalStationIn1());
            ((TextView) findViewById(R.id.secondJourneyDepartureTime)).setText(BusJourney.getInboundTime2());
            ((TextView) findViewById(R.id.secondJourneyArrivalTime)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeIn()));
            ((TextView) findViewById(R.id.secondJourneyDurationDetails)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes1()));
        }
    }

    public void setViews() {
        cross = findViewById(R.id.outCross);
    }

}