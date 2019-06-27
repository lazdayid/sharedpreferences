package com.lazday.sharedpreferences;

import android.app.Application;

public class App extends Application {
    public static PrefsManager prefsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        prefsManager = new PrefsManager(this);
    }
}
