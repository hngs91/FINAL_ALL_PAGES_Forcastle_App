package com.example.forcastle_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
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
Code implemented by Eugenia Vuong
 */
public class ConfirmationPage extends AppCompatActivity {

    ImageView iv_map;
    EditText email;
    Button sendReceipt, backConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        try {
            setViews();
        } catch (Exception e) {
            Toast.makeText(this, "setViews() broken", Toast.LENGTH_SHORT).show();
        }

        RelativeLayout rlMap = findViewById(R.id.rl_map);

        iv_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(BusJourney.getJourneyCode1().equals("NCALN")) gotoUrl("https://www.google.co.uk/maps/dir/Alnwick+Bus+station,+Alnwick/Alnwick+Castle,+Alnwick+NE66+1NQ/@55.4141255,-1.7103555,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487e00de03bf75c1:0xe85d13952387d595!2m2!1d-1.7092082!2d55.4129015!1m5!1m1!1s0x487e00e0ed23bc0d:0x8783a98b290f641!2m2!1d-1.7059204!2d55.4155828!3e2 ");
                if(BusJourney.getJourneyCode1().equals("NCAUK")) gotoUrl("https://www.google.co.uk/maps/dir/Bus+Station,+Bishop+Auckland/Auckland+Castle,+Market+Place,+Bishop+Auckland/@54.6654783,-1.6768747,17z/data=!4m14!4m13!1m5!1m1!1s0x487e823f6558141d:0xeacebd659320be06!2m2!1d-1.678785!2d54.664406!1m5!1m1!1s0x487e82382c8ee3d3:0xe85f1ebcc3cbec00!2m2!1d-1.670153!2d54.666712!3e2");
                if(BusJourney.getJourneyCode1().equals("NCBAM1")) gotoUrl("https://www.google.co.uk/maps/dir/The+Grove,+Bamburgh/Bamburgh+Castle,+Bamburgh/@55.6085361,-1.7149435,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x4880acff36c2244f:0x572764b0cc4ef936!2m2!1d-1.717214!2d55.607479!1m5!1m1!1s0x4880aea65a02c42f:0xfc42605b9141c368!2m2!1d-1.7099001!2d55.6089596!3e2");
                if(BusJourney.getJourneyCode1().equals("NCBAR1")) gotoUrl("https://www.google.co.uk/maps/dir/Galgate+-+Stand+A,+Barnard+Castle+DL12+8EQ/Barnard+Castle,+Flatts+Rd,+Scar+Top,+Barnard+Castle+DL12+8PR/@54.5441297,-1.9274279,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487c3b2c0acc98ad:0x655beee2e8d95f71!2m2!1d-1.924357!2d54.544777!1m5!1m1!1s0x487c3b2b9aeef005:0x8b39ac97907547bc!2m2!1d-1.9261214!2d54.5434564!3e2");
            }
        });

        backConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmationPage.this, PaymentPage.class);
                startActivity(intent);
            }
        });

        sendReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

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

    private void sendEmail() {
        String mEmail = email.getText().toString();
        String mSubject = "Forcastle Journey Receipt";
        String mMessage = "Thank you for using the Forcastle app! \n" +
                "Booking reference: " + "829394 \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Outbound: " + "Newcastle " + "to " + "Alnwick\n" +
                "Departs: " + "12:00" + "at" + "Eldon Square\n" +
                "Bus service: " + "307\n" +
                "------------------------------------\n" +
                "Inbound: " + "Alnwick " + "to " + "Newcastle\n" +
                "Departs: " + "18:00" + "at" + "Alnwick\n" +
                "Bus service: " + "307\n";

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);

        javaMailAPI.execute();
    }

    public void setViews() {
        iv_map = findViewById(R.id.iv_map);
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
        double totalPrice = BusJourney.getNoAdultTickets() * (BusJourney.getAdultBusPrice() + BusJourney.getAdultCastlePrice()) +
                BusJourney.getNoChildTickets() * (BusJourney.getChildBusPrice() + BusJourney.getChildCastlePrice());
        String totalPricePrintOut = "Total Price £" + String.format(Locale.UK, "%.2f", totalPrice);
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