package com.example.final_year_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ERP extends AppCompatActivity {
    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erp);
        w1 =findViewById(R.id.web);
        w1.loadUrl("https://erp.kluniversity.in/");
        w1.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        w1.getSettings().setDomStorageEnabled(true);
        w1.getSettings().setJavaScriptEnabled(true);
        w1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

    }
    @Override
    public void onBackPressed() {
        w1 =findViewById(R.id.web);
        if(w1.canGoBack()) {
            w1.goBack();
        }else{
            super.onBackPressed();
        }
    }

    public void reload(View view) {
        w1 =findViewById(R.id.web);
        w1.reload();

    }
    public void logout(View view) {
        Intent intent = new Intent(getApplicationContext(), Main_Activity.class);
        startActivity(intent);
    }
}