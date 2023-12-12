package com.jrs.myapplication.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jrs.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private Button okhttp;
    private Button retrofit;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void setListener() {
        okhttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initView() {
        okhttp = findViewById(R.id.okhttp);
        retrofit = findViewById(R.id.retrofit);
        result = findViewById(R.id.result);
    }
}