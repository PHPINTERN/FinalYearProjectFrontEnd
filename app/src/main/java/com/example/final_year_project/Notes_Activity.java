package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Notes_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
    }

    public void Class_Notes(View view) {
        Intent intent = new Intent(getApplicationContext(),Class_Notes_Activity.class);
        startActivity(intent);
    }

    public void mynotes(View view) {
        Intent intent = new Intent(getApplicationContext(), MyNotes_Activity.class);
        startActivity(intent);
    }
}