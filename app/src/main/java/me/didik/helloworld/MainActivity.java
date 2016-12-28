package me.didik.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import me.didik.helloworld.model.Person;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TagMainActivity";

    private EditText etEmail, etPassword;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = new SessionManager(this);
        if (sessionManager.isLoggedin()) openDashboard();

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

            Person person = new Person(email, password);
            sessionManager.setLogin(person);
            openDashboard();
        } else
            Toast.makeText(MainActivity.this, "Email or password is invalid", Toast.LENGTH_SHORT).show();
    }
}
