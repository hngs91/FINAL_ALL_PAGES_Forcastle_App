package com.example.forcastle_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;

import java.util.Locale;

/*
Code implemented by Eugenia Vuong, Zheng Yang & Harry Smith
 */
public class ConfirmationPage extends AppCompatActivity {

    ImageView iv_map;
    TextView castle;
    EditText email;
    Button sendReceipt, backConfirmation;

    // calculates the total cost of the jounrney including bus & castle tickets
    double totalPrice = BusJourney.getNoAdultTickets() * (BusJourney.getAdultBusPrice() + BusJourney.getAdultCastlePrice()) +
            BusJourney.getNoChildTickets() * (BusJourney.getChildBusPrice() + BusJourney.getChildCastlePrice());

    // converts to double totalPrice into a String to be included in the email to the user
    String totalPricePrintOut = "Total Price £" + String.format(Locale.UK, "%.2f", totalPrice);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        setViews();

        RelativeLayout rlMap = findViewById(R.id.rl_map);

        // dictates which map is shown to the user giving directions from the bus stop to the castle, only the relevant map is shown to the users
        if ("1".equals(HomePage.selectedCastle)) {
            iv_map.setImageResource(R.drawable.map_alnwick);
            castle.setText(R.string.alnwick);
            iv_map.setOnClickListener(view -> gotoUrl("https://www.google.co.uk/maps/dir/Alnwick+Bus+station,+Alnwick/Alnwick+Castle,+Alnwick+NE66+1NQ/@55.4141255,-1.7103555,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487e00de03bf75c1:0xe85d13952387d595!2m2!1d-1.7092082!2d55.4129015!1m5!1m1!1s0x487e00e0ed23bc0d:0x8783a98b290f641!2m2!1d-1.7059204!2d55.4155828!3e2"));
        } else if ("2".equals(HomePage.selectedCastle)) {
            iv_map.setImageResource(R.drawable.map_auckland);
            castle.setText(R.string.auckland);
            iv_map.setOnClickListener(view -> gotoUrl("https://www.google.co.uk/maps/dir/Bus+Station,+Bishop+Auckland/Auckland+Castle,+Market+Place,+Bishop+Auckland/@54.6654783,-1.6768747,17z/data=!4m14!4m13!1m5!1m1!1s0x487e823f6558141d:0xeacebd659320be06!2m2!1d-1.678785!2d54.664406!1m5!1m1!1s0x487e82382c8ee3d3:0xe85f1ebcc3cbec00!2m2!1d-1.670153!2d54.666712!3e2"));
        } else if ("3".equals(HomePage.selectedCastle)) {
            iv_map.setImageResource(R.drawable.map_bamburgh);
            castle.setText(R.string.bamburgh);
            iv_map.setOnClickListener(view -> gotoUrl("https://www.google.co.uk/maps/dir/The+Grove,+Bamburgh/Bamburgh+Castle,+Bamburgh/@55.6085361,-1.7149435,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x4880acff36c2244f:0x572764b0cc4ef936!2m2!1d-1.717214!2d55.607479!1m5!1m1!1s0x4880aea65a02c42f:0xfc42605b9141c368!2m2!1d-1.7099001!2d55.6089596!3e2"));
        } else if ("4".equals(HomePage.selectedCastle)) {
            iv_map.setImageResource(R.drawable.map_barnard);
            castle.setText(R.string.barnard);
            iv_map.setOnClickListener(view -> gotoUrl("https://www.google.co.uk/maps/dir/Galgate+-+Stand+A,+Barnard+Castle+DL12+8EQ/Barnard+Castle,+Flatts+Rd,+Scar+Top,+Barnard+Castle+DL12+8PR/@54.5441297,-1.9274279,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487c3b2c0acc98ad:0x655beee2e8d95f71!2m2!1d-1.924357!2d54.544777!1m5!1m1!1s0x487c3b2b9aeef005:0x8b39ac97907547bc!2m2!1d-1.9261214!2d54.5434564!3e2"));
        }

        // allows users to return to the previous page
        backConfirmation.setOnClickListener(view -> {
            Intent intent = new Intent(ConfirmationPage.this, PaymentPage.class);
            startActivity(intent);
        });

        // allows user to enter their email address and be sent an itinerary
        sendReceipt.setOnClickListener(view -> sendEmail());


        // dictates to dimensions of the map as it appears on the page to the user
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.map);

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int screenWidth = getResources().getDisplayMetrics().widthPixels - dp2px(20);
        float ivMapHeight = height * (1f * screenWidth / width);
        Log.d("TAG", "height: " + height);
        Log.d("TAG", "width: " + width);
        Log.d("TAG", "screenWidth: " + screenWidth);
        Log.d("TAG", "ivMapHeight: " + ivMapHeight);
        ViewGroup.LayoutParams rlMapLayoutParams = rlMap.getLayoutParams();
        ViewGroup.LayoutParams ivMapLayoutParams = iv_map.getLayoutParams();
        ivMapLayoutParams.height = (int) ivMapHeight;
        rlMapLayoutParams.height = (int) ivMapHeight;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private int dp2px(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }

    // formats the email message and sends to the user
    private void sendEmail() {
        String mEmail = email.getText().toString();
        String mSubject = "Forcastle Journey Receipt";
        String mMessageDirect = "Thank you for using the Forcastle app! \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Outbound: " + "Newcastle" + " to " + BusJourney.getCastleName() + "\n" +
                "Departs: " + BusJourney.getOutboundTime1() + " from " + BusJourney.getDepartureStationOut1() + "\n" +
                "Bus service: " + BusJourney.getBusNo1() + "\n"+
                "-------------------------------------\n" +
                "Inbound: " + BusJourney.getCastleName() + " to " + "Newcastle\n" +
                "Departs: " + BusJourney.getInboundTime1() + " at " + BusJourney.getDepartureStationIn1() + "\n" +
                "Bus service: " + BusJourney.getBusNo1() + "\n" +
                "-------------------------------------\n" +
                "Total PriceL " + totalPricePrintOut;

        String mMessageChange = "Thank you for using the Forcastle app! \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Outbound: " + "Newcastle" + " to " + BusJourney.getCastleName() + "\n" +
                "Departs: " + BusJourney.getOutboundTime1() + " from " + BusJourney.getDepartureStationOut1() + "\n" +
                "Bus service: " + BusJourney.getBusNo1() + " and " + BusJourney.getBusNo2() + "\n"+
                "-------------------------------------\n" +
                "Inbound: " + BusJourney.getCastleName() + " to " + "Newcastle\n" +
                "Departs: " + BusJourney.getInboundTime1() + "at" + BusJourney.getDepartureStationIn1() + "\n" +
                "Bus service: " + BusJourney.getBusNo2() + " and " + BusJourney.getBusNo1() + "\n" +
                "-------------------------------------\n" +
                "Total Price " + totalPricePrintOut;


        String emailSent;
        if(BusJourney.getDirectChange().equals("Direct")) {
            emailSent = mMessageDirect;
        } else {
            emailSent = mMessageChange;
        }

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, emailSent);

        javaMailAPI.execute();

        Toast.makeText(this, "Please check your inbox for your itinerary", Toast.LENGTH_LONG).show();
    }

    public void setViews() {
        iv_map = findViewById(R.id.iv_map);
        castle = findViewById(R.id.castle);
        email = findViewById(R.id.email);
        sendReceipt = findViewById(R.id.sendReceipt);
        backConfirmation = findViewById(R.id.back_confirmation);


        ((TextView) findViewById(R.id.outboundStation1)).setText(BusJourney.getDepartureStationOut1());
        ((TextView) findViewById(R.id.outboundTime1)).setText(BusJourney.getOutboundTime1());
        ((TextView) findViewById(R.id.outboundArrivalTime1)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeOut()));
        ((TextView) findViewById(R.id.inboundArrivalStation1)).setText(BusJourney.getDepartureStationOut1());
        ((TextView) findViewById(R.id.dateOfTravel)).setText(BusJourney.getTravelDate());

        // setting number of tickets
        String totalTicketsString = BusJourney.getNoAdultTickets() + " adult\n" + BusJourney.getNoChildTickets() + " child";
        ((TextView) findViewById(R.id.numberOfTickets)).setText((totalTicketsString));

        // calculating & setting total price
        ((TextView) findViewById(R.id.totalOverallPrice)).setText(totalPricePrintOut);
        ((TextView) findViewById(R.id.inboundTime1)).setText(BusJourney.getInboundTime1());
        ((TextView) findViewById(R.id.inboundArrivalTime1)).setText(TimeDateFormatters.timeFormat(BusJourney.getArrivalTimeIn()));

        if (BusJourney.getDirectChange().equals("Direct")) {
            ((TextView) findViewById(R.id.inboundStation1)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.inboundArrivalStation1)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.busNumber)).setText(BusJourney.getBusNo1());
            ((TextView) findViewById(R.id.operator)).setText(BusJourney.getOperator1());
        } else {
            ((TextView) findViewById(R.id.outboundArrivalStation1)).setText(BusJourney.getArrivalStationOut1());
            ((TextView) findViewById(R.id.inboundStation1)).setText(BusJourney.getArrivalStationOut1());
            String buses = BusJourney.getBusNo1() + "\n" + BusJourney.getBusNo2();
            ((TextView) findViewById(R.id.busNumber)).setText(buses);
            String operators = BusJourney.getOperator1() + "\n " + BusJourney.getOperator2();
            ((TextView) findViewById(R.id.operator)).setText(operators);
        }
    }
}