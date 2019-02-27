package com.example.stealth.log_ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class log_in extends AppCompatActivity {
    TextView textView;
    EditText Username,Password;
    Button b1;
    String permit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        textView=(TextView)findViewById(R.id.textView2) ;

        Username = (EditText)findViewById(R.id.edit_text1);
        Password=(EditText)findViewById(R.id.edit_text2);
        b1= (Button)findViewById(R.id.button3);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Medium.ttf");
        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        textView.setTypeface(myCustomFont3);
        Username.setTypeface(myCustomFont2);
        Password.setTypeface(myCustomFont2);
        b1.setTypeface(myCustomFont2);

    }

    public void onclick(View v){
        String username = Username.getText().toString();
        String password = Password.getText().toString();
        String type = "login";
        db_login backWork = new db_login(this);
        backWork.execute(type,username,password);







/*
        if(permit.equals("login successfull doc")){
            Intent intent = new Intent(this,home_doc.class);
            startActivity(intent);
        }

        else if(permit.equals("login successfull phar")){
            Intent intent = new Intent(this,home_phar.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Login unsuccessful. Please check your username and password",
                    Toast.LENGTH_LONG).show();
        }

*/


    }


}
