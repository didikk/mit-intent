package me.didik.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        sessionManager = new SessionManager(this);
        TextView tvWelcome = (TextView) findViewById(R.id.tv_welcome);
        String email = sessionManager.getEmail();
        tvWelcome.setText(String.format("Welcome %s", email));
    }

    public void logout(View view) {
        sessionManager.clear();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
