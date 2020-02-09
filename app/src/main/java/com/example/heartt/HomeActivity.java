package com.example.heartt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
    }
    public void sendMessage1(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SponsorInfo.class);
        startActivity(intent);
    }

    public void sendMessage2(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Gloves.class);
        startActivity(intent);
    }

    public void sendMessage3(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SleepWell.class);
        startActivity(intent);
    }

    public void sendMessage4(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, SleepWell.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //remove up/back arrow from home screen
        getSupportActionBar().setHomeButtonEnabled(false);      // Disable the button
        getSupportActionBar().setDisplayHomeAsUpEnabled(false); // Remove the left caret
        getSupportActionBar().setDisplayShowHomeEnabled(false); // Remove the icon

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item1:
                Intent intent1 = new Intent(this, HomeActivity.class);
                startActivity(intent1);
                break;
            case R.id.item2:
                Intent intent2 = new Intent(this, HistoryActivity.class);
                startActivity(intent2);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


}


