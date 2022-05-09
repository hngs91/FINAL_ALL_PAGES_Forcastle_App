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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationPage extends AppCompatActivity {

    ImageView iv_map;
    EditText email;
    Button sendReceipt, backConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        RelativeLayout rlMap = findViewById(R.id.rl_map);
        iv_map = findViewById(R.id.iv_map);
        email = findViewById(R.id.email);
        sendReceipt = findViewById(R.id.sendReceipt);
        backConfirmation = findViewById(R.id.back_confirmation);

        iv_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.co.uk/maps/dir/Alnwick+Bus+station,+Alnwick/Alnwick+Castle,+Alnwick+NE66+1NQ/@55.4141255,-1.7103555,17z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x487e00de03bf75c1:0xe85d13952387d595!2m2!1d-1.7092082!2d55.4129015!1m5!1m1!1s0x487e00e0ed23bc0d:0x8783a98b290f641!2m2!1d-1.7059204!2d55.4155828!3e2 ");
            }
        });

        backConfirmation.setOnClickListener(new View.OnClickListener(){
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
        int screenWidth = getResources().getDisplayMetrics().widthPixels-dp2px(20);
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
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private int dp2px(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }

    private void sendEmail() {
        String mEmail = email.getText().toString();
        String mSubject = "Forcastle Journey Receipt";
        String mMessage = "Thank you for using the Forcastle app! \n" +
                "Booking reference: " + "829394 \n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Outbound: "+ "Newcastle " + "to " + "Alnwick\n" +
                "Departs: " + "12:00" + "at" + "Eldon Square\n" +
                "Bus service: " + "307\n" +
                "------------------------------------\n" +
                "Inbound: " + "Alnwick " + "to " + "Newcastle\n" +
                "Departs: " + "18:00" + "at" + "Alnwick\n" +
                "Bus service: " + "307\n" ;


        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mMessage, mSubject);
        javaMailAPI.execute();

        Toast.makeText(ConfirmationPage.this, "Receipt sent! Congratulations, you're going to Bamburgh", Toast.LENGTH_SHORT).show();

    }


}