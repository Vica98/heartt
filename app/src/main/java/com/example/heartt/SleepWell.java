package com.example.heartt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SleepWell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_well);

    }

    public void sendMessage1(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
}
