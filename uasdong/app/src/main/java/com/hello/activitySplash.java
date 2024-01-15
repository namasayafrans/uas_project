package com.hello;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.Timer;
import java.util.TimerTask;

public class activitySplash extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 10000;
    ProgressBar pb;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prog();

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        // Menggunakan handler untuk menunda membuka home.class
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), home.class));
            finish();
        }, SPLASH_TIME_OUT);

        // Menyembunyikan ActionBar dan status bar
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void prog() {
        pb = findViewById(R.id.pb);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);

                if (counter == 100)
                    t.cancel();
            }
        };
        t.schedule(tt, 0, 100);
    }

}
