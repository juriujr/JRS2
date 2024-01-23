package com.jrs.myapplication.ui;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.jrs.myapplication.R;

import application.MyApplication;
import fragment.FragmentMain_detail;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout mainFragmentContainer;
    private RadioGroup mainRadiogroup;
    private RadioButton mainRadiobuttonRb1;
    private RadioButton mainRadiobuttonRb2;
    private RadioButton mainRadiobuttonRbadd;
    private RadioButton mainRadiobuttonRb3;
    private RadioButton mainRadiobuttonRb4;
    private FragmentMain_detail fragmentMainDetail,fragmentMainDetail2;
    private FragmentManager fragmentManager;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        fragmentManager = getSupportFragmentManager();
        initView();
    }

    private void initView() {
        myApplication = new MyApplication();
        mainFragmentContainer = findViewById(R.id.main_fragment_container);
        mainRadiogroup = findViewById(R.id.main_radiogroup);
        for (int i = 0;i < mainRadiogroup.getChildCount();i++){
            mainRadiogroup.getChildAt(i).setId(i);
        }
//        mainRadiobuttonRb1 = findViewById(R.id.main_radiobutton_rb1);
//        mainRadiobuttonRb2 = findViewById(R.id.main_radiobutton_rb2);
//        mainRadiobuttonRbadd = findViewById(R.id.main_radiobutton_rbadd);
//        mainRadiobuttonRb3 = findViewById(R.id.main_radiobutton_rb3);
//        mainRadiobuttonRb4 = findViewById(R.id.main_radiobutton_rb4);

        mainRadiogroup.setOnCheckedChangeListener(this);
        mainRadiogroup.check(0);
//        mainRadiobuttonRb1.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (i){
            case 0:
                if(fragmentMainDetail == null){
                    fragmentMainDetail = new FragmentMain_detail();
                    fragmentTransaction.add(R.id.main_fragment_container,fragmentMainDetail);
                }else{
                    fragmentTransaction.show(fragmentMainDetail);
                }
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        if(i == R.id.main_radiobutton_rb1){

        }
        fragmentTransaction.commit();
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        //隐藏所有Fragment
            if(fragmentMainDetail != null) fragmentTransaction.hide(fragmentMainDetail);
    }
}