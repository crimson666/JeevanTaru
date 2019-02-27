package com.example.stealth.log_ui;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class detail_home_phar extends AppCompatActivity {

    TextView name,age,gender,phone,address,description;
    String ph;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home_phar);

        name=(TextView) findViewById(R.id.name);
        btn1 = (Button)findViewById(R.id.call);
        btn2 = (Button)findViewById(R.id.remove);


        phone=(TextView) findViewById(R.id.phone);
        address=(TextView) findViewById(R.id.address);
        description=(TextView) findViewById(R.id.desc);

        Typeface myCustomFont3 = Typeface.createFromAsset(getAssets(),"fonts/Quicksand-Light.ttf");
        phone.setTypeface(myCustomFont3);
        name.setTypeface(myCustomFont3);
        address.setTypeface(myCustomFont3);
        description.setTypeface(myCustomFont3);
        btn1.setTypeface(myCustomFont3);
        btn2.setTypeface(myCustomFont3);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            name.setText(name.getText() + ": " + extras.getString("name"));

            phone.setText(phone.getText() + ": " + extras.getString("phone"));

            address.setText(address.getText() + ": " + extras.getString("address"));
            description.setText(description.getText() + ": " + extras.getString("desc"));
            ph=extras.getString("phone");

        }


    }

    public void call(View v){

        String phone=""+ph;
        phone="+91"+phone.substring(10);
        if (ActivityCompat.checkSelfPermission(detail_home_phar.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.fromParts("tel",phone, null)));


    }

    public void remove(View v){
        remove backWork = new remove(this);
        backWork.execute(ph);
    }


}
