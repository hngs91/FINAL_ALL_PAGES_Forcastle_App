package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.forcastle_app.DatabaseTeam.BusJourney;
import com.example.forcastle_app.DatabaseTeam.DataBaseHelper;
import com.example.forcastle_app.DatabaseTeam.TimeDateFormatters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
Code implemented by Zheng Yang & Harry Smith
 */
public class BoundPage extends AppCompatActivity {

    Toolbar outbound_toolbar;
    TextView headline;
    Button buyButton1, buyButton2, buyButton3, buyButton4, buyButton5;

    TextView changeDirect1, changeDirect2, changeDirect3, changeDirect4, changeDirect5,
            leaveTime1, leaveTime2, leaveTime3, leaveTime4, leaveTime5,
            arriveTime1, arriveTime2, arriveTime3, arriveTime4, arriveTime5,
            duration1, duration2, duration3, duration4, duration5;

    LinearLayout timeCard1, timeCard2, timeCard3, timeCard4, timeCard5;

    int i = 0; //counter for setTextViews method

    // Initiates Lists needed to store query data from the database
    List<Integer> outboundTimeListJourneyCode1 = new ArrayList<>();
    List<Integer> inboundTimeListReturnCode1 = new ArrayList<>();
    List<Integer> waitChangeTimes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_page);

        setViews();

        // If outbound bus details are shown users can navigate back to the filter page
        // If inbound bus details are shown users can navigate back to outbound bus details
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

        // below logic either shows users outbound bus details or inbound bus details depending on the value of the FilterPage.anchor
        if ("1".equals(FilterPage.anchor)) {
            headline.setText(R.string.outbound);
            ((TextView) findViewById(R.id.departureStation)).setText(BusJourney.getDepartureStationOut1());
            ((TextView) findViewById(R.id.arrivalStation)).setText(BusJourney.getArrivalStationOut1());

            // Populates the list with relevant outbound bus times
            outboundTimeListJourneyCode1 = runDatabaseQueryOutboundTimeJourneyCode1();

            // Populates up to five possible outbound bus journeys depending on what time the user wanted to leave
            populateTimeCards(outboundTimeListJourneyCode1, BusJourney.getJourneyCode2(), BusJourney.getJourneyDurationTotalMinutes1(), BusJourney.getJourneyDurationTotalMinutes2());

        } else if ("2".equals(FilterPage.anchor)) {
            headline.setText(R.string.inbound);
            waitChangeTimes.clear();
            ((TextView) findViewById(R.id.departureStation)).setText(BusJourney.getDepartureStationIn1());
            ((TextView) findViewById(R.id.arrivalStation)).setText(BusJourney.getArrivalStationIn1());

            // Populates the list with relevant inbound bus times
            inboundTimeListReturnCode1 = runDatabaseQueryInboundTimeReturnCode1();

            int inboundFirstJourneyDuration;

            if (BusJourney.getDirectChange().equals("Direct")) {
                inboundFirstJourneyDuration = BusJourney.getJourneyDurationTotalMinutes1();
            } else {
                inboundFirstJourneyDuration = BusJourney.getJourneyDurationTotalMinutes2();
            }
            populateTimeCards(inboundTimeListReturnCode1, BusJourney.getReturnCode2(), inboundFirstJourneyDuration, BusJourney.getJourneyDurationTotalMinutes1());
        }

        buyButton1.setOnClickListener(v -> {
            if ("1".equals(FilterPage.anchor)) {
                BusJourney.setOutboundTime1(leaveTime1.getText().toString());
                BusJourney.setArrivalTimeOut(TimeDateFormatters.reverseTimeFormat(arriveTime1.getText().toString()));
                BusJourney.setTravelTime1(duration1.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setOutboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(1)));
                    int changeWaitTime = waitChangeTimes.get(1) - waitChangeTimes.get(0);
                    BusJourney.setChangeWaitOut(TimeDateFormatters.durationFormat(changeWaitTime));
                }
                FilterPage.anchor = "2";
                Intent intent = new Intent(BoundPage.this, BoundPage.class);
                startActivity(intent);

            } else if ("2".equals(FilterPage.anchor)) {
                BusJourney.setInboundTime1(leaveTime1.getText().toString());
                BusJourney.setArrivalTimeIn(TimeDateFormatters.reverseTimeFormat(arriveTime1.getText().toString()));
                BusJourney.setTravelTime2(duration1.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setInboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(1)));
                    int changeWaitTime = waitChangeTimes.get(1) - waitChangeTimes.get(0);
                    BusJourney.setChangeWaitIn(TimeDateFormatters.durationFormat(changeWaitTime));
                }
                Intent intent = new Intent(BoundPage.this, OrderDetails.class);
                startActivity(intent);
            }
        });

        buyButton2.setOnClickListener(v -> {
            if ("1".equals(FilterPage.anchor)) {
                BusJourney.setOutboundTime1(leaveTime2.getText().toString());
                BusJourney.setArrivalTimeOut(TimeDateFormatters.reverseTimeFormat(arriveTime2.getText().toString()));
                BusJourney.setTravelTime1(duration2.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setOutboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(3)));
                    int changeWaitTime = waitChangeTimes.get(3) - waitChangeTimes.get(2);
                    BusJourney.setChangeWaitOut(TimeDateFormatters.timeFormat(changeWaitTime));
                }
                FilterPage.anchor = "2";
                Intent intent = new Intent(BoundPage.this, BoundPage.class);
                startActivity(intent);

            } else if ("2".equals(FilterPage.anchor)) {
                BusJourney.setInboundTime1(leaveTime2.getText().toString());
                BusJourney.setArrivalTimeIn(TimeDateFormatters.reverseTimeFormat(arriveTime2.getText().toString()));
                BusJourney.setTravelTime2(duration2.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setInboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(3)));
                    int changeWaitTime = waitChangeTimes.get(3) - waitChangeTimes.get(2);
                    BusJourney.setChangeWaitIn(TimeDateFormatters.durationFormat(changeWaitTime));
                }
                Intent intent = new Intent(BoundPage.this, OrderDetails.class);
                startActivity(intent);
            }
        });

        buyButton3.setOnClickListener(v -> {
            if ("1".equals(FilterPage.anchor)) {
                BusJourney.setOutboundTime1(leaveTime3.getText().toString());
                BusJourney.setArrivalTimeOut(TimeDateFormatters.reverseTimeFormat(arriveTime3.getText().toString()));
                BusJourney.setTravelTime1(duration3.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setOutboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(5)));
                    int changeWaitTime = waitChangeTimes.get(5) - waitChangeTimes.get(4);
                    BusJourney.setChangeWaitOut(TimeDateFormatters.timeFormat(changeWaitTime));
                }
                FilterPage.anchor = "2";
                Intent intent = new Intent(BoundPage.this, BoundPage.class);
                startActivity(intent);

            } else if ("2".equals(FilterPage.anchor)) {
                BusJourney.setInboundTime1(leaveTime3.getText().toString());
                BusJourney.setArrivalTimeIn(TimeDateFormatters.reverseTimeFormat(arriveTime3.getText().toString()));
                BusJourney.setTravelTime2(duration3.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setInboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(5)));
                    int changeWaitTime = waitChangeTimes.get(5) - waitChangeTimes.get(4);
                    BusJourney.setChangeWaitIn(TimeDateFormatters.durationFormat(changeWaitTime));
                }
                Intent intent = new Intent(BoundPage.this, OrderDetails.class);
                startActivity(intent);
            }
        });

        buyButton4.setOnClickListener(v -> {
            if ("1".equals(FilterPage.anchor)) {
                BusJourney.setOutboundTime1(leaveTime4.getText().toString());
                BusJourney.setArrivalTimeOut(TimeDateFormatters.reverseTimeFormat(arriveTime4.getText().toString()));
                BusJourney.setTravelTime1(duration4.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setOutboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(7)));
                    int changeWaitTime = waitChangeTimes.get(7) - waitChangeTimes.get(6);
                    BusJourney.setChangeWaitOut(TimeDateFormatters.timeFormat(changeWaitTime));
                }
                FilterPage.anchor = "2";
                Intent intent = new Intent(BoundPage.this, BoundPage.class);
                startActivity(intent);

            } else if ("2".equals(FilterPage.anchor)) {
                BusJourney.setInboundTime1(leaveTime4.getText().toString());
                BusJourney.setArrivalTimeIn(TimeDateFormatters.reverseTimeFormat(arriveTime4.getText().toString()));
                BusJourney.setTravelTime2(duration4.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setInboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(7)));
                    int changeWaitTime = waitChangeTimes.get(7) - waitChangeTimes.get(6);
                    BusJourney.setChangeWaitIn(TimeDateFormatters.durationFormat(changeWaitTime));
                }
                Intent intent = new Intent(BoundPage.this, OrderDetails.class);
                startActivity(intent);
            }
        });

        buyButton5.setOnClickListener(v -> {
            if ("1".equals(FilterPage.anchor)) {
                BusJourney.setOutboundTime1(leaveTime5.getText().toString());
                BusJourney.setArrivalTimeOut(TimeDateFormatters.reverseTimeFormat(arriveTime5.getText().toString()));
                BusJourney.setTravelTime1(duration5.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setOutboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(9)));
                    int changeWaitTime = waitChangeTimes.get(9) - waitChangeTimes.get(8);
                    BusJourney.setChangeWaitOut(TimeDateFormatters.timeFormat(changeWaitTime));
                }
                FilterPage.anchor = "2";
                Intent intent = new Intent(BoundPage.this, BoundPage.class);
                startActivity(intent);

            } else if ("2".equals(FilterPage.anchor)) {
                BusJourney.setInboundTime1(leaveTime5.getText().toString());
                BusJourney.setArrivalTimeIn(TimeDateFormatters.reverseTimeFormat(arriveTime5.getText().toString()));
                BusJourney.setTravelTime2(duration5.getText().toString());

                if (BusJourney.getDirectChange().equals("1 change")) {
                    BusJourney.setInboundTime2(TimeDateFormatters.timeFormat(waitChangeTimes.get(9)));
                    int changeWaitTime = waitChangeTimes.get(9) - waitChangeTimes.get(8);
                    BusJourney.setChangeWaitIn(TimeDateFormatters.durationFormat(changeWaitTime));
                }
                Intent intent = new Intent(BoundPage.this, OrderDetails.class);
                startActivity(intent);
            }
        });
    }

    // sets all variables to relevant views on the app page & sets correct display information
    public void setViews() {
        //sets departure, destination, date, & bus ticket prices based on data chosen by user
        ((TextView) findViewById(R.id.departureStation)).setText(BusJourney.getDepartureStationOut1());
        ((TextView) findViewById(R.id.arrivalStation)).setText(BusJourney.getArrivalStationOut1());
        ((TextView) findViewById(R.id.dayOfJourney)).setText(BusJourney.getTravelDate());

        String adultPriceText = "£" + String.format(Locale.UK, "%.2f", BusJourney.getAdultBusPrice()) + " Adult";
        ((TextView) findViewById(R.id.busAdultPrice1)).setText(adultPriceText);
        ((TextView) findViewById(R.id.busAdultPrice2)).setText(adultPriceText);
        ((TextView) findViewById(R.id.busAdultPrice3)).setText(adultPriceText);
        ((TextView) findViewById(R.id.busAdultPrice4)).setText(adultPriceText);
        ((TextView) findViewById(R.id.busAdultPrice5)).setText(adultPriceText);

        String childPriceText = "£" + String.format(Locale.UK, "%.2f", BusJourney.getChildBusPrice()) + " Child";
        ((TextView) findViewById(R.id.busChildPrice1)).setText(childPriceText);
        ((TextView) findViewById(R.id.busChildPrice2)).setText(childPriceText);
        ((TextView) findViewById(R.id.busChildPrice3)).setText(childPriceText);
        ((TextView) findViewById(R.id.busChildPrice4)).setText(childPriceText);
        ((TextView) findViewById(R.id.busChildPrice5)).setText(childPriceText);

        outbound_toolbar = findViewById(R.id.outbound_toolbar);
        headline = findViewById(R.id.headline);

        timeCard1 = findViewById(R.id.timeCard1);
        timeCard2 = findViewById(R.id.timeCard2);
        timeCard3 = findViewById(R.id.timeCard3);
        timeCard4 = findViewById(R.id.timeCard4);
        timeCard5 = findViewById(R.id.timeCard5);

        buyButton1 = findViewById(R.id.buyButton1);
        buyButton2 = findViewById(R.id.buyButton2);
        buyButton3 = findViewById(R.id.buyButton3);
        buyButton4 = findViewById(R.id.buyButton4);
        buyButton5 = findViewById(R.id.buyButton5);

        changeDirect1 = findViewById(R.id.changeDirect1);
        changeDirect2 = findViewById(R.id.changeDirect2);
        changeDirect3 = findViewById(R.id.changeDirect3);
        changeDirect4 = findViewById(R.id.changeDirect4);
        changeDirect5 = findViewById(R.id.changeDirect5);

        leaveTime1 = findViewById(R.id.leaveTime1);
        leaveTime2 = findViewById(R.id.leaveTime2);
        leaveTime3 = findViewById(R.id.leaveTime3);
        leaveTime4 = findViewById(R.id.leaveTime4);
        leaveTime5 = findViewById(R.id.leaveTime5);

        arriveTime1 = findViewById(R.id.arriveTime1);
        arriveTime2 = findViewById(R.id.arriveTime2);
        arriveTime3 = findViewById(R.id.arriveTime3);
        arriveTime4 = findViewById(R.id.arriveTime4);
        arriveTime5 = findViewById(R.id.arriveTime5);

        duration1 = findViewById(R.id.duration1);
        duration2 = findViewById(R.id.duration2);
        duration3 = findViewById(R.id.duration3);
        duration4 = findViewById(R.id.duration4);
        duration5 = findViewById(R.id.duration5);
    }

    public void populateTimeCards(List<Integer> databaseQueryList, String busJourneyCode, int journey1duration, int journey2duration) {
        try {
            setTextViewsValues(leaveTime1, arriveTime1, duration1, changeDirect1, databaseQueryList, busJourneyCode, journey1duration, journey2duration, i);
        } catch (Exception e) {
            timeCard1.setVisibility(View.INVISIBLE);
        }

        try {
            setTextViewsValues(leaveTime2, arriveTime2, duration2, changeDirect2, databaseQueryList, busJourneyCode, journey1duration, journey2duration, i);
        } catch (Exception e) {
            timeCard2.setVisibility(View.INVISIBLE);
        }

        try {
            setTextViewsValues(leaveTime3, arriveTime3, duration3, changeDirect3, databaseQueryList, busJourneyCode, journey1duration, journey2duration, i);
        } catch (Exception e) {
            timeCard3.setVisibility(View.INVISIBLE);
        }

        try {
            setTextViewsValues(leaveTime4, arriveTime4, duration4, changeDirect4, databaseQueryList, busJourneyCode, journey1duration, journey2duration, i);
        } catch (Exception e) {
            timeCard4.setVisibility(View.INVISIBLE);
        }

        try {
            setTextViewsValues(leaveTime5, arriveTime5, duration5, changeDirect5, outboundTimeListJourneyCode1, busJourneyCode, journey1duration, journey2duration, i);
        } catch (Exception e) {
            timeCard5.setVisibility(View.INVISIBLE);
        }

        if (timeCard1.getVisibility() == View.INVISIBLE) {
            Toast.makeText(this, "No bus times available, please return to the previous page and select an earlier time", Toast.LENGTH_LONG).show();
        }
    }

    public List<Integer> runDatabaseQueryOutboundTimeJourneyCode1() {
        return DataBaseHelper.getInstance(getApplicationContext()).bus1LeaveTimes(BusJourney.getTotalTime(), BusJourney.getJourneyCode1(), BusJourney.getPartOfWeek());
    }

    public List<Integer> runDatabaseQueryInboundTimeReturnCode1() {
        int queryTime = BusJourney.getArrivalTimeOut() + 120;
        return DataBaseHelper.getInstance(getApplicationContext()).bus1LeaveTimes(queryTime, BusJourney.getReturnCode1(), BusJourney.getPartOfWeek());
    }

    public void setTextViewsValues(TextView outbound, TextView arrival, TextView travelTime, TextView directChange, List<Integer> outboundTimeInt, String secondBusJourneyCode, int journey1duration, int journey2duration, int i) {

        int bus1leaveTime = outboundTimeInt.get(i);
        int bus1ArriveTime = bus1leaveTime + journey1duration;

        // sets if journey is direct or 1 change
        directChange.setText(BusJourney.getDirectChange());

        // sets outbound button text to the relevant entry on the List<Integer>
        outbound.setText(TimeDateFormatters.timeFormat(bus1leaveTime));

        if (BusJourney.getDirectChange().equals("Direct")) {
            // adds the duration of the bus journey to the outbound time to find the arrival time
            arrival.setText(TimeDateFormatters.timeFormat(bus1ArriveTime));

            // displays duration of journey
            travelTime.setText(TimeDateFormatters.durationFormat(journey1duration));
        } else {
            int bus2Leave = DataBaseHelper.getInstance(getApplicationContext()).bus2LeaveTime(bus1ArriveTime, secondBusJourneyCode, BusJourney.getPartOfWeek());

            int bus2ArriveTime = bus2Leave + journey2duration;

            int bus2JourneyDuration = bus2ArriveTime - bus1leaveTime;

            arrival.setText(TimeDateFormatters.timeFormat(bus2ArriveTime));

            travelTime.setText(TimeDateFormatters.durationFormat(bus2JourneyDuration));

            waitChangeTimes.add(bus1ArriveTime);
            waitChangeTimes.add(bus2Leave);

        }
        this.i++;
    }

}