package com.example.todoapp;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    ImageView logo;  // Declare ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        // ✅ Initialize logo before using it
        logo = findViewById(R.id.logo);

        // ✅ Check night mode and set the correct image
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (nightModeFlags == Configuration.UI_MODE_NIGHT_YES) {
            logo.setImageResource(R.drawable.newlogo);
        } else {
            logo.setImageResource(R.drawable.newlogo);
        }
        // Start animation
        animate(logo);

        // Apply insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void animate(View view) {
        logo.animate().alpha(1f).setDuration(4000);

        new Handler().postDelayed(() -> {
            // Navigate to LoginPage after animation
            Intent intent = new Intent(SplashScreen.this, LoginPage.class);
            startActivity(intent);
            finish();
        }, 4000);  // 4 seconds delay
    }
}