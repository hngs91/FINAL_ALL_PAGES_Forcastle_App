package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;

public class PaymentPage extends AppCompatActivity {

    TextView details1, details2;
    Button backPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        details1 = findViewById(R.id.details1);
        details2 = findViewById(R.id.details2);
        backPayment = findViewById(R.id.back_payment);

        //setting TextViews to user chosen journey data
        ((TextView) findViewById(R.id.JourneyFrom1)).setText(BusJourney.getDepartureStationOut());
        ((TextView) findViewById(R.id.JourneyTo1)).setText(BusJourney.getArrivalStationOut());
        ((TextView) findViewById(R.id.JourneyFrom2)).setText(BusJourney.getDepartureStationIn());
        ((TextView) findViewById(R.id.JourneyTo2)).setText(BusJourney.getArrivalStationIn());
        ((TextView) findViewById(R.id.journeyType1)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.journeyType2)).setText(BusJourney.getDirectChange());
        ((TextView) findViewById(R.id.confirmedDate)).setText(BusJourney.getTravelDate());
        ((TextView) findViewById(R.id.confirmDate2)).setText(BusJourney.getTravelDate());

        if (BusJourney.getDirectChange().equals("Direct")) {
            ((TextView) findViewById(R.id.time1)).setText(TimeDateFormatters.durationFormat((BusJourney.getJourneyTime1())));
        } else {
            ((TextView) findViewById(R.id.time1)).setText((BusJourney.getTravelTime1()));
        }

        if (BusJourney.getDirectChange().equals("Direct")) {
            ((TextView) findViewById(R.id.time2)).setText(TimeDateFormatters.durationFormat((BusJourney.getJourneyTime1())));
        } else {
            ((TextView) findViewById(R.id.time2)).setText((BusJourney.getTravelTime2()));
        }


        // add in if statement to send it to correct details page if journey is direct or 1 change
        details1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOutboundDetails();
            }
        });

        details2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInboundDetails();
            }
        });

        /*
        The method below should be uncommented once this code has been integrated with all the pages.
        the ClickListener will allow the backToTimeSelection() method to run (commented method below)
         */
        backPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToTimeSelection();
            }
        });

    }

    public void openOutboundDetails() {
        Intent intent = new Intent(PaymentPage.this, OutboundDetails.class);
        startActivity(intent);
    }

    public void openInboundDetails() {
        Intent intent = new Intent(PaymentPage.this, InboundDetails.class);
        startActivity(intent);
    }

    /*
    The backToTimeSelection() method should be uncommented and the InboundTimeSelection(page) should be renamed
    to the class of name of the outbound time selection page.
     */
    public void backToTimeSelection() {
        Intent intent = new Intent(PaymentPage.this, OutboundPage.class);
        startActivity(intent);
    }


    //this is the method to complete a horsepay transaction. The method gets the data and sends a JSONObject over request
    private void sendJSONObject(View view) throws IOException {
        TextView confirmedDate = (TextView) findViewById(R.id.confirmedDate);
        // TextView confirmedTime = (TextView) findViewById(R.id.timeID);

        String storeID = "team16";
        String customerID = "3784763";
        String date = confirmedDate.getText().toString();
        //String time = confirmedTime.getText().toString();
        String time = "14:00";
        String timeZone = "GMT";
        float transactionAmount = (float) 15.679;
        String currencyCode = "GBP";

        //create JSON object
        JSONObject requestObject = new JSONObject();
        try {
            requestObject.put("storeID", storeID);
            requestObject.put("customerID", customerID);
            requestObject.put("date", date);
            requestObject.put("time", time);
            requestObject.put("timeZone", timeZone);
            requestObject.put("transactionAmount", transactionAmount);
            requestObject.put("currencyCode", currencyCode);
            requestObject.put("forcePaymentSatusReturnType", true);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        String json = "{\"storeID\":1,\"name\":\"John\"}";
//        OkHttpClient client = new OkHttpClient();
//        RequestBody body = RequestBody.create( MediaType.parse("application/json"), json);
//        Request request = new Request.Builder()
//                .addHeader("Content-Type","application/json")
//                .url("http://homepages.cs.ncl.ac.uk/daniel.nesbitt/CSC8019/HorsePay/HorsePay.php")
//                .post(body)
//                .build();
//
//        okhttp3.Response response = client.newCall(request).execute();
    }


}