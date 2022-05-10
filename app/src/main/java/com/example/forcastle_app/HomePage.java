package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.forcastle_app.DatabaseTeam.BusJourney;
/*
Code implemented by Eugenia Vuong, Zheng Yang, & Harry Smith
 */
public class HomePage extends AppCompatActivity {

    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    Button submit;
    static String selectedCastle;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        setViews();

        /* The code below prevents multiple selections of the radio button */
        radioButton1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                radioButton1.setChecked(true);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
            }
        });

        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radioButton1.setChecked(false);
                    radioButton2.setChecked(true);
                    radioButton3.setChecked(false);
                    radioButton4.setChecked(false);

                    //creates busJourney object with relevant journey code(s)
                    BusJourney.buildBusJourney("NCAUK", "");
                }
            }
        });

        radioButton3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(true);
                radioButton4.setChecked(false);
            }
        });

        radioButton4.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(true);
            }
        });

        /* This method confirms the users selection and directs them to the next page */
        submit.setOnClickListener(v -> {
            if (radioButton1.isChecked()) {
                selectedCastle = "1";
                Intent intent = new Intent(HomePage.this, FacilitiesPage.class);
                startActivity(intent);
            } else if (radioButton2.isChecked()) {
                selectedCastle = "2";
                Intent intent = new Intent(HomePage.this, FacilitiesPage.class);
                startActivity(intent);
            } else if (radioButton3.isChecked()) {
                selectedCastle = "3";
                Intent intent = new Intent(HomePage.this, FacilitiesPage.class);
                startActivity(intent);
            } else if (radioButton4.isChecked()) {
                selectedCastle = "4";
                Intent intent = new Intent(HomePage.this, FacilitiesPage.class);
                startActivity(intent);
            } else {
                Toast.makeText(HomePage.this, "Please select a castle", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openActivity2() {
        if (radioButton1.isChecked()) {
            selectedCastle = "1";
            Intent intent = new Intent(HomePage.this, FacilitiesPage.class);
            startActivity(intent);
        } else if (radioButton2.isChecked()) {
            selectedCastle = "2";
            Intent intent = new Intent(HomePage.this, FacilitiesPage.class);
            startActivity(intent);
        } else if (radioButton3.isChecked()) {
            selectedCastle = "3";
            Intent intent = new Intent(HomePage.this, FacilitiesPage.class);
            startActivity(intent);
        } else if (radioButton4.isChecked()) {
            selectedCastle = "4";
            Intent intent = new Intent(HomePage.this, FacilitiesPage.class);
            startActivity(intent);
        } else {
            Toast.makeText(HomePage.this, "Please select a castle", Toast.LENGTH_SHORT).show();
        }

    }

    public void setViews() {
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        submit = findViewById(R.id.submit);
    }

}

