package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.forcastle_app.DatabaseTeam.BusJourney;

public class HomePage extends AppCompatActivity {

    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    Button submit;
    BusJourney busJourney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        submit = (Button) findViewById(R.id.submit);

        /* The code below prevents multiple selections of the radio button */
        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radioButton1.setChecked(true);
                    radioButton2.setChecked(false);
                    radioButton3.setChecked(false);
                    radioButton4.setChecked(false);

                    //creates busJourney object with relevant journey code(s)
                    busJourney = new BusJourney("NCALN", null);
                }
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
                    busJourney = new BusJourney("NCAUK", null);
                }
            }
        });

        radioButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radioButton1.setChecked(false);
                    radioButton2.setChecked(false);
                    radioButton3.setChecked(true);
                    radioButton4.setChecked(false);

                    //creates busJourney object with relevant journey code(s)
                    busJourney = new BusJourney("NCBAM1", "NCBAM2");
                }
            }
        });

        radioButton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radioButton1.setChecked(false);
                    radioButton2.setChecked(false);
                    radioButton3.setChecked(false);
                    radioButton4.setChecked(true);

                    //creates busJourney object with relevant journey code(s)
                    busJourney = new BusJourney("NCBAR1", "NCBAR2");
                }
            }
        });

        /* This method confirms the users selection and directs them to the next page */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }

    public void openActivity2() {
        if (radioButton1.isChecked()) {
            Intent intent = new Intent(HomePage.this, FacilitiesPageAlnwick.class);
            startActivity(intent);
        } else if (radioButton2.isChecked()) {
            Intent intent = new Intent(HomePage.this, FacilitiesPageAuckland.class);
            startActivity(intent);
        } else if (radioButton3.isChecked()) {
            Intent intent = new Intent(HomePage.this, FacilitiesPageBamburgh.class);
            startActivity(intent);
        } else if (radioButton4.isChecked()) {
            Intent intent = new Intent(HomePage.this, FacilitiesPageBarnard.class);
            startActivity(intent);
        } else {
            Toast.makeText(HomePage.this, "Please select a castle", Toast.LENGTH_SHORT).show();
        }

    }
}