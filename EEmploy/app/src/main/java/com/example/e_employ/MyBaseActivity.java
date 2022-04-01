package com.example.e_employ;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MyBaseActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
Toolbar toolbar;
NavigationView navigationView;
ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_base);
        drawerLayout =findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navView);
        setSupportActionBar(toolbar);
        toggle=new ActionBarDrawerToggle(this, drawerLayout,toolbar,0,0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }
}