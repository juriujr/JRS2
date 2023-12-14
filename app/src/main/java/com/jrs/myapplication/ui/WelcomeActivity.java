package com.jrs.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.jrs.myapplication.R;

import application.MyApplication;

public class WelcomeActivity extends AppCompatActivity {
    private MyApplication mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mApplication = (MyApplication) getApplication();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}