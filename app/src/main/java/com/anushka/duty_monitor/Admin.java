package com.anushka.duty_monitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void retrievebuttonclick(View view) {

        Intent intent = new Intent(getApplicationContext(),Data.class);
        startActivity(intent);

    }

    public void databuttonclick(View view) {
        Intent intent = new Intent(getApplicationContext(),ImageData.class);
        startActivity(intent);
    }
}