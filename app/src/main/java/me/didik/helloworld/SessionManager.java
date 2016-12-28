package me.didik.helloworld;

import android.content.Context;
import android.content.SharedPreferences;

import me.didik.helloworld.model.Person;

/**
 * Created by didik on 12/28/16.
 */

public class SessionManager {
    private static final String AUTH_PREFERENCES = "auth_preferences";
    private static final String EMAIL = "email";
    private static final String PASS = "pass";
    public static final String ISLOGGEDIN = "isloggedin";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(AUTH_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(Person person) {
        editor.putString(EMAIL, person.getEmail());
        editor.putString(PASS, person.getPassword());
        editor.putBoolean(ISLOGGEDIN, true);
        editor.apply();
    }

    public String getEmail() {
        return sharedPreferences.getString(EMAIL, "");
    }

    public String getPass() {
        return sharedPreferences.getString(PASS, "");
    }

    public boolean isLoggedin() {
        return sharedPreferences.getBoolean(ISLOGGEDIN, false);
    }

    public void clear() {
        editor.clear();
        editor.apply();
    }
}
