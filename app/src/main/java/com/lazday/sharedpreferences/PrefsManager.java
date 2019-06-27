package com.lazday.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {
    private final String TAG = "PrefsManager";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    private int PRIVATE_MODE = 0;
    private static final String PREF_NAME   = "Prefs12345";

    public static final String SESS_TEKS_1  = "sess_teks_1";
    public static final String SESS_TEKS_2  = "sess_teks_2";
    public static final String SESS_TEKS_3  = "sess_teks_3";
    public static final String SESS_NO_4    = "sess_no_4";
    public static final String SESS_BOOL_5  = "sess_bool_5";

    public PrefsManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void putString(String key, String value){
        editor.putString(key, value);
        editor.commit();
    }
    public void putInt(String key, int value){
        editor.putInt(key, value);
        editor.commit();
    }
    public void putBoolean(String key, boolean value){
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getString(String key){
        return pref.getString(key, "");
    }
    public int getInt(String key){
        return pref.getInt(key, 0);
    }
    public boolean getBoolean(String key){
        return pref.getBoolean(key, false);
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }
}
