package com.example.heartt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginInfo extends AppCompatActivity {
    EditText name,pass;
    Button login, signup;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_info);
        name = findViewById(R.id.etUsername);
        pass = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.btnSignUp);
        db = new DBHandler(getApplicationContext());



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.login(name.getText().toString(), pass.getText().toString())){
                    Toast.makeText(getApplicationContext(),"valid", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(loginInfo.this, HomeActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.signup(name.getText().toString(), pass.getText().toString());
                Toast.makeText(getApplicationContext(),"DONE", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(loginInfo.this, HomeActivity.class);
                startActivity(intent);

            }
        });
        Intent intent = getIntent();
    }
}
