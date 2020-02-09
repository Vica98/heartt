package com.example.heartt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);

        Intent intent = getIntent();
    }

        public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }
}
