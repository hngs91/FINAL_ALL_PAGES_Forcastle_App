package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BoundDetails extends AppCompatActivity {

    TextView cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_details);

        cross = (TextView) findViewById(R.id.outCross);

        cross.setOnClickListener(view -> {
            Intent i = new Intent(BoundDetails.this, PaymentPage.class);
            startActivity(i);
        });
    }

}