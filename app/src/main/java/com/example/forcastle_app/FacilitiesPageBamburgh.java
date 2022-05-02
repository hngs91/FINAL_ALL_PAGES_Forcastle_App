package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FacilitiesPageBamburgh extends AppCompatActivity {

    Toolbar bamburgh_toolbar;
    Button bamburgh_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_page_bamburgh);

        bamburgh_toolbar = findViewById(R.id.bamburgh_toolbar);
        bamburgh_button = findViewById(R.id.bamburgh_button);

        bamburgh_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesPageBamburgh.this, HomePage.class);
                startActivity(intent);
            }
        });

        bamburgh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesPageBamburgh.this, FilterPage.class);
                startActivity(intent);
            }
        });

    }
}
