package com.example.pradipa_11rpl1_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class ControlClass extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        if (sharedPreferences.getString("username", "").isEmpty() ||
        sharedPreferences.getString("username", "").equalsIgnoreCase("")){

            //login dlu
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

            finish();

        } else {
            startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));

            finish();
        }
    }
}