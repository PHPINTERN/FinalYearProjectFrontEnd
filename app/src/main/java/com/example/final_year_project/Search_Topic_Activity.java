package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Search_Topic_Activity extends AppCompatActivity {

    LinearLayout l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_topic);
    }

    public void search(View view) {
        l1 = findViewById(R.id.result);
        l1.setVisibility(View.VISIBLE);

    }
}