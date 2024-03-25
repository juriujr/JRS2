package application;

import android.app.Application;

import cn.bmob.v3.Bmob;

public class MyApplication extends Application {
    public static final String BMOB_APPLICATION_ID = "9b030d0cd898868306960a803a95ff1c";//Bmob云服务ID
    public Bmob mBmob;

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,BMOB_APPLICATION_ID);

    }

}