package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class More_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_profile);
    }

    public void logout(View view) {
        Intent intent = new Intent(getApplicationContext(),  Login_Activity.class);
        startActivity(intent);
    }
}