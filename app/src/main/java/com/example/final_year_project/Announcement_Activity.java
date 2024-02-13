package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Announcement_Activity extends AppCompatActivity {

    ArrayList<String> title_array ;
    ArrayList<String> date_array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        ListView listView = (ListView) findViewById(R.id.listview);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        try{
            String url ="http://10.0.2.0/annoucement.php";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        JSONObject jsonObject = response.getJSONObject("response");
                        String Status = jsonObject.getString("status");
                        JSONArray item = jsonObject.getJSONArray("user");



                        for(int i = 0; i<item.length();i++){
                            JSONObject title = item.getJSONObject(i);
                            String Notification_title = title.getString("Ttile");
                            title_array.add(Notification_title);
                            String Notification_Date = title.getString("Date");
                            date_array.add(Notification_Date);

                            Notification_Adapter notificationAdapter = new Notification_Adapter(getApplicationContext(),title_array,date_array);
                            listView.setAdapter(notificationAdapter);



                        }

                    } catch (JSONException e) {
                        Toast.makeText(Announcement_Activity.this,"Error: "+e.toString(),Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            requestQueue.add(jsonObjectRequest);

        }
        catch (Exception e){
            Toast.makeText(this,"Error: "+e.toString(),Toast.LENGTH_SHORT).show();
        }


    }



    public void logout(View view) {
        Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
        startActivity(intent);
    }

    public void Acadmic(View view) {
        Intent intent = new Intent(getApplicationContext(),Acadamic_Calander_Activity.class);
        startActivity(intent);
    }
}