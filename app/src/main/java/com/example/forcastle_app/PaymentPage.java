package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;
import java.util.Locale;

/*
Code implemented by Eugenia Vuong, Zheng Yang, & Harry Smith
 */
public class PaymentPage extends AppCompatActivity {

    TextView details1, details2;
    Button payButton;
    Toolbar backPayment;
    static String anchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        setViews();

        // shows correct journey duration based on if it is a direct journey or a 1-change journey
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


        // the value of the anchor dictates if outbound journey details are shown or inbound journey details are shown
        details1.setOnClickListener(view -> {
            anchor = "1";
            Intent intent = new Intent(PaymentPage.this, BoundDetails.class);
            startActivity(intent);
        });

        details2.setOnClickListener(view -> {
            anchor = "2";
            Intent intent = new Intent(PaymentPage.this, BoundDetails.class);
            startActivity(intent);
        });

        // allows users to navigate back to the outbound bus times page
        backPayment.setOnClickListener(view -> {
            Intent intent = new Intent(PaymentPage.this, BoundPage.class);
            startActivity(intent);
        });

        // allows users to continue to the Confirmation page
        payButton.setOnClickListener(view -> {
            Intent intent = new Intent(PaymentPage.this, ConfirmationPage.class);
            startActivity(intent);
        });
    }

    public void setViews() {
        details1 = findViewById(R.id.details1);
        details2 = findViewById(R.id.details2);
        backPayment = findViewById(R.id.toolbar);
        payButton = findViewById(R.id.payButton);


        //setting TextViews to user chosen journey data
        ((TextView) findViewById(R.id.JourneyFrom1)).setText(BusJourney.getDepartureStationOut1());
        ((TextView) findViewById(R.id.JourneyTo1)).setText(BusJourney.getArrivalStationOut1());
        ((TextView) findViewById(R.id.JourneyFrom2)).setText(BusJourney.getDepartureStationIn1());
        ((TextView) findViewById(R.id.JourneyTo2)).setText(BusJourney.getArrivalStationIn1());
        ((TextView) findViewById(R.id.journeyType1)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.journeyType2)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.confirmedDate)).setText(BusJourney.getTravelDate());
        ((TextView) findViewById(R.id.confirmDate2)).setText(BusJourney.getTravelDate());
        ((TextView) findViewById(R.id.confirmedAdultTickets)).setText(String.valueOf(BusJourney.getNoAdultTickets()));
        ((TextView) findViewById(R.id.confirmedChildTickets)).setText(String.valueOf(BusJourney.getNoChildTickets()));

        //calculating, formatting, and setting Price TextViews
        double totalAdultPrice = BusJourney.getNoAdultTickets() * (BusJourney.getAdultBusPrice() + BusJourney.getAdultCastlePrice());
        double totalChildPrice = BusJourney.getNoChildTickets() * (BusJourney.getChildBusPrice() + BusJourney.getChildCastlePrice());
        double overallPrice = totalAdultPrice + totalChildPrice;
        String adultPrice = "£" + String.format(Locale.UK, "%.2f", totalAdultPrice);
        String childPrice = "£" + String.format(Locale.UK, "%.2f", totalChildPrice);
        String totalPrice = "£" + String.format(Locale.UK, "%.2f", overallPrice);
        ((TextView) findViewById(R.id.adultPrice)).setText(adultPrice);
        ((TextView) findViewById(R.id.childPrice)).setText(childPrice);
        ((TextView) findViewById(R.id.totalPrice)).setText(totalPrice);
        ((TextView) findViewById(R.id.priceFinal)).setText(totalPrice);
    }
}