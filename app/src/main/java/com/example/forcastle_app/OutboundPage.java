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
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;

import java.util.List;

public class OutboundPage extends AppCompatActivity {

    Toolbar outbound_toolbar;
    Button outbound_button1, outbound_button2, outbound_button3, outbound_button4, outbound_button5;
    TextView outbound1, outbound2, outbound3, outbound4, outbound5,
            directChange1, directChange2, directChange3, directChange4, directChange5,
            arrival1, arrival2, arrival3, arrival4, arrival5,
            travelTime1, travelTime2, travelTime3, travelTime4, travelTime5;
    int i = 0; //counter for setTextViews method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outbound_page);


        //sets departure, destination, & date based on data chosen by user
        ((TextView) findViewById(R.id.departure)).setText(BusJourney.getDepartureStationOut());
        ((TextView) findViewById(R.id.destination)).setText(BusJourney.getArrivalStationOut());
        ((TextView) findViewById(R.id.travelDate)).setText(BusJourney.getTravelDate());

        // setting variables to the correct buttons & TextViews on the app page
        outbound_toolbar = findViewById(R.id.outbound_toolbar);

        outbound_button1 = findViewById(R.id.outbound_button1);
        outbound_button2 = findViewById(R.id.outbound_button2);
        outbound_button3 = findViewById(R.id.outbound_button3);
        outbound_button4 = findViewById(R.id.outbound_button4);
        outbound_button5 = findViewById(R.id.outbound_button5);

        outbound1 = findViewById(R.id.outbound1);
        outbound2 = findViewById(R.id.outbound2);
        outbound3 = findViewById(R.id.outbound3);
        outbound4 = findViewById(R.id.outbound4);
        outbound5 = findViewById(R.id.outbound5);

        directChange1 = findViewById(R.id.directChange1);
        directChange2 = findViewById(R.id.directChange2);
        directChange3 = findViewById(R.id.directChange3);
        directChange4 = findViewById(R.id.directChange4);
        directChange5 = findViewById(R.id.directChange5);

        arrival1 = findViewById(R.id.arrival1);
        arrival2 = findViewById(R.id.arrival2);
        arrival3 = findViewById(R.id.arrival3);
        arrival4 = findViewById(R.id.arrival4);
        arrival5 = findViewById(R.id.arrival5);

        travelTime1 = findViewById(R.id.travelTime1);
        travelTime2 = findViewById(R.id.travelTime2);
        travelTime3 = findViewById(R.id.travelTime3);
        travelTime4 = findViewById(R.id.travelTime4);
        travelTime5 = findViewById(R.id.travelTime5);

        // pulling relevant times using database queries and storing results in Lists
        List<Integer> outboundTimeInt = DataBaseHelper.getInstance(getApplicationContext()).outboundTimeListInt(BusJourney.getTotalTime(), BusJourney.getJourney1());

        List<Integer> secondBusTimesTest = DataBaseHelper.getInstance(getApplicationContext()).outboundTimeListInt2(outboundTimeInt.get(0), BusJourney.getJourney2(), BusJourney.getJourneyTime1());

        Toast.makeText(this, String.valueOf(outboundTimeInt.get(0)) + "    " + BusJourney.getJourney2() + "    " + String.valueOf(BusJourney.getJourneyTime1()), Toast.LENGTH_SHORT).show();

        //populating the 5 time cards with relevant journeys
        setTextViews(outbound1, arrival1, travelTime1, directChange1, outboundTimeInt, i);
        setTextViews(outbound2, arrival2, travelTime2, directChange2, outboundTimeInt, i);
        setTextViews(outbound3, arrival3, travelTime3, directChange3, outboundTimeInt, i);
        setTextViews(outbound4, arrival4, travelTime4, directChange4, outboundTimeInt, i);
        setTextViews(outbound5, arrival5, travelTime5, directChange5, outboundTimeInt, i);


        outbound_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OutboundPage.this, FilterPage.class);
                startActivity(intent);
            }
        });

        // when a user selects their desired time card, relevant BusJourney variables are set to the selected data
        outbound_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusJourney.setOutboundTime1(outbound1.getText().toString());
                BusJourney.setArrivalTime(TimeDateFormatters.reverseTimeFormat(arrival1.getText().toString()));
                BusJourney.setTravelTime1(travelTime1.getText().toString());

                Intent intent = new Intent(OutboundPage.this, InboundPage.class);
                startActivity(intent);
            }
        });

        outbound_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusJourney.setOutboundTime1(outbound2.getText().toString());
                BusJourney.setArrivalTime(TimeDateFormatters.reverseTimeFormat(arrival2.getText().toString()));
                BusJourney.setTravelTime1(travelTime2.getText().toString());

                Intent intent = new Intent(OutboundPage.this, InboundPage.class);
                startActivity(intent);

            }
        });

        /**
         * button 3 onwards crashes app
         */

        outbound_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusJourney.setOutboundTime1(outbound3.getText().toString());
                BusJourney.setArrivalTime(TimeDateFormatters.reverseTimeFormat(arrival3.getText().toString()));
                BusJourney.setTravelTime1(travelTime3.getText().toString());

                Intent intent = new Intent(OutboundPage.this, InboundPage.class);
                startActivity(intent);
            }
        });

        outbound_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusJourney.setOutboundTime1(outbound4.getText().toString());
                BusJourney.setArrivalTime(TimeDateFormatters.reverseTimeFormat(arrival4.getText().toString()));
                BusJourney.setTravelTime1(travelTime4.getText().toString());

                Intent intent = new Intent(OutboundPage.this, InboundPage.class);
                startActivity(intent);
            }
        });

        outbound_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusJourney.setOutboundTime1(outbound5.getText().toString());
                BusJourney.setArrivalTime(TimeDateFormatters.reverseTimeFormat(arrival5.getText().toString()));
                BusJourney.setTravelTime1(travelTime5.getText().toString());

                Intent intent = new Intent(OutboundPage.this, InboundPage.class);
                startActivity(intent);
            }
        });

    }

    //shows the relevant journeys available based on time & destination the user has chosen
    public void setTextViews(TextView outbound, TextView arrival, TextView travelTime, TextView directChange, List<Integer> outboundTimeInt, int i) {
        if (BusJourney.getDirectChange().equals("Direct")) {
            // sets outbound button text to the relevant entry on the List<Integer>
            outbound.setText(TimeDateFormatters.timeFormat(outboundTimeInt.get(i)));

            // adds the duration of the bus journey to the outbound time to find the arrival time
            arrival.setText(TimeDateFormatters.timeFormat(outboundTimeInt.get(i) + BusJourney.getJourneyTime1()));

            // displays duration of journey
            travelTime.setText(TimeDateFormatters.durationFormat((BusJourney.getJourneyTime1())));

            // displays journey is direct
            directChange.setText(BusJourney.getDirectChange());
        } else {

            List<Integer> secondBusTimes = DataBaseHelper.getInstance(getApplicationContext()).outboundTimeListInt2(outboundTimeInt.get(i), BusJourney.getJourney2(), BusJourney.getJourneyTime1());

            int firstBusArrival = outboundTimeInt.get(i);

            // sets outbound button text to the relevant entry on the List<Integer>
            outbound.setText(TimeDateFormatters.timeFormat(firstBusArrival));

            int bus2Leave = secondBusTimes.get(0);

            int arrivalTime = bus2Leave + BusJourney.getJourneyTime2();

            arrival.setText(TimeDateFormatters.timeFormat(arrivalTime));

            travelTime.setText(TimeDateFormatters.durationFormat(arrivalTime - firstBusArrival));

            directChange.setText(BusJourney.getDirectChange());
        }
        this.i++;
    }

}
