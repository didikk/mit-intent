package me.didik.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TagMainActivity";

    EditText etEmail, etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate is called");

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy is called");
    }

    public void submitLogin(View view) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.equalsIgnoreCase("didik@me.xyz") && password.equals("password")) {
            Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
        } else
            Toast.makeText(MainActivity.this, "Email or password is invalid", Toast.LENGTH_SHORT).show();
    }
}
