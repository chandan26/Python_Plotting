package com.example.e_employ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signin extends AppCompatActivity {
    private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        button3= findViewById(R.id.button3);
        button3.setOnClickListener(view -> open_menuscreen());


    }

    private void open_menuscreen() {
        Intent intent_vs= new Intent(this,app_menu.class);
        startActivity(intent_vs);
    }


}