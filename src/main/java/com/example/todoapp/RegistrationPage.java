package com.example.todoapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationPage extends AppCompatActivity {

    private EditText regName, regEmail, regPassword;
    private Button regBtn;
    private TextView loginLink;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initializing Views
        regName = findViewById(R.id.regName);
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        regBtn = findViewById(R.id.regBtn);
        loginLink = findViewById(R.id.loginLink);

        // Initializing SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        // Register Button Click
        regBtn.setOnClickListener(v -> registerUser());

        // Login Link Click
        loginLink.setOnClickListener(v -> startActivity(new Intent(RegistrationPage.this, LoginPage.class)));
    }

    private void registerUser() {
        String name = regName.getText().toString().trim();
        String email = regEmail.getText().toString().trim();
        String password = regPassword.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            regName.setError("Name is required");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            regEmail.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            regPassword.setError("Password is required");
            return;
        }

        if (password.length() < 6) {
            regPassword.setError("Password must be at least 6 characters");
            return;
        }

        // Saving User Data to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();

        Toast.makeText(this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();

        // Redirecting to Login Page
        startActivity(new Intent(RegistrationPage.this, LoginPage.class));
        finish();
    }
}
