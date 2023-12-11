package com.jrs.myapplication.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jrs.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private TextView request;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        request = findViewById(R.id.request);
        result = findViewById(R.id.result);
    }
}