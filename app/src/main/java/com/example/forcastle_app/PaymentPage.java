package com.example.forcastle_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class PaymentPage extends AppCompatActivity {

    TextView details1, details2;
    Toolbar back;
    static String anchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        details1 = (TextView) findViewById(R.id.details1);
        details2 = (TextView) findViewById(R.id.details2);
        back = findViewById(R.id.toolbar);

        details1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anchor = "1";
                Intent intent = new Intent(PaymentPage.this, BoundDetails.class);
                startActivity(intent);
            }
        });

        details2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anchor = "2";
                Intent intent = new Intent(PaymentPage.this, BoundDetails.class);
                startActivity(intent);
            }
        });

        /*
        The method below should be uncommented once this code has been integrated with all the pages.
        the ClickListener will allow the backToTimeSelection() method to run (commented method below)
         */
//        backPayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                backToTimeSelection();
//            }
//        });


    }

    /*
    The backToTimeSelection() method should be uncommented and the InboundTimeSelection(page) should be renamed
    to the class of name of the outbound time selection page.
     */
//    public void backToTimeSelection() {
//        Intent intent = new Intent(MainActivity.this, InboundTimeSelection.class);
//        startActivity(intent);
//    }


    //this is the method to complete a horsepay transaction. The method gets the data and sends a JSONObject over request
    private void sendJSONObject(View view) throws IOException {
        TextView confirmedDate = (TextView) findViewById(R.id.confirmedDate);
        // TextView confirmedTime = (TextView) findViewById(R.id.timeID);

        String storeID = "team16";
        String customerID  = "3784763";
        String date = confirmedDate.getText().toString();
        //String time = confirmedTime.getText().toString();
        String time = "14:00";
        String timeZone = "GMT";
        float transactionAmount = (float) 15.679;
        String currencyCode = "GBP";

        //create JSON object
        JSONObject requestObject = new JSONObject();
        try {
            requestObject.put("storeID", storeID);
            requestObject.put("customerID", customerID);
            requestObject.put("date", date);
            requestObject.put("time", time);
            requestObject.put("timeZone", timeZone);
            requestObject.put("transactionAmount", transactionAmount);
            requestObject.put("currencyCode", currencyCode);
            requestObject.put("forcePaymentSatusReturnType", true);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        String json = "{\"storeID\":1,\"name\":\"John\"}";
//        OkHttpClient client = new OkHttpClient();
//        RequestBody body = RequestBody.create( MediaType.parse("application/json"), json);
//        Request request = new Request.Builder()
//                .addHeader("Content-Type","application/json")
//                .url("http://homepages.cs.ncl.ac.uk/daniel.nesbitt/CSC8019/HorsePay/HorsePay.php")
//                .post(body)
//                .build();
//
//        okhttp3.Response response = client.newCall(request).execute();
    }


}