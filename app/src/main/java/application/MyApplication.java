package application;

import android.app.Application;
import android.content.Context;
import android.provider.ContactsContract;

import cn.bmob.v3.Bmob;
import dateBase.DataBaseHalper;

public class MyApplication extends Application {
    public static final String BMOB_APPLICATION_ID = "9b030d0cd898868306960a803a95ff1c";//Bmob云服务ID
    public Bmob mBmob;
    private static MyApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.mContext = this;
        Bmob.initialize(this,BMOB_APPLICATION_ID);
        DataBaseHalper dataBaseHalper = DataBaseHalper.getInstance(mContext);
    }


}
