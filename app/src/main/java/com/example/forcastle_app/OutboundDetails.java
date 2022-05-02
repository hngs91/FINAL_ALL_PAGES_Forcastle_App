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

        ((TextView) findViewById(R.id.outJourneyFromPop)).setText(BusJourney.getDepartureStationOut());
        ((TextView) findViewById(R.id.outJourneyTo1Pop)).setText(BusJourney.getArrivalStationOut());
        ((TextView) findViewById(R.id.journeyType1Pop)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.outFirstJourneyTime1)).setText(BusJourney.getOutboundTime1());
        ((TextView) findViewById(R.id.outFirstJourneyTime2)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTime()));

        /*((TextView) findViewById(R.id.outTime1Pop)).setText(TimeFormatters.durationFormat((BusJourney.getJourneyTime1())));
*/

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