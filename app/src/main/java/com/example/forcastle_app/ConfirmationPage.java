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
    double totalPrice = BusJourney.getNoAdultTickets() * (BusJourney.getAdultBusPrice() + BusJourney.getAdultCastlePrice()) +
            BusJourney.getNoChildTickets() * (BusJourney.getChildBusPrice() + BusJourney.getChildCastlePrice());
    String totalPricePrintOut = "Total Price £" + String.format(Locale.UK, "%.2f", totalPrice);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        setViews();

        RelativeLayout rlMap = findViewById(R.id.rl_map);

        if ("1".equals(HomePage.selectedCastle)) {
            iv_map.setImageResource(R.drawable.map_alnwick);
            castle.setText(R.string.alnwick);
            iv_map.setOnClickListener(view -> gotoUrl("https://www.google.co.uk/maps/dir/Alnwick+Bus+station,+Alnwick/Alnwick+Castle,+Alnwick+NE66+1NQ/@55.4141255,-1.7103555,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487e00de03bf75c1:0xe85d13952387d595!2m2!1d-1.7092082!2d55.4129015!1m5!1m1!1s0x487e00e0ed23bc0d:0x8783a98b290f641!2m2!1d-1.7059204!2d55.4155828!3e2 "));
        } else if ("2".equals(HomePage.selectedCastle)) {
            iv_map.setImageResource(R.drawable.map_auckland);
            castle.setText(R.string.auckland);
            iv_map.setOnClickListener(view -> gotoUrl("https://www.google.co.uk/maps/dir/Alnwick+Bus+station,+Alnwick/Alnwick+Castle,+Alnwick+NE66+1NQ/@55.4141255,-1.7103555,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487e00de03bf75c1:0xe85d13952387d595!2m2!1d-1.7092082!2d55.4129015!1m5!1m1!1s0x487e00e0ed23bc0d:0x8783a98b290f641!2m2!1d-1.7059204!2d55.4155828!3e2 "));
        } else if ("3".equals(HomePage.selectedCastle)) {
            iv_map.setImageResource(R.drawable.map_auckland);
            castle.setText(R.string.bamburgh);
            iv_map.setOnClickListener(view -> gotoUrl("https://www.google.co.uk/maps/dir/Alnwick+Bus+station,+Alnwick/Alnwick+Castle,+Alnwick+NE66+1NQ/@55.4141255,-1.7103555,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487e00de03bf75c1:0xe85d13952387d595!2m2!1d-1.7092082!2d55.4129015!1m5!1m1!1s0x487e00e0ed23bc0d:0x8783a98b290f641!2m2!1d-1.7059204!2d55.4155828!3e2 "));
        } else if ("4".equals(HomePage.selectedCastle)) {
            iv_map.setImageResource(R.drawable.map_auckland);
            castle.setText(R.string.barnard);
            iv_map.setOnClickListener(view -> gotoUrl("https://www.google.co.uk/maps/dir/Alnwick+Bus+station,+Alnwick/Alnwick+Castle,+Alnwick+NE66+1NQ/@55.4141255,-1.7103555,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487e00de03bf75c1:0xe85d13952387d595!2m2!1d-1.7092082!2d55.4129015!1m5!1m1!1s0x487e00e0ed23bc0d:0x8783a98b290f641!2m2!1d-1.7059204!2d55.4155828!3e2 "));
        }

        backConfirmation.setOnClickListener(view -> {
            Intent intent = new Intent(ConfirmationPage.this, PaymentPage.class);
            startActivity(intent);
        });

        sendReceipt.setOnClickListener(view -> sendEmail());

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