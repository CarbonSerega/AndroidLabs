package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("Про додаток");

        Bundle extras = getIntent().getExtras();
        ((TextView)(findViewById(R.id.name))).setText(extras.get("name").toString());
        ((TextView)(findViewById(R.id.group))).setText(extras.get("group").toString());
        ((TextView)(findViewById(R.id.phone))).setText(extras.get("phone").toString());
        ((TextView)(findViewById(R.id.date))).setText(extras.get("date").toString());
    }

    public void click_backToMain(View view) {
        finish();
    }

}
