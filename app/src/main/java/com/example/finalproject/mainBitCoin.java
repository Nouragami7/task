package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class mainBitCoin extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
//    TextView text5;
//    TextView text6;
//    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bit_coin);
        text1=findViewById(R.id.time_des_name);
        text2=findViewById(R.id.USD);
        text3=findViewById(R.id.GBP);
        text4=findViewById(R.id.EUR);

//        text5=findViewById(R.id.GBP);
//        text6=findViewById(R.id.EUR);
//        button=findViewById(R.id.b);
        conectToApi();
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {opendesActivity();}
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {opendesActivity();}
        });

        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {opendesActivity();}
        });
    }
    public void opendesActivity(){
        Intent intent=new Intent(this,des_screen.class);
        startActivity(intent);
    }
    private void conectToApi(){
        RequestQueue queue=Volley.newRequestQueue(this);
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {


                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONObject time= jsonObject.getJSONObject("time");
                            String updated=time.getString("updated");
                            // Toast.makeText(mainBitCoin.this,updated,Toast.LENGTH_LONG).show();
                            String des= jsonObject.getString("disclaimer");
                            String name= jsonObject.getString("chartName");


                            JSONObject bpi=jsonObject.getJSONObject("bpi");
                            //USD rate
                            JSONObject usdObject = bpi.getJSONObject("USD");
                            String rateUsd= usdObject.getString("rate");
                            //GBP rate
                            JSONObject gbpObject = bpi.getJSONObject("GBP");
                            String rateGbp= gbpObject.getString("rate");
                            //EUR rate
                            JSONObject eurObject = bpi.getJSONObject("EUR");
                            String rateEur= eurObject.getString("rate");

                            //To print data
                            text1.setText("Date: "+updated.toString()+"\n"+"\n"+"Description: "+des.toString()+"\n"+"\n"+"Currency Name: "+name.toString()+"\n"+"\n");
                           //To print the rate
                            text2.setText(rateUsd.toString()+"$");
                            text3.setText(rateGbp.toString()+"£");
                            text4.setText(rateEur.toString()+"€");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                    }
                });


        queue.add(stringRequest);

    }



}
