package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;

import java.sql.Time;

/*
Code implemented by Zheng Yang & Harry Smith
 */
public class BoundDetails extends AppCompatActivity {

    TextView cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_details);

        cross = findViewById(R.id.outCross);

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

    public void populatingOutboundDetails() {
        if (BusJourney.getDirectChange().equals("Direct")) {
            // makes second journey layout not visible for direct journeys
            ((TextView) findViewById(R.id.outJourneyFromPop)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.outJourneyTo1Pop)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.journeyType1Pop)).setText(BusJourney.getDirectChange());
            ((TextView) findViewById(R.id.outFirstJourneyTime1)).setText(BusJourney.getOutboundTime1());
            ((TextView) findViewById(R.id.outFirstJourneyTime2)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeOut()));
            ((TextView) findViewById(R.id.outFirstJourneyDur)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes1()));
            ((TextView) findViewById(R.id.outFirstJourneyFromPop)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.outFirstJourneyTo)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.outTime1Pop)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes1()));

            ((TextView) findViewById(R.id.outChangeDur)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outChange)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyTime1)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyTime2)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyFrom)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyDur)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyTo)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outBusIcon2)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outRoute2)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyBus)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outDot1)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outDot2)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outDot3)).setVisibility(View.INVISIBLE);
        } else {
            ((TextView) findViewById(R.id.outJourneyFromPop)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.outJourneyTo1Pop)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.journeyType1Pop)).setText(BusJourney.getDirectChange());
            ((TextView) findViewById(R.id.outFirstJourneyTime1)).setText(BusJourney.getOutboundTime1());
            String firstJourneyArrivalTime = TimeDateFormatters.timeFormat((TimeDateFormatters.reverseTimeFormat(BusJourney.getOutboundTime1())) + BusJourney.getJourneyDurationTotalMinutes1());
            ((TextView) findViewById(R.id.outFirstJourneyTime2)).setText(firstJourneyArrivalTime);
            ((TextView) findViewById(R.id.outFirstJourneyDur)).setText(TimeDateFormatters.timeFormat(BusJourney.getJourneyDurationTotalMinutes1()));
            ((TextView) findViewById(R.id.outFirstJourneyFromPop)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.outFirstJourneyTo)).setText(BusJourney.getArrivalStationOut2());
            ((TextView) findViewById(R.id.outTime1Pop)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes1()));

            ((TextView) findViewById(R.id.outChangeDur)).setText(BusJourney.getChangeWaitOut());
            ((TextView) findViewById(R.id.outSecondJourneyTime1)).setText(BusJourney.getOutboundTime2());
            ((TextView) findViewById(R.id.outSecondJourneyTime2)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeOut()));
            ((TextView) findViewById(R.id.outSecondJourneyFrom)).setText(BusJourney.getDepartureStationOut2());
            ((TextView) findViewById(R.id.outSecondJourneyDur)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes2()));
            ((TextView) findViewById(R.id.outSecondJourneyTo)).setText(BusJourney.getArrivalStationOut1());
        }
    }

    public void populatingInboundDetails() {
        if (BusJourney.getDirectChange().equals("Direct")) {
            // makes second journey layout not visible for direct journeys
            ((TextView) findViewById(R.id.outJourneyFromPop)).setText(BusJourney.getDepartureStationIn1());
            ((TextView) findViewById(R.id.outJourneyTo1Pop)).setText(BusJourney.getArrivalStationIn1());
            ((TextView) findViewById(R.id.journeyType1Pop)).setText(BusJourney.getDirectChange());
            ((TextView) findViewById(R.id.outFirstJourneyTime1)).setText(BusJourney.getInboundTime1());
            ((TextView) findViewById(R.id.outFirstJourneyTime2)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeIn()));
            ((TextView) findViewById(R.id.outFirstJourneyDur)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes1()));
            ((TextView) findViewById(R.id.outFirstJourneyFromPop)).setText(BusJourney.getDepartureStationIn1());
            ((TextView) findViewById(R.id.outFirstJourneyTo)).setText(BusJourney.getArrivalStationIn1());
            ((TextView) findViewById(R.id.outTime1Pop)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes1()));

            ((TextView) findViewById(R.id.outChangeDur)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outChange)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyTime1)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyTime2)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyFrom)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyDur)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyTo)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outBusIcon2)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outRoute2)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outSecondJourneyBus)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outDot1)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outDot2)).setVisibility(View.INVISIBLE);
            ((TextView) findViewById(R.id.outDot3)).setVisibility(View.INVISIBLE);
        } else {
            ((TextView) findViewById(R.id.outJourneyFromPop)).setText(BusJourney.getDepartureStationIn1());
            ((TextView) findViewById(R.id.outJourneyTo1Pop)).setText(BusJourney.getArrivalStationIn1());
            ((TextView) findViewById(R.id.journeyType1Pop)).setText(BusJourney.getDirectChange());
            ((TextView) findViewById(R.id.outFirstJourneyTime1)).setText(BusJourney.getInboundTime1());
            String firstJourneyArrivalTime = TimeDateFormatters.timeFormat((TimeDateFormatters.reverseTimeFormat(BusJourney.getInboundTime1())) + BusJourney.getJourneyDurationTotalMinutes2());
            ((TextView) findViewById(R.id.outFirstJourneyTime2)).setText(firstJourneyArrivalTime);
            ((TextView) findViewById(R.id.outFirstJourneyDur)).setText(TimeDateFormatters.timeFormat(BusJourney.getJourneyDurationTotalMinutes2()));
            ((TextView) findViewById(R.id.outFirstJourneyFromPop)).setText(BusJourney.getDepartureStationIn1());
            ((TextView) findViewById(R.id.outFirstJourneyTo)).setText(BusJourney.getArrivalStationIn2());
            ((TextView) findViewById(R.id.outTime1Pop)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes2()));

            ((TextView) findViewById(R.id.outChangeDur)).setText(BusJourney.getChangeWaitIn());
            ((TextView) findViewById(R.id.outSecondJourneyTime1)).setText(BusJourney.getInboundTime2());
            ((TextView) findViewById(R.id.outSecondJourneyTime2)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeIn()));
            ((TextView) findViewById(R.id.outSecondJourneyFrom)).setText(BusJourney.getDepartureStationIn2());
            ((TextView) findViewById(R.id.outSecondJourneyDur)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyDurationTotalMinutes1()));
            ((TextView) findViewById(R.id.outSecondJourneyTo)).setText(BusJourney.getArrivalStationIn1());
        }
    }

}