package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FacilitiesPageAuckland extends AppCompatActivity {

    Toolbar auckland_toolbar;
    Button auckland_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_page_auckland);

        auckland_toolbar = findViewById(R.id.auckland_toolbar);
        auckland_button = findViewById(R.id.auckland_button);

        auckland_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesPageAuckland.this, HomePage.class);
                startActivity(intent);
            }
        });

        auckland_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesPageAuckland.this, FilterPage.class);
                startActivity(intent);
            }
        });

    }
}
