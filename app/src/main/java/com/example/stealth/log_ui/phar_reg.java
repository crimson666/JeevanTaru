package com.example.stealth.log_ui;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class phar_reg extends AppCompatActivity {

    EditText name,username,password,license,phone,email,fax,address,pin,vhour;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phar_reg);
        textView=(TextView)findViewById(R.id.text1);
        name=(EditText)findViewById(R.id.name);
        username=(EditText)findViewById(R.id.uname);
        password=(EditText)findViewById(R.id.password);
        license=(EditText)findViewById(R.id.license);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        fax=(EditText)findViewById(R.id.fax);
        address=(EditText)findViewById(R.id.address);
        pin=(EditText)findViewById(R.id.pin);

        vhour=(EditText)findViewById(R.id.vhour);

        button=(Button)findViewById(R.id.button);

        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        textView.setTypeface(myCustomFont3);

        button.setTypeface(myCustomFont3);
    }



    public void onclick(View v){
        String str_name = name.getText().toString();
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();
        String str_license = license.getText().toString();
        String str_phone = phone.getText().toString();
        String str_email = email.getText().toString();
        String str_fax = fax.getText().toString();
        String str_address= address.getText().toString();
        String str_pin = pin.getText().toString();

        String str_vhour = vhour.getText().toString();

        String type = "register";
        db_reg_phar backWork2 = new db_reg_phar(this);
        backWork2.execute(type,str_name,str_username,str_password,str_license,str_phone,
                str_email,str_fax ,str_address,str_pin,str_vhour);
    }
}
