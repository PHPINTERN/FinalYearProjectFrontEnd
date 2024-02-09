package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LMS extends AppCompatActivity {

    WebView w1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_lms);

        w1 = findViewById(R.id.web);
        w1.loadUrl("https://lms.kluniversity.in/");

        w1.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        w1.getSettings().setDomStorageEnabled(true);
        w1.getSettings().setJavaScriptEnabled(true);
        w1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

    }

    @Override
    public void onBackPressed() {
        if (w1.canGoBack()) {
            w1.goBack();
        } else {
            super.onBackPressed();
        }
    }
    public void logout(View view) {
        Intent intent = new Intent(getApplicationContext(), Main_Activity.class);
        startActivity(intent);
    }
}