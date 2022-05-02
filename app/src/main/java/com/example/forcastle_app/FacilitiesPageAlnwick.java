package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FacilitiesPageAlnwick extends AppCompatActivity {

    Toolbar alnwick_toolbar;
    Button alnwick_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_page_alnwick);

        alnwick_toolbar = findViewById(R.id.alnwick_toolbar);
        alnwick_button = findViewById(R.id.alnwick_button);

        alnwick_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesPageAlnwick.this, HomePage.class);
                startActivity(intent);
            }
        });

        alnwick_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesPageAlnwick.this, FilterPage.class);
                startActivity(intent);
            }
        });

    }

}
