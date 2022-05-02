package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FacilitiesPageBarnard extends AppCompatActivity {

    Toolbar barnard_toolbar;
    Button barbard_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_page_barnard);

        barnard_toolbar = findViewById(R.id.barnard_toolbar);
        barbard_button = findViewById(R.id.barnard_button);

        barnard_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesPageBarnard.this, HomePage.class);
                startActivity(intent);
            }
        });

        barbard_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesPageBarnard.this, FilterPage.class);
                startActivity(intent);
            }
        });

    }
}
