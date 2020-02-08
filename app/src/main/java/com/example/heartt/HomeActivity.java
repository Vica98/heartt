package com.example.heartt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
    }
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SponsorInfo.class);
        startActivity(intent);
    }

    public void Gloves(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Gloves.class);
        startActivity(intent);
    }

    public void Sleep(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SleepWell.class);
        startActivity(intent);
    }
}
