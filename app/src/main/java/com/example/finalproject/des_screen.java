package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class des_screen extends AppCompatActivity {
    TextView textViewcode;
    TextView textViewsymbol;
    TextView textViewdesc;
    TextView textViewrate;



//    TextView text2;
//    TextView text3;
//    TextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_des_screen);
        textViewcode=findViewById(R.id.code);
        textViewsymbol=findViewById(R.id.symbol);
        textViewdesc=findViewById(R.id.desc);
        textViewrate=findViewById(R.id.Rate);
        conectToApi();
//        text2=findViewById(R.id.USD);
//        text3=findViewById(R.id.GBP);
//        text4=findViewById(R.id.EUR);
//
//
//        text2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                conectToApi();
//            }
//        });
//        text3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                conectToApi2();
//            }
//        });


//        ListView listView=findViewById(R.id.listView);
//        List<String> list=new ArrayList<>();
//        list.add("code");
//        list.add("symbol");
//        list.add("desc");
//        list.add("rate");
//        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
//        listView.setAdapter(arrayAdapter);



    }
    private void conectToApi() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {

                                JSONObject jsonObject = new JSONObject(response);
                                JSONObject bpi = jsonObject.getJSONObject("bpi");
                                //USD
                                JSONObject usdObject = bpi.getJSONObject("USD");
                                String codeUsd = usdObject.getString("code");
                                String symbolUsd = usdObject.getString("symbol");
                                String descUsd = usdObject.getString("description");
                                String rateUsd = usdObject.getString("rate");

                                textViewcode.setText(codeUsd.toString());
                                textViewsymbol.setText(symbolUsd.toString());
                                textViewdesc.setText(descUsd.toString());
                                textViewrate.setText(rateUsd.toString());


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(stringRequest);

    }
    private void conectToApi2() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject bpi = jsonObject.getJSONObject("bpi");
                            //USD
                            JSONObject usdObject = bpi.getJSONObject("GBP");
                            String codeUsd = usdObject.getString("code");
                            String symbolUsd = usdObject.getString("symbol");
                            String descUsd = usdObject.getString("description");
                            String rateUsd = usdObject.getString("rate");

                            textViewcode.setText(codeUsd.toString());
                            textViewsymbol.setText(symbolUsd.toString());
                            textViewdesc.setText(descUsd.toString());
                            textViewrate.setText(rateUsd.toString());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(stringRequest2);

    }

}




























//
//    String s="Usd";
//    String g="uggg";
//    String m="Ummm";
//      switch (TextView.generateViewId()){
//              case R.id.USD:
//              Toast.makeText(des_screen.this,s,Toast.LENGTH_LONG).show();
//              break;
//              case R.id.des:
//              Toast.makeText(des_screen.this,g,Toast.LENGTH_LONG).show();
//              break;
//              case R.id.name:
//              Toast.makeText(des_screen.this,m,Toast.LENGTH_LONG).show();
//              }
//              }