package com.anushka.duty_monitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Employee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
    }

    public void capturebuttonclick(View view) {
        Intent intent = new Intent(getApplicationContext(),CaptureImage.class);
        startActivity(intent);
        finish();
    }

    public void uploadbuttonclick(View view) {

        Intent intent = new Intent(getApplicationContext(),UploadImage.class);
        startActivity(intent);
        finish();

    }

}