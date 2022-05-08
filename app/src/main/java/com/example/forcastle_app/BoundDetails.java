package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BoundDetails extends AppCompatActivity {

    ImageView cross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_details);

        cross = findViewById(R.id.outCross);

        cross.setOnClickListener(view -> {
            Intent i = new Intent(BoundDetails.this, PaymentPage.class);
            startActivity(i);
        });
    }

}