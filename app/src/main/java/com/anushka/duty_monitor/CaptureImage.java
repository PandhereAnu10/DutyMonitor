package com.anushka.duty_monitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CaptureImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image);
    }

    public void openApp(View view) {
        Intent intent =  getPackageManager().getLaunchIntentForPackage("com.codebyashish.geotagimage");

        if(intent != null){
            startActivity(intent);
        }else{
            Toast.makeText(this, "The app is not installed on the device", Toast.LENGTH_LONG).show();
        }
    }
}