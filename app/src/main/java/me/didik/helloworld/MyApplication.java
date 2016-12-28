package me.didik.helloworld;

import android.app.Application;

/**
 * Created by didik on 12/28/16.
 * A
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SessionManager.init(this);
    }
}
