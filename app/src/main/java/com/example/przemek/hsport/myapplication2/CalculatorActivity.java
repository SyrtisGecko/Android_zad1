package com.example.przemek.hsport.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private String currentDisplay = "0";
    private String memory = "0";
    private int currentTask = 0;        // 1- for Add,  2 - for Sub,  3 - for Mult


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void on1Click(View view) {
        onNumberClick("1");
        setDisplay();
    }

    public void on2Click(View view) {
        onNumberClick("2");
        setDisplay();
    }

    public void on3Click(View view) {
        onNumberClick("3");
        setDisplay();
    }

    public void on4Click(View view) {
        onNumberClick("4");
        setDisplay();
    }

    public void on5Click(View view) {
        onNumberClick("5");
        setDisplay();
    }

    public void on6Click(View view) {
        onNumberClick("6");
        setDisplay();
    }

    public void on7Click(View view) {
        onNumberClick("7");
        setDisplay();
    }

    public void on8Click(View view) {
        onNumberClick("8");
        setDisplay();
    }

    public void on9Click(View view) {
        onNumberClick("9");
        setDisplay();
    }

    public void on0Click(View view) {
        onNumberClick("0");
        setDisplay();
    }

    public void onCEClick(View view) {
        currentDisplay = "0";
        memory = "0";
        currentTask = 0;
        setDisplay();
    }

    public void onMClick(View view) {
        if(checkIfDisplayZero()) {
            currentDisplay = memory;
        } else {
            memory = currentDisplay;
        }

        setDisplay();
    }

    public void onMultiplyClick(View view) {
        doCurrentTask();
        currentTask = 3;
        currentDisplay = memory;
        setDisplay();
        currentDisplay = "0";
    }

    public void onDivideClick(View view) {
        doCurrentTask();
        currentTask = 4;
        currentDisplay = memory;
        setDisplay();
        currentDisplay = "0";
    }

    public void onSubstractClick(View view) {
        doCurrentTask();
        currentTask = 2;
        currentDisplay = memory;
        setDisplay();
        currentDisplay = "0";
    }

    public void onAddClick(View view) {
        doCurrentTask();
        currentTask = 1;
        currentDisplay = memory;
        setDisplay();
        currentDisplay = "0";
    }

    public void onEqualsClick(View view) {
        doCurrentTask();
        currentDisplay = memory;
        setDisplay();
        currentTask = 0;
    }

    private void setDisplay() {
        TextView displayText = (TextView) findViewById(R.id.textView10);
        displayText.setText(currentDisplay);
    }

    public void onNumberClick(String s) {
        if(checkIfDisplayZero()) {
            currentDisplay = s;
        } else {
            currentDisplay = currentDisplay + s;
        }
    }

    private boolean checkIfDisplayZero() {
        if(currentDisplay.equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    public void doCurrentTask() {
        if(currentTask == 1) {
            int mem = (Integer.parseInt(memory) + Integer.parseInt(currentDisplay));
            memory = "" + mem;
        } else if(currentTask == 2) {
            int mem = (Integer.parseInt(memory) - Integer.parseInt(currentDisplay));
            memory = "" + mem;
        } else if(currentTask == 3) {
            int mem = (Integer.parseInt(memory) * Integer.parseInt(currentDisplay));
            memory = "" + mem;
        } else if(currentTask == 4) {
            int mem = (Integer.parseInt(memory) / Integer.parseInt(currentDisplay));
            memory = "" + mem;
        } else {
            memory = currentDisplay;
        }
    }
}
