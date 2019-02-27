package com.example.stealth.log_ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class request extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        TextView textView=(TextView)findViewById(R.id.textView2);
        textView.setTypeface(myCustomFont3);
    }

    public void click2(View v){

       Intent intent = new Intent(this,doc_req.class);
        startActivity(intent);


    }

    public void click3(View v){

        Intent intent = new Intent(this,phar_req.class);
        startActivity(intent);




    }
}
