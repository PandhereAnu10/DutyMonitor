package com.anushka.duty_monitor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Data extends AppCompatActivity {

    String sheetID = "  ";      //Insert your Sheet ID here
    String apiKEY = "   ";      //Insert your apiKey here

    String strCGPA;

    String strName;
    String strID;



    JSONArray jsonArray;
    ListView listView;

    CustomAdapter customAdapter;

    ArrayList<String> listID = new ArrayList<String>();
    ArrayList<String> listNAME = new ArrayList<String>();
    ArrayList<String> listCGPA = new ArrayList<String>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        listView = findViewById(R.id.listview_id);
        String urls = "https://sheets.googleapis.com/v4/spreadsheets/"+sheetID+"/values/Response?key="+apiKEY;

        RequestQueue queue = Volley.newRequestQueue(Data.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urls, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    jsonArray = response.getJSONArray("values");
                } catch (Exception e) {
                }

                IntStream.range(1, jsonArray.length())
                        .forEach(i -> {
                            try {
                                JSONArray json = jsonArray.getJSONArray(i);
                                strID = json.getString(0);
                                strName = json.getString(1);
                                strCGPA = json.getString(2);

                                listCGPA.add(strCGPA);
                                listNAME.add(strName);
                                listID.add(strID);



                                customAdapter = new CustomAdapter(getApplicationContext(), listCGPA, listNAME, listID);
                                listView.setAdapter(customAdapter);

                            } catch (Exception e) {
                            }

                        });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }
}