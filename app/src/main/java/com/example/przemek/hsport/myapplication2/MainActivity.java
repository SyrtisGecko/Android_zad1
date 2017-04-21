package com.example.przemek.hsport.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private static final int GET_DETAILS_RESULT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Intent intention_1 = new Intent(this, Main2Activity.class);
//        Button button_1 = (Button) findViewById(R.id.button);
//        button_1.setOnClickListener(new View.OnClickListener()
//                                    {
//                                        public void onClick(View view) {
//                                            startActivity(intention_1);
//                                        }
//                                    });
    }

//    public void startTwo(View view) {
//        final Intent intent_2 = new Intent(this, Main2Activity.class);
//        startActivity(intent_2);
//    }
//
//    public void startThree(View view) {
//        final Intent intent_3 = new Intent(this, Main3Activity.class);
//        startActivity(intent_3);
//    }
//
//    public void startFour_RL(View view) {
//        final Intent intent_4 = new Intent(this, Main4Activity_withRelativeLayout.class);
//        startActivity(intent_4);
//    }
//
//    public void startFive_TL(View view) {
//        final Intent intent_5 = new Intent(this, Main5Activity_withTableLayout.class);
//        startActivity(intent_5);
//    }
//
//    public void startSix_FL(View view) {
//        final Intent intent_6 = new Intent(this, Main6Activity_withFrameLayout.class);
//        startActivity(intent_6);
//    }
//
//    public void getDetails(View view) {
//        Intent intent = new Intent(this, Main5Activity_withTableLayout.class);
//        startActivityForResult(intent, GET_DETAILS_RESULT_CODE);
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == GET_DETAILS_RESULT_CODE) {
//            if(resultCode == RESULT_OK) {
//                String resultName = data.getStringExtra("name");
//                String resultSurname = data.getStringExtra("surname");
//                String resultDescription = data.getStringExtra("description");
//
//                TextView textViewName = (TextView) findViewById(R.id.textView6);
//                textViewName.setText("Name: " + resultName);
//                TextView textViewSurname = (TextView) findViewById(R.id.textView8);
//                textViewSurname.setText("Surname: " + resultSurname);
//                TextView textViewDescription = (TextView) findViewById(R.id.textView7);
//                textViewDescription.setText("Description: " + resultDescription);
//            }
//        }
//    }

    public void startPracticing(View view) {
        Intent intent_6 = new Intent(this, PracticingActivity.class);
        startActivity(intent_6);
    }

    public void playRouletteGame(View view) {
        Intent intent = new Intent(this, RouletteGameActivity.class);
        startActivity(intent);
    }
}
