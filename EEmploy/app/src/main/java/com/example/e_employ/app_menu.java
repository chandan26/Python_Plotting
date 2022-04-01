package com.example.e_employ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class app_menu extends AppCompatActivity {
    private Button buttonc3;
    private Button buttonc1;
    private Button buttonc2;
    private Button buttonc4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);
        buttonc1= findViewById(R.id.buttonc1);
        buttonc2= findViewById(R.id.buttonc2);
        buttonc3= findViewById(R.id.buttonc3);
        buttonc4= findViewById(R.id.buttonc4);
        buttonc1.setOnClickListener(view -> open_viewshifts());
        buttonc2.setOnClickListener(view -> open_punchout());
        buttonc3.setOnClickListener(view -> open_punchin());
        buttonc4.setOnClickListener(view -> open_chat());
    }

    private void open_punchout() {
        Intent intent_pout= new Intent(this,punch_out.class);
        startActivity(intent_pout);
    }

    private void open_viewshifts() {
        Intent intent_shifts= new Intent(this,ViewShifts.class);
        startActivity(intent_shifts);
    }

    private void open_chat() {
        Intent intent_chat= new Intent(this,chat.class);
        startActivity(intent_chat);

    }

    private void open_punchin() {
        Intent intent_punchin= new Intent(this,punch_in_time.class);
        startActivity(intent_punchin);

    }
}