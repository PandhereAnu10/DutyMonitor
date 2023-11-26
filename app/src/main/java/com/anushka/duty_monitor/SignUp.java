package com.anushka.duty_monitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

    TextInputLayout user_var, email_var, pass_var;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user_var = findViewById(R.id.name);
        email_var = findViewById(R.id.email);
        pass_var = findViewById(R.id.id_password);

    }

    public void loginbuttonclick(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();
    }

    public void registerbuttonclick(View view) {
        String user = user_var.getEditText().getText().toString();
        String email = email_var.getEditText().getText().toString();
        String pass = pass_var.getEditText().getText().toString();

        if(!user.isEmpty()){
            user_var.setError(null);
            user_var.setErrorEnabled(false);
            if(!email.isEmpty()){
                email_var.setError(null);
                email_var.setErrorEnabled(false);
                if(!pass.isEmpty()){
                    pass_var.setError(null);
                    pass_var.setErrorEnabled(false);
                    if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
                        email_var.setError("Invalid email");
                    }else{

                        firebaseDatabase = FirebaseDatabase.getInstance();
                        reference = firebaseDatabase.getReference("datauser");

                        String user_s = user_var.getEditText().getText().toString();
                        String email_s = email_var.getEditText().getText().toString();
                        String pass_s = pass_var.getEditText().getText().toString();

                        storingdata storingdatass = new storingdata(user_s,email_s,pass_s);

                        reference.child(user_s).setValue(storingdatass);

                        Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                        finish();
                    }
                }else{
                    pass_var.setError("Please enter the password");
                }
            }else{
                email_var.setError("Please enter the email");
            }
        }else {
            user_var.setError("Please enter the user name");
        }

    }

}