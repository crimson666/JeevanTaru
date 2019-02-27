package com.example.stealth.log_ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class doc_reg extends AppCompatActivity {
    EditText name,username,password,license,phone,email,fax,address,pin,fee,vhour;
    Spinner spinner;
    TextView textView;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_reg);

        //spinner
        spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
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
        fee=(EditText)findViewById(R.id.fee);
        vhour=(EditText)findViewById(R.id.vhour);

        button=(Button)findViewById(R.id.button);


        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        textView.setTypeface(myCustomFont3);
        Typeface myCustomFont2 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Medium.ttf");
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
        String str_fee = fee.getText().toString();
        String str_vhour = vhour.getText().toString();
        String str_spec = spinner.getSelectedItem().toString();//form spinner
        String type = "register";
        db_reg_doc backWork2 = new db_reg_doc(this);
        backWork2.execute(type,str_name,str_username,str_password,str_license,str_phone,
                str_email,str_fax ,str_address,str_pin,str_fee,str_vhour,str_spec);


        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
