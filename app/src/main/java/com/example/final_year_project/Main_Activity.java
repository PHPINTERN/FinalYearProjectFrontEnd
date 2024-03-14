package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);






//        Toast.makeText(this, Student_Id,Toast.LENGTH_SHORT).show();

    }

    public void Announcement(View view) {

        Intent announcement = new Intent(getApplicationContext(), Announcement_Activity.class);
//        announcement.putExtra("Student_Id",Student_Id);

        startActivity(announcement);
    }


    public void Profile(View view) {
        Intent intent11 = getIntent();
        String Student_Id = intent11.getStringExtra("Student_Id");
        String IP = intent11.getStringExtra("Server_Ip");
       Intent Profile = new Intent(getApplicationContext(), Profile_Activity.class);
        Profile.putExtra("Student_Id",Student_Id);
        Profile.putExtra("Server_Ip", IP);
       startActivity(Profile);
    }
    public void logout(View view) {
        Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
        startActivity(intent);
    }

    public void notes(View view) {
        Intent intent = new Intent(getApplicationContext(),Notes_Activity.class);
        startActivity(intent);
    }

    public void Quiz_Activity(View view) {
        Intent intent = new Intent(getApplicationContext(), Quiz_Activity.class);
        startActivity(intent);
    }

    public void Help_Desk(View view) {
        Intent intent =  new Intent(getApplicationContext(),HelpDesk_Activity.class);
        startActivity(intent);
    }

    public void anyqueries(View view) {
        Intent intent = new Intent(getApplicationContext(),Search_Topic_Activity.class);
        startActivity(intent);
    }
}