package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Login_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.login);



        try{
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String URL = "http://192.168.197.68/signin.php";
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject jsonObject = response.getJSONObject("response");
                                String Status = jsonObject.getString("status");
                                Toast.makeText(Login_Activity.this,Status ,Toast.LENGTH_SHORT).show();
                                if(Status == "1"){
                                    Intent intent = new Intent(getApplicationContext(), Main_Activity.class);
                                    startActivity(intent);
                                }
                                else{
//                                    Toast.makeText(Login_Activity.this,"User Not Found",Toast.LENGTH_SHORT).show();
                                }

                            }
                            catch (Exception e){
                                Toast.makeText(Login_Activity.this,e.toString(),Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Login_Activity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue.add(jsonObjectRequest);

                }
            });

        }
        catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();

        }


    }

    public void erp(View view) {
        Intent intent = new Intent(getApplicationContext(), ERP.class);
        startActivity(intent);


    }
    public void lms(View view) {
        Intent intent = new Intent(getApplicationContext(), LMS.class);
        startActivity(intent);


    }

//    public void login(View view) {
//        Intent intent = new Intent(getApplicationContext(), Main_Activity.class);
//        startActivity(intent);
//    }
}