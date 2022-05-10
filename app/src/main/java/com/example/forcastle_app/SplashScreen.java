package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

/*
Code implemented by Eugenia Vuong
 */
public class SplashScreen extends AppCompatActivity {
    private static final int splashPageTimeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(SplashScreen.this, HomePage.class);
            startActivity(homeIntent);
            finish();
        },splashPageTimeout);

    }
}