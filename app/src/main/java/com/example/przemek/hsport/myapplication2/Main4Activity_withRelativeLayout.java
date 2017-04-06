package com.example.przemek.hsport.myapplication2;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class Main4Activity_withRelativeLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4_with_relative_layout);
    }

    public void letsGetBack(View view) {
        Random rn = new Random();
        int n = rn.nextInt(100) + 1;

        if(n <= 25) {
            onBackPressed();
        } else {
            Toast.makeText(getApplicationContext(), "NOPE. Not this time.", Toast.LENGTH_SHORT).show();
        }

    }

}
