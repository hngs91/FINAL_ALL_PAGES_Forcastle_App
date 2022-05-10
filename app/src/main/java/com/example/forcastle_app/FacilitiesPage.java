package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;

/*
Code implemented by Zheng Yang
 */

public class FacilitiesPage extends AppCompatActivity {

    Toolbar toolbar;
    Button button;
    TextView headline, intro, adult_price, children_price, phone_num, website,
            fac1_name, fac1_tag1, fac1_tag2, fac1_tag3, fac1_addr,
            fac2_name, fac2_tag1, fac2_tag2, fac2_tag3, fac2_addr,
            fac3_name, fac3_tag1, fac3_tag2, fac3_tag3, fac3_addr;
    ImageView castle_pic,
            fac1_icon, fac1_star1, fac1_star2, fac1_star3, fac1_star4, fac1_star5,
            fac2_icon, fac2_star1, fac2_star2, fac2_star3, fac2_star4, fac2_star5,
            fac3_icon, fac3_star1, fac3_star2, fac3_star3, fac3_star4, fac3_star5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities_page);

        setViews();

        // allows users to go back to the home page to select another castle
        toolbar.setNavigationOnClickListener(v -> {
            Intent intent = new Intent(FacilitiesPage.this, HomePage.class);
            startActivity(intent);
        });

        // allows users to continue to the Filter Page if they are happy with the castle they have chosen
        button.setOnClickListener(v -> {
            // Stores the price of castle tickets in the BusJourney object
            BusJourney.setAdultCastlePrice(TimeDateFormatters.getCastlePrice(adult_price.getText().toString()));
            BusJourney.setChildCastlePrice(TimeDateFormatters.getCastlePrice(children_price.getText().toString()));

            Intent intent = new Intent(FacilitiesPage.this, FilterPage.class);
            startActivity(intent);
        });

        // ensures the correct information is displayed to the user based on which castle they chose on the Home Page
        if ("1".equals(HomePage.selectedCastle)) {
            headline.setText(R.string.alnwick_castle);
            castle_pic.setImageResource(R.drawable.pic_alnwick);
            intro.setText(R.string.alnwick_intro);
            adult_price.setText(R.string.alnwick_adults_price);
            children_price.setText(R.string.alnwick_children_price);
            phone_num.setText(R.string.alnwick_phone_num);
            website.setText(R.string.alnwick_website);

            fac1_icon.setImageResource(R.drawable.ic_alnwick_costa_coffee);
            fac1_name.setText(R.string.alnwick_fac1_name);
            fac1_tag1.setText(R.string.coffee_tag);
            fac1_tag2.setText(R.string.casual_tag);
            fac1_tag3.setVisibility(View.INVISIBLE);
            fac1_addr.setText(R.string.alnwick_fac1_addr);
            fac1_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star5.setImageResource(R.drawable.ic_pentagram_1);

            fac2_icon.setImageResource(R.drawable.ic_alnwick_restaurant_at_the_castle);
            fac2_name.setText(R.string.alnwick_fac2_name);
            fac2_tag1.setText(R.string.restaurant_tag);
            fac2_tag2.setText(R.string.bar_tag);
            fac2_tag3.setVisibility(View.INVISIBLE);
            fac2_addr.setText(R.string.alnwick_fac2_addr);
            fac2_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star5.setImageResource(R.drawable.ic_pentagram_2);

            fac3_icon.setImageResource(R.drawable.ic_alnwick_carlos);
            fac3_name.setText(R.string.alnwick_fac3_name);
            fac3_tag1.setText(R.string.fish_chips_tag);
            fac3_tag2.setText(R.string.bar_tag);
            fac3_tag3.setText(R.string.takeaway_tag);
            fac3_addr.setText(R.string.alnwick_fac3_addr);
            fac3_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star5.setImageResource(R.drawable.ic_pentagram_2);
        } else if ("2".equals(HomePage.selectedCastle)) {
            headline.setText(R.string.auckland_castle);
            castle_pic.setImageResource(R.drawable.pic_auckland);
            intro.setText(R.string.auckland_intro);
            adult_price.setText(R.string.auckland_adults_price);
            children_price.setText(R.string.auckland_children_price);
            phone_num.setText(R.string.auckland_phone_num);
            website.setText(R.string.auckland_website);

            fac1_icon.setImageResource(R.drawable.ic_auckland_bishops_kitchen);
            fac1_name.setText(R.string.auckland_fac1_name);
            fac1_tag1.setText(R.string.coffee_tag);
            fac1_tag2.setText(R.string.tapas_bar_tag);
            fac1_tag3.setVisibility(View.INVISIBLE);
            fac1_addr.setText(R.string.auckland_fac1_addr);
            fac1_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star5.setImageResource(R.drawable.ic_pentagram_1);

            fac2_icon.setImageResource(R.drawable.ic_auckland_fifteas_vintage_tea_room);
            fac2_name.setText(R.string.auckland_fac2_name);
            fac2_tag1.setText(R.string.breakfast_lunch_tag);
            fac2_tag2.setVisibility(View.INVISIBLE);
            fac2_tag3.setVisibility(View.INVISIBLE);
            fac2_addr.setText(R.string.auckland_fac2_addr);
            fac2_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star5.setImageResource(R.drawable.ic_pentagram_2);

            fac3_icon.setImageResource(R.drawable.ic_auckland_spudfellas);
            fac3_name.setText(R.string.auckland_fac3_name);
            fac3_tag1.setText(R.string.pizza_tag);
            fac3_tag2.setText(R.string.burger_tag);
            fac3_tag3.setVisibility(View.INVISIBLE);
            fac3_addr.setText(R.string.auckland_fac3_addr);
            fac3_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star5.setImageResource(R.drawable.ic_pentagram_2);
        }
        if ("3".equals(HomePage.selectedCastle)) {
            headline.setText(R.string.bamburgh_castle);
            castle_pic.setImageResource(R.drawable.pic_bamburgh);
            intro.setText(R.string.bamburgh_intro);
            adult_price.setText(R.string.bamburgh_adults_price);
            children_price.setText(R.string.bamburgh_children_price);
            phone_num.setText(R.string.bamburgh_phone_num);
            website.setText(R.string.bamburgh_website);

            fac1_icon.setImageResource(R.drawable.ic_bamburgh_the_clock_tower_tea_rooms);
            fac1_name.setText(R.string.bamburgh_fac1_name);
            fac1_tag1.setText(R.string.coffee_tag);
            fac1_tag2.setVisibility(View.INVISIBLE);
            fac1_tag3.setVisibility(View.INVISIBLE);
            fac1_addr.setText(R.string.bamburgh_fac1_addr);
            fac1_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star5.setImageResource(R.drawable.ic_pentagram_1);

            fac2_icon.setImageResource(R.drawable.ic_bamburgh_bamburger);
            fac2_name.setText(R.string.bamburgh_fac2_name);
            fac2_tag1.setText(R.string.takeaway_tag);
            fac2_tag2.setText(R.string.burger_tag);
            fac2_tag3.setVisibility(View.INVISIBLE);
            fac2_addr.setText(R.string.bamburgh_fac2_addr);
            fac2_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star5.setImageResource(R.drawable.ic_pentagram_2);

            fac3_icon.setImageResource(R.drawable.ic_bamburgh_the_potted_lobster);
            fac3_name.setText(R.string.bamburgh_fac3_name);
            fac3_tag1.setText(R.string.wine_tag);
            fac3_tag2.setText(R.string.lobster_tag);
            fac3_tag3.setVisibility(View.INVISIBLE);
            fac3_addr.setText(R.string.bamburgh_fac3_addr);
            fac3_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star5.setImageResource(R.drawable.ic_pentagram_1);
        } else if ("4".equals(HomePage.selectedCastle)) {
            headline.setText(R.string.barnard_castle);
            castle_pic.setImageResource(R.drawable.pic_barnard);
            intro.setText(R.string.barnard_intro);
            adult_price.setText(R.string.barnard_adults_price);
            children_price.setText(R.string.barnard_children_price);
            phone_num.setText(R.string.barnard_phone_num);
            website.setText(R.string.barnard_website);

            fac1_icon.setImageResource(R.drawable.ic_barnard_starbucks);
            fac1_name.setText(R.string.barnard_fac1_name);
            fac1_tag1.setText(R.string.coffee_tag);
            fac1_tag2.setText(R.string.casual_tag);
            fac1_tag3.setVisibility(View.INVISIBLE);
            fac1_addr.setText(R.string.barnard_fac1_addr);
            fac1_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac1_star5.setImageResource(R.drawable.ic_pentagram_1);

            fac2_icon.setImageResource(R.drawable.ic_barnard_valentines_restaurant);
            fac2_name.setText(R.string.barnard_fac2_name);
            fac2_tag1.setText(R.string.restaurant_tag);
            fac2_tag2.setText(R.string.british_tag);
            fac2_tag3.setVisibility(View.INVISIBLE);
            fac2_addr.setText(R.string.barnard_fac2_addr);
            fac2_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac2_star5.setImageResource(R.drawable.ic_pentagram_1);

            fac3_icon.setImageResource(R.drawable.ic_barnard_greggs);
            fac3_name.setText(R.string.barnard_fac3_name);
            fac3_tag1.setText(R.string.sandwiches_tag);
            fac3_tag2.setVisibility(View.INVISIBLE);
            fac3_tag3.setVisibility(View.INVISIBLE);
            fac3_addr.setText(R.string.barnard_fac3_addr);
            fac3_star1.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star2.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star3.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star4.setImageResource(R.drawable.ic_pentagram_1);
            fac3_star5.setImageResource(R.drawable.ic_pentagram_2);
        }

    }

    //  sets all variables to relevant views on the app page
    public void setViews() {
        toolbar = findViewById(R.id.toolbar);
        button = findViewById(R.id.button);

        headline = findViewById(R.id.headline);
        castle_pic = findViewById(R.id.castle_pic);
        intro = findViewById(R.id.intro);
        adult_price = findViewById(R.id.price_text_2);
        children_price = findViewById(R.id.price_text_4);
        phone_num = findViewById(R.id.phone_num);
        website = findViewById(R.id.website);

        fac1_icon = findViewById(R.id.fac1_ic);
        fac1_name = findViewById(R.id.fac1_name);
        fac1_tag1 = findViewById(R.id.fac1_tag1);
        fac1_tag2 = findViewById(R.id.fac1_tag2);
        fac1_tag3 = findViewById(R.id.fac1_tag3);
        fac1_addr = findViewById(R.id.fac1_addr);
        fac1_star1 = findViewById(R.id.fac1_star1);
        fac1_star2 = findViewById(R.id.fac1_star2);
        fac1_star3 = findViewById(R.id.fac1_star3);
        fac1_star4 = findViewById(R.id.fac1_star4);
        fac1_star5 = findViewById(R.id.fac1_star5);

        fac2_icon = findViewById(R.id.fac2_ic);
        fac2_name = findViewById(R.id.fac2_name);
        fac2_tag1 = findViewById(R.id.fac2_tag1);
        fac2_tag2 = findViewById(R.id.fac2_tag2);
        fac2_tag3 = findViewById(R.id.fac2_tag3);
        fac2_addr = findViewById(R.id.fac2_addr);
        fac2_star1 = findViewById(R.id.fac2_star1);
        fac2_star2 = findViewById(R.id.fac2_star2);
        fac2_star3 = findViewById(R.id.fac2_star3);
        fac2_star4 = findViewById(R.id.fac2_star4);
        fac2_star5 = findViewById(R.id.fac2_star5);

        fac3_icon = findViewById(R.id.fac3_ic);
        fac3_name = findViewById(R.id.fac3_name);
        fac3_tag1 = findViewById(R.id.fac3_tag1);
        fac3_tag2 = findViewById(R.id.fac3_tag2);
        fac3_tag3 = findViewById(R.id.fac3_tag3);
        fac3_addr = findViewById(R.id.fac3_addr);
        fac3_star1 = findViewById(R.id.fac3_star1);
        fac3_star2 = findViewById(R.id.fac3_star2);
        fac3_star3 = findViewById(R.id.fac3_star3);
        fac3_star4 = findViewById(R.id.fac3_star4);
        fac3_star5 = findViewById(R.id.fac3_star5);
    }

}
