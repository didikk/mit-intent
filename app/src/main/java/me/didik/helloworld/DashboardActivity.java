package me.didik.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sharedPreferences = getSharedPreferences(MainActivity.AUTH_PREFERENCES, MODE_PRIVATE);

        TextView tvWelcome = (TextView) findViewById(R.id.tv_welcome);
        String email = sharedPreferences.getString(MainActivity.EMAIL, "");
        tvWelcome.setText(String.format("Welcome %s", email));
    }

    public void logout(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
