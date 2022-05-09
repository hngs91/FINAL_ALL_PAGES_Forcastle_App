package com.example.forcastle_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/*
Code implemented by Eugenia Vuong
 */
public class SplashScreen extends AppCompatActivity {
    private static int splashPageTimeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreen.this, HomePage.class);
                startActivity(homeIntent);
                finish();
            }
        },splashPageTimeout); //display splash page for 2 seconds

    }
}