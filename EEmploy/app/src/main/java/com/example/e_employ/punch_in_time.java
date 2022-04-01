package com.example.e_employ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class punch_in_time extends AppCompatActivity {
    private Button buttonp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch_in_time);
        Button buttonp1 = findViewById(R.id.buttonp1);
        buttonp1.setOnClickListener(view -> {

            punch_toast();

        } );

    }

    private void punch_toast() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(" d MMM yyyy HH:mm:ss ");
        String time =  format.format(calendar.getTime());
        toastMsg("Your punch in Time is "+time);

    }
    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}