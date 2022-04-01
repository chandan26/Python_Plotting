package com.example.e_employ;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class punch_out extends AppCompatActivity {
    private Button buttonpo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch_out);
        Button buttonpo1 = findViewById(R.id.buttonpo1);
        buttonpo1.setOnClickListener(view -> {

            puncho_toast();

        } );
    }

    private void puncho_toast() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(" d MMM yyyy HH:mm:ss ");
        String time =  format.format(calendar.getTime());
        toastMsgo("Your punch in Time is "+time);
    }

    public void toastMsgo(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}