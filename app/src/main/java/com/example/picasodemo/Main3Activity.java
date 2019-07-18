package com.example.picasodemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
TextView tv,tv1;
String arr[]={"","","V","I","R","T","U","A","L"};
String arr1[]={"L","I","B","R","A","R","Y",""};
private static int SPLASH_TIME_OUT=4000;
String abc="",abc1="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
tv=findViewById(R.id.textView);
        tv1=findViewById(R.id.textView2);
        tv1.setVisibility(View.INVISIBLE);
        Thread t1=new Thread(new Runnable() {
    @Override
    public void run() {

        for (int i = 0; i < 9; i++) {
            try {
                abc = abc + arr[i];
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(abc);
                    }
                });
                Log.d("doing", abc);
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 8; i++) {
            try {
                    abc1 = abc1 + arr1[i];
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setVisibility(View.VISIBLE);
                        tv1.setText(abc1);
                    }
                });
                Log.d("doing", abc1);
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }});
        t1.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }}



