package com.jrs.myapplication.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.jrs.myapplication.R;

import Bean.UserBean;
import application.MyApplication;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    private Button bt_login;
    private Button bt_regist;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initUI();
        setListener();
//        bt.setTranslationY(-1000f);
//        setBtUpAndDown(bt);
        setLAndR();



    }

    private void setListener() {
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserBean userBean = new UserBean();
                userBean.setREGISTTIME("2023-12-08 21:00:00");
                userBean.setUSERREGISTINFO("aa");
                userBean.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                        if(e == null){
                            Log.i("app",s);
                        }else{
                            Log.e("app",e.getMessage());
                        }
                    }
                });
            }
        });
        bt_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegistDialog();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showRegistDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setView(R.layout.dialog_login);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void initUI() {
        myApplication = new MyApplication();
        bt_login = findViewById(R.id.login_login);
        bt_regist = findViewById(R.id.login_regist);
    }

    private void setLAndR() {
        Animation animationLeft = AnimationUtils.loadAnimation(this,R.anim.login_bt_login_slide_in_from_left);
        animationLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bt_login.setAnimation(animationLeft);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        bt_login.setAnimation(animationLeft);


        Animation animationRight = AnimationUtils.loadAnimation(this,R.anim.login_bt_login_slide_in_from_right);
        animationRight.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bt_regist.setAnimation(animationRight);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        bt_regist.setAnimation(animationRight);
    }

    private void setBtUpAndDown(Button bt) {
        ObjectAnimator XobjectAnimator = ObjectAnimator.ofFloat(bt,"translationY",-1000f,0f);
        XobjectAnimator.setDuration(1000);

        XobjectAnimator.setInterpolator(new BounceInterpolator());

        ObjectAnimator YobjectAnimator = ObjectAnimator.ofFloat(bt,"translationY",0f,-500f);
        YobjectAnimator.setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(XobjectAnimator,YobjectAnimator);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animatorSet.start();
                    }
                },2000);

            }
        });
        animatorSet.start();
    }
}