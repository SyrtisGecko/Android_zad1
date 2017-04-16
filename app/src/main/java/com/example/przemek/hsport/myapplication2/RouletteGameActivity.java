package com.example.przemek.hsport.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class RouletteGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette_game);
    }

    public void playRoulette(View view) {
        ImageView image = (ImageView) findViewById(R.id.ball1);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.counterclockwise);
        image.startAnimation(animation);
    }

    public void setTheBet(View view) {
        Intent intent = new Intent(this, BetSelectionActivity.class);
        startActivity(intent);
    }
}
