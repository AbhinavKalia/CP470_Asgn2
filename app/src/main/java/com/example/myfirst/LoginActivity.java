package com.example.myfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText emailAddress;
    private Button loginButton;

    protected static final String ACTIVITY_NAME = "LoginActivity";

    private SharedPreferences appPreferences;
    private String sharedPreferencesFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"In onCreate()");

        loginButton = findViewById(R.id.login_b);
        emailAddress = findViewById(R.id.email);
        sharedPreferencesFile = "com.example.myfirst.sharedpreferencesfile";

        appPreferences = getSharedPreferences(sharedPreferencesFile, MODE_PRIVATE);
        String userName = appPreferences.getString("LOGIN_USER_NAME", "");
        if(!(userName.equals("")))
        {
            emailAddress.setText(userName);
        }
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String user = emailAddress.getText().toString().trim();

                if(!(user.equals("")))
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"In onResume()");

    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"In onStart()");

    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"In onPause()");
        SharedPreferences.Editor prefEditor = appPreferences.edit();
        prefEditor.putString("LOGIN_USER_NAME", emailAddress.getText().toString().trim());
        prefEditor.apply();

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"In onStop()");

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In onDestroy()");

    }
}