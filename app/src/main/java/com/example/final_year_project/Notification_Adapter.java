package com.example.final_year_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Notification_Adapter extends BaseAdapter {
    Context context;


    ArrayList<String> title;
    ArrayList<String> data;
    LayoutInflater inflater;

    Notification_Adapter(Context context, ArrayList<String> title, ArrayList<String> data){
            this.context = context;
            this.data = data;
            this.title = title;
            inflater = (LayoutInflater.from(context));

    }
    @Override
    public int getCount() {

        return title.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater.inflate(R.layout.view_notification_listview,null);
        TextView textView = (TextView) convertView.findViewById(R.id.notification_title);
        TextView textView1 = (TextView)  convertView.findViewById(R.id.notification_content);
        textView.setText(title.get(position));
        textView1.setText(title.get(position));
        return null;
    }
}
