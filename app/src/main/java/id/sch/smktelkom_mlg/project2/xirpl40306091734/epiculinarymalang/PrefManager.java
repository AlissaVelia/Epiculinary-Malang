package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang;

/**
 * Created by yoan on 3/30/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Microsoft on 08/11/2016.
 */

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    //shared pref mode
    int PRIVATE_MODE = 0;

    //Shared preferences file name
    private static final String PREF_NAME = "Mbok Jamu";

    private static final String IS_FIRST_TIME_LAUCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch(){
        return pref.getBoolean(IS_FIRST_TIME_LAUCH, true);
    }


}
