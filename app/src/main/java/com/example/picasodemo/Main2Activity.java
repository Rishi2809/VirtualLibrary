package com.example.picasodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {
ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pb=findViewById(R.id.progressBar);
        WebView webView=findViewById(R.id.webview);
   String pdf=getIntent().getStringExtra("pdf");
   String url=getIntent().getStringExtra("url");
        Log.d("data",pdf+","+url);
        if(url==null){
        webView.loadUrl("https://docs.google.com/viewer?url=" + pdf);
        webView.getSettings().setJavaScriptEnabled(true);
    }else
        {
            webView.loadUrl(url);
            webView.getSettings().setJavaScriptEnabled(true);
        }
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                pb.setVisibility(View.VISIBLE);
                return false;

            }

            @Override
            public void onLoadResource(WebView view, String url) {
                pb.setVisibility(View.GONE);

                super.onLoadResource(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);

                pb.setVisibility(View.GONE);
            }
        });

    }}
