package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Profile_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        try{
            Intent intent = getIntent();
            String Student_Id1 = intent.getStringExtra("Student_Id");
            String Student_Id_String  = Student_Id1.toString();
            String IP = intent.getStringExtra("Server_Ip");
            String URL =  "http://192.168.198.68/profile.php?Student_Id="+Student_Id_String;

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try{
                        JSONObject jsonObject = response.getJSONObject("response");
                        String Status = jsonObject.getString("status");
                        String Student_Profile = jsonObject.getString("Student_Profile");
                        String Student_Name = jsonObject.getString("Student_Name");
                        String Student_Id = jsonObject.getString("Student_Id");
                        String Student_Branch = jsonObject.getString("Student_Branch");
                        String Student_PhoneNo = jsonObject.getString("Student_Phone");
                        String Student_Email = jsonObject.getString("Student_Email");
                        String Student_Address = jsonObject.getString("Student_Address");

                        if(Status.equals("1")){
//                            Toast.makeText(Profile_Activity.this,Student_Profile,Toast.LENGTH_SHORT).show();
                            ImageView imageView = (ImageView) findViewById(R.id.Student_Profile);
                            Picasso.get().load(Student_Profile).into(imageView);

                            TextView textView = (TextView) findViewById(R.id.Student_Name);
                            textView.setText(Student_Name);

                            TextView  Student_Id_TextView = (TextView) findViewById(R.id.Student_Id);
                            Student_Id_TextView.setText(Student_Id);

                            TextView BCA_TextView = (TextView) findViewById(R.id.Branch);
                            BCA_TextView.setText(Student_Branch);

                            TextView Student_Email_TextView = (TextView) findViewById(R.id.Student_Email);
                            Student_Email_TextView.setText(Student_Email);

                            TextView Student_Phone_TextView = (TextView) findViewById(R.id.Student_Number);
                            Student_Phone_TextView.setText(Student_PhoneNo);

                            TextView Student_Address_TextView = (TextView) findViewById(R.id.Student_Address);
                            Student_Address_TextView.setText(Student_Address);

                        }
                        else{
                            Toast.makeText(Profile_Activity.this,"Profile Not Found",Toast.LENGTH_SHORT).show();
                        }

                    }
                    catch (Exception e){

                       Toast.makeText(Profile_Activity.this,e.toString(),Toast.LENGTH_LONG).show();

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(Profile_Activity.this,error.toString(),Toast.LENGTH_LONG).show();
                }
            });
            requestQueue.add(jsonObjectRequest);

        }
        catch (Exception e){

            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }





    }

    public void viewmore(View view) {
        Intent intent = new Intent(getApplicationContext(), More_Profile.class);
        startActivity(intent);
    }
    public void logout(View view) {
        Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
        startActivity(intent);
    }
}