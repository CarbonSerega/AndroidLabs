package com.example.lab2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Головна активність");
    }

    public void click_toSecondActivity(View view) {
        goToSecondActivity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.content_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch(id){
            case R.id.action_go_to_second_activity :
                goToSecondActivity();
                return true;
            case R.id.action_input_data:
                ((EditText)(findViewById(R.id.name))).setText("В'ячеслав");
                ((EditText)(findViewById(R.id.group))).setText("ІПЗ-17-1");
                ((EditText)(findViewById(R.id.phone))).setText("0688598567");

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                ((EditText)(findViewById(R.id.date))).setText(dtf.format(now));

                return true;
            case R.id.action_change_orientation:
                changeOrientation();
                return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void click_changeOrientation(View view) {
        changeOrientation();
    }

    @SuppressLint("SourceLockedOrientationActivity")
    private void changeOrientation()
    {
        int orientation = MainActivity.this.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    private void goToSecondActivity()
    {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        intent.putExtra("name", ((EditText)(findViewById(R.id.name))).getText().toString());
        intent.putExtra("group", ((EditText)(findViewById(R.id.group))).getText().toString());
        intent.putExtra("phone", ((EditText)(findViewById(R.id.phone))).getText().toString());
        intent.putExtra("date", ((EditText)(findViewById(R.id.date))).getText().toString());
        startActivity(intent);
    }
}
