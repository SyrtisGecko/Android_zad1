package com.example.przemek.hsport.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static android.R.attr.path;

public class BetSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bet_selection);
    }

    public void makeTheBet(View view) {
        System.out.println("Making a bet.");
        ImageView image = (ImageView) findViewById(view.getId());
        String betName = (String) image.getTag();
        System.out.println(betName);


        Intent resultIntent = new Intent();
        resultIntent.putExtra("bet", betName);
//        resultIntent.putExtra("surname", surnameToSendBack);
//        resultIntent.putExtra("description", descriptionToSendBack);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
