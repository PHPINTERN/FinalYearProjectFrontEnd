package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
            startActivity(intent);

        }
        catch (Exception e){
            TextView textView = (TextView) findViewById(R.id.normal);
            String TEXT = e.toString();
            textView.setText(TEXT);
        }

    }
}