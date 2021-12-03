package com.example.game_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView tic = (TextView) findViewById(R.id.tic);
        tic.setY(-1000);
        tic.animate().translationYBy(1000).setDuration(300);

        TextView tac = (TextView) findViewById(R.id.tac);
        tac.setX(-1000);
        tac.animate().translationXBy(1000).setDuration(300);

        TextView toe = (TextView) findViewById(R.id.toe);
        toe.setZ(-1000);
        toe.animate().translationZBy(1000).setDuration(300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent =  new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        },3000);





    }
}