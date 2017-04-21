package com.example.przemek.hsport.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    private static final Map<Integer, String> betDetails;
    static {
        betDetails = new HashMap<Integer, String>();
        betDetails.put(0, "bet0g"); betDetails.put(1, "bet1r"); betDetails.put(2, "bet2b"); betDetails.put(3, "bet3r");
        betDetails.put(4, "bet4b"); betDetails.put(5, "bet5r"); betDetails.put(6, "bet6b");
        betDetails.put(7, "bet7r"); betDetails.put(8, "bet8b"); betDetails.put(9, "bet9r");
        betDetails.put(10, "bet10b"); betDetails.put(11, "bet11b"); betDetails.put(12, "bet12r");
        betDetails.put(13, "bet13b"); betDetails.put(14, "bet14r"); betDetails.put(15, "bet15b");
        betDetails.put(16, "bet16r"); betDetails.put(17, "bet17b"); betDetails.put(18, "bet18r");
        betDetails.put(19, "bet19r"); betDetails.put(20, "bet20b"); betDetails.put(21, "bet21r");
        betDetails.put(22, "bet22b"); betDetails.put(23, "bet23r"); betDetails.put(24, "bet24b");
        betDetails.put(25, "bet25r"); betDetails.put(26, "bet26b"); betDetails.put(27, "bet27r");
        betDetails.put(28, "bet28b"); betDetails.put(29, "bet29b"); betDetails.put(30, "bet30r");
        betDetails.put(31, "bet31b"); betDetails.put(32, "bet32r"); betDetails.put(33, "bet33b");
        betDetails.put(34, "bet34r"); betDetails.put(35, "bet35b"); betDetails.put(36, "bet36r");
    }

    private static final int GET_BET = 0;
    
    protected String thisBet = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette_game);
    }

    public void playRoulette(View view) {
        Random rn = new Random();
        int n = rn.nextInt(37);
//        n = 4;                                      // !!! CHEATING !!!
        System.out.println("Wylosowano: " + n);

//        ImageView image = (ImageView) findViewById(R.id.ball1);
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.counterclockwise);
//        image.startAnimation(animation);


        playAnimation(n);
//        validateScore(n);
    }

    private void validateScore(int n) {
        if(thisBet == null || thisBet.isEmpty()) {
            Toast.makeText(getApplicationContext(), "You didn't select your bet! \nTry again.", Toast.LENGTH_SHORT).show();
        } else if(betDetails.get(n).equals(thisBet)) {
            Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou won.", Toast.LENGTH_SHORT).show();
        } else if(n%2 == 0 && thisBet.equals("beteven")) {
            Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed it's even.", Toast.LENGTH_SHORT).show();
        } else if(n%2 == 1 && thisBet.equals("betodd")) {
            Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed it's odd.", Toast.LENGTH_SHORT).show();
        } else if(thisBet.equals("betred")) {
            if(n == 1 || n == 3 || n == 5 || n == 7 || n == 9 || n == 12 || n == 14 || n == 16 || n == 18 || n == 19 ||
                    n == 21 || n == 23 || n == 25 || n == 27 || n == 30 || n == 32 || n == 34 || n == 36) {
                Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed the color.", Toast.LENGTH_SHORT).show();
            }
        } else if(thisBet.equals("betblack")) {
            if(n == 2 || n == 4 || n == 6 || n == 8 || n == 10 || n == 11 || n == 13 || n == 15 || n == 17 || n == 20 ||
                    n == 22 || n == 24 || n == 26 || n == 28 || n == 29 || n == 31 || n == 33 || n == 35) {
                Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed the color.", Toast.LENGTH_SHORT).show();
            }
        } else if (thisBet.equals("bet1st12") && n <= 12) {
            Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed the number range.", Toast.LENGTH_SHORT).show();
        } else if (thisBet.equals("bet2nd12") && n > 12 && n <= 24) {
            Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed the number range.", Toast.LENGTH_SHORT).show();
        } else if (thisBet.equals("bet3rd12") && n > 24) {
            Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed the number range.", Toast.LENGTH_SHORT).show();
        } else if (thisBet.equals("bet1to18") && n <= 18) {
            Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed the number range.", Toast.LENGTH_SHORT).show();
        } else if (thisBet.equals("bet19to36") && n > 18) {
            Toast.makeText(getApplicationContext(), "!!!CONGRATULATIONS!!!\nYou guessed the number range.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Not this time.\nTry again.", Toast.LENGTH_SHORT).show();
        }
    }

    private void playAnimation(final int n) {
        double d = phi.get(n);
        final float f = (float) d;

        RotateAnimation rotate = new RotateAnimation(0, -1080-f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(3500);
        rotate.setInterpolator(new LinearInterpolator());

        final ImageView image= (ImageView) findViewById(R.id.ball1);
        image.setRotation(0);

        final TextView text = (TextView) findViewById(R.id.resultText);
        text.setText("Result: ");

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                image.setRotation(360-f);

                text.setText("Result: " + n);
                validateScore(n);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        image.startAnimation(rotate);
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
