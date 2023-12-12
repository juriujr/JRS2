package dateBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHalper extends SQLiteOpenHelper {

    Context mContext;
    private static final int DB_VERSION = 1;
    private static DataBaseHalper mDataBaseHalper;

    public synchronized static DataBaseHalper getInstance(Context context){
        if(mDataBaseHalper == null ){
            mDataBaseHalper = new DataBaseHalper(context);
        }
        return mDataBaseHalper;
    }

    public DataBaseHalper(@Nullable Context context) {
        super(context, "JRSSQLITEBASE", null, DB_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
