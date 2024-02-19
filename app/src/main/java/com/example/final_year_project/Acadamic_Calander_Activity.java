package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Acadamic_Calander_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acadamic_calander);
        try{


        String[] Branch = {"MCA","BCA"};
        String[] Year = {"1st Year","2nd Year","3rd Year"};
        String[] Semester = {"ODD","EVEN","SUMMER"};
        Spinner spinner = (Spinner) findViewById(R.id.Acdamic_Calander_Branch);




        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Acadamic_Calander_Activity.this, android.R.layout.simple_spinner_item,Branch);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        try{


        Spinner spinner1 = (Spinner) findViewById(R.id.Acdamic_Calander_Year);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(Acadamic_Calander_Activity.this, android.R.layout.simple_spinner_item,Year);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(arrayAdapter1);
        }
        catch (Exception e){
            Toast.makeText(this,"Year Spinner "+e.toString(),Toast.LENGTH_SHORT).show();
        }

        try{
            Spinner spinner2 = (Spinner) findViewById(R.id.Acdamic_Calander_Semester);
            ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String >(Acadamic_Calander_Activity.this, android.R.layout.simple_spinner_item,Semester);
            spinner2.setAdapter(arrayAdapter2);
        }
        catch (Exception e){
            Toast.makeText(this,"Semster Spinner"+e.toString(),Toast.LENGTH_SHORT).show();
        }


        }
        catch (Exception e){
            Toast.makeText(this,"Whole Spinner"+e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

    public void viewmore(View view) {
        Intent intent =  new Intent(getApplicationContext(),Acadamic_Calander_Course.class);
        startActivity(intent);
    }
}