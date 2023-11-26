package com.anushka.duty_monitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void adminbuttonclick(View view) {

        Intent intent = new Intent(getApplicationContext(),Admin.class);
        startActivity(intent);
        finish();

    }

    public void employeebuttonclick(View view) {

        Intent intent = new Intent(getApplicationContext(),Employee.class);
        startActivity(intent);
        finish();
    }

}