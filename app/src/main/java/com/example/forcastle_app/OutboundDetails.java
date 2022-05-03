package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;

public class OutboundDetails extends AppCompatActivity {

    TextView cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outbound_details);

        Toast.makeText(OutboundDetails.this, String.valueOf(BusJourney.getArrivalTime()), Toast.LENGTH_SHORT).show();

        cross = findViewById(R.id.outCross);

        /**
         * HARRY - expand if...else statement to cover both sections for 1 change journeys
          */


        if (BusJourney.getDirectChange().equals("Direct")) {
            // makes second journey layout not visible for direct journeys
            ((TextView) findViewById(R.id.outJourneyFromPop)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.outJourneyTo1Pop)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.journeyType1Pop)).setText(BusJourney.getDirectChange());
            ((TextView) findViewById(R.id.outFirstJourneyTime1)).setText(BusJourney.getOutboundTime1());
            ((TextView) findViewById(R.id.outFirstJourneyTime2)).setText(TimeDateFormatters.durationFormat(BusJourney.getArrivalTime()));
            ((TextView) findViewById(R.id.outFirstJourneyDur)).setText(TimeDateFormatters.timeFormat(BusJourney.getJourneyTime1()));
            ((TextView) findViewById(R.id.outFirstJourneyFromPop)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.outFirstJourneyTo)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.outTime1Pop)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyTime1()));

            ((TextView) findViewById(R.id.outChangeDur)).setText(null);
            ((TextView) findViewById(R.id.outChange)).setText(null);
            ((TextView) findViewById(R.id.outSecondJourneyTime1)).setText(null);
            ((TextView) findViewById(R.id.outSecondJourneyTime2)).setText(null);
            ((TextView) findViewById(R.id.outSecondJourneyFrom)).setText(null);
            ((TextView) findViewById(R.id.outSecondJourneyDur)).setText(null);
            ((TextView) findViewById(R.id.outSecondJourneyTo)).setText(null);
            ((TextView) findViewById(R.id.outBusIcon2)).setBackground(null);
            ((TextView) findViewById(R.id.outRoute2)).setBackground(null);
            ((TextView) findViewById(R.id.outSecondJourneyBus)).setText(null);
            ((TextView) findViewById(R.id.outDot1)).setBackground(null);
            ((TextView) findViewById(R.id.outDot2)).setBackground(null);
            ((TextView) findViewById(R.id.outDot3)).setBackground(null);
        } else {
            ((TextView) findViewById(R.id.outJourneyFromPop)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.outJourneyTo1Pop)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.journeyType1Pop)).setText(BusJourney.getDirectChange());
            ((TextView) findViewById(R.id.outFirstJourneyTime1)).setText(BusJourney.getOutboundTime1());
            String firstJourneyArrivalTime = TimeDateFormatters.timeFormat((TimeDateFormatters.reverseTimeFormat(BusJourney.getOutboundTime1())) + BusJourney.getJourneyTime1());
            ((TextView) findViewById(R.id.outFirstJourneyTime2)).setText(firstJourneyArrivalTime);
            ((TextView) findViewById(R.id.outFirstJourneyDur)).setText(TimeDateFormatters.timeFormat(BusJourney.getJourneyTime1()));
            ((TextView) findViewById(R.id.outFirstJourneyFromPop)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.outFirstJourneyTo)).setText(BusJourney.getArrivalStationOut2());
            ((TextView) findViewById(R.id.outTime1Pop)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyTime1()));

            ((TextView) findViewById(R.id.outChangeDur)).setText(BusJourney.getChangeWait());
            ((TextView) findViewById(R.id.outSecondJourneyTime1)).setText(BusJourney.getOutboundTime2());
            ((TextView) findViewById(R.id.outSecondJourneyTime2)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTime()));
            ((TextView) findViewById(R.id.outSecondJourneyFrom)).setText(BusJourney.getDepartureStationIn2());
            ((TextView) findViewById(R.id.outSecondJourneyDur)).setText(TimeDateFormatters.durationFormat(BusJourney.getJourneyTime2()));
            ((TextView) findViewById(R.id.outSecondJourneyTo)).setText(BusJourney.getArrivalStationOut1());
        }


        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToPayment();
            }
        });
    }

    public void backToPayment() {
        Intent i = new Intent(OutboundDetails.this, PaymentPage.class);
        startActivity(i);
    }
}