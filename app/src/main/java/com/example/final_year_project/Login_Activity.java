package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void erp(View view) {
        Intent intent = new Intent(getApplicationContext(), ERP.class);
        startActivity(intent);


    }
    public void lms(View view) {
        Intent intent = new Intent(getApplicationContext(), LMS.class);
        startActivity(intent);


    }

    public void login(View view) {
        Intent intent = new Intent(getApplicationContext(), Main_Activity.class);
        startActivity(intent);
    }
}