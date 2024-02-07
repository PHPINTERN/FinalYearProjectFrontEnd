package com.example.final_year_project;

import static java.lang.Character.getType;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.util.Log;

import org.json.JSONObject;
import org.w3c.dom.Text;

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
                    EditText Username = (EditText) findViewById(R.id.Username);
                    String USERNAME = "";
                    USERNAME = Username.getText().toString();


                    EditText Password = (EditText) findViewById(R.id.Password);
                    String PASSWORD = "";
                    PASSWORD = Password.getText().toString();

                    String URL = "http://192.168.115.68/signin.php?Username="+USERNAME+"&Password="+PASSWORD;
//                    String URL = "http://10.0.2.2/signin.php";
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject jsonObject = response.getJSONObject("response");
                                String Status = jsonObject.getString("status");

                                String stringWithoutSpaces = Status.replaceAll("\\s", "").trim();
                                if(stringWithoutSpaces.equals("1")){
                                    String Student_Id = jsonObject.getString("student_id");
                                    Intent intent = new Intent(getApplicationContext(), Main_Activity.class);
                                    intent.putExtra("Student_Id",Student_Id);
                                    startActivity(intent);
                                }

                                else if(stringWithoutSpaces.equals("0")) {
                                    TextView not_found = (TextView) findViewById(R.id.not_found);
                                    not_found.setVisibility(View.VISIBLE);

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


}