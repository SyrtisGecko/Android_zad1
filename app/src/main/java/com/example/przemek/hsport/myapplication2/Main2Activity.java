package com.example.przemek.hsport.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View myWindow2 = (View) findViewById(R.id.myWindow2);
        myWindow2.setOnLongClickListener(new View.OnLongClickListener()
        {
            public boolean onLongClick(View v) {
                finish();
                return false;
            }
        });
    }

    public void sendEmail(View view) {
        Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_EMAIL, new String[] {"syrtismajor@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Android App Test");
        email.putExtra(Intent.EXTRA_TEXT, "Sending email using Intent attached to button in Activity2");
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose email client..."));
    }

    public void dialNumber(View view) {
        Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:071-320-2319"));
        startActivity(dial);
    }

    public void showPics(View view) {
        Intent pics = new Intent();
        pics.setType("image/pictures/*");
        pics.setAction(Intent.ACTION_GET_CONTENT);
        startActivity(pics);
    }

    public void sendSMS(View view) {
        Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:604317811"));
        sms.putExtra("sms_body", "testing sending sms as Intent in Android Activity");
        startActivity(sms);
    }

    public void openBrowser(View view) {
        Intent browser = new Intent(Intent.ACTION_WEB_SEARCH, Uri.parse("http://www.google.com"));
        startActivity(browser);
    }
}
