package com.example.stealth.log_ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=(TextView) findViewById(R.id.textView2);
        b1= (Button)findViewById(R.id.button1);
        b2= (Button)findViewById(R.id.button2);
        b3= (Button)findViewById(R.id.button3);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        textView1.setTypeface(myCustomFont);
        b1.setTypeface(myCustomFont2);
        b2.setTypeface(myCustomFont2);
        b3.setTypeface(myCustomFont2);


    }

    public void click(View v){
        Intent intent = new Intent(this, log_in.class);
        startActivity(intent);

    }

    public void click2(View v){
        Intent intent = new Intent(this, registration.class);
        startActivity(intent);

    }

    public void click3(View v){
        Intent intent = new Intent(this, request.class);
        startActivity(intent);

    }
}
