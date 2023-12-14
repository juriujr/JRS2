package dateBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.jrs.myapplication.R;

import java.io.IOException;
import java.util.List;

import Utils.XMLPullUtils;

public class DataBaseHalper extends SQLiteOpenHelper {

    Context mContext;
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "JRSSQLITEBASE";
    private static DataBaseHalper mDataBaseHalper;
    private List<String> tableSql ;

    public synchronized static DataBaseHalper getInstance(Context context){
        if(mDataBaseHalper == null ){
            mDataBaseHalper = new DataBaseHalper(context);
        }
        return mDataBaseHalper;
    }

    public DataBaseHalper(@Nullable Context context) {
        super(context, "JRSSQLITEBASE", null, DB_VERSION);
        this.mContext = context;
        try {

            tableSql =  XMLPullUtils.getAllTable(context.getResources().openRawResource(R.xml.tablelist));
            Log.i("dbhelper","创建成功");
        } catch (Exception e) {
            Log.i("dbhelper","创建失败" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (String sql : tableSql){
            sqLiteDatabase.execSQL(sql);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
