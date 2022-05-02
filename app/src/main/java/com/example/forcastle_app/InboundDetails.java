package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InboundDetails extends AppCompatActivity {

    TextView inCross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbound_details);

        inCross = (TextView) findViewById(R.id.inCross);

        inCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtoPayment2();
            }
        });
    }

    public void backtoPayment2() {
        Intent intent = new Intent(InboundDetails.this, PaymentPage.class);
        startActivity(intent);
    }
}