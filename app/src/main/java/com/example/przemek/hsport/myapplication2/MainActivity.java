package com.example.przemek.hsport.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intention_1 = new Intent(this, Main2Activity.class);
        Button button_1 = (Button) findViewById(R.id.button);
        button_1.setOnClickListener(new View.OnClickListener()
                                    {
                                        public void onClick(View view) {
                                            startActivity(intention_1);
                                        }
                                    });
    }

    public void startTwo(View view) {
        final Intent intent_2 = new Intent(this, Main2Activity.class);
        startActivity(intent_2);
    }

    public void startThree(View view) {
        final Intent intent_3 = new Intent(this, Main3Activity.class);
        startActivity(intent_3);
    }


}
