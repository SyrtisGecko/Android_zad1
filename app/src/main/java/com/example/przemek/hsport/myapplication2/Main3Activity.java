package com.example.przemek.hsport.myapplication2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void backTo1(View view) {
        onBackPressed();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Activity_3 has been stopped", Toast.LENGTH_SHORT).show();
    }

    public void clockwise(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView3);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(animation);
    }

    public void zoom(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView3);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        image.startAnimation(animation);
    }

    public void fade(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView3);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(animation);
    }

    public void blink(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView3);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation);
    }

    public void move(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView3);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation);
    }

    public void slide(View view) {
        ImageView image = (ImageView) findViewById(R.id.imageView3);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation);
    }
}
