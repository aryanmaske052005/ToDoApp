package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the splash screen layout
        setContentView(R.layout.activity_main);

        // Handler to delay the transition to the login activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the Login Activity after the delay
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();  // Close the Splash Screen so the user cannot return to it
            }
        }, 3000);  // 3000ms = 3 seconds delay
    }
}
