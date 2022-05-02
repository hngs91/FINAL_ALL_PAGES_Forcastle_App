package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.DataBaseHelper;
import com.example.forcastle_app.DatabaseTeam.TimeFormatters;

import java.util.List;

public class InboundPage extends AppCompatActivity {

    Toolbar inbound_toolbar;
    Button inbound_button1, inbound_button2, inbound_button3, inbound_button4, inbound_button5;
    TextView inbound1, inbound2, inbound3, inbound4, inbound5,
            directChangeIn1, directChangeIn2, directChangeIn3, directChangeIn4, directChangeIn5,
            arrivalIn1, arrivalIn2, arrivalIn3, arrivalIn4, arrivalIn5,
            travelTimeIn1, travelTimeIn2, travelTimeIn3, travelTimeIn4, travelTimeIn5;
    int i = 0; //counter for setTextViews method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbound_page);

        //sets departure, destination, & date based on data chosen by user
        ((TextView) findViewById(R.id.departureIn)).setText(BusJourney.getDepartureStationIn());
        ((TextView) findViewById(R.id.destinationIn)).setText(BusJourney.getArrivalStationIn());
        ((TextView) findViewById(R.id.travelDateIn)).setText(BusJourney.getTravelDate());

        // setting variables to the correct buttons & TextViews on the apps page
        inbound_toolbar = findViewById(R.id.inbound_toolbar);

        inbound_button1 = findViewById(R.id.inbound_button1);
        inbound_button2 = findViewById(R.id.inbound_button2);
        inbound_button3 = findViewById(R.id.inbound_button3);
        inbound_button4 = findViewById(R.id.inbound_button4);
        inbound_button5 = findViewById(R.id.inbound_button5);

        inbound1 = findViewById(R.id.inbound1);
        inbound2 = findViewById(R.id.inbound2);
        inbound3 = findViewById(R.id.inbound3);
        inbound4 = findViewById(R.id.inbound4);
        inbound5 = findViewById(R.id.inbound5);

        directChangeIn1 = findViewById(R.id.DirectChangeIn1);
        directChangeIn2 = findViewById(R.id.DirectChangeIn2);
        directChangeIn3 = findViewById(R.id.DirectChangeIn3);
        directChangeIn4 = findViewById(R.id.DirectChangeIn4);
        directChangeIn5 = findViewById(R.id.DirectChangeIn5);

        arrivalIn1 = findViewById(R.id.arrivalIn1);
        arrivalIn2 = findViewById(R.id.arrivalIn2);
        arrivalIn3 = findViewById(R.id.arrivalIn3);
        arrivalIn4 = findViewById(R.id.arrivalIn4);
        arrivalIn5 = findViewById(R.id.arrivalIn5);

        travelTimeIn1 = findViewById(R.id.travelTimeIn1);
        travelTimeIn2 = findViewById(R.id.travelTimeIn2);
        travelTimeIn3 = findViewById(R.id.travelTimeIn3);
        travelTimeIn4 = findViewById(R.id.travelTimeIn4);
        travelTimeIn5 = findViewById(R.id.travelTimeIn5);

        List<Integer> inboundTimeInt;
        // pulling relevant times using database queries and storing results in Lists
        if (BusJourney.getDirectChange().equals("Direct")) {
            inboundTimeInt = DataBaseHelper.getInstance(getApplicationContext()).outboundTimeListInt(BusJourney.getArrivalTime() + 120, BusJourney.getReturn1());
        } else {
            inboundTimeInt = DataBaseHelper.getInstance(getApplicationContext()).outboundTimeListInt(BusJourney.getArrivalTime() + 120, BusJourney.getReturn2());
        }
        //populating the 5 time cards with relevant journeys
        setTextViews(inbound1, arrivalIn1, travelTimeIn1, directChangeIn1, inboundTimeInt, i);
        setTextViews(inbound2, arrivalIn2, travelTimeIn2, directChangeIn2, inboundTimeInt, i);
        setTextViews(inbound3, arrivalIn3, travelTimeIn3, directChangeIn3, inboundTimeInt, i);
        setTextViews(inbound4, arrivalIn4, travelTimeIn4, directChangeIn4, inboundTimeInt, i);
        setTextViews(inbound5, arrivalIn5, travelTimeIn5, directChangeIn5, inboundTimeInt, i);


        inbound_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InboundPage.this, OutboundPage.class);
                startActivity(intent);
            }
        });

        inbound_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusJourney.setOutboundTime2(inbound1.getText().toString());
                BusJourney.setReturnTime(TimeFormatters.reverseTimeFormat(arrivalIn1.getText().toString()));
                BusJourney.setTravelTime2(travelTimeIn1.getText().toString());

                Intent intent = new Intent(InboundPage.this, PaymentPage.class);
                startActivity(intent);
            }
        });

    }


    //shows the relevant journeys available based on time & destination the user has chosen
    public void setTextViews(TextView outbound, TextView arrival, TextView travelTime, TextView directChange, List<Integer> inboundTimeInt, int i) {
        if (BusJourney.getDirectChange().equals("Direct")) {
            outbound.setText(TimeFormatters.timeFormat(inboundTimeInt.get(i)));
            int arrivalTime = BusJourney.getJourneyTime1() + inboundTimeInt.get(i);
            BusJourney.setReturnTime(arrivalTime);
            arrival.setText(TimeFormatters.timeFormat(arrivalTime));

            travelTime.setText(TimeFormatters.durationFormat((BusJourney.getJourneyTime1())));
            directChange.setText(BusJourney.getDirectChange());
        } else {
            try {
                outbound.setText(TimeFormatters.timeFormat(inboundTimeInt.get(i)));
                int bus2Leave = DataBaseHelper.getInstance(getApplicationContext()).outboundTimeListInt2(inboundTimeInt.get(i), BusJourney.getReturn1(), BusJourney.getJourneyTime2()).get(0);
                int arrivalTime = bus2Leave + BusJourney.getJourneyTime1();
                BusJourney.setReturnTime(arrivalTime);
                arrival.setText(TimeFormatters.timeFormat(arrivalTime));
                travelTime.setText(TimeFormatters.durationFormat(arrivalTime - inboundTimeInt.get(i)));
                directChange.setText(BusJourney.getDirectChange());
            } catch (Exception e) {
                Toast.makeText(this, "1 change return broken", Toast.LENGTH_SHORT).show();
            }
        }
        this.i++;
    }

}