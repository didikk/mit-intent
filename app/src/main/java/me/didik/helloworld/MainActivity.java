package me.didik.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TagMainActivity";
    public static final String AUTH_PREFERENCES = "auth_preferences";
    public static final String EMAIL = "email";
    public static final String PASS = "pass";
    public static final String ISLOGGEDIN = "isloggedin";

    private EditText etEmail, etPassword;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(AUTH_PREFERENCES, MODE_PRIVATE);

        boolean isLoggedIn = sharedPreferences.getBoolean(ISLOGGEDIN, false);
        Log.d("isloggedin", String.valueOf(isLoggedIn));
        if (isLoggedIn) openDashboard();

        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate is called");

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
    }

    private void openDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }

    public void submitLogin(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.equalsIgnoreCase("didik@me.xyz") && password.equals("password")) {
            Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(EMAIL, email);
            editor.putString(PASS, password);
            editor.putBoolean(ISLOGGEDIN, true);
            editor.apply();

            openDashboard();
        } else
            Toast.makeText(MainActivity.this, "Email or password is invalid", Toast.LENGTH_SHORT).show();
    }
}
