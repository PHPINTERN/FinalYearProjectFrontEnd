package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Class_Notes_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_notes);
    }


    public void Submit_Course_Notes(View view) {
        Intent intent = new Intent(getApplicationContext(), Course_Notes_Activity.class);
        startActivity(intent);

    }
}