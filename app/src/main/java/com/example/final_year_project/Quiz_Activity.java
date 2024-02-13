package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Quiz_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void Quiz_Submit(View view) {
        Toast.makeText(this,"QUIZ STARTED",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),Course_Co_Quiz_Activity.class);
        startActivity(intent);

    }


    public void Course_Quiz(View view) {
        Intent intent = new Intent(getApplicationContext(),Course_Quiz.class);
        startActivity(intent);
    }
}