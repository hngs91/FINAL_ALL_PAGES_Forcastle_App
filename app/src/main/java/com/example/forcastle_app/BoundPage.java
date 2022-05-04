package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BoundPage extends AppCompatActivity {

    Toolbar outbound_toolbar;
    TextView headline;
    Button outbound_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_page);

        outbound_toolbar = findViewById(R.id.outbound_toolbar);
        headline = findViewById(R.id.headline);
        outbound_button = findViewById(R.id.outbound_button);

        outbound_toolbar.setNavigationOnClickListener(v -> {
            if ("1".equals(FilterPage.anchor)) {
                Intent intent = new Intent(BoundPage.this, FilterPage.class);
                startActivity(intent);
            } else if ("2".equals(FilterPage.anchor)) {
                FilterPage.anchor = "1";
                Intent intent = new Intent(BoundPage.this, BoundPage.class);
                startActivity(intent);
            }
        });

        outbound_button.setOnClickListener(v -> {
            if ("1".equals(FilterPage.anchor)) {
                FilterPage.anchor = "2";
                Intent intent = new Intent(BoundPage.this, BoundPage.class);
                startActivity(intent);
            } else if ("2".equals(FilterPage.anchor)) {
                Intent intent = new Intent(BoundPage.this, PaymentPage.class);
                startActivity(intent);
            }
        });

        if ("1".equals(FilterPage.anchor)) {
            headline.setText(R.string.outbound);
        } else if ("2".equals(FilterPage.anchor)) {
            headline.setText(R.string.inbound);
        }

    }

}
