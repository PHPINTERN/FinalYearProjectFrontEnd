package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void Announcement(View view) {
        Intent intent = new Intent(getApplicationContext(), Announcement_Activity.class);
        startActivity(intent);
    }


    public void Profile(View view) {
        Intent intent =  new Intent(getApplicationContext(), Profile_Activity.class);
        startActivity(intent);
    }
}