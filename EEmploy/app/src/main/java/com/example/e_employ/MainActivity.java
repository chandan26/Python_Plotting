package com.example.e_employ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);
        button5= findViewById(R.id.button5);
        button5.setOnClickListener(view -> open_signup());
        button.setOnClickListener(view -> open_sign_in());
    }

    private void open_signup() {
        Intent intent_signup= new Intent(this, signup.class);
        startActivity(intent_signup);
    }

    private void open_sign_in() {
        Intent intent_sign= new Intent(this, signin.class);
        startActivity(intent_sign);
    }
}