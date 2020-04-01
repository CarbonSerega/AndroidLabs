package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Головна активність");
    }

    public void click_toSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        intent.putExtra("name", ((EditText)(findViewById(R.id.name))).getText().toString());
        intent.putExtra("group", ((EditText)(findViewById(R.id.group))).getText().toString());
        intent.putExtra("phone", ((EditText)(findViewById(R.id.phone))).getText().toString());
        intent.putExtra("date", ((EditText)(findViewById(R.id.date))).getText().toString());
        startActivity(intent);
    }

    @SuppressLint("SourceLockedOrientationActivity")
    public void click_changeOrientation(View view) {
        int orientation = MainActivity.this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}
