package Tools;

import java.util.Calendar;

public class TimeUtils {

    public static String getYear(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year+"年";
    }
}
