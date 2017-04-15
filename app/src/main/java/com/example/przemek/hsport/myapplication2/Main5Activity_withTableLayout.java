package com.example.przemek.hsport.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;

public class Main5Activity_withTableLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_with_table_layout);
    }

    public void sendAll(View view) {
        EditText textName = (EditText) findViewById(R.id.editText2);
        EditText textSurname = (EditText) findViewById(R.id.editText3);
        EditText textDescription = (EditText) findViewById(R.id.editText4);

        String nameToSendBack = textName.getText().toString();
        String surnameToSendBack = textSurname.getText().toString();
        String descriptionToSendBack = textDescription.getText().toString();

        Intent resultIntent = new Intent();
        resultIntent.putExtra("name", nameToSendBack);
        resultIntent.putExtra("surname", surnameToSendBack);
        resultIntent.putExtra("description", descriptionToSendBack);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

}
