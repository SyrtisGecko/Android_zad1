package com.example.przemek.hsport.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RouletteGameActivity extends AppCompatActivity {
    private static final Map<Integer, Double> phi;
    static {
        phi = new HashMap<Integer, Double>();
        phi.put(8, 9.729); phi.put(30, 19.458); phi.put(11, 29.187); phi.put(36, 38.916); phi.put(13, 48.645);
        phi.put(27, 58.374); phi.put(6, 68.103); phi.put(34, 77.832); phi.put(17, 87.561);
        phi.put(25, 97.29); phi.put(2, 107.019); phi.put(21, 116.748); phi.put(4, 126.477);
        phi.put(19, 136.206); phi.put(15, 145.935); phi.put(32, 155.664); phi.put(0, 165.393);
        phi.put(26, 175.122); phi.put(3, 184.851); phi.put(35, 194.58); phi.put(12, 204.309);
        phi.put(28, 214.038); phi.put(7, 223.767); phi.put(29, 233.496); phi.put(18, 243.225);
        phi.put(22, 252.954); phi.put(9, 262.683); phi.put(31, 272.412); phi.put(14, 282.141);
        phi.put(20, 291.87); phi.put(1, 301.599); phi.put(33, 311.328); phi.put(16, 321.057);
        phi.put(24, 330.786); phi.put(5, 340.515); phi.put(10, 350.244); phi.put(23, 359.973);
    }

    private static final int GET_BET = 0;
    
    private String thisBet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette_game);
    }

    public void playRoulette(View view) {
        Random rn = new Random();
        int n = rn.nextInt(37);
        System.out.println("Wylosowano: " + n);

//        ImageView image = (ImageView) findViewById(R.id.ball1);
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.counterclockwise);
//        image.startAnimation(animation);


        playAnimation(n);
    }

    private void playAnimation(int n) {
        double d = phi.get(n);
        final float f = (float) d;
        RotateAnimation rotate = new RotateAnimation(0, -1080-f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3500);
        rotate.setInterpolator(new LinearInterpolator());
        final ImageView image= (ImageView) findViewById(R.id.ball1);
        image.setRotation(0);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image.setRotation(360-f);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        image.startAnimation(rotate);

//        ImageView image = (ImageView) findViewById(R.id.ball1);
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.counterclockwise2);
//        animation.
//        image.startAnimation(animation);
    }

    public void setTheBet(View view) {
        Intent intent = new Intent(this, BetSelectionActivity.class);
        startActivityForResult(intent, GET_BET);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GET_BET) {
            if(resultCode == RESULT_OK) {
                System.out.println("Getting back after selecting bet.");
                String bet = data.getStringExtra("bet");
                thisBet = bet;

                ImageView yourBetImage = (ImageView) findViewById(R.id.yourBet);
                int resID = getResources().getIdentifier(bet, "drawable", getPackageName());
                System.out.println(bet + ", drawable, " + getPackageName());
                yourBetImage.setImageResource(resID);
            }
        }
    }
}
