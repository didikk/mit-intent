package me.didik.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView tvWelcome = (TextView) findViewById(R.id.tv_welcome);
        String email = getIntent().getStringExtra("email");
        tvWelcome.setText(String.format("Welcome %s", email));
    }
}
