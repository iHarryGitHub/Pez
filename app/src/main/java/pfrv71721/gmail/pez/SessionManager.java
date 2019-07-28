package pfrv71721.gmail.pez;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SessionManager {

    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "smartSystemLogin";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    private static final String KET_ID = "idEmploy";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }



    //[START ID]
    public int getId(){
       // return pref.getInt(KET_ID,0);
        return pref.getInt(KET_ID, -1);
    }
    //[END ]

    //[START ID]
    public void setId(int id){
        editor.putInt(KET_ID,id);

        //commit id
        editor.commit();
        Log.d(TAG,"Id modified");
    }
    //[END ]
}
